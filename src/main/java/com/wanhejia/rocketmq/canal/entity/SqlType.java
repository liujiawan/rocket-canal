package com.wanhejia.rocketmq.canal.entity;

import java.io.Serializable;

/**
 * Author:zhansan
 * Date:2021/11/29
 * Description:
 */
public class SqlType  implements Serializable {
    private int id;
    private int commodity_name;
    private int commodity_price;
    private int number;
    private int description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(int commodity_name) {
        this.commodity_name = commodity_name;
    }

    public int getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(int commodity_price) {
        this.commodity_price = commodity_price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
