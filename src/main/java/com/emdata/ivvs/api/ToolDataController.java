package com.emdata.ivvs.api;

import com.emdata.ivvs.common.constants.Constants;
import com.emdata.ivvs.common.utils.CodeUtils;
import com.emdata.ivvs.common.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: txw
 * @Date: 2019/11/20 10:53
 */

@RestController
@RequestMapping("/tools")
@Api(tags = "工具处理")
public class ToolDataController {

    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 网络地址图片转为Base64
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "手动测试获取ftp数据Api")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public JSONResult<Map<String, Object>> getData() {
        JSONResult<Map<String, Object>> result = new JSONResult<>();
        try {
            result.setCode(CodeUtils.SUCCESS.getCode());
            result.setMsg(CodeUtils.SUCCESS.getMessage());
            Map<String, Object> resultMap = new HashMap<>(Constants.DEFAULT_LIST_INITIALIZE);
        } catch (Exception e) {
            logger.error("tools/getData Exception:{}" + e);
            result.setError(CodeUtils.BACKEND_ERROR.getCode(),CodeUtils.QUERY_NULL.getMessage());
        }
        return result;
    }


}
