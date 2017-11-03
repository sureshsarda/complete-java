package in.sureshsarda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App extends AbstractMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	// Adding database repo wise is a tedious task
	// See Discussion:
	// https://stackoverflow.com/questions/12078669/spring-data-mongodb-connect-to-multiple-databases-in-one-mongo-instance
	// You have to use MongoTemplates and stuff. (Maybe I'll try this later)
	@Override
	protected String getDatabaseName() {
		return "customer_db";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}

	// This bean is not required when connecting to localhost, but including
	// here for the sake of reference.
	// Required when you are not using AbstractMongoConfiguration
	// public @Bean MongoClient mongoClient() {
	// return new MongoClient();
	// }
}
