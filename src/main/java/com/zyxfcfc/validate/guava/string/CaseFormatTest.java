package com.zyxfcfc.validate.guava.string;

import com.google.common.base.CaseFormat;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-07-01
 * @Description:
 */
public class CaseFormatTest {
    public static void main(String args[]) {
        CaseFormatTest tester = new CaseFormatTest();
        tester.testCaseFormat();
    }

    private void testCaseFormat() {
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }

}
