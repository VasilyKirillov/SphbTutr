
package validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;


@Documented //?
@Constraint(validatedBy = EmployeeValidator.class) /* means that this annotatoin is a constraint thhat should be validated by specific class */
@Target(ElementType.TYPE) /* This means that annotation is applicable for Class only */
@Retention(RetentionPolicy.RUNTIME) /* at runtime we can see that this class marked with this annotation */
public @interface Employee {
    /* annotation magic . mandatory */
    String message() default "manager and employee must work for the same company";  //?
    Class<?>[] groups() default {};          //mandatory for Validator
    Class<?>[] payload() default {};        //mandatory for Validator
}
