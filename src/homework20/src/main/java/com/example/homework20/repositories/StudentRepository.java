package com.example.homework20.repositories;

import com.example.homework20.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByNume(String nume);

    Optional<Student> findByNumeAndPrenume(String nume, String prenume);

    @Query("SELECT s FROM Student s WHERE s.nume = ?1")
    List<Student> findByNumeUsingQuery(String nume);

    @Query(value = "SELECT * FROM studenti JOIN adrese_studenti " +
            "ON studenti.id_adresa = adrese_studenti.id " +
            "WHERE studenti.nume = ?1 AND adrese_studenti.localitate = ?2",
            nativeQuery = true)
    List<Optional<Student>> findByNumeAndLocalitate(String nume, String localitate);
}

