package com.javaglobe.excelreading;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.javaglobe.model.Student;

public class ReadExcelFile {

	private static final int REGISTRATION_NUMBER_INDEX = 0;
	private static final int NAME_INDEX = 1;
	private static final int MARK_INDEX = 2;
	private static final int CLASS_INDEX = 3;

	private List<Student> readExcelValues(File fileInputStream) throws IOException {
		System.out.println("SpreadSheet Path & Name : " + fileInputStream.getPath());
		Workbook wb = WorkbookFactory.create(fileInputStream);
		System.out.println("Sheet Name : " + wb.getSheetName(0));
		Sheet sheet1 = wb.getSheetAt(0);
		System.out.println("SpreadSheet Row Count : " + sheet1.getPhysicalNumberOfRows());
		return StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(sheet1.rowIterator(), Spliterator.ORDERED), false).skip(1)
				.map(this::createStudent).collect(Collectors.toList());
	}

	private Student createStudent(Row row) {
		// Read each row and return as Student Object.
		Student student = null;
		if (Objects.nonNull(row)) {
			student = new Student();
			student.setStudentRegistrationNumber(row.getCell(REGISTRATION_NUMBER_INDEX).getStringCellValue());
			student.setStudentName(row.getCell(NAME_INDEX).getStringCellValue());
			student.setStudentMark((int) row.getCell(MARK_INDEX).getNumericCellValue());
			student.setStudentClass((int) row.getCell(CLASS_INDEX).getNumericCellValue());
		}
		return student;

	}

	public static void main(String[] args) throws IOException {

		ReadExcelFile readFile = new ReadExcelFile();

		// Read the file
		File xlsxFile = new File("./src/main/resources/student-list.xlsx");
		File xlsFile = new File("./src/main/resources/student-doc.xls");

		// Reading the xlsxFile now, If you want to read the xlsFile change the below code to- readFile.readExcelValues(xlsFile);
		List<Student> students = readFile.readExcelValues(xlsFile);

		// Printing the created Student List Values
		students.forEach(v -> System.out.println(v.toString()));
	}
}
