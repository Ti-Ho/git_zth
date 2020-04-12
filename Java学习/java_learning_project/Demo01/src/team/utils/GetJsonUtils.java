package team.utils;

import java.util.List;

public class GetJsonUtils {
	private int code;
	private String msg;
	private long count;
	private List<String> data;
	
	public GetJsonUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GetJsonUtils(int code, String msg, long count, List<String> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}

	public String toJson() {
		String json = "{\"code\":0,\"msg\":\"\",\"count\":"+ count+",\"data\":" + data +"}";
		return json;
	}
	
	
}
