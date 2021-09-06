package cn.com.godliu.shirodemo.exception;

import cn.com.godliu.shirodemo.response.ResultMsg;
import com.google.gson.Gson;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局错误捕捉，这里只捕捉shiro要求权限访问的web方法异常
 */
@ControllerAdvice
public class NoPermissionException {

    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public String handleShiroException(Exception ex) {
        return new Gson().toJson(ResultMsg.fail("您无权限访问该方法"));
    }
    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationException(Exception ex) {
        return new Gson().toJson(ResultMsg.fail("当前用户是非法用户"));
    }
}
