package lilm.p.easy.web.entity.user;

import java.io.Serializable;

/**
 * Created by lilm on 17-9-6.
 */
public class User implements Serializable{
	
	private String userId;
	private String username;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
