package by.bsuir.maven.lab.service;

import by.bsuir.maven.lab.service.exception.ServiceException;

public class AuthenticationService {
	
	private static final String username  = "admin";
	
	private static final String password  = "admin";
	
	private static final String UNAUTHORIZED_REASON  = "Invalid credentials";
	
	public void authenticate(String login, String password) {
		if(!login.equals(login) || !password.equals(this.password)) {
			throw new ServiceException(UNAUTHORIZED_REASON);
		}
		
	}

}
