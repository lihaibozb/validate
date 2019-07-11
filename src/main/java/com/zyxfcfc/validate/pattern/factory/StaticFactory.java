package com.zyxfcfc.validate.pattern.factory;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * description: 类+静态方法，就是静态工厂
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/4 11:08 AM
 */
public class StaticFactory {

    public static boolean isEmpty(List list){
        return CollectionUtils.isEmpty(list);
    }

}
