package com.java.project.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/reply/*")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    /**
     * 댓글 등록
     * @param replyVO
     */
    @PostMapping("setAdd")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setAdd(ReplyVO replyVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", replyService.setAdd(replyVO));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 댓글 업데이트
     * @param replyVO
     */
    @PostMapping("setUpdate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setUpdate(ReplyVO replyVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", replyService.setUpdate(replyVO));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 댓글 삭제
     * @param replyVO
     */
    @PostMapping("setDelete")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setDelete(ReplyVO replyVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", replyService.setDelete(replyVO));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
