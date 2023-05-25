package br.com.tinnova.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.tinnova.veiculo.application.api.VeiculoAlteracaoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoAlteradoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idVeiculo", updatable = false, unique = true, nullable = false)
	private UUID idVeiculo;
	@NotBlank
	private String veiculo;
	@NotBlank
	private String marca;
	@NotNull
	private Integer ano;
	@NotBlank
	private String descricao;
	private Boolean vendido;

	private LocalDateTime created;
	private LocalDateTime update;

	public Veiculo(VeiculoRequest veiculoRequest) {

		this.veiculo = veiculoRequest.getVeiculo();
		this.marca = veiculoRequest.getMarca();
		this.ano = veiculoRequest.getAno();
		this.descricao = veiculoRequest.getDescricao();
		this.vendido = false;
		this.created = LocalDateTime.now();
	}

	public void atualiza(@Valid VeiculoAlteracaoRequest veiculoRequest) {
		this.descricao = veiculoRequest.getDescricao();
		this.vendido = veiculoRequest.getVendido();
		this.update = LocalDateTime.now();
	}

	public void alteraCompleto(@Valid VeiculoAlteradoRequest veiculoRequest) {
		this.veiculo = veiculoRequest.getVeiculo();
		this.marca = veiculoRequest.getMarca();
		this.ano = veiculoRequest.getAno();
		this.descricao = veiculoRequest.getDescricao();
		this.vendido = false;
		this.update = LocalDateTime.now();
	}
}