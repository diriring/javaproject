package com.java.project.board;

import lombok.Data;

import java.util.Date;
@Data
public class BoardVO {

    private Long boardNum;
    private Integer categoryNum;
    private String id;
    private String title;
    private String content;
    private Date regDate;
    private Date editDate;
    private Long hit;
    private Long rmd;

    private CategoryVO categoryVO;

}
