package cn.com.godliu.shirodemo.mapper;

import cn.com.godliu.shirodemo.entity.RolerInfo;
import cn.com.godliu.shirodemo.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * 角色表
 */
@Mapper
public interface RolerInfoMapper {
    @Insert("INSERT INTO rolerinfo (role, createtime) VALUES(#{role}, #{createtime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(RolerInfo roler);

    @Select("SELECT id, role, createtime, updatetime, state FROM rolerinfo WHERE id = #{id}")
    RolerInfo findById(long id);
}
