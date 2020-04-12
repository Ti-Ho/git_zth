package team.dao.backup;

public class Backup {
	private String name;
	private String type;
	private String price;
	private String amount;
	private String in_time;
	private String deadline;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getIn_time() {
		return in_time;
	}
	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Backup(String name, String type, String price, String amount, String in_time, String deadline,
			String status) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.in_time = in_time;
		this.deadline = deadline;
		this.status = status;
	}
	public Backup() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Backup [name=" + name + ", type=" + type + ", price=" + price + ", amount=" + amount + ", in_time="
				+ in_time + ", deadline=" + deadline + ", status=" + status + "]";
	}
	
}
