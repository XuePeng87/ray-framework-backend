package cc.xuepeng.ray.framework.facade.system.exception;

import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.module.dept.exception.SysDeptDuplicateException;
import cc.xuepeng.ray.framework.module.dept.exception.SysDeptNotFoundException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictDuplicateException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictItemDuplicateException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictItemNotFoundException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictNotFoundException;
import cc.xuepeng.ray.framework.module.func.exception.SysFuncCannotDeleteException;
import cc.xuepeng.ray.framework.module.func.exception.SysFuncDuplicateException;
import cc.xuepeng.ray.framework.module.func.exception.SysFuncNotFoundException;
import cc.xuepeng.ray.framework.module.role.exception.SysRoleCannotDeleteException;
import cc.xuepeng.ray.framework.module.role.exception.SysRoleDuplicateException;
import cc.xuepeng.ray.framework.module.role.exception.SysRoleNotFoundException;
import cc.xuepeng.ray.framework.module.user.exception.SysUserDuplicateException;
import cc.xuepeng.ray.framework.module.user.exception.SysUserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统管理模块的异常处理器
 * 数据字典错误编码：50010 - 50019
 * 部门错误编码：50020 - 50029
 * 菜单错误编码：50030 - 50039
 * 角色错误编码：50040 - 50049
 * 用户错误编码：50050 - 50059
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {

    /**
     * SysDictDuplicateException异常处理，返回错误信息和错误代码
     * 代码为50010，错误信息为"数据字典已存在"
     *
     * @param e SysDictDuplicateException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysDictDuplicateException.class)
    @ResponseBody
    public Result<String> sysDictDuplicateExceptionHandler(SysDictDuplicateException e) {
        log.error("数据字典已存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.DICT_DUPLICATE).msg(e.getMessage()).build();
    }

    /**
     * SysDictNotFoundException异常处理，返回错误信息和错误代码
     * 代码为50011，错误信息为"数据字典不存在"
     *
     * @param e SysDictNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysDictNotFoundException.class)
    @ResponseBody
    public Result<String> sysDictNotFoundExceptionHandler(SysDictNotFoundException e) {
        log.error("数据字典不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.DICT_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * SysDictItemDuplicateException异常处理，返回错误信息和错误代码
     * 代码为50012，错误信息为"数据字典项已存在"
     *
     * @param e SysDictItemDuplicateException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysDictItemDuplicateException.class)
    @ResponseBody
    public Result<String> sysDictItemDuplicateExceptionHandler(SysDictItemDuplicateException e) {
        log.error("数据字典项已存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.DICT_ITEM_DUPLICATE).msg(e.getMessage()).build();
    }

    /**
     * SysDictItemNotFoundException异常处理，返回错误信息和错误代码
     * 代码为50013，错误信息为"数据字典项不存在"
     *
     * @param e SysDictItemNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysDictItemNotFoundException.class)
    @ResponseBody
    public Result<String> sysDictItemNotFoundExceptionHandler(SysDictItemNotFoundException e) {
        log.error("数据字典项不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.DICT_ITEM_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * SysDeptDuplicateException异常处理，返回错误信息和错误代码
     * 代码为50020，错误信息为"部门已存在"
     *
     * @param e SysDeptDuplicateException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(SysDeptDuplicateException.class)
    @ResponseBody
    public Result<String> sysDeptDuplicateExceptionHandler(SysDeptDuplicateException e) {
        log.error("部门已存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.DEPT_DUPLICATE).msg(e.getMessage()).build();
    }

    /**
     * SysDeptNotFoundException异常处理，返回错误信息和错误代码
     * 代码为50021，错误信息为"部门不存在"
     *
     * @param e SysDeptNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(SysDeptNotFoundException.class)
    @ResponseBody
    public Result<String> sysDeptNotFoundExceptionHandler(SysDeptNotFoundException e) {
        log.error("部门不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.DEPT_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * SysFuncDuplicateException异常处理，返回错误信息和错误代码
     * 代码为50030，错误信息为"菜单已存在"
     *
     * @param e SysFuncDuplicateException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysFuncDuplicateException.class)
    @ResponseBody
    public Result<String> sysFuncDuplicateExceptionHandler(SysFuncDuplicateException e) {
        log.error("菜单已存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.FUNC_DUPLICATE).msg(e.getMessage()).build();
    }

    /**
     * SysFuncNotFoundException异常处理，返回错误信息和错误代码
     * 代码为50031，错误信息为"菜单不存在"
     *
     * @param e SysFuncNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysFuncNotFoundException.class)
    @ResponseBody
    public Result<String> sysFuncNotFoundExceptionHandler(SysFuncNotFoundException e) {
        log.error("菜单不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.FUNC_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * SysFuncCannotDeleteException异常处理，返回错误信息和错误代码
     * 代码为50032，错误信息为"菜单不能删除"
     *
     * @param e SysFuncCannotDeleteException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysFuncCannotDeleteException.class)
    @ResponseBody
    public Result<String> sysFuncCannotDeleteExceptionHandler(SysFuncCannotDeleteException e) {
        log.error("菜单不能删除 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.FUNC_CANNOT_DELETE).msg(e.getMessage()).build();
    }

    /**
     * SysRoleDuplicateException异常处理，返回错误信息和错误代码
     * 代码为50040，错误信息为"角色已存在"
     *
     * @param e SysRoleDuplicateException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysRoleDuplicateException.class)
    @ResponseBody
    public Result<String> sysRoleDuplicateExceptionHandler(SysRoleDuplicateException e) {
        log.error("角色已存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.ROLE_DUPLICATE).msg(e.getMessage()).build();
    }

    /**
     * SysRoleNotFoundException异常处理，返回错误信息和错误代码
     * 代码为50041，错误信息为"角色不存在"
     *
     * @param e SysRoleNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysRoleNotFoundException.class)
    @ResponseBody
    public Result<String> sysRoleNotFoundExceptionHandler(SysRoleNotFoundException e) {
        log.error("角色不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.ROLE_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * SysRoleCannotDeleteException异常处理，返回错误信息和错误代码
     * 代码为50042，错误信息为"角色不能删除"
     *
     * @param e SysRoleCannotDeleteException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysRoleCannotDeleteException.class)
    @ResponseBody
    public Result<String> sysRoleCannotDeleteExceptionHandler(SysRoleCannotDeleteException e) {
        log.error("角色不能删除 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.ROLE_CANNOT_DELETE).msg(e.getMessage()).build();
    }

    /**
     * SysUserDuplicateException异常处理，返回错误信息和错误代码
     * 代码为50050，错误信息为"用户已存在"
     *
     * @param e SysUserDuplicateException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysUserDuplicateException.class)
    @ResponseBody
    public Result<String> sysUserDuplicateExceptionHandler(SysUserDuplicateException e) {
        log.error("用户已存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.USER_DUPLICATE).msg(e.getMessage()).build();
    }

    /**
     * SysUserNotFoundException异常处理，返回错误信息和错误代码
     * 代码为50051，错误信息为"用户不存在"
     *
     * @param e SysUserNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = SysUserNotFoundException.class)
    @ResponseBody
    public Result<String> sysUserNotFoundExceptionHandler(SysUserNotFoundException e) {
        log.error("用户不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(SystemResultStatus.USER_NOT_FOUND).msg(e.getMessage()).build();
    }

}
