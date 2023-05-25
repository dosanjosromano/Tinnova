package br.com.tinnova.veiculo.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class VeiculoAlteracaoRequest {
	@NotBlank
	private String descricao;
	private Boolean vendido;
}

