package edu.utvt.attendance;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;

import edu.utvt.attendance.persistence.common.StatusType;
import edu.utvt.attendance.persistence.entities.Teacher;
import edu.utvt.attendance.persistence.repositories.TeacherRepository;

@SpringBootApplication
public class TeacherRestApiApplication implements CommandLineRunner{
	
	@Autowired
	private TeacherRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TeacherRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		int startElements = 0;
		int totalElements = 6;
		Faker faker = new Faker();
		List<Teacher> teachers = new ArrayList<>();
		
		startElements = (int) this.repository.count();
		
		for (int i =  startElements = 0; i < totalElements; i++) {
			Teacher teacher1 = null;
			Teacher teacher2 = null;
			Teacher teacher3 = null;
			Teacher teacher4 = null;
			Teacher teacher5 = null;
			Teacher teacher6 = null;

			
			teacher1 = new Teacher("1", "Pamela", "Rosales", "pamelarosales@utvtol.edu.mx", 
					StatusType.ON, new Date(ThreadLocalRandom.current().nextInt() * i), null );
			teacher2 = new Teacher("2", "Roberto", "Camacho", "robertocamacho@utvtol.edu.mx", 
					StatusType.ON, new Date(ThreadLocalRandom.current().nextInt() * i), null );
			teacher3 = new Teacher("3", "Florencio", "Barrera", "florenciobarrera@utvtol.edu.mx", 
					StatusType.ON, new Date(ThreadLocalRandom.current().nextInt() * i), null );
			teacher4 = new Teacher("4", "Miguel", "Islas", "miguelislas@utvtol.edu.mx", 
					StatusType.ON, new Date(ThreadLocalRandom.current().nextInt() * i), null );
			teacher5 = new Teacher("5", "Jorge", "Almeida","jorgealmeida@utvtol.edu.mx", 
					StatusType.ON, new Date(ThreadLocalRandom.current().nextInt() * i), null );
			teacher6 = new Teacher("6", "Marcos", "Granados", "marcosgranadp@utvtol.edu.mx", 
					StatusType.ON, new Date(ThreadLocalRandom.current().nextInt() * i), null );
			
			
			teachers.add(teacher1);
			teachers.add(teacher2);
			teachers.add(teacher3);
			teachers.add(teacher4);
			teachers.add(teacher5);
			teachers.add(teacher6);

		}
		
		this.repository.saveAll(teachers);
		
	}
	
	

	
	
	
	
}
