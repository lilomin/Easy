package lilm.p.easy.web.service.user;

import lilm.p.easy.web.dao.user.UserDao;
import lilm.p.easy.web.entity.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lilm on 17-9-7.
 */
@Service
public class UserService {
	
	@Resource
	private UserDao userDao;
	
	public User selectById(String id) {
		return userDao.queryById(id);
	}
	
	public int createUser(User user) {
		return userDao.insert(user);
	}
}
