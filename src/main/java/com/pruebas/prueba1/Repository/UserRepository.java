package com.pruebas.prueba1.Repository;

import com.pruebas.prueba1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //Aca van las consultas(Querys)
    @Query("FROM User WHERE ciudad LIKE 'Resistencia'")
    List <User> findUsersByCity();

    @Query("FROM User WHERE FechaCreacion > ?1")
    List <User> findCreationDateAfter(LocalDate date);
}
