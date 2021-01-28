package com.atguigu.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**	见common
 *  1.整合Mybatis-plus步驟：
 * 		1.1导入Mybatis-plus依赖pom.xml
 *  	1.2配置
 *         1.2.1配置数据源
 *           1）导入数据库驱动依赖pom.xml
 *           2）在application.yml中配置数据源
 *         1.2.2配置mybatis-plus
 *			 1）注解在主启动类@MapperScan
 *			 2）在application.yml中配置Mybatis-plus映射文件位置
 *
 */

/**
 * nacos注册中心配置步骤：
 * 1.修改 pom.xml 文件，引入 Nacos Discovery Starter。

	 <dependency>
	 <groupId>com.alibaba.cloud</groupId>
	 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
	 </dependency>
 2.在应用的 /src/main/resources/application.properties 配置文件中配置 Nacos Server 地址

 	 spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
 3.使用 @EnableDiscoveryClient 注解开启服务注册与发现功能

	 @SpringBootApplication
	 @EnableDiscoveryClient
	 public class ProviderApplication {

	 public static void main(String[] args) {
	 SpringApplication.run(ProviderApplication.class, args);
	 }

	 @RestController
	 class EchoController {
	 @GetMapping(value = "/echo/{string}")
	 public String echo(@PathVariable String string) {
	 return string;
	 }
	 }
	 }
 *
 *
 * nacos配置中心配置步骤：
 *  1.修改 pom.xml 文件，引入 Nacos Config Starter。

		 <dependency>
		 <groupId>com.alibaba.cloud</groupId>
		 <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
		 </dependency>
 	2.在应用的 /src/main/resources/bootstrap.properties 配置文件中配置 Nacos Config 元数据
		 spring.application.name=nacos-config-example
		 spring.cloud.nacos.config.server-addr=127.0.0.1:8848
	3.需要给配置中心添加Data Id：gulimall-coupon.properties，配置规则：应用名.properties
	4.给应用名添加任何配置
 	5.使用 @Value 注解来将对应的配置注入到 SampleController 的 userName 和 age 字段，并添加 @RefreshScope 打开动态刷新功能
		 @RefreshScope
		 class SampleController {

		 @Value("${user.name}")
		 String userName;

		 @Value("${user.age}")
		 int age;
		 }
 	注意：配置中心的配置优先于应用的配置文件
    6.配置中心相关细节
	  每个微服务创建自己的命名空间，用来隔离；使用配置分组区分环境，如：dev开发、test测试、prod上线
      在bootstrap.properties进行相关配置即可。
 */
@MapperScan("com.atguigu.gulimall.coupon.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallCouponApplication.class, args);
		System.out.println("GulimallCouponApplication 成功启动！");
	}

}
