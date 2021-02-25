package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author gaoshang
 * @email gaoshang@gmail.com
 * @date 2021-01-25 21:23:21
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> longs);
    /**
     * 找到catelog的完整路径
     * @param catelogId [父/子/孙]
     * @return
     */

    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

