package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact; 

class ContactDAOTest1 {

	private DriverManagerDataSource datasource;
	private ContactDAO dao;
	@BeforeEach
	void setupBeforeEach() {
		datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		datasource.setUsername("c##shivapalakurthy");
		datasource.setPassword("1234567890");
		
		dao=new ContactDAOImpl(datasource);
	}
	
	@Test
	void testSave() {
	
		
		Contact contact=new Contact("Manasa","Manasa@gmail.com","Viraar,Mumbai","7829292826");
		int result =dao.save(contact);
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		Contact contact=new Contact(10005,"vivek","vivek@gmail.com","Pune","9292929284");
		int result =dao.update(contact);
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		Integer id=10005;
		Contact contact=dao.get(id);
		if(contact!=null)
			System.out.println(contact);
		assertNotNull(contact);
	} 

	@Test
	void testDelete() {
		Integer id=10009;
		int result=dao.delete(id);
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Contact> listContacts=dao.list();
		for(Contact aContact:listContacts)
		{
			System.out.println(aContact);
		}
		assertTrue(!listContacts.isEmpty());
	}

}
