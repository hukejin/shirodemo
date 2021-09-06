package cn.com.godliu.shirodemo.shiro;

import cn.com.godliu.shirodemo.entity.RolerPermission;
import cn.com.godliu.shirodemo.entity.UserInfo;
import cn.com.godliu.shirodemo.entity.UserRoler;
import cn.com.godliu.shirodemo.mapper.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserRolerMapper userRolerMapper;
    @Autowired
    private RolerInfoMapper rolerInfoMapper;
    @Autowired
    private RolerPermissionMapper rolerPermissionMapper;
    @Autowired
    private PermissionInfoMapper permissionInfoMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = userInfoMapper.findByName(username);
        //查询角色
        List<UserRoler> userRolers = userRolerMapper.findByUserId(userInfo.getId());
        if(userRolers != null && userRolers.size() > 0){
            for (int i = 0; i < userRolers.size(); i++) {
                long rolerId = userRolers.get(i).getRolerId();
                simpleAuthorizationInfo.addRole(rolerInfoMapper.findById(rolerId).getRole());
                //添加权限
                List<RolerPermission> rolerPermissions = rolerPermissionMapper.findByRolerId(rolerId);
                if(rolerPermissions != null && rolerPermissions.size()>0){
                    for (int j = 0; j < rolerPermissions.size(); j++) {
                        long pid = rolerPermissions.get(j).getPermissionId();
                        simpleAuthorizationInfo.addStringPermission(permissionInfoMapper.findById(pid).getPermission());
                    }
                }
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String passwd = new String((char[]) authenticationToken.getCredentials());

        if (username == null) {
            throw new AccountException("用户名不正确");
        }
        UserInfo userInfo = userInfoMapper.findByName(username);
        if(!passwd.equals(userInfo.getPassword())){
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(username,passwd,"");
    }
}
