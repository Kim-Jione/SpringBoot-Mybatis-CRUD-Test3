package site.metacoding.firstapp.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.members.Members;
import site.metacoding.firstapp.domain.users.Users;

@Setter
@Getter
public class MembersJoinDto {
	private String username;
	private String password;
	private String role;
	private String membersName;
	private String membersEmail;

	public Users toUsers() {
		return new Users(this.username, this.password, "member");
	}

	public Members toMembers(Integer usersId) {
		return new Members(usersId, this.membersName, this.membersEmail);
	}

}