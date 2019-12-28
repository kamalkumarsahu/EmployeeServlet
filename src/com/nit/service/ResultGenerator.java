package com.nit.service;

import com.nit.bean.Student;
import com.nit.bean.StudentReport;
import com.nit.dao.DataRetrive;


/**
 * this class is check the std and it will generate the result whether the
 * student is pass or failed based on class where they are studying.
 * 
 * 
 * @author KamalKumarSahu
 *
 */
public class ResultGenerator {

	private DataRetrive dr = null;

	/**
	 * constructor will create the object for dao
	 * 
	 * 
	 */
	public ResultGenerator() {
		dr = new DataRetrive();
	}

	/**
	 * this method take the roll no as parameter and return the average mark
	 * scored by student
	 * 
	 * @param rollno
	 * @return
	 */
	public float getAverageMarksBasedOnRollNo(int rollno) throws Exception{
		
		Student st = dr.getData(rollno);
		
		int sub1 = st.getSub1();
		int sub2 = st.getSub2();
		int sub3 = st.getSub3();
		
		int total=sub1+sub2+sub3;
		float average=(float)total/3;
		
		return average;
	}
	
	/**
	 * this method take the roll no as parameter and return the average mark
	 * scored by student
	 * 
	 * @param rollno
	 * @return
	 */
	public StudentReport getStudentResult(int rollno) throws Exception{
		
		StudentReport report=new StudentReport();
		
		Student st = dr.getData(rollno);
		report.setStudent(st);
		
		int sub1 = st.getSub1();
		int sub2 = st.getSub2();
		int sub3 = st.getSub3();
		
		int total=sub1+sub2+sub3;
		float average=(float)total/3;
		report.setPer(average);
		return report;
	}
	
}
