package com.wanhejia.rocketmq.canal.bo;

import cn.throwx.canal.gule.annotation.CanalModel;
import cn.throwx.canal.gule.common.FieldNamingPolicy;
import lombok.Data;

import java.util.Date;

/**
 * 商品信息
 *
 * @author YXF
 * @date 2020-12-23 15:27:24
 */
@CanalModel(database = "cms-order", table = "order", fieldNamingPolicy =
        FieldNamingPolicy.LOWER_UNDERSCORE)
@Data
public class OrderBO {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 店铺名称
     */
    private String shopName;

}
