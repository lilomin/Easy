package lilm.p.easy.account.dao.user;

import lilm.p.easy.account.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lilm on 17-9-6.
 */
public interface UserDao {
	
	@Select("SELECT user_id, username, password, email, nickname FROM user WHERE username = #{username}")
	@Results({
			@Result(property = "userId", column = "user_id"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "email", column = "email"),
			@Result(property = "nickname", column = "nickname")
	})
	User queryByUsername(String username);
	
	@Select("SELECT user_id, username, password, email, nickname FROM user WHERE user_id = #{userId}")
	@Results({
			@Result(property = "userId", column = "user_id"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "email", column = "email"),
			@Result(property = "nickname", column = "nickname")
	})
	User queryById(@Param("userId") String userId);
	
	@Insert(
			"insert into user values " +
					"(#{userId}, #{username}, #{password}, #{email}, #{nickname}, #{createTime}, #{updateTime})"
	)
	int insert(User user);
	
}
