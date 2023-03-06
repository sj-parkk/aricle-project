package com.example.articletest.mapper;

import com.example.articletest.domain.CertificationVO;
import com.example.articletest.domain.LoginVO;
import com.example.articletest.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user_info(password,name,createAt,createBy) VALUES(#{user.password},#{user.name},sysdate(),#{user.createBy})")
    @Options(useGeneratedKeys = true, keyProperty="id")//id는 자동생성이기 때문에 이렇게 해야 자동생성된 id도 return 해준다.
    int insert(@Param("user") UserInfo user);

    //id를 통해 재사용 가능
    //property와 column이 일치한다면 따로 작성하지 않아도된다.

    @Select("select * from user_info")
    @Results(id="CompanyMap",value={
//           @Result(property = "name",column = "user_name") userinfo java객체 name과 user_info 테이블의 name 컬럼이 일치하므로 궂이 설정하지 않겠음
            @Result(property = "user_id",column="id")// 현재는 UserInfo에도 user_id로 변경하였음
    })
    List<UserInfo> getAll();

    @Select("select * from user_info where id=#{user_id}")
    @ResultMap("CompanyMap")
    UserInfo giveId_getUserInfo(@Param("id")int id);


    UserInfo getUserByIdAndPassword(LoginVO loginVO);

    @ResultMap("CompanyMap")
    UserInfo getUserById(String id);

    void updateAccount(UserInfo userInfo);

    void insertAccount(UserInfo userInfo);
    @Insert("INSERT INTO authentic(user_id,authentic_msg) VALUES(#{user_id},#{cert})")
    void insertAuthentic(CertificationVO vo);
    @Update("UPDATE authentic SET msgcheck='3' where user_id=#{user_id} and authentic_msg=#{cert}")
    void updateAuthentic(CertificationVO vo);

    @Select("select * from authentic where user_id=#{user_id} and authentic_msg=#{authentic_msg} ")
    CertificationVO selectAuthentic(UserInfo userInfo);

    @Select("select * from user_info where email=#{email}")
    UserInfo giveEmail_getUserInfo(String email);

    @Select("select * from user_info where id=#{user_id} and email=#{email}")
    UserInfo getUserByIdAndEmail(CertificationVO vo);
}
