package com.java.project.reply;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {

    private Long replyNum;
    private String id;
    private Long boardNum;
    private String content;
    private Date regDate;

}
