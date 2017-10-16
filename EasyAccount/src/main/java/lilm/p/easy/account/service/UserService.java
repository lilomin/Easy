package lilm.p.easy.account.service;

import lilm.p.easy.account.dao.user.UserDao;
import lilm.p.easy.account.entity.user.User;
import lilm.p.easy.common.exception.ExceptionEnum;
import lilm.p.easy.common.exception.ServerException;
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
		User user = userDao.queryById(id);
		if (user == null) {
			throw new ServerException(ExceptionEnum.DATA_NOT_FOUND);
		}
		return user;
	}
	
	public void createUser(User user) {
		int flag = userDao.insert(user);
		if (flag < 1) {
			throw new ServerException(ExceptionEnum.DATA_SAVE_FAILED);
		}
	}
}
