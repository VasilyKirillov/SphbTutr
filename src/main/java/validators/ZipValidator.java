package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipValidator implements ConstraintValidator<Zip, String> {

    private int lengthConstraint;
    @Override
    public void initialize(Zip constraintAnnotation) {
        lengthConstraint = constraintAnnotation.length();
    }

    @Override
    public boolean isValid(String zip, ConstraintValidatorContext context) {
       
        boolean result = zip.length() <= lengthConstraint;
        if (result) {
            for (char ch : zip.toCharArray()) {
                result &= Character.isLetterOrDigit(ch);
            }
        }
        return result;
    }

}
