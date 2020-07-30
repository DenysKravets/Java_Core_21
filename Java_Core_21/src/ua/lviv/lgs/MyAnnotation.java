package ua.lviv.lgs;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyAnnotation 
{
	public boolean value() default false;
}
