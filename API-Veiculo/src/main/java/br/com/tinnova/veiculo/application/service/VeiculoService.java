package br.com.tinnova.veiculo.application.service;

import java.util.List;

import br.com.tinnova.veiculo.application.api.VeiculoListResponse;
import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoResponse;

public interface VeiculoService {

	VeiculoResponse criaVeiculo(VeiculoRequest veiculoRequest);

	List<VeiculoListResponse> buscaTodosVeiculos();

}
