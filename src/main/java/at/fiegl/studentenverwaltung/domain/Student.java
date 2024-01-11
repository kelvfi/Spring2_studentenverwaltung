package at.fiegl.studentenverwaltung.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Generiert dieses Datenmodell
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id //Deklarieren als ID
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //Generiert die ID
    private Long id;

    @Size(min=2) //Automatische Validierung von Datenfeldern
    private String name;

    @Size(min = 4, max = 6)
    private String plz;

    public Student(String name, String plz) {
        this.name = name;
        this.plz = plz;
    }
}
