package com.atguigu.gulimall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gulimall.product.dao.AttrGroupDao;
import com.atguigu.gulimall.product.entity.AttrEntity;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import com.atguigu.gulimall.product.service.AttrGroupService;
import com.atguigu.gulimall.product.service.AttrService;
import com.atguigu.gulimall.product.vo.AttrGroupWithAttrsVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    /**
     *
     * @param params
     * @param catelogId 传入的所属分类id:catelog_id
     * @return
     */

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {

        String key = (String) params.get("key");

        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>();

        if (!StringUtils.isNullOrEmpty(key)) {
            wrapper.and((obj)->{
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });

        }

        if (catelogId == 0){
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    wrapper
            );
            return new PageUtils(page);
        }else {
            //select * from pms_attr_group where catelog_id =? and (attr_group_id = key or attr_group_name like %key%)

            wrapper.eq("catelog_id",catelogId);

            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),wrapper);

            return new PageUtils(page);

        }


    }

    /**
     * 根据分类id查出所有属性分组和属性
     * @param catelogId
     * @return
     */

    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {

        //1查询分组信息
        List<AttrGroupEntity> groupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));

        //2查询所有属性，并封装成vo
        List<AttrGroupWithAttrsVo> collect = groupEntities.stream().map((group) -> {
            //封装属性分组
            AttrGroupWithAttrsVo attrsVo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(group, attrsVo);
            //封装所有属性
            List<AttrEntity> attrEntities = attrService.getRelationAttr(group.getAttrGroupId());
            attrsVo.setAttrs(attrEntities);
            return attrsVo;
        }).collect(Collectors.toList());

        return collect;
    }


}