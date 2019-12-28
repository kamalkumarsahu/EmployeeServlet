package com.nit.controller;

import com.nit.bean.StudentReport;
import com.nit.service.ResultGenerator;

/**
 * this class will give the result of student based on roll No.
 * 
 * @author KamalKumarSahu
 *
 */
public class ResultController {

	private ResultGenerator rg = null;

	/**
	 * dependency
	 */
	public ResultController() {
		rg = new ResultGenerator();
	}

	/**
	 * if student get more then 50% then student will pass or failed.
	 * 
	 * @param rollNo
	 * @return
	 */
	
	public StudentReport getResult(int rollNo) {
		try {
			StudentReport report = rg.getStudentResult(rollNo);

			switch (report.getStudent().getClazz()) {
			case 10:
				report.setResult(report.getPer() >= 50 ? "pass" : "fail");
				break;
			case 9:
				report.setResult(report.getPer() >= 45 ? "pass" : "fail");
				break;
			case 8:
				report.setResult(report.getPer() >= 40 ? "pass" : "fail");
				break;
			case 7:
				report.setResult(report.getPer() >= 35 ? "pass" : "fail");
				break;
			default:
				report.setResult(report.getPer() >= 30 ? "pass" : "fail");
				break;
			}
			
			return report;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
