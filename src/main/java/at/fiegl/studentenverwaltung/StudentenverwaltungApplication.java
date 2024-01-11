package at.fiegl.studentenverwaltung;

import at.fiegl.studentenverwaltung.domain.Student;
import at.fiegl.studentenverwaltung.repositories.DbZugriffStudenten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner {

	//Hier ist man schon entkoppelt weil man verwendet ja quasi nur ein Interface aber das interface erbt ja von der JPA
	@Autowired
	DbZugriffStudenten dbZugriffStudenten;

	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Somit haben wir schon entkoppelt durch das DbZugriffsInterface
		this.dbZugriffStudenten.studentSpeichern(new Student("Claudio Landerer", "6460"));
		this.dbZugriffStudenten.studentSpeichern(new Student("Günther Jauch", "6441"));
		this.dbZugriffStudenten.studentSpeichern(new Student("Maria Brunsteiner", "6450"));
	}
}
