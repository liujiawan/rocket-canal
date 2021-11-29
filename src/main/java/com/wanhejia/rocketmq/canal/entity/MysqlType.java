package com.wanhejia.rocketmq.canal.entity;

import java.io.Serializable;

/**
 * Author:zhansan
 * Date:2021/11/29
 * Description:
 */
public class MysqlType implements Serializable {
    private String id;
    private String commodity_name;
    private String commodity_price;
    private String number;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(String commodity_price) {
        this.commodity_price = commodity_price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
