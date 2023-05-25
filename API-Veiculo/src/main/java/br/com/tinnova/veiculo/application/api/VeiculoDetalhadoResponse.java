package br.com.tinnova.veiculo.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.tinnova.domain.Veiculo;
import lombok.Value;

@Value
public class VeiculoDetalhadoResponse {
	private UUID idVeiculo;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	private LocalDateTime created;
	private LocalDateTime update;

	public VeiculoDetalhadoResponse(Veiculo veiculo) {
		this.idVeiculo = veiculo.getIdVeiculo();
		this.veiculo = veiculo.getVeiculo();
		this.marca = veiculo.getMarca();
		this.ano = veiculo.getAno();
		this.descricao = veiculo.getDescricao();
		this.vendido = veiculo.getVendido();
		this.created = veiculo.getCreated();
		this.update = veiculo.getUpdate();
		
	}

	
	
}