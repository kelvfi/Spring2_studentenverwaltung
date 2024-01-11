package at.fiegl.studentenverwaltung.repositories;

import at.fiegl.studentenverwaltung.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Dieses Interface erbt quasi von dem JpaRepository allso alles was in dem anderen Interface steht bekommt dieses auch!
// ebenso erben wir auch das eigene Repo

@Repository
public interface StudentJPARepo extends JpaRepository<Student,Long> {
    List<Student> findAllByPlz(String plz);

}
