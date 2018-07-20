package com.uifuture.entity;

import com.uifuture.common.BaseEntity;

import java.math.BigDecimal;

/**
 * test comment
 * 数据库表: book
 * @author chenhaoxiang 2018-07-20
 */
public class Book extends BaseEntity {
    /**
     * 书名
     * Table Fields : book.name
     */
    private String name;

    /**
     * 价格
     * Table Fields : book.price
     */
    private BigDecimal price;

    /**
     * studid
     * Table Fields : book.studid
     */
    private String studid;

    /**
     * 书名
     * @return name 书名
     */
    public String getName() {
        return name;
    }

    /**
     * 书名
     * @param name 书名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 价格
     * @return price 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 价格
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * studid
     * @return studid studid
     */
    public String getStudid() {
        return studid;
    }

    /**
     * studid
     * @param studid studid
     */
    public void setStudid(String studid) {
        this.studid = studid == null ? null : studid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", studid=").append(studid);
        sb.append("]");
        return sb.toString();
    }
}