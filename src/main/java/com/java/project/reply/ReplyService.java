package com.java.project.reply;

import com.java.project.board.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;

    public int setAdd(ReplyVO replyVO) throws Exception {
        return replyMapper.setAdd(replyVO);
    }

    public List<ReplyVO> getList(BoardVO boardVO) throws Exception {
        return replyMapper.getList(boardVO);
    }

    public int setUpdate(ReplyVO replyVO) throws Exception {
        return replyMapper.setUpdate(replyVO);
    }

    public int setDelete(ReplyVO replyVO) throws Exception {
        return replyMapper.setDelete(replyVO);
    }

}
