package io.junq.examples.spring.model;

public class User {
	private long id;
	private String name;
	private String email;
	private String mobilePhone;
	
	public User() {
		super();
	}

	public User(final String nameToSet, final String emailToSet, final String mobilePhoneToSet) {
		super();

		name = nameToSet;
		email = emailToSet;
		mobilePhone = mobilePhoneToSet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
