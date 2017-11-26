package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.Student;

@Service
public class StudentService {
	
	//创建50个学生
	public static List<Student> createStudent(){

		
		List<Student> stulist = new ArrayList();
		for(int i=1;i<=50;i++) {
			//随机分数
			int num = (int)(Math.random()*9);
			Student s = new Student(i,"s"+i,false);
			stulist.add(s);
		}

		return stulist;

	}

	//签到
	public static void toSign(List<Student> stu,String name) {
		for(int i=0;i<stu.size();i++) {
			if(name.equals(stu.get(i).getName())) {
				stu.get(i).setSign(true);
				System.out.println(stu.get(i).getName()+"签到成功");
			}
		}
	}
	
	//统计签到人数
	public static int countSignNum(List<Student> stu) {
		int count=0;
		for(int i=0;i<stu.size();i++) {
			if(stu.get(i).isSign()) {
				stu.get(i).setSign(true);
				count++;
			}
		}
		return count;
	}
	//打印未签到人的姓名，id
	public static void countUnsignNum(List<Student> stu) {
		int count=0;
		for(int i=0;i<stu.size();i++) {
			Student student = stu.get(i);
			if(!student.isSign()) {
				System.out.println("id="+student.getId()+",name="+student.getName());
			}
		}
	}

}
