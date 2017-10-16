package lilm.p.easy.account.common;

import lilm.p.easy.common.ResponseFactory;
import lilm.p.easy.common.exception.ExceptionEnum;
import lilm.p.easy.common.exception.ServerException;
import lilm.p.easy.common.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lilm on 17-10-16.
 */
@ControllerAdvice
public class ErrorHandle {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public CommonResponse serverError(Exception e) {
		if (e instanceof ServerException) {
			return ResponseFactory.error(((ServerException) e).getE());
		}
		
		log.error("SERVER ERROR! MSG: {}", e);
		return ResponseFactory.error(ExceptionEnum.UNKNOWN);
	}
	
}
