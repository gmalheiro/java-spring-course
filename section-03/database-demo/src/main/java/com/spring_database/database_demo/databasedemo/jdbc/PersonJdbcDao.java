package com.spring_database.database_demo.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring_database.database_demo.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?",
				new BeanPropertyRowMapper<Person>(Person.class), id);
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from Person where id = ? ", id);
	}

	public List<Person> findByLocation(String location) {
		return jdbcTemplate.query("select * from person where location=?",
				new BeanPropertyRowMapper<Person>(Person.class), location);
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update("insert into person " + " (id,name,location,birth_date) " + " values (?,?,?,?)",
				person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
	}

	public int updatePerson(Person person) {
		return jdbcTemplate.update("update person set name = ? , location = ?, birth_date = ? where id = ?", person.getName(),
				person.getLocation(), new Timestamp(person.getBirthDate().getTime()),person.getId());
	}

}
