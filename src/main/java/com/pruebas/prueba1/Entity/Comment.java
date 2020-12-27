package com.pruebas.prueba1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Comment {

    @Column
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    // @NotBlank
    //@Size(max = 200)
    private String Comentario;

    @Column
    private LocalDate FechaCreacion = LocalDate.now();


    //Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser_comments() {
        return user_comments;
    }

    public void setUser_comments(User user_comments) {
        this.user_comments = user_comments;
    }

    //Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable = false)
    @JsonBackReference(value="commentPostReference")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonBackReference(value="commentUserReference")
    private User user_comments;


    //Constructores

    public Comment(long id) {
        this.id = id;
    }

}
