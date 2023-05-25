package br.com.tinnova.veiculo.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.tinnova.domain.Veiculo;
import br.com.tinnova.veiculo.application.repository.VeiculoRepository;
import br.com.tinnova.veiculo.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class VeiculoInfraRepository implements VeiculoRepository {

	private final VeiculoSpringDataJPARepository veiculoSpringDataJPARepository;

	@Override
	public Veiculo salva(Veiculo veiculo) {
		log.info("[inicia] VeiculoInfraRepository - salva");
		veiculoSpringDataJPARepository.save(veiculo);
		log.info("[finaliza] VeiculoInfraRepository - salva");
		return veiculo;
	}

	@Override
	public List<Veiculo> buscaTodosVeiculos() {
		log.info("[inicia] VeiculoInfraRepository - buscaTodosVeiculos");
		List<Veiculo> todosVeiculos = veiculoSpringDataJPARepository.findAll();
		log.info("[finaliza] VeiculoInfraRepository - buscaTodosVeiculos");
		return todosVeiculos;
	}

	@Override
	public Veiculo buscaVeiculoId(UUID idVeiculo) {
		log.info("[inicia] VeiculoInfraRepository - buscaVeiculoId");
		Veiculo veiculo = veiculoSpringDataJPARepository.findById(idVeiculo)
				.orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Veículo não encontrado!"));
		log.info("[finaliza] VeiculoInfraRepository - buscaVeiculoId");
		return veiculo;
	}

	@Override
	public void deletaVeiculo(Veiculo veiculo) {
		veiculoSpringDataJPARepository.delete(veiculo);
	}
}
