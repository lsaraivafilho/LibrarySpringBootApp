package library.repositories; // The package where this repository is located at

// Including the needed imports
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Allows access to the 'User' bean
import library.beans.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// Using a customer query to find a specific user by his/her email address
	@Query("SELECT u FROM User u WHERE u.emailAddress = ?1")
	User findByEmail(String emailAddress);
}