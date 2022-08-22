package com.java.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
