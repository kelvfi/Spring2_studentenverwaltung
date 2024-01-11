package at.fiegl.studentenverwaltung;

import at.fiegl.studentenverwaltung.domain.Student;
import at.fiegl.studentenverwaltung.repositories.StudentJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner {

	@Autowired
	StudentJPARepo studentJPARepo;

	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.studentJPARepo.save(new Student("Claudio Landerer", "6460"));
		this.studentJPARepo.save(new Student("Günther Jauch", "6441"));
		this.studentJPARepo.save(new Student("Maria Brunsteiner", "6450"));
	}
}
