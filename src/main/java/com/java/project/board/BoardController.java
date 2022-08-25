package com.java.project.board;

import com.java.project.reply.ReplyService;
import com.java.project.reply.ReplyVO;
import com.java.project.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final ReplyService replyService;

    @GetMapping("boardList")
    public ModelAndView getList(Pager pager) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<BoardVO> ar = boardService.getList(pager);
        mv.addObject("list", ar);
        mv.setViewName("board/boardList");
        return mv;
    }

    @GetMapping("boardWrite")
    public void setAdd() throws Exception {

    }

    @PostMapping("boardWrite")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setAdd(BoardVO boardVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", boardService.setAdd(boardVO));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("boardDetail")
    public ModelAndView getDetail(BoardVO boardVO) throws Exception {
        ModelAndView mv = new ModelAndView();
        boardVO = boardService.getDetail(boardVO);
        List<ReplyVO> ar = replyService.getList(boardVO);
        mv.addObject("list", ar);
        mv.addObject("boardVO", boardVO);
        mv.setViewName("board/boardDetail");
        return mv;
    }

    @GetMapping("boardUpdate")
    public ModelAndView setUpdate(BoardVO boardVO, ModelAndView mv) throws Exception {
        boardVO = boardService.getDetail(boardVO);
        mv.addObject("vo", boardVO);
        mv.setViewName("board/boardUpdate");
        return mv;
    }

    @PostMapping("boardUpdate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setUpdate(BoardVO boardVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", boardService.setUpdate(boardVO));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("boardDelete")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setDelete(BoardVO boardVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", boardService.setDelete(boardVO));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
