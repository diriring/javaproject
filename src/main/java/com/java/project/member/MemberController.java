package com.java.project.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입 페이지 이동
     * @return
     */
    @GetMapping("memberJoin")
    public ModelAndView setAdd() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/memberJoin");
        return mv;
    }

    /**
     * 회원가입 (DB INSERT)
     * @param memberVO
     */
    @PostMapping("memberJoin")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setAdd(MemberVO memberVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", memberService.setAdd(memberVO));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 로그인 페이지 이동
     */
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/login");
        return mv;
    }

    /**
     * 로그인 요청
     * @param memberVO
     * @param session
     */
    @PostMapping("login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> login(MemberVO memberVO, HttpSession session) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", memberService.login(memberVO, session));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 로그아웃
     * @param session
     */
    @GetMapping("logout")
    public String logout(HttpSession session) throws Exception {
        memberService.logout(session);
        return "index";
    }

    /**
     * 마이페이지 이동
     * @param session
     */
    @GetMapping("myPage")
    public ModelAndView myPage(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        MemberVO memberVO = memberService.getMyInfo(session);
        mv.addObject("memberVO", memberVO);
        mv.setViewName("member/myPage");
        return mv;
    }

    /**
     * 회원 정보 수정 페이지 이동
     * @param session
     */
    @GetMapping("memberUpdate")
    public ModelAndView setUpdate(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        MemberVO memberVO = memberService.getMyInfo(session);
        mv.addObject("memberVO", memberVO);
        mv.setViewName("member/memberUpdate");
        return mv;
    }

    /**
     * 회원 정보 업데이트 (DB UPDATE)
     * @param memberVO
     * @param session
     */
    @PostMapping("memberUpdate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setUpdate(MemberVO memberVO, HttpSession session) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", memberService.setUpdate(memberVO, session));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 회원 탈퇴 페이지 이동
     * @throws Exception
     */
    @GetMapping("memberDelete")
    public void setDelete() throws Exception {

    }

    /**
     * 회원 탈퇴 (DB UPDATE)
     * @param memberVO
     * @param session
     */
    @PostMapping("memberDelete")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setDelete(MemberVO memberVO, HttpSession session) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", memberService.setDelete(memberVO, session));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 아이디 / 이메일 중복 확인
     * @param memberVO
     */
    @PostMapping("checkMember")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkMember(MemberVO memberVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", memberService.checkMember(memberVO));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
