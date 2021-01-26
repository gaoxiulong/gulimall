package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);

		System.out.println("GulimallProductApplication 成功启动！");
	}

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
	 *
	 */

}
