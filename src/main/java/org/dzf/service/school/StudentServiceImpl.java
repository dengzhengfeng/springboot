package org.dzf.service.school;

import javax.annotation.Resource;

import org.dzf.domain.school.Student;
import org.dzf.domain.school.StudentRepository;
import org.springframework.stereotype.Service;

@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService{
	@Resource(name = "studentRepository")
	private StudentRepository studentRepository;

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
}
