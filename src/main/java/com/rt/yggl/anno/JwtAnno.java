package com.rt.yggl.anno;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtAnno {
    public String name() default "";
}
