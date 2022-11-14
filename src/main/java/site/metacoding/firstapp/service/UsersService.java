package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.admin.AdminDao;
import site.metacoding.firstapp.domain.members.MembersDao;
import site.metacoding.firstapp.domain.users.Users;
import site.metacoding.firstapp.domain.users.UsersDao;
import site.metacoding.firstapp.web.dto.request.AdminJoinDto;
import site.metacoding.firstapp.web.dto.request.MembersJoinDto;

@RequiredArgsConstructor
@Service
public class UsersService {
	private final UsersDao usersDao;
	private final AdminDao adminDao;
	private final MembersDao membersDao;

	public Users 유저네임찾기(String username) {
		Users usersPS = usersDao.findByUsername(username);
		return usersPS;
	}

	public void 관리자회원가입(AdminJoinDto adminJoinDto) {
		usersDao.insert(adminJoinDto.toUsers());
		Users usersPS = usersDao.findByUsername(adminJoinDto.getUsername());
		adminDao.insert(adminJoinDto.toAdmin(usersPS.getUsersId()));
	}

	public void 구매자회원가입(MembersJoinDto membersJoinDto) {
		usersDao.insert(membersJoinDto.toUsers());
		Users usersPS = usersDao.findByUsername(membersJoinDto.getUsername());
		membersDao.insert(membersJoinDto.toMembers(usersPS.getUsersId()));
	}

}
