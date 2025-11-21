package cc.xuepeng.ray.framework.facade.system.dict.exception;

import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictDuplicateException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictItemDuplicateException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictItemNotFoundException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统管理模块的异常处理器
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SysDictExceptionHandler {

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
        return new Result.Builder<String>(SysDictResultStatus.DICT_DUPLICATE).msg(e.getMessage()).build();
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
        return new Result.Builder<String>(SysDictResultStatus.DICT_NOT_FOUND).msg(e.getMessage()).build();
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
        return new Result.Builder<String>(SysDictResultStatus.DICT_ITEM_DUPLICATE).msg(e.getMessage()).build();
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
        return new Result.Builder<String>(SysDictResultStatus.DICT_ITEM_NOT_FOUND).msg(e.getMessage()).build();
    }

}
