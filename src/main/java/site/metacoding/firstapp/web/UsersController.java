package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.users.Users;
import site.metacoding.firstapp.domain.users.UsersDao;
import site.metacoding.firstapp.service.UsersService;
import site.metacoding.firstapp.web.dto.request.AdminJoinDto;
import site.metacoding.firstapp.web.dto.request.LoginDto;
import site.metacoding.firstapp.web.dto.request.MembersJoinDto;
import site.metacoding.firstapp.web.dto.response.CMRespDto;

@RequiredArgsConstructor
@Controller
public class UsersController {
	private final HttpSession session; // 스프링이 서버시작시에 IoC 컨테이너에 보관함.
	private final UsersDao usersDao;
	private final UsersService usersService;

	// Admin 회원가입
	@PostMapping("/admin/join")
	public String joinadmin(AdminJoinDto adminJoinDto) {

		Users usersPS = usersService.유저네임찾기(adminJoinDto.getUsername());
		if (usersPS != null) {
			return "redirect:/loginForm";
		}
		usersService.관리자회원가입(adminJoinDto);
		return "redirect:/";

	}

	// Members 회원가입
	@PostMapping("/member/join")
	public String joinmembers(MembersJoinDto membersJoinDto) {

		Users usersPS = usersService.유저네임찾기(membersJoinDto.getUsername());
		if (usersPS != null) {
			return "redirect:/loginForm";
		}
		usersService.구매자회원가입(membersJoinDto);
		return "redirect:/";

	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

	// 관리자 로그인
	@PostMapping("/admin/login")
	public String AdminLogin(LoginDto loginDto) {
		Users usersPS = usersDao.adminLogin(loginDto);
		if (usersPS != null) {
			session.setAttribute("principal", usersPS);
			return "redirect:/";
		} else {
			return "redirect:/loginForm";
		}
	}

	// 관리자 로그인
	@PostMapping("/member/login")
	public String memberLogin(LoginDto loginDto) {
		Users usersPS = usersDao.memberLogin(loginDto);
		if (usersPS != null) {
			session.setAttribute("principal", usersPS);
			return "redirect:/";
		} else {
			return "redirect:/loginForm";
		}
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "users/loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "users/joinForm";
	}

}