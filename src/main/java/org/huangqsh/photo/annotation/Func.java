package org.huangqsh.photo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Func {
	
	String name();
    String code();
    
    /** 是否是功能模块 */
    boolean isFuncModule();
    /** 是否需要鉴权 */
    boolean needCheck();
    /** 是否开放 */
    boolean isOpen();
    /** 先导功能 */
    String precursorFuncCode() default "";
    
    /** 数据权限依赖 */
    String dataPermissionFuncCode() default "";
    /** 模块依赖 */
    String moduleFuncCode() default "";
    String moduleFuncFullCode() default "";
    String description() default "";
    String remark() default "";

}
