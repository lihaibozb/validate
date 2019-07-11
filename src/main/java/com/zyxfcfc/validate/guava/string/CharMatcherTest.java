package com.zyxfcfc.validate.guava.string;

import com.google.common.base.CharMatcher;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-07-01
 * @Description:
 */
public class CharMatcherTest {
    public static void main(String args[]) {
        CharMatcherTest tester = new CharMatcherTest();
        tester.testCharMatcher();
    }

    private void testCharMatcher() {
        // only the digits
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123"));
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("     Mahesh     Parashar ", ' '));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        // star out all digits
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh123", "*"));
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("mahesh123"));
        // eliminate all characters that aren't digits or lowercase
    }

}
