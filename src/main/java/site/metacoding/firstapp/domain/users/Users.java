package site.metacoding.firstapp.domain.users;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Users {

	private Integer usersId;
	private String username;
	private String password;
	private String role;
	private Timestamp createdAt;

	public Users(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
