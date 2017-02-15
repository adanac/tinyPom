package com.adanac.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController extends BaseController {

	@RequestMapping("/test")
	public String toCookieTestIndex() {
		return "/cookietest/loginCookie";
	}

}
