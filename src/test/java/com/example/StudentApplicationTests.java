package com.example;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.service.StudentService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {

	@Autowired
	private StudentService studentService;
	
	@Test
	public void contextLoads() {
		
	}
	@Test
	public void createStudent() throws Exception {
		List<Student> stu = studentService.createStudent();
		Assert.assertEquals(50, stu.size());
		
		
	}
	
	@Test
	public void toSign() {
		List<Student> stu = studentService.createStudent();
		studentService.toSign(stu, "s3");
		Assert.assertEquals(true, stu.get(2).isSign());
	}
	
	@Test
	public void countSignNum() {
		List<Student> stu = studentService.createStudent();
		studentService.toSign(stu, "s3");
		int num = StudentService.countSignNum(stu);
		assertEquals(1, num);
	}
	
	
	

}
