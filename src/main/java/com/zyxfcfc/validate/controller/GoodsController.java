package com.zyxfcfc.validate.controller;

import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.zyxfcfc.validate.generator.pojo.Goods;
import com.zyxfcfc.validate.generator.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/11 5:53 PM
 */
@RestController
public class GoodsController {

    @Autowired
    private KeyGenerator keyGenerator;

    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/goods/save")
    public String save(){
        for(int i= 1 ; i <= 40 ; i ++){
            Goods goods = new Goods();
            goods.setGoodsId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            goodsService.insert(goods);
        }
        return "success";
    }

}
