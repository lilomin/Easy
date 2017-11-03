package lilm.p.easy.account.service;

import lilm.p.easy.account.dao.user.UserDao;
import lilm.p.easy.account.entity.user.User;
import lilm.p.easy.common.exception.ExceptionEnum;
import lilm.p.easy.common.exception.ServerException;
import lilm.p.easy.common.util.UUIDUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lilm on 17-9-7.
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Resource
	private UserDao userDao;
	
	@Cacheable(key ="#p0")
	public User selectById(String id) {
		User user = userDao.queryById(id);
		if (user == null) {
			throw new ServerException(ExceptionEnum.DATA_NOT_FOUND);
		}
		return user;
	}
	
	public void createUser(User user) {
		user.setUserId(UUIDUtil.createUUID());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setCreateTime(new Date());
		
		User userExists = userDao.queryByUsername(user.getUsername());
		if (userExists != null) {
			throw new ServerException(ExceptionEnum.USER_EXISTS);
		}
		int flag = userDao.insert(user);
		if (flag < 1) {
			throw new ServerException(ExceptionEnum.DATA_SAVE_FAILED);
		}
	}
	
	public User verifyUser(User user) {
		String userId = user.getUserId();
		String password = user.getPassword();
		if (userId == null || password == null) {
			throw new ServerException(ExceptionEnum.PARAMS_EMPTY);
		}
		User existsUser = selectById(userId);
		if (encoder.matches(password, existsUser.getPassword())) {
			return existsUser;
		}
		return null;
	}
}
