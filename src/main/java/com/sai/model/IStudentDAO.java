package com.sai.model;

import com.sai.dto.Student;

public interface IStudentDAO {
	public String addStudent(Student std);
	public Student searchStudent(int id);
	public String deleteStudent(int id);
	public String updateStudent(Student std);
}
