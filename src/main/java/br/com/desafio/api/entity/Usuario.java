package br.com.desafio.api.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements UserDetails {	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String login; 
	private String password;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
	private List<Perfil> perfil;
	
	public Usuario(String login, String password, List<Perfil> perfil) {
		this.login = login;
	    this.password = password;
	    this.perfil = perfil;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.perfil.get(0).getPerfil().contentEquals("ROLE_ADMIN"))
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
					new SimpleGrantedAuthority("ROLE_USER"));
        else 
        	return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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
