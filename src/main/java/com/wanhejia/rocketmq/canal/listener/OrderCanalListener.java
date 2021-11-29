package com.wanhejia.rocketmq.canal.listener;

import cn.throwx.canal.gule.model.CanalBinLogEvent;
import cn.throwx.canal.gule.model.CanalBinLogResult;
import cn.throwx.canal.gule.support.processor.BaseCanalBinlogEventProcessor;
import cn.throwx.canal.gule.support.processor.ExceptionHandler;
import com.alibaba.fastjson.JSON;
import com.wanhejia.rocketmq.canal.bo.OrderBO;
import com.wanhejia.rocketmq.canal.exception.RrException;
import com.wanhejia.rocketmq.canal.utils.ElasticSearchUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 订单的监听
 * @author FrozenWatermelon
 * @date 2021/02/03
 */
@Component
public class OrderCanalListener extends BaseCanalBinlogEventProcessor<OrderBO> {

    private static final Logger log = LoggerFactory.getLogger(OrderCanalListener.class);

    @Autowired
    private ElasticSearchUtils elasticSearchUtils;

    /**
     * 插入订单，此时插入es
     */
    @Override
    protected void processInsertInternal(CanalBinLogResult<OrderBO> result) {
        Long orderId = result.getPrimaryKey();
        if(elasticSearchUtils.existsById("order",orderId+"")){
            try {
                elasticSearchUtils.updateDataById(JSON.toJSONString(result.getAfterData()),"order",
                        orderId+"");
            } catch (Exception e) {
                log.info("插入数据失败"+e.getMessage());
            }
        }else{
            try {
                elasticSearchUtils.addData(JSON.toJSONString(result.getAfterData()),"order",
                        orderId+"");
            } catch (Exception e) {
                log.info("插入数据失败"+e.getMessage());
            }
        }
    }

    /**
     * 更新订单，删除订单索引，再重新构建一个
     */
    @Override
    protected void processUpdateInternal(CanalBinLogResult<OrderBO> result) {
        Long orderId = result.getPrimaryKey();
        if(elasticSearchUtils.existsById("order",orderId+"")){
            try {
                elasticSearchUtils.updateDataById(JSON.toJSONString(result.getAfterData()),"order",
                        orderId+"");
            } catch (Exception e) {
                log.info("插入数据失败"+e.getMessage());
            }
        }else{
            try {
                elasticSearchUtils.addData(JSON.toJSONString(result.getAfterData()),"order",
                        orderId+"");
            } catch (Exception e) {
                log.info("插入数据失败"+e.getMessage());
            }
        }
    }

    @Override
    protected ExceptionHandler exceptionHandler() {
        return (CanalBinLogEvent event, Throwable throwable) -> {
            throw new RrException("创建索引异常",throwable);
        };
    }
}
