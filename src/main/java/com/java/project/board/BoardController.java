package com.java.project.board;

import com.java.project.reply.ReplyService;
import com.java.project.reply.ReplyVO;
import com.java.project.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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

    @GetMapping("exception")
    public void generateException() {

    }

    /**
     * 글 목록 조회
     * @param pager
     */
    @GetMapping("boardList")
    public ModelAndView getList(Pager pager) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<BoardVO> ar = boardService.getList(pager);
        mv.addObject("list", ar);
        mv.setViewName("board/boardList");
        return mv;
    }

    /**
     * 글 작성 페이지 이동
     */
    @GetMapping("boardWrite")
    public void setAdd() throws Exception {

    }

    /**
     * 글 작성 (DB INSERT)
     * @param boardVO
     */
    @PostMapping("boardWrite")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setAdd(BoardVO boardVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", boardService.setAdd(boardVO));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 글 상세 조회
     * @param pager
     */
    @GetMapping("boardDetail")
    public ModelAndView getDetail(Pager pager) throws Exception {
        ModelAndView mv = new ModelAndView();
        BoardVO boardVO = boardService.getDetail(pager);
        List<ReplyVO> ar = replyService.getList(boardVO);
        mv.addObject("list", ar);
        mv.addObject("boardVO", boardVO);
        mv.setViewName("board/boardDetail");
        return mv;
    }

    /**
     * 글 업데이트 페이지 이동
     * @param pager
     * @param mv
     */
    @GetMapping("boardUpdate")
    public ModelAndView setUpdate(Pager pager, ModelAndView mv) throws Exception {
        BoardVO boardVO = boardService.getDetail(pager);
        mv.addObject("vo", boardVO);
        mv.setViewName("board/boardUpdate");
        return mv;
    }

    /**
     * 글 업데이트 (DB UPDATE)
     * @param boardVO
     */
    @PostMapping("boardUpdate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setUpdate(BoardVO boardVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", boardService.setUpdate(boardVO));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 글 삭제
     * @param boardVO
     */
    @PostMapping("boardDelete")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> setDelete(BoardVO boardVO) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("data", boardService.setDelete(boardVO));
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 파일 업로드
     * @param mf
     */
    @PostMapping("uploadFile")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> uploadFile(MultipartFile mf) throws Exception {
        String fileName = boardService.uploadFile(mf);
        Map<String, Object> result = new HashMap<>();
        result.put("data", fileName);
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 파일 삭제
     * @param fileName
     */
    @PostMapping("deleteFile")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteFile(String fileName) throws Exception {
        boolean check = boardService.deleteFile(fileName);
        Map<String, Object> result = new HashMap<>();
        result.put("data", check);
        result.put("desc", "success");
        result.put("status", 200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
