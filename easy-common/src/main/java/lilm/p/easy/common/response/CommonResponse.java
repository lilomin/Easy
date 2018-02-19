package lilm.p.easy.common.response;

import java.io.Serializable;

/**
 * Created by lilm on 17-9-7.
 */
public class CommonResponse {
	
	private Integer code;
	private String msg;
	private boolean success;
	private Serializable data;
	private long timestamp;
	
	public CommonResponse(Integer code, String msg, boolean success, Serializable data) {
		this.code = code;
		this.msg = msg;
		this.success = success;
		this.data = data;
		this.timestamp = System.currentTimeMillis();
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public Serializable getData() {
		return data;
	}
	
	public void setData(Serializable data) {
		this.data = data;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "CommonResponse{" +
				"code='" + code + '\'' +
				", msg='" + msg + '\'' +
				", success=" + success +
				", data=" + data +
				", timestamp=" + timestamp +
				'}';
	}
}
