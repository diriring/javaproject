package com.java.project.Interceptor;

import com.java.project.board.BoardService;
import com.java.project.board.BoardVO;
import com.java.project.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class IdCheckInterceptor implements HandlerInterceptor {

    private final BoardService boardService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean check = false;

        String method = request.getMethod();
        String boardNum = request.getParameter("boardNum");

        MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardNum(Long.parseLong(boardNum));
        boardVO = boardService.getDetail(boardVO);

        if(memberVO.getId().equals(boardVO.getId())) {
            check = true;
        }

        if(!check) {
            request.setAttribute("message", "권한이 없습니다.");
            request.setAttribute("path", "./boardList");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
            view.forward(request, response);
        }
        return check;
    }
}
