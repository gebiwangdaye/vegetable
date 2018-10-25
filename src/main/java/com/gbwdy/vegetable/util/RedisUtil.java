package com.gbwdy.vegetable.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author gebiwangdaye
 */
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  指定缓存失效时间
     * @param key  键
     * @param time 过期时间
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取缓存失效时间
     * @param key 键
     * @return
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }


    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean isExist(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除多个缓存
     * @param keys
     */
    public void remove(List<String> keys){
        for (String key : keys){
            remove(key);
        }
    }

    /**
     * 删除单个缓存
     * @param key
     */
    public void remove(String key){
        redisTemplate.delete(key);
    }

    /**
     * 放入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 放入缓存 可设置过期时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value,long time){
        try {
            redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

}
