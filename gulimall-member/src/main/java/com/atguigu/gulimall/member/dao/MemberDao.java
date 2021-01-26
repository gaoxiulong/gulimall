package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author gaoshang
 * @email gaoshang@gmail.com
 * @date 2021-01-26 11:02:10
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
