package at.fiegl.studentenverwaltung.controller;

import at.fiegl.studentenverwaltung.exceptions.ExceptionDTO;
import at.fiegl.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.fiegl.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //So wird er zum ExceptionController
public class ExceptionController {

    //Hier wird die API angegeben
    @ExceptionHandler(StudentNichtGefunden.class) //Diese Methode kümmert sich Exception | Wenn ein Fehler auftritt!
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentNichtGefunden studentNichtGefunden) /*Art der Exception in Parameter*/ {
        return new ResponseEntity<>(new ExceptionDTO("1000", studentNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentValidierungFehlgeschlagen.class) //Diese Methode kümmert sich Exception | Wenn ein Fehler auftritt!
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentValidierungFehlgeschlagen studentValidierungFehlgeschlagen) /*Art der Exception in Parameter*/ {
        return new ResponseEntity<>(new ExceptionDTO("9000", studentValidierungFehlgeschlagen.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
