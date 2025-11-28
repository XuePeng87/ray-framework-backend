package cc.xuepeng.ray.framework.module.auth.exception;

import cc.xuepeng.ray.framework.core.auth.exception.SessionUserNotFoundException;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用的异常处理类
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SysAuthExceptionHandler {

    /**
     * 登录失败的异常处理
     *
     * @param e 登录失败的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = SysLoginFailedException.class)
    @ResponseBody
    public Result<String> sysLoginFailedException(SysLoginFailedException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(SysAuthResultStatus.LOGIN_FAIL)
                .msg(e.getMessage())
                .build();
    }

    /**
     * 登录锁定的异常处理
     *
     * @param e 登录锁定的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = SysLoginLockedException.class)
    @ResponseBody
    public Result<String> sysLoginLockedException(SysLoginLockedException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(SysAuthResultStatus.LOGIN_LOCKED)
                .msg(e.getMessage())
                .build();
    }

    /**
     * 系统认证失败的异常处理
     * 错误码：401
     *
     * @param e 未登录的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = NotLoginException.class)
    @ResponseBody
    public ResponseEntity<String> notLoginException(NotLoginException e) {
        log.error(e.getMessage());
        String message = switch (e.getType()) {
            case NotLoginException.NOT_TOKEN -> NotLoginException.NOT_TOKEN_MESSAGE;
            case NotLoginException.INVALID_TOKEN -> NotLoginException.INVALID_TOKEN_MESSAGE;
            case NotLoginException.TOKEN_TIMEOUT -> NotLoginException.TOKEN_TIMEOUT_MESSAGE;
            case NotLoginException.BE_REPLACED -> NotLoginException.BE_REPLACED_MESSAGE;
            case NotLoginException.KICK_OUT -> NotLoginException.KICK_OUT_MESSAGE;
            case NotLoginException.TOKEN_FREEZE -> NotLoginException.TOKEN_FREEZE_MESSAGE;
            case NotLoginException.NO_PREFIX -> NotLoginException.NO_PREFIX_MESSAGE;
            default -> "当前会话未登录";
        };
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 系统认证失败的异常处理
     * 错误码：401
     *
     * @param e 未登录的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = SessionUserNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> sessionUserNotFoundException(SessionUserNotFoundException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }


    /**
     * 系统鉴权失败的异常处理
     * 错误码：403
     *
     * @param e 无操作角色的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = NotRoleException.class)
    @ResponseBody
    public ResponseEntity<String> notRoleException(NotRoleException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>("无此角色", HttpStatus.FORBIDDEN);
    }

    /**
     * 系统鉴权失败的异常处理
     * 错误码：403
     *
     * @param e 无操作权限的异常对象
     * @return 错误信息
     */
    @ExceptionHandler(value = NotPermissionException.class)
    @ResponseBody
    public ResponseEntity<String> notPermissionException(NotPermissionException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>("无此权限", HttpStatus.FORBIDDEN);
    }

}
