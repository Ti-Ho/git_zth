package team.dao.client;

public class Client {
	private String number;
	private String ID_number;
	private String phone;
	private String email;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String number, String iD_number, String phone, String email) {
		super();
		this.number = number;
		ID_number = iD_number;
		this.phone = phone;
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getID_number() {
		return ID_number;
	}
	public void setID_number(String iD_number) {
		ID_number = iD_number;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Client [number=" + number + ", ID_number=" + ID_number + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
