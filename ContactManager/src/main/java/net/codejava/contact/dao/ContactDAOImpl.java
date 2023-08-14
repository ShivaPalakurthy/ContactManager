package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;
	
	 
	
	public ContactDAOImpl(DataSource datasource) {
		 this.jdbcTemplate=new JdbcTemplate(datasource);
	}

	@Override
	public int save(Contact c) {
		String sql="INSERT INTO CONTACT (CONTACTNAME, EMAIL, ADDRESS, PHONE) VALUES(?, ?, ?, ?)";
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getTelephone());
		 
	}

	@Override
	public int update(Contact c) {
		String sql="UPDATE CONTACT SET CONTACTNAME=?, EMAIL=?, ADDRESS=?, PHONE=? WHERE CONTACT_ID=?";
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getTelephone(),c.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sql="SELECT * FROM CONTACT WHERE CONTACT_ID="+id;
		
		ResultSetExtractor<Contact> extractor=new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name=rs.getString("CONTACTNAME");
					String email=rs.getString("EMAIL");
					String address=rs.getString("ADDRESS");
					String telephone=rs.getString("PHONE");
					return new Contact(id,name,email,address,telephone);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql="DELETE FROM CONTACT WHERE CONTACT_ID="+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql="SELECT * FROM CONTACT";
		RowMapper<Contact> rowMapper=new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id=rs.getInt("CONTACT_ID");
				String name=rs.getString("CONTACTNAME");
				String email=rs.getString("EMAIL");
				String address=rs.getString("ADDRESS");
				String telephone=rs.getString("PHONE");
				return new Contact(id,name,email,address,telephone); 
			}
		
		};
		return  jdbcTemplate.query(sql, rowMapper);
		 
	}

}
