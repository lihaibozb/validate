package com.zyxfcfc.validate.pattern.factory.sample;

/**
 * @author lihaibo
 * @version 1.0.0
 * @apiNote
 * @date 2019/7/4 11:37 AM
 */
public class SimpleRoujiamoFactory {

    public static Roujiamo createRoujiamo(String type) {
        Roujiamo roujiamo = null;
        if ("suan".equals(type)) {
            roujiamo = new SuanRoujiamo();
        } else if ("la".equals(type)) {
            roujiamo = new LaRoujiamo();
        }
        roujiamo.prepare();
        roujiamo.fire();
        roujiamo.pack();
        return roujiamo;
    }

}
