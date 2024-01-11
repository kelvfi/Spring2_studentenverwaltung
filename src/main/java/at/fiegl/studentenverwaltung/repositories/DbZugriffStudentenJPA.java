package at.fiegl.studentenverwaltung.repositories;


import at.fiegl.studentenverwaltung.domain.Student;
import at.fiegl.studentenverwaltung.exceptions.StudentNichtGefunden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component //Instanziert automatisch | Deklaration dass, das eine inizierbare Komponente wird
public class DbZugriffStudentenJPA implements DbZugriffStudenten {

    //@Autowired Wäre eine möglichkeit
    private StudentJPARepo studentJPARepo;

    public DbZugriffStudentenJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }

    @Override
    public Student studentSpeichern(Student student) {
        return this.studentJPARepo.save(student);
    }

    @Override
    public List<Student> alleStudenten() {
        return this.studentJPARepo.findAll();
    }

    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return this.studentJPARepo.findAllByPlz(plz);
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        //Man bekommt ein Optional zurück deswegen muss man es so Wrappen.
        //Optional ist ein Paket wo was drin sein kann oder auch nicht
        Optional<Student> optStudent = this.studentJPARepo.findById(id);

        if (optStudent.isPresent()) {
            return optStudent.get();
        } else {
            throw new StudentNichtGefunden("Student mit der Id "+ id +" nicht gefunden!");
        }
    }

    @Override
    public void studentLoeschenMitId(Long id) {
        this.studentJPARepo.deleteById(id);
    }
}
