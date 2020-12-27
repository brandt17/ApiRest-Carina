package com.pruebas.prueba1.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pruebas.prueba1.Entity.Comment;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO {
    private Long Id;
    private String Comentario;
    private LocalDate FechaCreacion;

    public CommentDTO(Long id) {

        Id = id;
    }

    public CommentDTO(Comment comment) {
        this.Id = comment.getId();
        this.Comentario = comment.getComentario();
    }

    public CommentDTO(Long id, String Comentario, LocalDate FechaCreacion) {
        this.Id = id;
        this.Comentario = Comentario;
        this.FechaCreacion = FechaCreacion;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        this.Comentario = comentario;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
}
