package com.java.project.board;

import com.java.project.util.Pager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public int setAdd(BoardVO boardVO) throws Exception;
    public List<BoardVO> getList(Pager pager) throws Exception;
    public Long countTotal() throws Exception;
    public BoardVO getDetail(BoardVO boardVO) throws Exception;
    public int setUpdate(BoardVO boardVO) throws Exception;
    public int setDelete(BoardVO boardVO) throws Exception;

}
