package easy.lilm.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lilm on 17-9-6.
 */
@Controller
@RequestMapping("api/v1")
public class EasyController {

	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
}
