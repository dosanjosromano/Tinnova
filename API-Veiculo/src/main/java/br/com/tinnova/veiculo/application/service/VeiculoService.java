package br.com.tinnova.veiculo.application.service;

import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoResponse;

public interface VeiculoService {

	VeiculoResponse criaVeiculo(VeiculoRequest veiculoRequest);

}
