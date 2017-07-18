package com.team.hk.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lidongliang on 2017/6/30.
 * Annotation
 */

@DefinedAnnotation() // 调用自定义注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTest {

    @Test
    public void Test() {
        // 通过反射获得自定义Annotation
        DefinedAnnotation definedAnnotation = AnnotationTest.class.getAnnotation(DefinedAnnotation.class);
        System.out.println("annotation = " + definedAnnotation.value()[0]);
    }
}
