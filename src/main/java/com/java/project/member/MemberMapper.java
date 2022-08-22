package com.java.project.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public int setAdd(MemberVO memberVO) throws Exception;

}
