package com.zyxfcfc.validate.generator.service.impl;

import com.zyxfcfc.validate.generator.dao.GoodsMapper;
import com.zyxfcfc.validate.generator.pojo.Goods;
import com.zyxfcfc.validate.generator.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/11 5:47 PM
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(Long goodsId) {
        return goodsMapper.deleteByPrimaryKey(goodsId);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public Goods selectByPrimaryKey(Long goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }
}
