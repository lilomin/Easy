package easy.lilm.p.dao.user;

import easy.lilm.p.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lilm on 17-9-6.
 */
@Mapper
public interface UserDao {
	
	User findById(@Param("userId") String userId);
	
	int insert(User user);
	
}
