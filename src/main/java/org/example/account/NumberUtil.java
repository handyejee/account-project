package org.example.account;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class NumberUtil {
//    private NumberUtil() {
//        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
//    }// util 성 클래스 : 객체는 껍데기, 실제로는 아래 메서드에서 수행할때


    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public static Integer minus(Integer a, Integer b) {
        return a - b;
    }

}
