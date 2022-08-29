package com.java.project.reply;

import com.java.project.board.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;

    /**
     * 댓글 등록
     * @param replyVO
     */
    public int setAdd(ReplyVO replyVO) throws Exception {
        return replyMapper.setAdd(replyVO);
    }

    /**
     * 댓글 목록 조회
     * @param boardVO
     */
    public List<ReplyVO> getList(BoardVO boardVO) throws Exception {
        return replyMapper.getList(boardVO);
    }

    /**
     * 댓글 업데이트
     * @param replyVO
     */
    public int setUpdate(ReplyVO replyVO) throws Exception {
        return replyMapper.setUpdate(replyVO);
    }

    /**
     * 댓글 삭제
     * @param replyVO
     */
    public int setDelete(ReplyVO replyVO) throws Exception {
        return replyMapper.setDelete(replyVO);
    }

}
