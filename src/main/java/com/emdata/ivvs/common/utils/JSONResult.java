package com.emdata.ivvs.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.context.MessageSource;

import java.io.Serializable;
import java.util.Locale;

/**
 *
 */
public class JSONResult<T> implements Serializable {


    private boolean success = true;

    private String code;

    private String msg;

    private T data;

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public boolean getSuccess()
    {
        return this.success;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }



    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public String toJson()
    {
        return JSON.toJSONString(this);
    }

    public void setError(String errorCode, MessageSource messageSource,
                         Object... params)
    {
        this.setSuccess(false);
        this.setCode(errorCode);
        this.setMsg(messageSource.getMessage(errorCode, params,
                Locale.SIMPLIFIED_CHINESE));
    }

    public void setError(String errorCode, String errorInfo)
    {
        this.setSuccess(false);
        this.setCode(errorCode);
        this.setMsg(errorInfo);
    }

    @SuppressWarnings("all")
    public void setError(String errorCode, MessageSource messageSource)
    {
        setError(errorCode, messageSource, null);
    }

    public JSONResult() {
        this.code = CodeUtils.SUCCESS.getCode();
        this.msg = CodeUtils.SUCCESS.getMessage();
    }
}