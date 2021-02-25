package com.atguigu.gulimall.thirdparty;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallThirdPartyApplicationTests {

	@Test
	void textLoads() {
	}

	@Autowired
	OSSClient ossClient;

	@Test
	void upload() {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
/*        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4Fykx4yKZr1LHf15eJX5";
        String accessKeySecret = "zhOs919PewfJGaXkU9vaqewvWzDoHO";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);*/

// 上传文件流。
		InputStream inputStream = null;
		String fileName = "55.jpg";
		String objectName = "upfile/" + fileName;  //必填
		try {
			inputStream = new FileInputStream("D:\\55.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ossClient.putObject("gulimall-ywst", objectName, inputStream);

// 关闭OSSClient。
		ossClient.shutdown();

		System.out.println("文件上传成功~~");
	}

}
