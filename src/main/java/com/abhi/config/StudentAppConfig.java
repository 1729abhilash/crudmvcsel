package com.abhi.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.abhi"})
@PropertySource("classpath:db.properties")
public class StudentAppConfig {

    @Autowired
    Environment environment;


    //set up my view resolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ret = new DriverManagerDataSource();
//        ret.setDriverClassName(environment.getProperty("driver"));
//        ret.setUsername(environment.getProperty("username"));
//        ret.setPassword(environment.getProperty("password"));
//        ret.setUrl(environment.getProperty("url"));
           ret.setUsername("root");
           ret.setPassword("password");
           ret.setUrl("jdbc:mysql://localhost:3306/selexp");
           ret.setDriverClassName("com.mysql.cj.jdbc.Driver");
           return ret;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate ret = new JdbcTemplate(dataSource());

      return ret;

     }

}
