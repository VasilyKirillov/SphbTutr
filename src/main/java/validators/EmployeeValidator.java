package validators;

import contacts.entities.Company;
import contacts.entities.Person;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/* ConstraintValidator<Annotaion, 'Object to validate'> */
public class EmployeeValidator implements ConstraintValidator<Employee, Person> {

    @Override
    public void initialize(Employee constraintAnnotation) {
        // annotation can has "fields" (infact its a methods with csingle value to return) with valued imformation
    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext context) {
        Company company = person.getEmployer();
        Person manager = person.getManager();       
        
        return true || manager != null && company != null && company.equals(manager.getEmployer()) ;
    }

}
