package net.strive2codejava.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import net.strive2codejava.sms.dto.StudentDto;
import net.strive2codejava.sms.entity.Student;
import net.strive2codejava.sms.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	//handler method to handle list of students
	
	@GetMapping("/students")
	public String listAllStudents(Model model){
		List<StudentDto> stud = studentService.getAllStudents();
		model.addAttribute("stud", stud);
		return "students";
	}
	
	@GetMapping("/students/new")
	public String newStudent(Model model) {
		//create student model object to store student form data and in our case the model object is StudentDto
		StudentDto studentDto = new StudentDto();
		
		//Add studentDto to the model
		model.addAttribute("student", studentDto);
		//after storing data in the model we return a view
		return "newStudent";
		
	}
	
	@PostMapping("/students")
	public String saveNewStudent(@Valid @ModelAttribute("student") StudentDto student, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("student", student);
			return "newStudent";
		}
		studentService.createStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{studentId}/edit")
	public String editStudent(@PathVariable("studentId") Long studentId, Model model) {
		StudentDto student = studentService.getStudentById(studentId);
		model.addAttribute("student", student);
		return "editStudent";
	}
	
	@PostMapping("/students/{studentId}")
	public String saveEdited(@PathVariable("studentId")Long studentId, @Valid @ModelAttribute("student") StudentDto studentDto,
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("student", studentDto);
			return "editStudent";
		}
		studentDto.setId(studentId);
		studentService.updateStudent(studentDto);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/{studentId}/delete")
	public String deleteStudent(@PathVariable("studentId")Long studentId) {
		studentService.deleteAstudent(studentId);
		return "redirect:/students";
	}
	
//Handler method to handle view student request
	@GetMapping("/students/{studentId}/view")
	public String viewStudent(@PathVariable("studentId") Long studentId, Model model) {
		StudentDto studentDto = studentService.getStudentById(studentId);
		model.addAttribute("student", studentDto);
		return "view_student";
	}
	
	
	
	
	

}
