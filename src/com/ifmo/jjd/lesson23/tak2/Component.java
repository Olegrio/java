package com.ifmo.jjd.lesson23.tak2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // в качестве параметров можно использовать только строки, примитивы и перечисления\
    // при использовании аннотации, обязательно требуется указание значение параметра - если нет default

    String fileName();
    long version() default 1;

}
