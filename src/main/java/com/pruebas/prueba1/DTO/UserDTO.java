package com.pruebas.prueba1.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pruebas.prueba1.Entity.Comment;
import com.pruebas.prueba1.Entity.Post;
import com.pruebas.prueba1.Entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate FechaCreacion;
    private String pais;
    private String provincia;
    private String ciudad;
    private List<PostDTO> postDTO;
    private List<CommentDTO> commentDTO;

    public UserDTO(User user){
        this.id = user.getId();
        this.nombre = user.getNombre();
        this.apellido = user.getApellido();
        this.email = user.getEmail();
        this.FechaCreacion = user.getFechaCreacion();
        this.pais = user.getPais();
        this.provincia = user.getProvincia();
        this.ciudad = user.getCiudad();
        this.postDTO = retrievePosts(user);
        this.commentDTO = user.getComments().stream()
                .map((Comment commentDTO) -> new CommentDTO(
                        commentDTO.getId(),
                        commentDTO.getComentario(), commentDTO.getFechaCreacion()))
                .collect(Collectors.toList());
    }

    private List<PostDTO> retrievePosts(User user) {
        return user.getPosts().stream()
                .map((Post postDTO) -> new PostDTO(
                        postDTO.getId(),
                        postDTO.getTitulo(),
                        postDTO.getDescripcion(),
                        postDTO.getContenido(),
                        new UserDTO(
                                postDTO.getUser().getId()),
                        postDTO.getFechaCreacion(),
                        postDTO.getPublicado(),
                        postDTO.getComments().stream()
                                .map(CommentDTO::new)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public UserDTO(Long id) {
        this.id = id;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<PostDTO> getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(List<PostDTO> postDTO) {
        this.postDTO = postDTO;
    }

    public List<CommentDTO> getCommentDTO() {
        return commentDTO;
    }

    public void setCommentDTO(List<CommentDTO> commentDTO) {
        this.commentDTO = commentDTO;
    }
}
