package br.com.tinnova.veiculo.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class VeiculoAlteradoRequest {
	@NotBlank
	private String veiculo;
	@NotBlank
	private String marca;
	@NotNull
	private Integer ano;
	@NotBlank
	private String descricao;
	private Boolean vendido;
}
