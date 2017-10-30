package lilm.p.easy.account.controller.user;

import lilm.p.easy.common.ResponseFactory;
import lilm.p.easy.common.response.CommonResponse;
import lilm.p.easy.account.entity.user.User;
import lilm.p.easy.account.service.UserService;
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
@RequestMapping("api/v1/account/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@GetMapping("{id}")
	public CommonResponse selectById(@PathVariable("id") String id) {
		User user = userService.selectById(id);
		return ResponseFactory.success(user);
	}
	
	@PostMapping("register")
	public CommonResponse createUser(@RequestBody User user) {
		userService.createUser(user);
		return ResponseFactory.success(user);
	}
}
