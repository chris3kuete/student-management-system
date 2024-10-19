package net.strive2codejava.sms.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.strive2codejava.sms.dto.StudentDto;
import net.strive2codejava.sms.entity.Student;
import net.strive2codejava.sms.mapper.StudentMapper;
import net.strive2codejava.sms.repository.StudentRepo;
import net.strive2codejava.sms.service.StudentService;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	public StudentRepo studentRepo;

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> stud = studentRepo.findAll();
		List<StudentDto> studentDto = stud.stream()
				.map((stude) -> StudentMapper.mapToStudentDto(stude))
				.collect(Collectors.toList());
		return studentDto;
	}

	@Override
	public void createStudent(StudentDto studentDto) {
		if(studentDto != null) {
			Student stud = new Student(
					studentDto.getId(),
					studentDto.getFirstName(),
					studentDto.getLastName(),
					studentDto.getEmail());
			studentRepo.save(stud);
		}
		
		
	}

	@Override
	public StudentDto getStudentById(Long studentId) {
		Student stud = studentRepo.findById(studentId).get();
		StudentDto studentDto = StudentMapper.mapToStudentDto(stud);
	
		return studentDto;
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		studentRepo.save(StudentMapper.mapToStudent(studentDto));
		
	}

	@Override
	public void deleteAstudent(Long studentId) {
		Student stud = studentRepo.findById(studentId).get();
		studentRepo.delete(stud);
		
	}

	               
	

}
