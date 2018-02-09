
package validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = ZipValidator.class)
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Zip {
    String message() default  "Zip must have numbers or letters and have proper length ";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
    int length() default 10;
}
