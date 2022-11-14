package site.metacoding.firstapp.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.admin.Admin;
import site.metacoding.firstapp.domain.users.Users;

@Setter
@Getter
public class AdminJoinDto {
	private String username;
	private String password;
	private String role;
	private String adminName;
	private String adminEmail;

	public Users toUsers() {
		return new Users(this.username, this.password, "admin");
	}

	public Admin toAdmin(Integer usersId) {
		return new Admin(usersId, this.adminName, this.adminEmail);
	}
}