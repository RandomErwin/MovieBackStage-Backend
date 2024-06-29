package org.web.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

// 自定義註解
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface PermissionAnnotation {
}
