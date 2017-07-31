package net.balgre.controller;

import java.math.BigInteger;

import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.balgre.BalgreConstants;
import net.balgre.domain.AccessToken;
import net.balgre.domain.NaverAccessToken;
import net.balgre.domain.NaverUserResponse;
import net.balgre.domain.UserData;
import net.balgre.domain.UserResponse;
import net.balgre.dto.LoginDTO;
import net.balgre.dto.LoginDTO02;
import net.balgre.network.KakaoClient;
import net.balgre.network.NaverClient;
import net.balgre.service.LoginService;
import net.balgre.service.UserInfoService;

@Controller
public class SocialApiController {

	@Autowired
	private LoginService service;

	@Autowired
	private UserInfoService userInfoService;

	// CSRF defence token
	// token save(verification)
	public String generateState()
	{
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
		// 130th random number. toString(32)??
	}

	@SuppressWarnings("deprecation")
	@CrossOrigin
	@RequestMapping(value="/naver/login", method=RequestMethod.GET)
	public String naverLogin(HttpServletRequest request) {
		String uri = request.getScheme() + "://" +   request.getServerName();
		String redirectUrl = java.net.URLEncoder.encode(uri+BalgreConstants.NAVER_LOGIN_REDIRECT_URL);
		String state = generateState();
		// token random string produce

		String url = "https://nid.naver.com/oauth2.0/authorize?client_id=" + BalgreConstants.NAVER_CLIENT_ID + "&response_type=code&redirect_uri=" + redirectUrl + "&state=" + state;
		request.getSession().setAttribute("state", state);
		return "redirect:"+url;
	}

	@CrossOrigin
	@RequestMapping(value = "/naver/callback", method = RequestMethod.GET)
	public String naverCallback(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		NaverClient client = new NaverClient(BalgreConstants.NAVER_CLIENT_ID);
		NaverAccessToken accessToken = client.getAuth("authorization_code", request.getParameter("state"), request.getParameter("code"));
		NaverUserResponse userData = client.getUserData(accessToken.getAccess_token());
		
		if(userData != null) {
			String type = "N";

			LoginDTO loginDto = new LoginDTO();
			loginDto.setUsername(userData.getResponse().getId());
			loginDto.setPassword(type);
			LoginDTO02 loginDto02 = service.login(loginDto);
			
			model.addAttribute("sns_id", userData.getResponse().getId());
			model.addAttribute("nickName", userData.getResponse().getName());
			model.addAttribute("email", userData.getResponse().getEmail());
			model.addAttribute("type", type);
			model.addAttribute("status", "100");
			
			if(loginDto02 != null) {
				
				model.addAttribute("status", "200");
				model.addAttribute("userVO", loginDto02);
				UserResponse userRes = userInfoService.getUserInfo2(loginDto02.getToken());
				request.getSession().setAttribute("user", userRes.getUser());
				request.getSession().setAttribute("login", loginDto02);
			}
		}
		
		return "/sns/callback";
	}

	@RequestMapping(value = "/kakao/login", method = RequestMethod.GET)
	public String oauth(HttpServletRequest request) {
		String uri = request.getScheme() + "://" +   request.getServerName();
		String url = "https://kauth.kakao.com/oauth/authorize?client_id="+BalgreConstants.KAKO_API_KEY+"&redirect_uri="+uri+BalgreConstants.KAKAO_REDIRECT_URL+"&response_type=code";
		return "redirect:"+url;
	}

	@RequestMapping(value = "/kakao/auth", method = RequestMethod.GET)
	public String auth(@RequestParam("code") String code, Model model, HttpServletRequest request, HttpSession session) throws Exception {
		KakaoClient client = new KakaoClient(BalgreConstants.KAKO_API_KEY);
		String uri = request.getScheme() + "://" +   request.getServerName();
		AccessToken token = client.getAuth("authorization_code", uri+BalgreConstants.KAKAO_REDIRECT_URL, code);

		UserData userData = client.getUserData(token.getAccess_token());

		if(userData != null) {
			String type = "K";

			LoginDTO loginDto = new LoginDTO();
			loginDto.setUsername(userData.getId());
			loginDto.setPassword(type);
			LoginDTO02 loginDto02 = service.login(loginDto);
			
			model.addAttribute("sns_id", userData.getId());
			model.addAttribute("nickName", userData.getProperties().getNickname());
			model.addAttribute("email", userData.getMail());
			model.addAttribute("type", type);
			model.addAttribute("status", "100");
			
			if(loginDto02 != null) {
				
				model.addAttribute("status", "200");
				model.addAttribute("userVO", loginDto02);
				UserResponse userRes = userInfoService.getUserInfo2(loginDto02.getToken());
				request.getSession().setAttribute("user", userRes.getUser());
				request.getSession().setAttribute("login", loginDto02);
			}
		}
		
		return "/sns/callback";

	}

	@CrossOrigin
	@RequestMapping(value = "/sns/login", method = RequestMethod.POST)
	@ResponseBody
	public String loginPOST(@RequestParam("login") String login,
			@RequestParam("type") String type,
			HttpSession session,
			HttpServletRequest request,
			Model model) throws Exception {
		
		System.out.println(login);
		System.out.println(type);

		LoginDTO loginDto = new LoginDTO();
		loginDto.setUsername(login);
		loginDto.setPassword(type);
		LoginDTO02 loginDTO02 = service.login(loginDto);
		
		System.out.println(loginDTO02);

		if (loginDTO02 == null) {
			return "failed";
		}

		model.addAttribute("userVO", loginDTO02);

		UserResponse userRes = userInfoService.getUserInfo2(loginDTO02.getToken());
		request.getSession().setAttribute("user", userRes.getUser());
		request.getSession().setAttribute("login", loginDTO02);

		return "success";

	}
}
