package com.zyxfcfc.validate.pattern.factory.sample;

/**
 * description:
 *
 * @author lihaibo
 * @version 1.0.0
 * @date 2019/7/4 11:14 AM
 */
public class RoujiamoStore {

    public Roujiamo sellRoujiamo(String type) {
        return SimpleRoujiamoFactory.createRoujiamo(type);
    }

    public static void main(String[] args) {
        RoujiamoStore roujiamoStore = new RoujiamoStore();
        roujiamoStore.sellRoujiamo("la");
    }

}
