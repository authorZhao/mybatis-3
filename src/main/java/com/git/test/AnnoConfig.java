package com.git.test;

import com.git.test.mapper.UserMapper;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author authorZhao
 * @since 2023-09-06
 */
public class AnnoConfig {
    static SqlSessionFactory sqlSessionFactory = null;

    static{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //构建配置类
        Configuration configuration = new Configuration();
        //数据源
        DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/cube_zhao?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8","root","root");
        //事务类型
        JdbcTransactionFactory jdbcTransaction = null;
        jdbcTransaction = new JdbcTransactionFactory();
        //新建环境，就是settings里面的配置
        Environment dev = new Environment("dev", jdbcTransaction, dataSource);
        configuration.setEnvironment(dev);
        //添加接口文件
        configuration.addMapper(UserMapper.class);
        configuration.setCacheEnabled(false);
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        configuration.setMapUnderscoreToCamelCase(true);

        //这个类的作用暂时研究不多，看名字就知道对拍错有帮助
        ErrorContext.instance().resource("test/UserMapper.xml");
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("test/UserMapper.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, "test/UserMapper.xml", configuration.getSqlFragments());
        //添加xml，有时候需要结合注解和xml
        mapperParser.parse();
        //添加拦截器
//        configuration.addInterceptor(new MyInterceptor1());
//        configuration.addInterceptor(new MybatisOptimisticInterceptor());
        //构建
        sqlSessionFactory = sqlSessionFactoryBuilder.build(configuration);
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

    public static SqlSession getSessionByType(ExecutorType execType){
        return sqlSessionFactory.openSession(execType);
    }

    public static SqlSession getSessionByTypeAndAutoCommit(ExecutorType execType,boolean autoCommit){
        return sqlSessionFactory.openSession(execType,autoCommit);
    }


}
