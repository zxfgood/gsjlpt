package com.zxf.gsjlpt;

import com.zxf.gsjlpt.common.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
//使用@ServletComponentScan 注解后
// Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册
//启注解事务管理
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = "com.zxf.gsjlpt.mapper", markerInterface = MyMapper.class)
// @EnableEurekaServer
public class GsjlptApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsjlptApplication.class, args);
	}

}

