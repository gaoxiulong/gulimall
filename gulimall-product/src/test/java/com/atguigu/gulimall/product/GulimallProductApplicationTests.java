package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@Slf4j
@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void testFindPath(){
        Long[] path = categoryService.findCatelogPath(225L);

        log.info("完整路径：{}", Arrays.asList(path));

    }


/*    @Autowired
    private OSSClient ossClient;

    //简单文件上传到阿里云oss上测试
    @Test
    void upload() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4Fykx4yKZr1LHf15eJX5";
        String accessKeySecret = "zhOs919PewfJGaXkU9vaqewvWzDoHO";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
        InputStream inputStream = null;
        String fileName = "5.jpg";
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
    }*/

    //增加数据
    @Test
    void testSave() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为2");

        boolean b = brandService.save(brandEntity);

        System.out.println("保存结果：" + b);

    }

    //修改数据
    @Test
    void testUpdate() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("任正菲");

        brandService.updateById(brandEntity);

        System.out.println("更新成功");

    }

    //查询数据
    @Test
    void testQuery() {
        //简单查询
        System.out.println(brandService.getById(1));

        BrandEntity brandEntity = new BrandEntity();

        //复杂查询
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));

        for (BrandEntity out : list) {
            System.out.println(out);
        }

    }

    //删除数据***************************************************************************
    @Test
    void testDelete() {

        //常用快捷键
        //1.ctrl + alt + v 自动添加返回值
        boolean id = brandService.removeById(3);

        //2.Tab 快捷补全代码 比如：sout
        System.out.println(id);

        //ctrl + alt + space 自动提示代码
        if (id == true) {
            System.out.println("删除成功！");
        }
        //3.导包相关快捷键：
        // 1）设置自动导包settings-Editor-Genenal-Auto Import-Add&Optimize---重要
        // 2）alt+enter 手动导同类包  --补充
        // 3）Ctrl+Alt+O 优化导入的类和包<===等同于===>Optimize  ---基本不用

        // 4.写好代码之后ctrl+alt+l格式化代码

    }
}
