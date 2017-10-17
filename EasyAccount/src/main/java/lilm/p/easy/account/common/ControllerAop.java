package lilm.p.easy.account.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * Created by lilm on 17-9-7.
 */
@Component
@Aspect
public class ControllerAop {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private ThreadLocal<Long> time = new ThreadLocal<>();
	
	@Pointcut("execution(public * lilm.p.easy.account.controller..*.*(..))")
	public void log(){}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		time.set(System.currentTimeMillis());
		log.info("{} <=== executing, args: {}", methodInfoLog(joinPoint), joinPoint.getArgs());
	}
	
	@After("log()")
	public void afterExec(JoinPoint joinPoint) {
		log.info("{} ===> executed, takes: {} ms ", methodInfoLog(joinPoint), System.currentTimeMillis() - time.get());
	}
	
	private String methodInfoLog(JoinPoint joinPoint) {
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		Method method = ms.getMethod();
		if (method == null) {
			return "";
		}
		String className = method.getDeclaringClass().getName();
		String methodName = method.getName();
		return className + "." + methodName;
	}
	
}
