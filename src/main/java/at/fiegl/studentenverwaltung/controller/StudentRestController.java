package at.fiegl.studentenverwaltung.controller;

import at.fiegl.studentenverwaltung.domain.Student;
import at.fiegl.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.fiegl.studentenverwaltung.services.StudentenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Wird verwendet um mit einer REST-API zu
 * Kommunizieren
 */
@RestController //Alle Methoden haben einen ResponseBody als HTTP verwendet wird es wird JSON Produziert
@RequestMapping("/api/v1/studenten")
public class StudentRestController {

    private StudentenService studentenService;

    public StudentRestController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }

    //Wraper der den http status kapselt und http body
    @GetMapping
    public ResponseEntity<List<Student>> gibAlleStudenten() {
        return ResponseEntity.ok(this.studentenService.alleStudenten());
    }

    @PostMapping
    public ResponseEntity<Student> studentEinfuegen(@RequestBody Student student) /*@RequestBody generiert automatisch ein Studenten Objekt, wenn im Post request bestimmte Daten mitgegeben wurden */ {
        return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
    }

    @DeleteMapping("/{id}")
    public String studentLoeschen(@PathVariable Long id) /*@PathVariable holt sich aus URL die ID*/ {
        this.studentenService.studentLoeschenMitId(id);
        return "Student gelöscht";
    }

    @GetMapping("/mitplz/{plz}")
    public ResponseEntity<List<Student>> alleStudentenMitPlz(@PathVariable String plz) {
        return ResponseEntity.ok(this.studentenService.alleStudentenMitPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentMitId(@PathVariable Long id) throws StudentNichtGefunden {
        return ResponseEntity.ok(this.studentenService.studentMitId(id));
    }

}
