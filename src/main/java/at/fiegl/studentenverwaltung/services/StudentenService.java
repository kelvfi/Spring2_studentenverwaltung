package at.fiegl.studentenverwaltung.services;

import at.fiegl.studentenverwaltung.domain.Student;
import at.fiegl.studentenverwaltung.exceptions.StudentNichtGefunden;

import java.util.List;

/**
 * Die Klassen die den ServiceLayer verwenden möchten sollten auch Entkoppelt werden
 * deswegen machen wir hier auch noch ein Interface.
 */
public interface StudentenService {
    List<Student> alleStudenten();
    Student studentEinfuegen(Student student);
    Student studentMitId(Long id) throws StudentNichtGefunden;
    List<Student> alleStudentenMitPlz(String plz);
    void studentLoeschenMitId(Long id);

}
