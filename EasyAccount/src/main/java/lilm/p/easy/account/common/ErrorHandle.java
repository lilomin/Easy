package lilm.p.easy.account.common;

import lilm.p.easy.common.ResponseFactory;
import lilm.p.easy.common.exception.ExceptionEnum;
import lilm.p.easy.common.exception.ServerException;
import lilm.p.easy.common.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lilm on 17-10-16.
 */
@ControllerAdvice
public class ErrorHandle {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@ResponseBody
	@ExceptionHandler(ServerException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	public CommonResponse handleServerError(Exception e) {
		return ResponseFactory.error(((ServerException) e).getE());
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	public CommonResponse handleUnknownError(Exception e) {
		log.error("SERVER ERROR! MSG: ", e);
		return ResponseFactory.error(ExceptionEnum.SERVER_ERROR);
	}
	
}
