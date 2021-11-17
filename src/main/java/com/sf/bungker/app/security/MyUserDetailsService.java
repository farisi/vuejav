package com.sf.bungker.app.security;

import com.sf.bungker.app.entities.Role;
import com.sf.bungker.app.entities.User;
import com.sf.bungker.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService
{
	private final UserRepository userRepository;

	@Autowired
	public MyUserDetailsService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
	{
		User user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("Could not find Username");
		return new MyUserDetails(user, getGrantedAuthorities(user.getRoles()));
	}

	private List<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles)
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
}