package com.java.project.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("memberJoin")
    public ModelAndView setAdd() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/memberJoin");

        return mv;
    }

    @PostMapping("memberJoin")
    @ResponseBody
    public int setAdd(MemberVO memberVO) throws Exception {
        int result = memberService.setAdd(memberVO);
        return result;
    }

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/login");
        return mv;
    }

    @PostMapping("login")
    @ResponseBody
    public int login(MemberVO memberVO, HttpSession session) throws Exception {
        int result = memberService.login(memberVO, session);
        return result;
    }

    @GetMapping("logout")
    public String logout(HttpSession session) throws Exception {
        memberService.logout(session);
        return "index";
    }

    @GetMapping("myPage")
    public ModelAndView myPage(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        MemberVO memberVO = memberService.getMyInfo(session);
        mv.addObject("memberVO", memberVO);
        mv.setViewName("member/myPage");
        return mv;
    }

    @GetMapping("memberUpdate")
    public ModelAndView setUpdate(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        MemberVO memberVO = memberService.getMyInfo(session);
        mv.addObject("memberVO", memberVO);
        mv.setViewName("member/memberUpdate");
        return mv;
    }

    @PostMapping("memberUpdate")
    @ResponseBody
    public int setUpdate(MemberVO memberVO, HttpSession session) throws Exception {


        int result = memberService.setUpdate(memberVO, session);
        return result;
    }

    @GetMapping("memberDelete")
    public void setDelete() throws Exception {

    }

    @PostMapping("memberDelete")
    @ResponseBody
    public int setDelete(MemberVO memberVO, HttpSession session) throws Exception {
        int result = memberService.setDelete(memberVO, session);
        return result;
    }

    @PostMapping("checkId")
    @ResponseBody
    public int checkId(MemberVO memberVO) throws Exception {
        int result = memberService.checkId(memberVO);
        return result;
    }

    @PostMapping("checkEmail")
    @ResponseBody
    public int checkEmail(MemberVO memberVO) throws Exception {
        int result = memberService.checkEmail(memberVO);
        return result;
    }

}
