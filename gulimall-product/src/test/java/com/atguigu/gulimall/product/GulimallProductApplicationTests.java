package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

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
