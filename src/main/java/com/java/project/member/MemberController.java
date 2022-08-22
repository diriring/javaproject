package com.java.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("memberJoin")
    public ModelAndView setAdd() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/memberJoin");

        return mv;
    }

    @PostMapping("memberJoin")
    public ModelAndView setAdd(MemberVO memberVO) throws Exception {
        ModelAndView mv = new ModelAndView();
        int result = memberService.setAdd(memberVO);
        mv.addObject("result", result);
        mv.setViewName("common/ajaxResult");
        return mv;
    }

    @GetMapping("login")
    public ModelAndView login() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/login");

        return mv;
    }

    @PostMapping("login")
    public ModelAndView login(MemberVO memberVO) throws Exception {
        ModelAndView mv = new ModelAndView();
        int result = memberService.login(memberVO);
        mv.addObject("result", result);
        mv.setViewName("common/ajaxResult");

        return mv;
    }

}
