package com.pruebas.prueba1.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pruebas.prueba1.Entity.Comment;
import com.pruebas.prueba1.Entity.Post;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private UserDTO userDTO;
    private LocalDate FechaCreacion;
    private Boolean publicado;
    private List<CommentDTO> commentDTO;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.titulo = post.getTitulo();
        this.descripcion = post.getDescripcion();
        this.contenido = post.getContenido();
        this.userDTO = new UserDTO(post.getUser());
        this.FechaCreacion = post.getFechaCreacion();
        this.publicado = post.getPublicado();
        this.commentDTO = post.getComments().stream()
                .map((Comment commentDTO) -> new CommentDTO(
                        commentDTO.getId(),
                        commentDTO.getComentario(),
                        commentDTO.getFechaCreacion())).collect(Collectors.toList());
    }



    public PostDTO(Long id, String titulo, String descripcion, String contenido, UserDTO userDTO, LocalDate FechaCreacion, Boolean publicado, List<CommentDTO> commentDTO) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.userDTO = userDTO;
        this.FechaCreacion = FechaCreacion;
        this.publicado = publicado;
        this.commentDTO = commentDTO;
    }

    public PostDTO(Long id, String titulo, String descripcion, String contenido, UserDTO userDTO, LocalDate FechaCreacion, Boolean publicado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.userDTO = userDTO;
        this.FechaCreacion = FechaCreacion;
        this.publicado = publicado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public List<CommentDTO> getCommentDTO() {
        return commentDTO;
    }

    public void setCommentDTO(List<CommentDTO> commentDTO) {
        this.commentDTO = commentDTO;
    }
}