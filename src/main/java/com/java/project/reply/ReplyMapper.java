package com.java.project.reply;

import com.java.project.board.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public int setAdd(ReplyVO replyVO) throws Exception;
    public List<ReplyVO> getList(BoardVO boardVO) throws Exception;
    public int setUpdate(ReplyVO replyVO) throws Exception;
    public int setDelete(ReplyVO replyVO) throws Exception;
}
