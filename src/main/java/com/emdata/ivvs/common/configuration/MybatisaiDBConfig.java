package com.emdata.ivvs.common.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = {"com.emdata.ivvs.dao"}, sqlSessionFactoryRef = "aiDbSqlSessionFactory")
public class MybatisaiDBConfig {

    @Bean(name = "aiDb")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource") // application.properteis中对应属性的前缀
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "aiDbSqlSessionFactory")
    @Primary
    public SqlSessionFactory aiDbSqlSessionFactory(@Qualifier("aiDb") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "aiDbTransactionManager")
    @Primary
    public DataSourceTransactionManager aiDbTransactionManager(@Qualifier("aiDb") DruidDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "aiDbSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate
        aiDbSqlSessionTemplate(@Qualifier("aiDbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
