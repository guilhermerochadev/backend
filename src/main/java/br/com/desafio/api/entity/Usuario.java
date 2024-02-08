package br.com.desafio.api.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String login; 
	private String password;
	@OneToMany
	private Perfil role;
	
	
	public Usuario(String login, String password, Perfil role) {
		this.login = login;
	    this.password = password;
	    this.role = role;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(role.getRole().endsWith("ROLE_ADMIN")) 
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), 
					new SimpleGrantedAuthority("ROLE_USER"));
        else 
        	return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		
		//return List.of(new SimpleGrantedAuthority(role.getRole()));
	}
	
	@Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }	
	
}
