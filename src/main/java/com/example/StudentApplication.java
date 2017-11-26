package com.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.service.StudentService;

@SpringBootApplication
public class StudentApplication {

	@Autowired
	private StudentService studentService;
	
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public static void main(String[] args) {
		new StudentApplication().test();
	}
	@Bean
	public  void test() {
		Scanner s = new Scanner(System.in);
		List<Student> createStudent = studentService.createStudent();
		while(true) {
			System.out.println("1.查看全部学生信息");
			System.out.println("2.进行签到");
			System.out.println("3.查看签到统计信息");
			System.out.println("4.退出");
			System.out.println("请输入你要进行的操作：");
			int num = s.nextInt();
			if(num==1) {
				for (Student student : createStudent) {
					System.out.println(student);
				}
			}else if(num==4) {
				System.out.println("已经退出系统");
				break;
			}else if(num==2) {
				System.out.println("请输入学生姓名：");
				String name = s.next();
				studentService.toSign(createStudent, name);
			}else if(num==3) {
				int countSignNum = StudentService.countSignNum(createStudent);
				System.out.println("已经签到的人有"+countSignNum+"个，还未签到的有"+(50-countSignNum)+"个");
				System.out.println("还未签到的人分别是：");
				studentService.countUnsignNum(createStudent);
			}
			
			
		}
	}
	
	
}
