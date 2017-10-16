package lilm.p.easy.common.exception;

/**
 * Created by lilm on 17-10-16.
 */
public class ServerException extends RuntimeException {
	
	private ExceptionEnum e;
	
	public ServerException(ExceptionEnum e) {
		this.e = e;
	}
	
	public ExceptionEnum getE() {
		return e;
	}
}
