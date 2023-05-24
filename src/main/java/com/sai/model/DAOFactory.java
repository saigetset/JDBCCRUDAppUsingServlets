package com.sai.model;

public class DAOFactory {
	private static IStudentDAO stdDAO = null;
	
	private DAOFactory(){}
	
	public static IStudentDAO getStudentDAOObj(	) {
		if(stdDAO==null)
			stdDAO = new StudentDAOImpl();
		return stdDAO;
	}
	
}
