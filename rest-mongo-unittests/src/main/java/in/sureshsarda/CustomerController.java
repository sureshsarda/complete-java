package in.sureshsarda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;

	@RequestMapping(value = "/", method = {
				RequestMethod.GET
	})

	public List<Customer> index(
				@RequestParam String firstName,
				@RequestParam String lastName) {

		if (firstName == null) {
			return customerRepo.findAllByLastName(lastName);
		} else if (lastName == null) {
			return customerRepo.findAllByFirstName(firstName);
		} else {
			return customerRepo.findAllByFirstNameAndLastName(firstName, lastName);
		}

	}

	@RequestMapping(value = "/", method = {
				RequestMethod.POST
	})
	public String insert(
				@RequestBody Customer cust) {
		Customer saved = customerRepo.insert(cust);
		return saved.id;
	}

}
