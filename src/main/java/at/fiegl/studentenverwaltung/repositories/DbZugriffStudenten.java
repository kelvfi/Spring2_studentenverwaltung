package at.fiegl.studentenverwaltung.repositories;

import at.fiegl.studentenverwaltung.domain.Student;
import at.fiegl.studentenverwaltung.exceptions.StudentNichtGefunden;

import java.util.List;

/**
 * Hier geben wir an mit welchen Layers wir gerne
 * arbeiten möchten.
 */
public interface DbZugriffStudenten {

    Student studentSpeichern(Student student);
    List<Student> alleStudenten();
    List<Student> alleStudentenAusDemOrt(String plz);
    Student studentMitId(Long id) throws StudentNichtGefunden;
    void studentLoeschenMitId(Long id);

}
