package team.dao.backupflow;

public class BackupFlow {
	private String name;
	private String type;
	private String fixNumber;
	private String amount;
	private String price;
	private String outTime;
	public BackupFlow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BackupFlow(String name, String type, String fixNumber, String amount, String price, String outTime) {
		super();
		this.name = name;
		this.type = type;
		this.fixNumber = fixNumber;
		this.amount = amount;
		this.price = price;
		this.outTime = outTime;
	}
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
	public String getFixNumber() {
		return fixNumber;
	}
	public void setFixNumber(String fixNumber) {
		this.fixNumber = fixNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	@Override
	public String toString() {
		return "BackupFlow [name=" + name + ", type=" + type + ", fixNumber=" + fixNumber + ", amount=" + amount
				+ ", price=" + price + ", outTime=" + outTime + "]";
	}
	
}	
