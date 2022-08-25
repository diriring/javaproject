package com.java.project.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply/*")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

}
