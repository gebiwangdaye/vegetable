package com.gbwdy.vegetable.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
@Data
public class Vegetable {
    private int id;
    private String name ;
    private String code;
    private double price;
    private Date time;
    private Date birthday;
    private String image;
    private String place;
    private String product;
    private String checker;
    private String plantingHistory;
}
