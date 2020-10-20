package green.vo;

import java.util.Date;

public class Member {
	protected int no;
	protected String name;
	protected String email;
	protected String password;
	protected Date createdDate;
	protected Date modifielDate;

	public Member setNo(int no) {
		this.no = no;
		return this;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public Member setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Member setEmail(String email) {
		this.email = email;
		return this;

	}

	public String getPassword() {
		return password;
	}

	public Member setPassword(String password) {
		this.password = password;
		return this;

	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Member setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;

	}

	public Date getModifielDate() {
		return modifielDate;
	}

	public Member setModifielDate(Date modifielDate) {
		this.modifielDate = modifielDate;
		return this;

	}

}
