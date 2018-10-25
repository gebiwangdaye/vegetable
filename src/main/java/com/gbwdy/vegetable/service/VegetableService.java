package com.gbwdy.vegetable.service;

import com.gbwdy.vegetable.vo.Vegetable;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
public interface VegetableService {
    Vegetable findVegetableByCode(String code);

    Vegetable findVegetableById(String id);

    int addVegetable(Vegetable vegetable);
}
