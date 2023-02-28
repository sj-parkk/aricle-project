package com.example.articletest.service;

import com.example.articletest.domain.CertificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class CertificationSerivce {
        @Autowired
        private JavaMailSender emailSender;
        /**
         * 6자리 인증키 생성, int 반환
         * @return
         */
        public static String generateAuthNo() {
            java.util.Random generator = new java.util.Random();
            generator.setSeed(System.currentTimeMillis());
            return Integer.toString(generator.nextInt(1000000) % 1000000);
        }



        public void sendCertEmail(CertificationVO vo){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(vo.getAdmin_email());
            message.setTo(vo.getEmail());
            message.setSubject(vo.getUser_id()+ "님의 비밀번호 찾기");
            message.setText("인증번호 : " + vo.getCert());
            emailSender.send(message);
        }

        public void sendNewPW(CertificationVO vo,String newPW){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(vo.getAdmin_email());
            message.setTo(vo.getEmail());
            message.setSubject(vo.getUser_id()+ "님의 비밀번호가 발급되었습니다.");
            message.setText("비밀번호 : " + newPW);
            emailSender.send(message);
        }

        public String sendCertNewUserEmail(String email){
            String certNum = generateAuthNo();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("game3408@naver.com");
            message.setTo(email);
            message.setSubject("이메일 인증");
            message.setText("인증번호 : " + certNum );
            emailSender.send(message);
            return certNum;
        }
        public static String RandomPasswordGenerator() {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit,rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            return generatedString;
        }

}



