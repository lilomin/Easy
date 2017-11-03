package lilm.p.easy.common;

import lilm.p.easy.common.exception.ExceptionEnum;
import lilm.p.easy.common.response.CommonResponse;

import java.io.Serializable;

/**
 * Created by lilm on 17-9-7.
 */
public class ResponseFactory<T> {
	
	public static CommonResponse success(Serializable o) {
		return new CommonResponse(1, "success", true, o);
	}
	
	public static CommonResponse fail(String failMsg) {
		return new CommonResponse(-1, failMsg, false, null);
	}
	
	public static CommonResponse error(ExceptionEnum e) {
		return new CommonResponse(e.getCode(), e.getDetail(), false, null);
	}
	
}
