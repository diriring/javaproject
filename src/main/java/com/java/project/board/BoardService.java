package com.java.project.board;

import com.java.project.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public int setAdd(BoardVO boardVO) throws Exception {
        return boardMapper.setAdd(boardVO);
    }

    public List<BoardVO> getList(Pager pager) throws Exception {
        pager.makeRow();
        pager.makeNum(boardMapper.countTotal());
        return boardMapper.getList(pager);
    }

    public BoardVO getDetail(BoardVO boardVO) throws Exception {
        return boardMapper.getDetail(boardVO);
    }

    public int setUpdate(BoardVO boardVO) throws Exception {
        return boardMapper.setUpdate(boardVO);
    }

    public int setDelete(BoardVO boardVO) throws Exception {
        return boardMapper.setDelete(boardVO);
    }

}
