package lilm.p.easy.web.controller.aop;

import lilm.p.easy.common.response.CommonResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by lilm on 17-9-7.
 */
@Component
@Aspect
public class ControllerAop {
	
	@Around("execution(public * lilm.p.easy.web.controller..*.*(..))")
	public Object controllerAround(ProceedingJoinPoint point) {
		CommonResponse cr = null;
		Logger log = LoggerFactory.getLogger(point.getTarget().getClass());
		try {
			cr = (CommonResponse) point.proceed();
		} catch (Throwable t) {
			log.error("[Controller error] ==> ", t);
			cr = new CommonResponse("500", "Service Error: " + t.getMessage(), false, null);
		} finally {
			if (log.isDebugEnabled() && cr != null) {
				log.debug("[Controller response] ==> " + cr.toString());
			}
		}
		return cr;
	}
	
}
