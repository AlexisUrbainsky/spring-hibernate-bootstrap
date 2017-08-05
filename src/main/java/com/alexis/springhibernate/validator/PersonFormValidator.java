package com.alexis.springhibernate.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.alexis.springhibernate.model.Person;

@Component
public class PersonFormValidator implements Validator {
	
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		
		Person person = (Person) target;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.personForm.name");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "NotEmpty.personForm.lastName");
		ValidationUtils.rejectIfEmpty(errors, "sex", "NotEmpty.personForm.sex");
		ValidationUtils.rejectIfEmpty(errors, "email", "Pattern.userForm.email");
		
		if(!emailValidator.valid(person.getEmail())){
			errors.rejectValue("email", "Pattern.userForm.email");
		}
	}
	
}
