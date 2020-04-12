package team.dao.fix;

public class Fix {
	private String number;
	private String fix_people;
	private String detection_record;
	private String fix_record;
	private String workload;
	private String status;
	public Fix() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fix(String number, String fix_people, String detection_record, String fix_record, String workload,
			String status) {
		super();
		this.number = number;
		this.fix_people = fix_people;
		this.detection_record = detection_record;
		this.fix_record = fix_record;
		this.workload = workload;
		this.status = status;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getfix_people() {
		return fix_people;
	}
	public void setfix_people(String fix_people) {
		this.fix_people = fix_people;
	}
	public String getdetection_record() {
		return detection_record;
	}
	public void setdetection_record(String detection_record) {
		this.detection_record = detection_record;
	}
	public String getfix_record() {
		return fix_record;
	}
	public void setfix_record(String fix_record) {
		this.fix_record = fix_record;
	}
	public String getWorkload() {
		return workload;
	}
	public void setWorkload(String workload) {
		this.workload = workload;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Fix [number=" + number + ", fix_people=" + fix_people + ", detection_record=" + detection_record
				+ ", fix_record=" + fix_record + ", workload=" + workload + ", status=" + status + "]";
	}
	
}
