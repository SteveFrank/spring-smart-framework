package org.smart.framework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.smart.framwork.utils.ClassUtil;

import java.util.Set;

/**
 * @author yangqian
 * @date 2021/1/5
 */
public class ClassUtilTest {
    @DisplayName("提取目标类方法: extractPackageClassTest")
    @Test
    public void extractPackageClassTest() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("org.smart.framwork.core.annotation");
        System.out.println(classSet);
        Assertions.assertEquals(4, classSet.size());
    }

}
