package com.dream.dec.service;

import com.dream.dec.dto.OnlineConsultingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class OnlineConsultingService {
    private final JavaMailSender javaMailSender;

    public int createMessage(OnlineConsultingDTO dto) throws Exception{

        //받는사람 이메일 수정 (dreamedu0191)
        String toEmail = "dreamedu0191@naver.com";

        MimeMessage message = javaMailSender.createMimeMessage();
        //message.setTo(testEmail);
        message.addRecipients(Message.RecipientType.TO, toEmail);
        message.setSubject(dto.getUserNm() + "님의 문의 (" + LocalDateTime.now() + ")");

        String msgg="";
        msgg+= "<div style='margin:100px;'>";
        msgg+= "<h1> 발송시간 :" +  LocalDateTime.now() + "</h1>";
        msgg+= "<p> 고객명 :" + dto.getUserNm() + "</p>";
        msgg+= "<p> 연락처 :" + dto.getUserHp() + "</p>";
        msgg+= "<br>";

        msgg+= "<p> 내용 :" + dto.getUserDesc() + "</p>";
        msgg+= "<br>";

//        msgg+= "<br>";
//        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
//        msgg+= "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
//        msgg+= "<div style='font-size:130%'>";
//        msgg+= "CODE : <strong>";
//        msgg+= key+"</strong><div><br/> ";
//        msgg+= "</div>";

        message.setText(msgg, "utf-8", "html");
        try {
            javaMailSender.send(message);
        }catch (MailException e){
            log.error("메일전송 오류 : " + e.toString());
        }
        return 1;
    }
}
