package net.codejava.contact.model;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String address;
	private String telephone;

	 

	public Contact() {
	 
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", telephone="
				+ telephone + "]";
	}


	public Contact(int id, String name, String email, String address, String telephone) {
		this(name,email,address,telephone);
		this.id = id;
		 
	}
	

	public Contact(String name, String email, String address, String telephone) {
		 
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
