package com.java.project.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    //@Test
    void setAdd() throws Exception {

        MemberVO memberVO = new MemberVO();

        memberVO.setId("id1");
        memberVO.setPassword("asdf1234");
        memberVO.setSalt("salt");
        memberVO.setName("name1");
        memberVO.setEmail("id1@gmail.com");
        memberVO.setPhone("010-1111-1111");

        int result = memberMapper.setAdd(memberVO);

        assertEquals(1, result);

    }

}
