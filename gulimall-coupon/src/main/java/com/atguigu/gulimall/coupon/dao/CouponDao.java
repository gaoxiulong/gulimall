package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author gaoshang
 * @email gaoshang@gmail.com
 * @date 2021-01-26 09:54:54
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
