package com.Remento.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.Remento.Model.TestModel;

@Component
public class SecurityProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String id = (String) authentication.getPrincipal();
		String pw = (String) authentication.getCredentials();
		
		System.out.println( id );
		System.out.println( pw );
		
		if (id.equals("aaa") && pw.equals("aaa") ) {
			List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
			role.add(new SimpleGrantedAuthority("ROLE_USER"));
			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(id, pw, role);
			result.setDetails( new TestModel(id, pw) );
			return result;
		} else {
			throw new BadCredentialsException("Bad");
		}
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
