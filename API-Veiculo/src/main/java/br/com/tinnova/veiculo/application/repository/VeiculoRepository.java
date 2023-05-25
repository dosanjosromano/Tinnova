package br.com.tinnova.veiculo.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.tinnova.domain.Veiculo;

public interface VeiculoRepository {

	Veiculo salva(Veiculo veiculo);

	List<Veiculo> buscaTodosVeiculos();

	Veiculo buscaVeiculoId(UUID idVeiculo);

	void deletaVeiculo(Veiculo veiculo);

}
