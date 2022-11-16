package library.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String raw = "MyPassword@1234";
		String encoded = encoder.encode(raw);
		
		System.out.println(encoded);
	}
}