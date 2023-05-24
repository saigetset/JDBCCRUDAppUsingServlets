package com.sai.Service;

import com.sai.dto.Student;

public interface IStudentService {
	public String addStudent(Student std);
	public Student searchStudent(int id);
	public String deleteStudent(int id);
	public String updateStudent(Student std);
}
