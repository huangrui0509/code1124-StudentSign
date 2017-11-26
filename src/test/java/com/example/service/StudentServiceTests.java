package com.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTests {

	@Autowired
	private StudentService studentService;
	@Test
	public void createStudent() {
		List<Student> stu = studentService.createStudent();
		for (Student student : stu) {
			System.out.println(student);
		}
		
		
	}
	
	@Test
	public void toSign() {
		List<Student> stu = studentService.createStudent();
		studentService.toSign(stu, "s3");
		for (Student student : stu) {
			System.out.println(student);
		}
	}
	@Test
	public void countSignNum() {
		List<Student> stu = studentService.createStudent();
		studentService.toSign(stu, "s3");
		int num = StudentService.countSignNum(stu);
		assertEquals(num, 1);
	}
}
