package com.atguigu.gulimall.ware.vo;

import lombok.Data;

@Data
public class PurchaseItemDoneVo {

    private Long itemId;     //采购项
    private Integer status;  //状态
    private String reason;   //原因
}
