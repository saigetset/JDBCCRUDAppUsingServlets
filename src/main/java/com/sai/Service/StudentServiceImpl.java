package com.sai.Service;

import com.sai.dto.Student;
import com.sai.model.DAOFactory;
import com.sai.model.IStudentDAO;

public class StudentServiceImpl implements IStudentService {
	private IStudentDAO stdDAO;

	@Override
	public String addStudent(Student std) {
		// TODO Auto-generated method stub
		stdDAO = DAOFactory.getStudentDAOObj();
		return stdDAO.addStudent(std);
	}

	@Override
	public Student searchStudent(int id) {
		// TODO Auto-generated method stub
		stdDAO = DAOFactory.getStudentDAOObj();
		return stdDAO.searchStudent(id);
	}

	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		stdDAO = DAOFactory.getStudentDAOObj();
		return stdDAO.deleteStudent(id);
	}

	@Override
	public String updateStudent(Student std) {
		// TODO Auto-generated method stub
		stdDAO = DAOFactory.getStudentDAOObj();
		return stdDAO.updateStudent(std);
	}
	
	
}
