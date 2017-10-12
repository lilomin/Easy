package lilm.p.easy.common;

import lilm.p.easy.common.response.CommonResponse;

import java.io.Serializable;

/**
 * Created by lilm on 17-9-7.
 */
public class ResponseFactory {
	
	public static CommonResponse getSuccessResponse(Serializable o) {
		return new CommonResponse("200", "success", true, o);
	}
	
	public static CommonResponse getFailResponse(String msg) {
		return new CommonResponse("400", msg, false, null);
	}
	
}
