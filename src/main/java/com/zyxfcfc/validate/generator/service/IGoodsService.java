package com.zyxfcfc.validate.generator.service;

import com.zyxfcfc.validate.generator.pojo.Goods;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/11 5:47 PM
 */
public interface IGoodsService {

    int deleteByPrimaryKey(Long goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

}
