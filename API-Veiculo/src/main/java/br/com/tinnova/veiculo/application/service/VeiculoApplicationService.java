package br.com.tinnova.veiculo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tinnova.domain.Veiculo;
import br.com.tinnova.veiculo.application.api.VeiculoListResponse;
import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoResponse;
import br.com.tinnova.veiculo.application.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class VeiculoApplicationService implements VeiculoService {

	private final VeiculoRepository veiculoRepository;

	@Override
	public VeiculoResponse criaVeiculo(VeiculoRequest veiculoRequest) {
		log.info("[inicia] VeiculoApplicationService - criaVeiculo ");
		Veiculo veiculo = veiculoRepository.salva(new Veiculo(veiculoRequest));
		log.info("[finaliza] VeiculoApplicationService - criaVeiculo ");
		return VeiculoResponse.builder()
				.idVeiculo(veiculo.getIdVeiculo())
				.build();
	}

	@Override
	public List<VeiculoListResponse> buscaTodosVeiculos() {
		log.info("[inicia] VeiculoApplicationService - buscaTodosVeiculos ");
		List<Veiculo> veiculos = veiculoRepository.buscaTodosVeiculos();
		log.info("[finaliza] VeiculoApplicationService - buscaTodosVeiculos ");
		return VeiculoListResponse.converte(veiculos);
	}

}
