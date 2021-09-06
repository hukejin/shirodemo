package cn.com.godliu.shirodemo.mapper;

import cn.com.godliu.shirodemo.entity.RolerPermission;
import cn.com.godliu.shirodemo.entity.UserRoler;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RolerPermissionMapper {

    @Insert("INSERT INTO rolerpermission (userid, rolerid) VALUES(#{userId}, #{rolerId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(RolerPermission roler);

    @Select("SELECT id, rolerid, permissionid FROM rolerpermission WHERE id = #{id}")
    RolerPermission findById(long id);

    @Select("SELECT id, rolerid, permissionid FROM rolerpermission WHERE permissionid = #{pid}")
    List<RolerPermission> findByPerId(long pid);

    @Select("SELECT id, rolerid, permissionid FROM rolerpermission WHERE rolerid = #{rid}")
    List<RolerPermission> findByRolerId(long rid);
}
