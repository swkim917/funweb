package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberLoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 로그인 안했으면(세션값 없으면) /member/login 리다이렉트 이동
		if (id == null) {
			response.sendRedirect("/member/login");
			return false; // false를 리턴하면 컨트롤러 메소드 실행 안함
		}
		
		return true; // true를 리턴하면 컨트롤러 메소드 실행함
	}

}
