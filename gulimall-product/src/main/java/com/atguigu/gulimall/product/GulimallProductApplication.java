package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
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
	 * 2.逻辑删除
	 *   2.1配置全局的逻辑删除规则（可以省略）
	 *   2.2配置逻辑删除的组件Bean（可以省略）
	 *   2.3在实体类字段上加逻辑删除注解@TableLogic
	 *
	 * 3.JSR303数据校验
	 * 	3.1给bean加校验注解@NotBlank,并自定义提示信息message
	 * 	3.2在controller对应save()方法上加上@Valid标明是数据校验
	 * 	3.3在controller对应save()方法上加上BindingResult参数，提示错误信息
	 * 	3.4分组校验（适用于多场景的情况）
	 * 		1）给Bean上标注什么情况需要校验，使用groups标注(需要先创建一个对应的接口)
	 * 		2）在controller上增加@Validated({AddGroup.class})注解
	 * 	 	3)分组校验只能使用于分组的情况才生效
	 *  3.5自定义校验
	 *  	1）自己编写一个自定义校验注解
	 *  	2）自己编写一个自定义的校验器
	 *  	3）关联自定义的校验器和校验注解
	 *      @Constraint(validatedBy = {ListValueConstraintValidator.class})
	 *
	 * 4.统一的异常处理@Controller
	 *  4.1编写异常处理类，使用@RestControllerAdvice注解
	 *  4.2使用@ExceptionHandler标注方法可以处理的异常
	 *
	 */

}
