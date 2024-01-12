package at.fiegl.studentenverwaltung.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionDTO {
    /* Exceptions haben immer einen Code und eine Message */
    private String code;
    private String message;

}
