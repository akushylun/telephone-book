package com.akushylun.telephonebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.akushylun.telephonebook.entities.Person;
import com.akushylun.telephonebook.repository.PersonRepository;

public class UserService implements UserDetailsService {

    private PersonRepository repository;

    @Autowired
    @Qualifier("PersonRepositoryHibernate")
    public void setRepository(PersonRepository repository) {
	this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Person user = repository.findByUsername(username);
	if (user != null) {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	    return new User(user.getUsername(), user.getPassword(), authorities);
	}
	throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
