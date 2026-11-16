package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker fk=new Faker();
	
	public String generateRandomUsername() {
		
		return fk.name().username();
	}
	public String generateRandomPassword() {
		
		return fk.internet().password();
	}
	public String generateRandomFullName() {
		
		return fk.name().fullName();
	}
	public String generateRandomEmail() {
		
		return fk.internet().emailAddress();
	}
	public String generateRandomPhoneNumber() {
		
		return fk.phoneNumber().cellPhone();
	}
	public String generateRandomAddress() {
		
		return fk.address().streetAddress();
	}

}
