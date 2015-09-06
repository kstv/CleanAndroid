package com.promeg.github.doubanmovie.common.utils.visibility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记一个类的access scope为package-private
 *
 * 并无实际的access control作用，仅用于显式说明access scope，防止重构代码时误改
 *
 * Created by guyacong on 2015/9/6.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface PackagePrivate {

}
