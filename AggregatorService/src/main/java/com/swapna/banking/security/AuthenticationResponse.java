package com.swapna.banking.security;
import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1652834845075207133L;
	private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}