package com.zyxfcfc.validate.pattern.factory.sample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/4 11:23 AM
 */
@Slf4j
public class Roujiamo {

    /**
     * 肉夹馍的名字
     */
    private String name;

    /**
     * description: 准备工作
     *
     * @param
     * @return
     */
    public void prepare() {
        log.info("揉面-剁肉-完成准备工作");
    }

    /**
     * description: 包装
     *
     * @param
     * @return
     */
    public void pack() {
        log.info("肉夹馍-专用袋-包装");
    }

    /**
     * @param
     * @return
     * @apiNote 烘烤
     */
    public void fire() {
        log.info("肉夹馍-专用设备-烘烤");
    }

}
