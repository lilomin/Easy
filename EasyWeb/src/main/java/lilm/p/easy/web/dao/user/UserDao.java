package lilm.p.easy.web.dao.user;

import lilm.p.easy.web.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lilm on 17-9-6.
 */
public interface UserDao {
	
	@Select("SELECT user_id, username FROM user WHERE user_id = #{userId}")
	@Results({
			@Result(property = "userId", column = "user_id"),
			@Result(property = "username", column = "username")
	})
	User queryById(@Param("userId") String userId);
	
	@Insert("insert into user values (#{userId}, #{username})")
	int insert(User user);
	
}
