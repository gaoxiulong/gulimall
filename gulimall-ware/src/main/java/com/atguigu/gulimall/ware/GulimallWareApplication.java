package com.atguigu.gulimall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableTransactionManagement
//@MapperScan("com.atguigu.gulimall.ware.dao")
@EnableFeignClients(basePackages = "com.atguigu.gulimall.ware.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallWareApplication.class, args);
		System.out.println("GulimallWareApplication已经成功启动！");
	}

}
