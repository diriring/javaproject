package com.java.project.board;

import com.java.project.util.Pager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int setAdd(BoardVO boardVO) throws Exception;
    List<BoardVO> getList(Pager pager) throws Exception;
    Long countTotal(Pager pager) throws Exception;
    BoardVO getDetail(BoardVO boardVO) throws Exception;
    int setUpdate(BoardVO boardVO) throws Exception;
    int setDelete(BoardVO boardVO) throws Exception;
    int countHit(BoardVO boardVO) throws Exception;

}
