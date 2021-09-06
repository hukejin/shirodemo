package cn.com.godliu.shirodemo.mapper;

import cn.com.godliu.shirodemo.entity.PermissionInfo;
import cn.com.godliu.shirodemo.entity.UserRoler;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.sql.Wrapper;
import java.util.List;

@Mapper
public interface UserRolerMapper {


    @Insert("INSERT INTO user-roler (userid, rolerid) VALUES(#{userId}, #{rolerId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(UserRoler roler);

    @Select("SELECT id, userid, rolerid FROM userroler WHERE id = #{id}")
    UserRoler findById(long id);

    @Select("SELECT id, userid, rolerid FROM userroler WHERE userid = #{uid}")
    List<UserRoler> findByUserId(long uid);

    @Select("SELECT id, userid, rolerid FROM userroler WHERE rolerid = #{rid}")
    List<UserRoler> findByRolerId(long rid);
}
