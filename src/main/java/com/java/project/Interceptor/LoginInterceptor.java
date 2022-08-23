package com.java.project.Interceptor;

import com.java.project.member.MemberVO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean check = false;
        MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
        if(memberVO != null) {
            check = true;
        }

        if(!check) {
            request.setAttribute("message", "로그인이 필요합니다.");
            request.setAttribute("path", "../member/login");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
            view.forward(request, response);
        }
        return check;
    }
}
