package in.sureshsarda;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

	@Bean
	public Filter getTimepassFilter() {
		return new Filter() {

			@Override
			public void init(FilterConfig filterConfig) throws ServletException {
				System.out.println("Initing a filter");

			}

			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
						throws IOException, ServletException {
				System.out.println("Wow! I got a request!");

			}

			@Override
			public void destroy() {
				// TODO Auto-generated method stub

			}

		};
	}

}
