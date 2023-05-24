package com.sai.Service;

public class ServiceFactory {
	private static IStudentService stdService=null;
	
	private ServiceFactory() {}
	
	public static IStudentService getStudentServiceObj() {
		if(stdService == null)
			stdService = new StudentServiceImpl();
		return stdService;
	}
}
