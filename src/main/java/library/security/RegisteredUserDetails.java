package library.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import library.beans.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisteredUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User registeredUser;

	/**
	 * This is the nondefault constructor that sets the user field of this class.
	 * 
	 * @param toFind - the user to be set
	 */
	public RegisteredUserDetails(User toFind) {
		setRegisteredUser(toFind);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	/**
	 * Thiss method gets the password value for each particular user.
	 * 
	 * @return the user's password
	 */
	@Override
	public String getPassword() {
		return registeredUser.getPassword();
	}

	/**
	 * This method gets the username (email) for each particular user.
	 * 
	 * @return the user's username (email)
	 */
	@Override
	public String getUsername() {
		return registeredUser.getEmailAddress();
	}

	/**
	 * This method checks whether a given user account is expired or not.
	 * 
	 * @return true - the account is not expired; false otherwise
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * This method checks whether a given user account is locked or not.
	 * 
	 * @return true - the user account is locked; false otherwise
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * This method checks whether a given user account's credentials are expired or
	 * not.
	 * 
	 * @return true - the credentials have expired; false otherwise
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * This method checks whether a given user account is enabled or not.
	 * 
	 * @return true - the account is enabled; false otherwise
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName() {
		return registeredUser.getFirstName() + " " + registeredUser.getLastName();
	}
}