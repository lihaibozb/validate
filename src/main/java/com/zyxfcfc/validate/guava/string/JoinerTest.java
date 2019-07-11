package com.zyxfcfc.validate.guava.string;

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-07-01
 * @Description:
 */
public class JoinerTest {

    public static void main(String args[]) {
        JoinerTest tester = new JoinerTest();
        tester.testJoiner();
    }

    private void testJoiner() {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
    }

}
