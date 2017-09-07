package easy.lilm.p.service.user;

import easy.lilm.p.dao.user.UserDao;
import easy.lilm.p.entity.user.User;
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
		return userDao.findById(id);
	}
	
	public int createUser(User user) {
		return userDao.insert(user);
	}
}
