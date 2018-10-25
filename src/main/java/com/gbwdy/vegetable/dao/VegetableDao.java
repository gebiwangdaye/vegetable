package com.gbwdy.vegetable.dao;

import com.gbwdy.vegetable.vo.Vegetable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 *
 */
@Mapper
public interface VegetableDao {

    @Select("select id,name,code,price,time,birthday,image,place,product,checker,planting_history from vegetable where code =#{code}")
    Vegetable findVegetableByCode(String code);

    @Select("select id,name,code,price,time,birthday,image,place,product,planting_history from vegetable where id =#{id}")
    Vegetable findVegetableById(String id);

    @Insert("insert into vegetable values(#{id},#{name},#{code},#{price},#{time},#{birthday},#{image},#{place},#{product},#{checker},#{plantingHistory})")
    int addVegetable(Vegetable vegetable);
}

