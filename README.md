# HTTP异常编码

| 模块 | 错误码   | 错误原因   | 异常                         | 备注 |
| ---- | -------- | ---------- | ---------------------------- | ---- |
| Auth | HTTP.401 | 用户未登录 | NotLoginException            |      |
|      |          |            | SessionUserNotFoundException |      |
|      | HTTP.403 | 用户未授权 | NotRoleException             |      |
|      |          |            | NotPermissionException       |      |





# 异常编码

| 模块 | 错误码 | 错误原因     | 异常                          | 备注 |
| ---- | ------ | ------------ | ----------------------------- | ---- |
| Auth | 50001  | 登录失败     | SysLoginFailedException       |      |
|      | 50002  | 账号锁定     | SysLoginLockedException       |      |
| Dict | 50010  | 字典已存在   | SysDictDuplicateException     |      |
|      | 50011  | 字典不存在   | SysDictNotFoundException      |      |
|      | 50012  | 字典项已存在 | SysDictItemDuplicateException |      |
|      | 50013  | 字典项不存在 | SysDictItemNotFoundException  |      |
| Dept | 50020  | 部门已存在   | SysDeptDuplicateException     |      |
|      | 50021  | 部门不存在   | SysDeptNotFoundException      |      |
| Func | 50030  | 功能已存在   | SysFuncDuplicationException   |      |
|      | 50031  | 功能不存在   | SysFuncNotFoundException      |      |
|      | 50032  | 功能不能删除 | SysFuncCannotDeleteException  |      |
| Role | 50040  | 角色已存在   | SysRoleDuplicateException     |      |
|      | 50041  | 角色不存在   | SysRoleNotFoundException      |      |
|      | 50042  | 角色不能删除 | SysRoleCannotDeleteException  |      |
| User | 50050  | 用户已存在   | SysUserDuplicateException     |      |
|      | 50051  | 用户不存在   | SysUserNotFoundException      |      |
|      |        |              |                               |      |
|      |        |              |                               |      |
|      |        |              | SessionUserNotFoundException  |      |
|      |        |              | CodecException                |      |
|      |        |              | FileConvertException          |      |
|      |        |              | FileParseException            |      |
|      |        |              | FileUtilException             |      |
|      |        |              | RocketMQSendFailedException   |      |
|      |        |              | DisruptorCopyMessageException |      |
|      |        |              |                               |      |
|      |        |              | VerifyCodeExpiredException    |      |
|      |        |              | VerifyCodeIncorrectException  |      |
|      |        |              |                               |      |

