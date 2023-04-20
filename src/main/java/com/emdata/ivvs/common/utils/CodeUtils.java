package com.emdata.ivvs.common.utils;

/**
 * @version 1.0
 */
public enum CodeUtils {

    SUCCESS("200" , "成功" , true),
    NULL("300" , "数据为空" , false),
    FAIL("500" , "失败" , false),
    UNAUTH("403" , "没有权限，请登录" , false),
    SUCCESSNEWS("101" , "返回成功。" , true),
    SMS_SEND_SUCCESS("200" , "发送成功，请查收" , true),
    AUDIO_SEND_SUCCESS("200" , "发送成功" , true),
    AUDIO_SEND_FAILUE("-300" , "发送成功" , false),
    SMS_SEND_FAILUE("200" , "发送失败" , false),
    PHONE_NUMBER_NULL("200" , "手机号码不能为空" , false),
    SMS_CODE_ERROR("200" , "请不要频繁获取短信,请稍后再试" , false),
    CHANNEL_TYPE_NULL("200" , "通道类型不能为空" , false),
    SMS_CHANNEL_CLOSED("200" , "短信通道已经关闭" , false),
    AUDIO_CHANNEL_CLOSED("200" , "语音通道已经关闭" , false),
    CHANNEL_TYPE_ERROR("200" , "通道类型错误" , false),
    PHONE_NUMBER_ERROR("200" , "请输入正确手机号码" , false),
    VALIDATE_CODE_NULL("200" , "短信验证码不能为空" , false),
    GET_VALIDATE_CODE("200" , "请重新获取短信验证码" , false),
    LOGIN_SUCCESS("200" , "登录成功" , true),
    LOGIN_FAILUE("200" , "登录失败" , false),
    SMS_VALIDATE_CODE_TRUE("200" , "短信验证码正确" , true),
    SMS_VALIDATE_CODE_ERROR("200" , "短信验证码错误" , false),
    LOGOUT_SUCCESS("200" , "用户退出成功" , true),
    LOGOUT_FAILUE("200" , "用户退出失败" , false),
    NO_LOGIN("1009" , "请登录" , false),
    PHONE_NUMBER_REGIST("200" , "手机号码已注册" , true),
    PHONE_NUMBER_NOT_REGIST("200" , "手机号码未注册" , false),
    USERNAME_NULL("201" , "登录账户不能为空" , false),
    PASSWORD_NULL("201" , "密码不能为空" , false),
    PASSWORD_LENGTH_ERROR("200" , "密码长度必须是6到16位" , false),
    REGISTER_SUCCESS("200" , "注册成功" , true),
    REGISTER_FAILUE("200" , "注册失败" , false),
    PASSWORD_ERROR("201" , "登录密码错误" , false),
    USER_PASSWORD_ERROR("2001" , "用户名或密码错误" , false),
    PASSWORD_ERROR_LOGIN("201" , "用户名或密码错误" , false),
    PASSWORD_NOSURE("201" , "原密码错误，修改失败" , false),
    TOKEN_NULL("200" , "token不能为空" , false),
    UPDATE_PASSWORD_SUCCESS("200" , "密码修改成功" , true),
    UPDATE_PASSWORD_FAILUE("200" , "密码修改失败" , false),
    OLD_PASSWORD_NULL("200" , "原密码不能为空" , false),
    OLD_PASSWORD_LENGTH_ERROR("200" , "原密码长度必须是6到16位" , false),
    NEW_PASSWORD_NULL("200" , "新密码不能为空" , false),
    NEW_PASSWORD_LENGTH_ERROR("200" , "新密码长度必须是6到16位" , false),
    RE_PASSWORD_NULL("200" , "确认密码不能为空" , false),
    RE_PASSWORD_LENGTH_ERROR("200" , "确认密码长度必须是6到16位" , false),
    PASSWORD_NOT_SAME("200" , "新密码和确认密码不一样" , false),
    SAVE_SUCCESS("2001" , "保存成功" , true),
    SAVE_FAIL("2002" , "保存失败" , false),
    DELETE_SUCCESS("3001" , "删除成功" , true),
    DELETE_FAIL("3002" , "删除失败" , false),
    DELETE_FAIL_ROLE("3003" , "删除失败，该角色关联用户，不允许删除" , false),
    UPDATE_SUCCESS("4001" , "修改成功" , true),
    UPDATE_FAIL("4002" , "修改失败" , false),
    LINEON_SUCCESS("5001" , "发布成功" , true),
    LINEON_FAIL("5002" , "发布失败" , false),
    QUERRYSUCCESS("200" , "查询成功" , true),
    QUERRYFAIL("500" , "查询失败" , false),
    NAME_FAIL("102" , "已存在" , false),
    IMAGE_UPLOAD_FAILUE_TYPE("1011" , "上传的文件类型错误，请上传GIF、PNG、JPG图片！" , false),
    HTTP_PATH_FAIL("-300","链接失效/图片不存在",false),
    BACKEND_ERROR("-200" , "程序异常请联系管理员" , false),
    PARAMS_ERROR("500" , "参数错误" , true),
    PARAMS_NULL("500" , "参数为空" , true),
    EXCEL_EXPORT("60001" , "文件导出不能超过5000条数据" , true),
    RESURVEY_DATE("60002" , "该日期已重测，请稍后再试！" , false),
    CHECK_DATE("60003" , "已申请数据未全部审核完成，请确认后重试!" , false),
    DATA_NULL("300" , "数据为空，申请失败！" , true),
    DATA_PARAMS_NULL("400" , "违法行为选项为空，申请失败！" , false),
    RESULT_SUCCESS("20012" , "查询成功！" , true),
    QUERY_NULL("200" , "查询结果为空" , true),
    NOT_GB_CODE("6001" , "此国标编号不存在" , true),
    NOT_SB_CODE("6002" , "此省标编号不存在" , true),
    NOT_GB_CODE_RELATIONS("6002" , "此省标无对应国标编号" , true),
    ILLEGALITY_EXISTING("6003" , "该违法类型已存在" , true),
    LPN_NO_MATCH_STR("501" , "车牌号不匹配，请输入正确的车牌号" , false),
    USER_REDO("8001" , "机构下存在用户信息,不允许删除!" , false),
    ORG_REDO("8002" , "同机构下名称重复!" , false),
    DATA_REDO("8003" , "数据重复,请确认后重试!" , false),
    USERNAME_REDO("8004" , "用户名称重复!" , false),
    ID_CARD_REDO("8005" , "身份证号重复!" , false),
    USER_BH_REDO("8006" , "用户编号重复!" , false),
    ID_CARD_ERROR("8007" , "身份证号格式错误!" , false),
    NOT_AUTH_BAYONET("9001" , "该用户未分配卡口!" , false),
    NOT_AUTH_DEVICE("9001" , "该用户未分配设备权限!" , false),
    LOGIN_RESULT_BAN("9002" , "帐号已经禁止登录!" , false),
    LOGIN_RESULT_NUMBER("9002" , "由于密码输入错误次数大于5次，帐号锁定5分钟！" , false),
    LOGIN_STATE("9003" , "您的账户已被锁定，请联系管理员！" , false),
    LOGIN_ERROR_MESSAGE("9004" , "您输入的用户名或密码错误，请重新输入" , false),
    LOGIN_PLACES("200" , "您的账户在其它地方登录，如需冻结账户，请联系管理员" , true),
    NOT_CHOOSE_DEVICE("9002" , "违法设备为空，请选择违法设备!" , false),
    ROLE_CHOOSE_NULL("9003" , "角色为空，请选择角色!" , false),
    DEVICE_REPEAT("9005" , "设备已存在，无法添加!" , false),
    DEVICE_NOT_EXISTS("9006" , "该设备不存在,无法进行修改!" , false),
    PARAMS_JUDGE_ERROR("10001" , "参数校验失败" , true),
    USER_LOGIN_VALID("10002" , "用户已过期" , true),
    LOGIN_OTHER_PLACES("403" , "您的账户在其它地方登录，如需冻结账户，请联系管理员" , true),
    EXPORT_ERROR("10003" , "导出失败" , false),
    EXPORT_DATA_NULL("300" , "数据为空，导出失败！" , true),
    IMPORT_ERROR("10003" , "导入失败" , false),
    LOGIN_STATE_NULL("9006","该账户已不存在！",false),
    LOGIN_STATE_OUT("9005","您的账户已超过使用期限，请联系管理员！",false),
    IMPORT_DATA_NULL("300" , "数据为空，导入失败！" , true),
    TASK_NAME_NULL("300" , "请输入任务名称！" , false),
    TASK_NAME_EXISTS("-300" , "任务名称重复！" , false),
    TASK_FILE_NULL("300" , "请上传任务视频文件！" , false),
    TASK_VIOLATE_NULL("300" , "请选择解析违法类型！" , false),
    TASK_BZ_NULL("300" , "请选择场景标注信息！" , false),
    TASK_VIDEO_SAVE_STATUS("754","上传失败,网络传输异常",false),
    TASK_VIDEO_SAVE1_STATUS("755","上传失败,FTP连接已被中断",false),
    TASK_DATA_DETAILS_NULL("200","任务数据为空.",false),
    SUBMIT_DATA_STATUS_SUCESS("200","提交成功",true),
    SUBMIT_DATA_STATUS_FAIL("-300","提交失败",true),

    ;


    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 返回状态
     */
    private Boolean flag;

    private CodeUtils(String code , String message , Boolean flag) {
        this.code = code;
        this.message = message;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
