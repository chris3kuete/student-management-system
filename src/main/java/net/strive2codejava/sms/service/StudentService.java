package net.strive2codejava.sms.service;

import java.util.List;

import net.strive2codejava.sms.dto.StudentDto;

public interface StudentService{
	
	List<StudentDto> getAllStudents();
	
	void createStudent(StudentDto studentDto);

	StudentDto getStudentById(Long studentId);

	void updateStudent(StudentDto student);

	void deleteAstudent(Long studentId);

	

}
