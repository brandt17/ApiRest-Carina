package com.pruebas.prueba1.Controller;

import com.pruebas.prueba1.Entity.Post;
import com.pruebas.prueba1.Services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;
    private PostController postController;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> CreatePost (@RequestBody Post newPost) {
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.CREATED); }

    @GetMapping
    public ResponseEntity<?> GetPost() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK); }

    @GetMapping("/")
    public ResponseEntity<?> GetPostWithWord(@RequestParam String word){
        return new ResponseEntity<>(postService.getPostWithWord(word), HttpStatus.OK); }

    @GetMapping("/published")
    public ResponseEntity<?> NotPublished(){
        return new ResponseEntity<>(postService.findNotPublished(), HttpStatus.OK); }

    @PutMapping("/{postId}")
    public ResponseEntity<?> UpdatePost (@PathVariable Long postId, @RequestBody Post post){
        Post updatePost = postService.getPost(postId);
        updatePost.setTitulo(post.getTitulo());
        updatePost.setDescripcion(post.getDescripcion());
        updatePost.setContenido(post.getContenido());
        updatePost.setPublicado(post.getPublicado());
        return new ResponseEntity<>(postService.updatePost(updatePost), HttpStatus.OK);
    }

    @DeleteMapping ("/{postId}")
    public ResponseEntity<?> DeletePost (@PathVariable Long postId) {
        Post post = postService.getPost(postId);
        postService.delete(post);
        return new ResponseEntity<>(HttpStatus.OK); }
}
