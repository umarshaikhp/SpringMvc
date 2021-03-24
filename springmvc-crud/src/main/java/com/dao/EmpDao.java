package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.controller.Emp;

public class EmpDao {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Emp emp) {
		String sql = "insert into emp99 (name,salary,designation) values('" + emp.getName() + "'," + emp.getSalary()
				+ ",'" + emp.getDesignation() + "')";
		template.update(sql);
	}

	public List<Emp> getEmployees() {
		return template.query("select * from Emp99", new RowMapper<Emp>() {

			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp = new Emp();
				System.out.println(rowNum);
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getInt(3));
				emp.setDesignation(rs.getString(4));
                System.out.println("welcome");

				return emp;
			}
		});
	}

	public int delete(int id) {
		String sql = "delete from emp99 where id =" + id + "";
		return template.update(sql);
		// TODO Auto-generated method stub

	}

	public int update(Emp emp) {
		System.out.println(emp.getDesignation());
		String sql = "update emp99 set name='" + emp.getName() + "',salary=" + emp.getSalary() + ",designation= '"
				+ emp.getDesignation() + "' where id = " + emp.getId() + " ";
		return template.update(sql);

	}

	public Emp getEmpById(int id) {
		String sql = "select * from emp99 where id=?";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Emp>(Emp.class));

	}
}