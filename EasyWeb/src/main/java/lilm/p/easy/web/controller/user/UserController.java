package lilm.p.easy.web.controller.user;

import lilm.p.easy.common.ResponseFactory;
import lilm.p.easy.common.response.CommonResponse;
import lilm.p.easy.common.util.UUIDUtil;
import lilm.p.easy.web.entity.user.User;
import lilm.p.easy.web.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lilm on 17-9-7.
 */
@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@GetMapping("user/{id}")
	public CommonResponse selectById(@PathVariable("id") String id) {
		User user = userService.selectById(id);
		if (user == null) {
			return ResponseFactory.getFailResponse("failed");
		}
		return ResponseFactory.getSuccessResponse(user);
	}
	
	@PostMapping("user/create")
	public CommonResponse createUser(@RequestBody User user) {
		user.setUserId(UUIDUtil.createUUID());
		int flag = userService.createUser(user);
		if (flag != 1) {
			return ResponseFactory.getFailResponse("failed");
		}
		return ResponseFactory.getSuccessResponse(user);
	}
}
