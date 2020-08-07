package com.example.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

//어플리케이션 시작지점에 동작해야하는 것들을 설정하는 것이 config이다
//MyBatis 연동 config
@Slf4j          //loging 관련 모듈
@Configuration
public class DatabaseConfig {
    @Autowired
    private ApplicationContext applicationContext;

    //모든 Mybatis 애플리케이션은 SqlSessionFaactory인스턴스를 사용한다.
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.springboot.domain");       //해당 Alias를 통해 com.example.springboot.domain구문을 @Alias("String") 내부의 String으로 지정할 수 있다.
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));       //classpath의 mapper패키지의 모든 xml을 Mapper와 연동한다.
        //Mapper는 매핑된 구문을 바인딩 하기 위한 인터페이스로 Mapper인스턴스는 SqlSession에서 생성한다.

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
