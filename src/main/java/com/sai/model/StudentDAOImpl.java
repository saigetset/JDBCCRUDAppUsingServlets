package com.sai.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sai.dto.Student;
import com.sai.util.JDBCUtil;

public class StudentDAOImpl implements IStudentDAO {
	private static Connection con = null;
	private static PreparedStatement pstmt = null;

	@Override
	public String addStudent(Student std) {
		// TODO Auto-generated method stub
		try {
			con = JDBCUtil.getJDBCConnection();
			pstmt = con.prepareStatement("Insert into Students(name,age,city) values(?,?,?)");
			pstmt.setString(1, std.getName());
			pstmt.setInt(2, std.getAge());
			pstmt.setString(3, std.getCity());
			
			int val = pstmt.executeUpdate();
			if(val == 1) {
				return "successful";
			}
			else {
				return "failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student searchStudent(int id) {
		// TODO Auto-generated method stub
		Student std = new Student();
		ResultSet rs = null;
		try {
			con = JDBCUtil.getJDBCConnection();
			pstmt = con.prepareStatement("Select * from Students where id=?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					std.setId(rs.getInt(1));
					std.setName(rs.getString(2));
					std.setAge(rs.getInt(3));
					std.setCity(rs.getString(4));
					return std;
				}else {
					return null;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		try {
			con = JDBCUtil.getJDBCConnection();
			pstmt = con.prepareStatement("Delete from Students where id=?");
			pstmt.setInt(1, id);
			int val = pstmt.executeUpdate();
			if(val == 1) {
				return "successful";
			}
			else {
				return "failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateStudent(Student std) {
		// TODO Auto-generated method stub
		try {
			con = JDBCUtil.getJDBCConnection();
			pstmt = con.prepareStatement("Update Students set name=?,age=?,city=? where id=?");
			pstmt.setString(1, std.getName());
			pstmt.setInt(2, std.getAge());
			pstmt.setString(3, std.getCity());
			pstmt.setInt(4, std.getId());
			
			int val = pstmt.executeUpdate();
			if(val == 1) {
				return "successful";
			}
			else {
				return "failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
