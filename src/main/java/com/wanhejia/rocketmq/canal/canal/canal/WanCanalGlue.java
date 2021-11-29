package com.wanhejia.rocketmq.canal.canal.canal;

import cn.throwx.canal.gule.CanalGlue;
import cn.throwx.canal.gule.model.CanalBinLogEvent;
import cn.throwx.canal.gule.model.ModelTable;
import cn.throwx.canal.gule.support.adapter.SourceAdapterFacade;
import cn.throwx.canal.gule.support.processor.BaseCanalBinlogEventProcessor;
import cn.throwx.canal.gule.support.processor.CanalBinlogEventProcessorFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author FrozenWatermelon
 */
public class WanCanalGlue implements CanalGlue {

    private final CanalBinlogEventProcessorFactory canalBinlogEventProcessorFactory;

    @Override
    public void process(String content) {
        CanalBinLogEvent event = (CanalBinLogEvent) SourceAdapterFacade.X.adapt(CanalBinLogEvent.class, content);
        ModelTable modelTable = ModelTable.of(event.getDatabase(), event.getTable());
        List<BaseCanalBinlogEventProcessor<?>> baseCanalBinlogEventProcessors = this.canalBinlogEventProcessorFactory.get(modelTable);
        if (CollectionUtils.isEmpty(baseCanalBinlogEventProcessors)) {
            return;
        }
        baseCanalBinlogEventProcessors.forEach((processor) -> {
            processor.process(event);
        });
    }


    private WanCanalGlue(CanalBinlogEventProcessorFactory canalBinlogEventProcessorFactory) {
        this.canalBinlogEventProcessorFactory = canalBinlogEventProcessorFactory;
    }

    public static WanCanalGlue of(CanalBinlogEventProcessorFactory canalBinlogEventProcessorFactory) {
        return new WanCanalGlue(canalBinlogEventProcessorFactory);
    }
}
