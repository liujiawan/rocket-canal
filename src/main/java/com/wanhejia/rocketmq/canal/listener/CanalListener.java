package com.wanhejia.rocketmq.canal.listener;

import cn.throwx.canal.gule.CanalGlue;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author FrozenWatermelon
 * @date 2021/02/03
 */
@Component
@RocketMQMessageListener(topic = "cms-article",consumerGroup = "cms-article")
public class CanalListener implements RocketMQListener<String> {

    @Autowired
    private CanalGlue canalGlue;

    @Override
    public void onMessage(String message) {
        canalGlue.process(message);
    }
}