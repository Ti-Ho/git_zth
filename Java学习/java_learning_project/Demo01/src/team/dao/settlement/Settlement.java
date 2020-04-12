package team.dao.settlement;

public class Settlement {
	private String fix_number;
	private String fix_money;
	private String material_money;
	private String total_money;
	private String settle_time;
	public Settlement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Settlement(String fix_number, String fix_money, String material_money, String total_money,
			String settle_time) {
		super();
		this.fix_number = fix_number;
		this.fix_money = fix_money;
		this.material_money = material_money;
		this.total_money = total_money;
		this.settle_time = settle_time;
	}
	public String getFix_number() {
		return fix_number;
	}
	public void setFix_number(String fix_number) {
		this.fix_number = fix_number;
	}
	public String getFix_money() {
		return fix_money;
	}
	public void setFix_money(String fix_money) {
		this.fix_money = fix_money;
	}
	public String getMaterial_money() {
		return material_money;
	}
	public void setMaterial_money(String material_money) {
		this.material_money = material_money;
	}
	public String getTotal_money() {
		return total_money;
	}
	public void setTotal_money(String total_money) {
		this.total_money = total_money;
	}
	public String getSettle_time() {
		return settle_time;
	}
	public void setSettle_time(String settle_time) {
		this.settle_time = settle_time;
	}
	@Override
	public String toString() {
		return "Settlement [fix_number=" + fix_number + ", fix_money=" + fix_money + ", material_money="
				+ material_money + ", total_money=" + total_money + ", settle_time=" + settle_time + "]";
	}
	
}
