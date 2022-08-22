package com.java.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public int setAdd(MemberVO memberVO) throws Exception {
        //솔트 생성
        String salt = "";
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        salt = new String(Base64.getEncoder().encode(bytes));

        //비밀번호에 솔트 붙여주기
        String password = memberVO.getPassword();
        password = password + salt;

        //비밀번호 해시화
        String hashedPassword = "";
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes(StandardCharsets.UTF_8));
        hashedPassword = DatatypeConverter.printBase64Binary(md.digest());

        memberVO.setSalt(salt);
        memberVO.setPassword(hashedPassword);

        return memberMapper.setAdd(memberVO);
    }

    public int login(MemberVO memberVO) throws Exception {
        String password = memberVO.getPassword();
        String id = memberVO.getId();

        memberVO = memberMapper.getSalt(memberVO);

        String salt = memberVO.getSalt();

        password = password + salt;

        String hashedPassword = "";
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes(StandardCharsets.UTF_8));
        hashedPassword = DatatypeConverter.printBase64Binary(md.digest());

        memberVO.setId(id);
        memberVO.setPassword(hashedPassword);

        memberVO = memberMapper.getMember(memberVO);

        int result = 0;

        if (memberVO != null) {
            result = 1;
        }

        return result;
    }

}
