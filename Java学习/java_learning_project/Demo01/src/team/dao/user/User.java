package team.dao.user;

public class User {
	private String account;
	private String password;
	private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String account, String password, String role) {
		super();
		this.account = account;
		this.password = password;
		this.role = role;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", role=" + role + "]";
	}
	
}
