package com.example.articletest.controller;

import com.example.articletest.config.SHA;
import com.example.articletest.domain.CertificationVO;
import com.example.articletest.domain.UserInfo;
import com.example.articletest.mapper.SessionContants;
import com.example.articletest.mapper.UserMapper;
import com.example.articletest.service.CertificationSerivce;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/Certification")
public class CertificationController {
    @Autowired
    UserMapper mapper;

    @Autowired
    private CertificationSerivce certificationSerivce;

    @PostMapping("/emailConfirm")
    @ResponseBody
    public String emailConfirm(@RequestBody CertificationVO vo, HttpServletRequest request){
        UserInfo info = mapper.getUserByIdAndEmail(vo);
        if(Objects.isNull(info)){
            return "false";
        };
        mapper.insertAuthentic(vo);
        certificationSerivce.sendCertEmail(vo);
        HttpSession session = request.getSession();
        session.setAttribute(SessionContants.Certification,vo);
        session.setMaxInactiveInterval(300);

        return "true";
    }

    @GetMapping("/findPW")
    public String findPW(){
        return "/FindMyPW";
    }


    @PostMapping("/certPW")
    @ResponseBody
    public String findPwByEmail(@RequestBody Map<String,String> map,HttpServletRequest request){
        String takeByUserCertNum = map.get("auth");

        CertificationVO vo =  (CertificationVO)request.getSession()
                .getAttribute(SessionContants.Certification);
        String takeSessionCertNum = vo.getCert();

        if(takeSessionCertNum.equals(takeByUserCertNum)){
            mapper.updateAuthentic(vo);
            String newPW = CertificationSerivce.RandomPasswordGenerator();
            UserInfo userInfo = new UserInfo(vo.getUser_id(), SHA.getSHA512(newPW));
            mapper.updateAccount(userInfo);
            certificationSerivce.sendNewPW(vo,newPW);
            return "true";
        }else{
            return "false";
        }

    }


    @PostMapping("/certEmail")
    @ResponseBody
    public String certEmail(@RequestBody Map<String,String> map,HttpServletRequest request){
        HttpSession session = request.getSession();
        String email = map.get("email");
        UserInfo info = mapper.giveEmail_getUserInfo(email);
        if(!Objects.isNull(info)){
            return "false";
        };
//        String certNum = certificationSerivce.sendCertNewUserEmail(email);
//        session.setAttribute("certNum",certNum);
        return "true";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public String idDupCheck(@RequestBody Map<String,String> map){
        String id = map.get("user_id");
        UserInfo info = mapper.getUserById(id);
        if(Objects.isNull(info)){
            return "true";
        }else{
            return "false";
        }
    }
}
