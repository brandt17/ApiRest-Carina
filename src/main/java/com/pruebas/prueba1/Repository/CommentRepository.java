package com.pruebas.prueba1.Repository;

import com.pruebas.prueba1.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    //Aca van las consultas(Querys)
    @Query(value="SELECT * FROM Comment c WHERE post_id = ?1 ORDER BY c.FechaCreacion  DESC LIMIT ?2", nativeQuery = true)
    List<Comment> CommentsByPostId(Long post_id, Integer num);
}
