package cn.com.godliu.shirodemo.mapper;

import cn.com.godliu.shirodemo.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Insert("INSERT INTO userinfo (username, password, salt, createtime) VALUES(#{useruame}, #{password}, #{salt}, #{createtime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(UserInfo city);

    @Select("SELECT id, username, password, salt, createtime, updatetime, state FROM userinfo WHERE id = #{id}")
    UserInfo findById(long id);

    @Select("SELECT id, username, password, salt,createtime, updatetime, state FROM userinfo WHERE username = #{username}")
    UserInfo findByName(String username);
}
