package com.emdata.ivvs.common.configuration;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageInterceptor;

/**
 * @CreateDate: 2019/7/12 12:08
 * @Version: 1.0
 */
@Configuration
public class PageHelpConfig {
    @Bean
    public PageInterceptor pageHelper() {
        PageInterceptor pageHelper = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("offsetPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "false");
        properties.setProperty("reasonable", "false");
        properties.setProperty("autoRuntimeDialect", "true");
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        new SqlSessionFactoryBean().setPlugins(new Interceptor[] {pageHelper});
        return pageHelper;
    }
}
