package team.dao.repair;

public class Repair {
	private String number;
	private String client_number;
	private String product_type;
	private String fault_phenomena;
	private String fault_type;
	private String time;
	private String status;
	public Repair() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Repair(String number, String client_number, String product_type, String fault_phenomena, String fault_type,
			String time, String status) {
		super();
		this.number = number;
		this.client_number = client_number;
		this.product_type = product_type;
		this.fault_phenomena = fault_phenomena;
		this.fault_type = fault_type;
		this.time = time;
		this.status = status;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getclient_number() {
		return client_number;
	}
	public void setclient_number(String client_number) {
		this.client_number = client_number;
	}
	public String getproduct_type() {
		return product_type;
	}
	public void setproduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getfault_phenomena() {
		return fault_phenomena;
	}
	public void setfault_phenomena(String fault_phenomena) {
		this.fault_phenomena = fault_phenomena;
	}
	public String getfault_type() {
		return fault_type;
	}
	public void setfault_type(String fault_type) {
		this.fault_type = fault_type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Repair [number=" + number + ", client_number=" + client_number + ", product_type=" + product_type
				+ ", fault_phenomena=" + fault_phenomena + ", fault_type=" + fault_type + ", time=" + time + ", status="
				+ status + "]";
	}
	
}
