package in.sureshsarda;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	// Most of the crud queries are created automatically, but in a typical
	// application where you want customer queries, you simply implement this
	// interface in a class and write your own queries.
	public List<Customer> findAllByFirstName(String firstName);

	public List<Customer> findAllByLastName(String lastName);

	public List<Customer> findAllByFirstNameOrLastName(String firstName, String lastName);
	
	public List<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);

}
