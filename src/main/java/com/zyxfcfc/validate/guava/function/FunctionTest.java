package com.zyxfcfc.validate.guava.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-07-02
 * @Description:
 */
@Slf4j
public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Long> function = Functions.compose(new Function<Integer, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable Integer input) {
                return input * 2L;
            }
        }, new Function<String, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable String input) {
                return input.length();
            }
        });

        log.info(String.valueOf(function.apply("test")));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
    public void test(){

    }

}
