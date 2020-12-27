package com.pruebas.prueba1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    //@NotBlank
    //@Size(min=4, max=50)
    private String titulo;

    @Column(nullable = false)
    // @NotBlank
    private String descripcion;

    @Column
    private String contenido;

    @Column
    private LocalDate fechaCreacion = LocalDate.now();

    @Column
    private Boolean publicado;


    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    //Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonBackReference(value="postReference")
    private User user;

    @OneToMany(mappedBy="post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value="commentPostReference")
    private List<Comment> comments = new ArrayList<>();


    //contructores

    public Post(long id) {
        this.id = id;
    }
}
