package br.com.desafio.api.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_PERFIL")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Perfil {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String perfil;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	

}
