package com.atguigu.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1.想要远程调用别的服务
 *   1.1引入open-feign
 *   1.2编写一个接口，告诉SpringCloud这个接口需要调用远程服务
 *		1)声明接口的每一个方法调用远程服务的每一个请求全路径
 *	1.3开启远程调用功能@EnableFeignClients
 *
 */

@EnableFeignClients("com.atguigu.gulimall.member.feign")
@MapperScan("com.atguigu.gulimall.member.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallMemberApplication.class, args);
		System.out.println("GulimallMemberApplication启动成功！");
	}


}
