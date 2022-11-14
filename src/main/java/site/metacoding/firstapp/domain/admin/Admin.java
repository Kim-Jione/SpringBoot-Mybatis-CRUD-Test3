package site.metacoding.firstapp.domain.admin;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class Admin {
	private Integer adminId;
	private String adminName;
	private String adminEmail;
	private Integer usersId;
	private Timestamp createdAt;
	
	public Admin(Integer usersId, String adminName, String adminEmail) {
		this.usersId = usersId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
	}

	
}
