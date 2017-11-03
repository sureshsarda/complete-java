package in.sureshsarda;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// This annotation is not required if you don't want the default name
// The default name is the name of the class with first character as lowercase.
@Document(collection = "customers")
public class Customer {

	@Id
	public String id;

	// No annotation, fields in DB must be of same name
	public String firstName;

	public String lastName;

	public Customer() {}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[FirstName: %s, LastName: %s]", this.firstName, this.lastName);
	}
}
