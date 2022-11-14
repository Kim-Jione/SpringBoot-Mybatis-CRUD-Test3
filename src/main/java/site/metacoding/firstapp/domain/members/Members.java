package site.metacoding.firstapp.domain.members;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Members {
	private Integer membersId;
	private String membersName;
	private String membersEmail;
	private Integer usersId;
	private Timestamp createdAt;

	public Members(Integer usersId, String membersName, String membersEmail) {
		this.usersId = usersId;
		this.membersName = membersName;
		this.membersEmail = membersEmail;
	}

	
}
