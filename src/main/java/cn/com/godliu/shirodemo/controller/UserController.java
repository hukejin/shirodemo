package cn.com.godliu.shirodemo.controller;

import cn.com.godliu.shirodemo.entity.UserInfo;
import cn.com.godliu.shirodemo.mapper.UserInfoMapper;
import cn.com.godliu.shirodemo.response.ResultMsg;
import cn.com.godliu.shirodemo.utils.EncryptionUtil;
import cn.com.godliu.shirodemo.utils.RandomUtil;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Value("${apns}")
    private String apnsPath;

    @PostMapping(value = "/addUser", produces = "application/json;charset=utf-8")
    public String insertUser(@RequestBody UserInfo userInfo){

        if(userInfo == null || userInfo.getUseruame() == null || userInfo.getPassword() == null){
            return new Gson().toJson(ResultMsg.fail("数据缺失"));
        }
        String passwd = userInfo.getPassword();
        String salt = RandomUtil.randomString(6);
        passwd = EncryptionUtil.encryptionString(passwd, salt);
        userInfo.setSalt(salt);
        userInfo.setPassword(passwd);
        userInfoMapper.insert(userInfo);

        return new Gson().toJson(ResultMsg.ok(userInfo));
    }

    /**
     * 通过注解的方式，要求查询接口需要有user:query权限
     * @param userId
     * @return
     */
    @GetMapping(value = "/getUserById", produces = "application/json;charset=utf-8")
    @RequiresPermissions("user:query")
    public String getUserById(long userId){
        try {
            return new Gson().toJson(ResultMsg.ok(userInfoMapper.findById(userId)));
        }catch (AuthorizationException e){
            return new Gson().toJson(ResultMsg.fail(e.getMessage()));
        }




    }

    @PostMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login(String userName,String passwd) throws FileNotFoundException {


        File file= ResourceUtils.getFile(apnsPath);
        log.info("#####"+file.getAbsolutePath());

        if(log.isDebugEnabled()){
            log.debug("debug");
        }else{
            log.info("info");
        }

        if(userName == null || "".equals(userName)){
            return new Gson().toJson(ResultMsg.fail("用户名不能为空"));
        }
        UserInfo userInfo = userInfoMapper.findByName(userName);
        if(userInfo == null){
            return new Gson().toJson(ResultMsg.fail("用户不存在"));
        }
        String password = EncryptionUtil.encryptionString(passwd,userInfo.getSalt());
        //mDom60i6yqAdVgWK5wDI0g==
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }

    }
}
