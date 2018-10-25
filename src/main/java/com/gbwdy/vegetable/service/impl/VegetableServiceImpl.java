package com.gbwdy.vegetable.service.impl;

import com.gbwdy.vegetable.dao.VegetableDao;
import com.gbwdy.vegetable.service.VegetableService;
import com.gbwdy.vegetable.vo.Vegetable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
@Service
public class VegetableServiceImpl implements VegetableService {

    @Resource
    VegetableDao vegetableDao;
    @Override
    public Vegetable findVegetableByCode(String code) {
        return vegetableDao.findVegetableByCode(code);
    }

    @Override
    public Vegetable findVegetableById(String id) {
        return vegetableDao.findVegetableById(id);
    }

    @Override
    public int addVegetable(Vegetable vegetable) {
        return vegetableDao.addVegetable(vegetable);
    }
}
