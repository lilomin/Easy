package lilm.p.easy.common.exception;

/**
 * Created by lilm on 17-10-16.
 */
public enum ExceptionEnum {
	
	SERVER_ERROR(-1, "internal server error"),
	DATA_NOT_FOUND(1001, "data not found"),
	DATA_SAVE_FAILED(1002, "data save failed"),
	PARAMS_EMPTY(1003, "params is empty"),
	USER_EXISTS(2001, "username is exists");
	
	ExceptionEnum(Integer code, String detail) {
		this.code = code;
		this.detail = detail;
	}
	
	Integer code;
	String detail;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
