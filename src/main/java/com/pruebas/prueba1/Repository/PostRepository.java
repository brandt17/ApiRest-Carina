package com.pruebas.prueba1.Repository;

import com.pruebas.prueba1.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //Aca van las consultas(Querys)
    @Query("SELECT p FROM Post p WHERE p.titulo LIKE %:word%")
    List <Post> findPost(@Param("word") String word);

    @Query("SELECT p FROM Post p WHERE p.publicado = 0")
    List <Post> findNotPublished();
}

