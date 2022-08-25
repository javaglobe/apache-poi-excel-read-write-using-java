package com.javaglobe.model;

public class Student {

	private String studentRegistrationNumber;
	private String studentName;
	private Integer studentMark;
	private Integer studentClass;

	public Student() {}

	public String getStudentRegistrationNumber() {
		return studentRegistrationNumber;
	}

	public void setStudentRegistrationNumber(String studentRegistrationNumber) {
		this.studentRegistrationNumber = studentRegistrationNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentMark() {
		return studentMark;
	}

	public void setStudentMark(Integer studentMark) {
		this.studentMark = studentMark;
	}

	public Integer getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	@Override
	public String toString() {
		return "Student [studentRegistrationNumber=" + studentRegistrationNumber + ", studentName=" + studentName
				+ ", studentMark=" + studentMark + ", studentClass=" + studentClass + "]";
	}

}
