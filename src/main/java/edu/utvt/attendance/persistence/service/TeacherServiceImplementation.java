package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.attendance.persistence.entities.Teacher;
import edu.utvt.attendance.persistence.repositories.TeacherRepository;

@Service
@Transactional
public class TeacherServiceImplementation implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher save(Teacher teacher) {
		return this.teacherRepository.save(teacher);
	}

	@Transactional(readOnly = false)
	@Override
	public Teacher update(String id, Teacher teacher) {
		// TODO Auto-generated method stub
		Optional<Teacher> teacherOptional = null;
		teacherOptional = this.findById(id);
		
		if(teacherOptional.isPresent()) {
			teacherOptional.get().setFirstName(teacher.getFirstName());
			teacherOptional.get().setLastName(teacher.getLastName());
			teacherOptional.get().setEmail(teacher.getEmail());
			teacherOptional.get().setStatus(teacher.getStatus());
			teacherOptional.get().setBirthDate(teacher.getBirthDate());
			
			this.teacherRepository.save(teacher);
		}
		
		return teacherOptional.orElseThrow();
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return this.teacherRepository.findAll();
	}

	@Override
	public Optional<Teacher> findById(String id) {
		// TODO Auto-generated method stub
		return this.teacherRepository.findById(id);
	}

	@Override
	public ResponseEntity<Teacher> deleteById(String id) {
		// TODO Auto-generated method stub
		Optional<Teacher> teacherOptional = null;
		ResponseEntity<Teacher> responseEntity = null;
		
		teacherOptional = this.teacherRepository.findById(id);
		
		if(teacherOptional.isPresent()) {
			
			this.teacherRepository.delete(teacherOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		} else {
			responseEntity = ResponseEntity.notFound().build();
		}
		
		
		
		return responseEntity;
	}

	@Override
	public Page<Teacher> get(Integer page, Integer size) {
		// TODO Auto-generated method stub
PageRequest pageRequest = PageRequest.of(page, size, Sort.by("lastName"));
		
		return this.teacherRepository.findAll(pageRequest);
	}

}
