package com.java.project.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public int setAdd(MemberVO memberVO) throws Exception;
    MemberVO getMember(MemberVO memberVO) throws Exception;
    public MemberVO getSalt(MemberVO memberVO) throws Exception;
    public MemberVO getMyInfo(MemberVO memberVO) throws Exception;
    public int setDelete(MemberVO memberVO) throws Exception;
    public int checkId(MemberVO memberVO) throws Exception;
    public int checkEmail(MemberVO memberVO) throws Exception;
    public int setUpdate(MemberVO memberVO) throws Exception;
}
