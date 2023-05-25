package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.tinnova.domain.Veiculo;
import lombok.Value;

@Value
public class VeiculoListResponse {
	private UUID idVeiculo;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	
	
	public static List<VeiculoListResponse> converte(List<Veiculo> veiculos) {
		
		return veiculos.stream()
				.map(VeiculoListResponse::new)
				.collect(Collectors.toList());
	}

	public VeiculoListResponse(Veiculo veiculo) {
		
		this.idVeiculo = veiculo.getIdVeiculo();
		this.veiculo = veiculo.getVeiculo();
		this.marca = veiculo.getMarca();
		this.ano = veiculo.getAno();
		this.descricao = veiculo.getDescricao();
		
	}
	
	
}