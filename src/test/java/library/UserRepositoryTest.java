package library; // The package where this test class is located at

// Including the needed imports
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import library.beans.User;
import library.repositories.UserRepository;

@DataJpaTest // To allow for testing with JPA persistence
@AutoConfigureTestDatabase(replace = Replace.NONE) // To compare the results with the actual database
@Rollback(false) // To commit the results

public class UserRepositoryTest {
	@Autowired
	UserRepository repo;

	@Autowired
	private TestEntityManager manager;

	@Test
	public void testCreateUser() {

		// ARRANGE
		User toTest = new User("Maria", "Bravard", "mbravard@iastate.edu", "MyPassword@1234", "8303028094");

		// ACT
		User saved = repo.save(toTest); // Saving him/her
		User existing = manager.find(User.class, saved.getUserID()); // Finding the existing customer

		// ASSERT
		assertThat(existing.getFirstName()).isEqualTo(toTest.getFirstName()); // Comparing the results and testing
	}

	@Test
	public void testFindUserByEmailAddress() {

		// ARRANGE
		String username = "igbravard@dmacc.edu";

		// ACT
		User toTest = repo.findByEmail(username);

		// ASSERT
		assertThat(toTest).isNotNull(); // Making sure that an actual record was found
	}
}