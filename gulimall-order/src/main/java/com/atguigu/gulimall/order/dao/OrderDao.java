package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author gaoshang
 * @email gaoshang@gmail.com
 * @date 2021-01-26 11:18:26
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
