package com.nit.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nit.bean.Student;
import com.nit.dao.DbConnection;
import com.nit.exception.StudentNotThereException;

public class DataRetrive {
	private Connection con = null;
	private PreparedStatement ps = null;

	private String statement = "SELECT * FROM STUDENT where rollno=?";

	public DataRetrive() {
		// TODO Auto-generated constructor stub
		con = new DbConnection().getCon();
	}

	public Student getData(int rollno) throws Exception {

		ps = con.prepareStatement(statement);
		ps.setInt(1, rollno);
		ResultSet rs = ps.executeQuery();
		Student st = new Student();
		if (rs.next()) {
			st.setRollno(rs.getInt(1));
			st.setFirstname(rs.getString(2));
			st.setLastname(rs.getString(3));
			st.setAddress(rs.getString(4));
			st.setClazz(rs.getInt(5));
			st.setSub1(rs.getInt(6));
			st.setSub2(rs.getInt(7));
			st.setSub3(rs.getInt(8));
		}else{
			throw new StudentNotThereException("Student not there in db.");
		}
		return st;
	}
}
