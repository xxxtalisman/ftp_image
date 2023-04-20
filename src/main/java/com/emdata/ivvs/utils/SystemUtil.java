package com.emdata.ivvs.utils;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Date: 2019/2/27 16:42
 * @Version: 1.0
 * @Author: pengqingfeng
 * @Description:
 */
@Slf4j
public class SystemUtil {

    /***
     * 添加权限
     * @param path
     */
    public static void addPermission(String path) {
        if (isWin() || StrUtil.isBlank(path)) {
            return;
        }
        String command = "sudo chmod 777 " + path;
        try {
            if (!command.equals("/")) {
                Runtime.getRuntime().exec(command);
            }
        } catch (Exception e) {
            log.error("======Runtime.getRuntime addPermission Exceptions======{}", command);
        }
    }

    /**
     * 判断当前系统
     *
     * @return
     */
    public static boolean isWin() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "/violation/2019-12-27/320595000000090160_150684_2_20191227071324_NULL_NULL_02_苏E900V1_13441_320500000900_NULL_9_1_1_1_LFBJBBB132JA18840_NULL_1006_NULL_NULL_NULL_GP01.jpg";
        //获取照片名称
        String fileSubName = a.substring(a.lastIndexOf("/") + 1);
        System.out.println(fileSubName);

    }
}
