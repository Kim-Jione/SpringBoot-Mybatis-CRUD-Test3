package site.metacoding.firstapp.domain.members;

import java.util.List;

public interface MembersDao {

	public void insert(Members members);

	public Members findById(Integer membersId);

	public List<Members> findAll(Integer membersId);

	public void update(Members members);

	public void delete(Integer membersId);
}
