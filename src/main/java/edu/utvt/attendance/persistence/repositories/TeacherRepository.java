package edu.utvt.attendance.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendance.persistence.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
