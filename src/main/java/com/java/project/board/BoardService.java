package com.java.project.board;

import com.java.project.util.FileManage;
import com.java.project.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;
    private final FileManage fileManage;

    public int setAdd(BoardVO boardVO) throws Exception {
        return boardMapper.setAdd(boardVO);
    }

    public List<BoardVO> getList(Pager pager) throws Exception {
        pager.makeRow();
        pager.makeNum(boardMapper.countTotal(pager));
        return boardMapper.getList(pager);
    }

    public BoardVO getDetail(BoardVO boardVO) throws Exception {
        boardMapper.countHit(boardVO);
        return boardMapper.getDetail(boardVO);
    }

    public int setUpdate(BoardVO boardVO) throws Exception {
        return boardMapper.setUpdate(boardVO);
    }

    public int setDelete(BoardVO boardVO) throws Exception {
        return boardMapper.setDelete(boardVO);
    }

    public String uploadFile(MultipartFile mf) throws Exception {
        String fileName = fileManage.fileSave(mf, "resources/img");
        fileName = "/resources/img/" + fileName;
        return fileName;
    }

    public boolean deleteFile(String fileName) throws Exception {
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        return fileManage.remove("resources/img/", fileName);
    }

}
