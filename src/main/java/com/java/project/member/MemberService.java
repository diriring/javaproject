package com.java.project.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.xml.bind.DatatypeConverter;
import java.lang.reflect.Member;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Enumeration;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

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

    public int login(MemberVO memberVO, HttpSession session) throws Exception {
        String password = memberVO.getPassword();
        String id = memberVO.getId();

        //솔트값 가져오기
        memberVO = memberMapper.getMyInfo(memberVO);
        String salt = memberVO.getSalt();

        password = password + salt;

        //비밀번호 해시화
        String hashedPassword = "";
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes(StandardCharsets.UTF_8));
        hashedPassword = DatatypeConverter.printBase64Binary(md.digest());

        memberVO.setId(id);
        memberVO.setPassword(hashedPassword);

        //로그인 여부 확인
        memberVO = memberMapper.getMember(memberVO);

        int result = 0;


        if (memberVO != null) {
            //로그인 성공
            session.setAttribute("member", memberVO);
            result = 1;
        }

        return result;
    }

    public void logout(HttpSession session) throws Exception {
        session.invalidate();
    }

    public MemberVO getMyInfo(HttpSession session) throws Exception {
        MemberVO memberVO = (MemberVO)session.getAttribute("member");
        memberVO = memberMapper.getMyInfo(memberVO);
        return memberVO;
    }

    public int setDelete(MemberVO memberVO, HttpSession session) throws Exception {
        //세션 정보
        MemberVO temp = (MemberVO)session.getAttribute("member");

        //입력한 비밀번호에 솔트값 더해주기
        String password = memberVO.getPassword();
        String salt = memberMapper.getMyInfo(temp).getSalt();
        password = password + salt;

        //해시화 한 뒤, 비밀번호가 맞는지 확인
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes(StandardCharsets.UTF_8));
        password = DatatypeConverter.printBase64Binary(md.digest());

        temp.setPassword(password);

        temp = memberMapper.getMember(temp);

        int result = 3;

        if(temp != null) {
            temp.setName("name");
            temp.setEmail("email");
            temp.setPhone("phone");
            temp.setDelete(1);
            result = memberMapper.setUpdate(temp);
            //id를 제외한 회원정보를 다른 임의의 값으로 UPDATE
            session.invalidate();
        }

        return result;
    }

    public int checkMember(MemberVO memberVO) throws Exception {
        if(memberVO.getId() != null && memberVO.getEmail() != null) {
            String email = memberVO.getEmail();
            memberVO = memberMapper.getMyInfo(memberVO);

            if(email.equals(memberVO.getEmail())) {
                return 0;
            }

            MemberVO temp = new MemberVO();
            temp.setEmail(email);
            return memberMapper.checkMember(temp);
        }
        return memberMapper.checkMember(memberVO);
    }


    public int setUpdate(MemberVO memberVO, HttpSession session) throws Exception {
        MemberVO temp = (MemberVO)session.getAttribute("member");
        memberVO.setId(temp.getId());
        return memberMapper.setUpdate(memberVO);
    }

}
