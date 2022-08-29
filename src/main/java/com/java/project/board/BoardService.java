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

    /**
     * 글 목록 조회
     * @param pager
     */
    public List<BoardVO> getList(Pager pager) throws Exception {
        pager.makeRow();
        pager.makeNum(boardMapper.countTotal(pager));
        return boardMapper.getList(pager);
    }

    /**
     * 글 상세 조회
     * @param pager
     */
    public BoardVO getDetail(Pager pager) throws Exception {
        BoardVO boardVO = boardMapper.getList(pager).get(0);
        boardMapper.countHit(boardVO);
        return boardVO;
    }

    /**
     * 글 업데이트
     * @param boardVO
     */
    public int setUpdate(BoardVO boardVO) throws Exception {
        return boardMapper.setUpdate(boardVO);
    }

    public int setDelete(BoardVO boardVO) throws Exception {
        return boardMapper.setDelete(boardVO);
    }

    /**
     * 파일 업로드
     * @param mf
     */
    public String uploadFile(MultipartFile mf) throws Exception {
        String fileName = fileManage.fileSave(mf, "resources/img");
        fileName = "/resources/img/" + fileName;
        return fileName;
    }

    /**
     * 파일 삭제
     * @param fileName
     */
    public boolean deleteFile(String fileName) throws Exception {
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        return fileManage.remove("resources/img/", fileName);
    }

}
