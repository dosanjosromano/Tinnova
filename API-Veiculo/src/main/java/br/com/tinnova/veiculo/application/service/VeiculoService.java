package br.com.tinnova.veiculo.application.service;

import java.util.List;
import java.util.UUID;

import br.com.tinnova.veiculo.application.api.VeiculoAlteracaoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoDetalhadoResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListResponse;
import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoResponse;

public interface VeiculoService {

	VeiculoResponse criaVeiculo(VeiculoRequest veiculoRequest);

	List<VeiculoListResponse> buscaTodosVeiculos();

	VeiculoDetalhadoResponse buscaVeiculoId(UUID idVeiculo);

	void deletaVeiculoId(UUID idVeiculo);

	void pathAtualizaVeiculo(UUID idVeiculo, VeiculoAlteracaoRequest veiculoAlteracaoRequest);

}
