package com.spring.jdbc.SpringJDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAddress(rs.getString("Address"));
		student.setCourse(rs.getString("Course"));
		
		return student;
	}
	

}
