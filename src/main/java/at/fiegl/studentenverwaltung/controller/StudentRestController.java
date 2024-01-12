package at.fiegl.studentenverwaltung.controller;

import at.fiegl.studentenverwaltung.domain.Student;
import at.fiegl.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.fiegl.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import at.fiegl.studentenverwaltung.services.StudentenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
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

    /*@RequestBody generiert automatisch ein Studenten Objekt,
     wenn im Post request bestimmte Daten mitgegeben wurden.
     Wenn die Validierung einen fehler hat gibt er diesen in
     BindingResult mit an und speichert es.*/
    @PostMapping
    public ResponseEntity<Student> studentEinfuegen(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen {
        String errors = "";

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors += "Validierungsfehler für Objekt "+error.getObjectName()+
                        " im Feld "+((FieldError)error).getField() + " mit folgendem Problem: " +
                        error.getDefaultMessage();
            }
            throw new StudentValidierungFehlgeschlagen(errors);
        } else {
            return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
        }
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
