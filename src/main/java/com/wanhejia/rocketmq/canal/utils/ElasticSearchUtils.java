package com.wanhejia.rocketmq.canal.utils;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * es 的工具类
 *
 * @author czchen
 * @version 1.0
 * @date 2020/8/25 14:37
 */
@Component
public class ElasticSearchUtils {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    /**
     * 数据添加，正定ID
     *
     * @param jsonMap 要增加的数据
     * @param index      索引，类似数据库
     * @param id         数据ID, 为null时es随机生成
     * @return
     */
    public String addData(String jsonMap, String index, String id) throws IOException {
        //创建请求
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        //request.timeout(TimeValue.timeValueSeconds(1));
        //将数据放入请求 json
        IndexRequest source = request.source(jsonMap, XContentType.JSON);
        //客户端发送请求
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        return response.getId();
    }



    /**
     * 数据添加 随机id
     *
     * @param jsonMap 要增加的数据
     * @param index      索引，类似数据库
     * @return
     */
    public String addData(String jsonMap, String index) throws IOException {
        return addData(jsonMap, index, UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
    }



    /**
     * 通过ID 更新数据
     *
     * @param jsonMap     要增加的数据
     * @param index      索引，类似数据库
     * @param id         数据ID
     * @return
     */
    public void updateDataById(String jsonMap, String index, String id) throws IOException {
        //更新请求
        index=index+"_"+"test";
        UpdateRequest update = new UpdateRequest(index, id);

        //保证数据实时更新
        update.setRefreshPolicy("true");
        update.doc(jsonMap);
        update.retryOnConflict(3);
        //执行更新请求
        UpdateResponse update1 = restHighLevelClient.update(update, RequestOptions.DEFAULT);
    }
    public  boolean existsById(String index,String id) {
        try{
            index=index+"_"+"test";
            GetRequest request = new GetRequest(index, id);
            //不获取返回的_source的上下文
            request.fetchSourceContext(new FetchSourceContext(false));
            request.storedFields("_none_");
            return restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        }catch (Exception e){
            return false;
        }

    }



}
