package br.com.desafio.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.desafio.api.repositories.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	UsuarioRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 return userRepo.findByLogin(username);
	}
}
