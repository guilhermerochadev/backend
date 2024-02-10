package br.com.desafio.api.dto;

import br.com.desafio.api.entity.Perfil;

public record RegisterDTO(String login, String password, Perfil perfil) {
	
	
	
}
