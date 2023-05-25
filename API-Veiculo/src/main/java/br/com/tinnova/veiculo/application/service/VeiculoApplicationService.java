package br.com.tinnova.veiculo.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.tinnova.domain.Veiculo;
import br.com.tinnova.veiculo.application.api.VeiculoAlteracaoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoDetalhadoResponse;
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

	@Override
	public VeiculoDetalhadoResponse buscaVeiculoId(UUID idVeiculo) {
		log.info("[inicia] VeiculoApplicationService - buscaVeiculoId ");
		Veiculo veiculo = veiculoRepository.buscaVeiculoId(idVeiculo);
		log.info("[finaliza] VeiculoApplicationService - buscaVeiculoId ");
		return new VeiculoDetalhadoResponse(veiculo);
	}

	@Override
	public void deletaVeiculoId(UUID idVeiculo) {
		log.info("[inicia] VeiculoApplicationService - deletaVeiculoId ");
		Veiculo veiculo = veiculoRepository.buscaVeiculoId(idVeiculo);
		veiculoRepository.deletaVeiculo(veiculo);
		log.info("[finaliza] VeiculoApplicationService - deletaVeiculoId ");
	}

	@Override
	public void pathAtualizaVeiculo(UUID idVeiculo, VeiculoAlteracaoRequest veiculoAlteracaoRequest) {
		log.info("[inicia] VeiculoApplicationService - pathAtualizaVeiculo ");
		Veiculo veiculo = veiculoRepository.buscaVeiculoId(idVeiculo);
		veiculo.atualiza(veiculoAlteracaoRequest);
		veiculoRepository.salva(veiculo);
		log.info("[finaliza] VeiculoApplicationService - pathAtualizaVeiculo ");
		
	}
}
