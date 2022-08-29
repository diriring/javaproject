package com.java.project.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int setAdd(MemberVO memberVO) throws Exception;
    MemberVO getMember(MemberVO memberVO) throws Exception;
    MemberVO getMyInfo(MemberVO memberVO) throws Exception;
    int checkMember(MemberVO memberVO) throws Exception;
    int setUpdate(MemberVO memberVO) throws Exception;
}
