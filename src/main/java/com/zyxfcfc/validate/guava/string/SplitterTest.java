package com.zyxfcfc.validate.guava.string;

import com.google.common.base.Splitter;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-07-01
 * @Description:
 */
public class SplitterTest {

    public static void main(String args[]) {
        SplitterTest tester = new SplitterTest();
        tester.testSplitter();
    }

    private void testSplitter() {
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
    }


}
