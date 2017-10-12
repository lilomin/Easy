package lilm.p.easy.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lilm on 17-9-6.
 */
@RestController
@RequestMapping("api/v1")
public class EasyController {
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
}
