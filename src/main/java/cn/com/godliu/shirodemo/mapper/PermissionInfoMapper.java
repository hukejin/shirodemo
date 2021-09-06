package cn.com.godliu.shirodemo.mapper;

import cn.com.godliu.shirodemo.entity.PermissionInfo;
import cn.com.godliu.shirodemo.entity.RolerInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PermissionInfoMapper {

    @Insert("INSERT INTO permissioninfo (permission, createtime) VALUES(#{permission}, #{createtime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(PermissionInfo roler);

    @Select("SELECT id, role, createtime, updatetime, state FROM permissioninfo WHERE id = #{id}")
    PermissionInfo findById(long id);
}
