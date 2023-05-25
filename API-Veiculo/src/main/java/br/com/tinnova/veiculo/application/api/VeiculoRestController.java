package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.tinnova.veiculo.application.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class VeiculoRestController implements VeiculoAPI {

	private final VeiculoService veiculoService;

	@Override
	public VeiculoResponse postVeiculo(VeiculoRequest veiculoRequest) {
		log.info("[inicia]VeiculoController -  postVeiculo");
		VeiculoResponse veiculoCriado = veiculoService.criaVeiculo(veiculoRequest);
		log.info("[finaliza]VeiculoController -  postVeiculo");
		return veiculoCriado;
	}

	@Override
	public List<VeiculoListResponse> getTodosVeiculos() {
		log.info("[inicia]VeiculoController -  getTodosVeiculos");
		List<VeiculoListResponse> veiculos = veiculoService.buscaTodosVeiculos();
		log.info("[finaliza]VeiculoController -  getTodosVeiculos");
		return veiculos;
	}

	@Override
	public VeiculoDetalhadoResponse getVeiculoAtravesId(UUID idVeiculo) {
		log.info("[inicia]VeiculoController - getVeiculoAtravesId");
		log.info("[idVeiculo] {}", idVeiculo);
		VeiculoDetalhadoResponse veiculoDetalhado = veiculoService.buscaVeiculoId(idVeiculo);
		log.info("[finaliza]VeiculoController - getVeiculoAtravesId");
		return veiculoDetalhado;
	}

	@Override
	public void deletaVeiculoAtravesId(UUID idVeiculo) {
		log.info("[inicia]VeiculoController - deletaVeiculoAtravesId");
		veiculoService.deletaVeiculoId(idVeiculo);
		log.info("[finaliza]VeiculoController -  deletaVeiculoAtravesId");
		
	}

	@Override
	public void pathAtualizaVeiculo(UUID idVeiculo, @Valid VeiculoAlteracaoRequest veiculoAlteracaoRequest) {
		log.info("[inicia]VeiculoController - pathAtualizaVeiculo");
		log.info("[idVeiculo] {}", idVeiculo);
		veiculoService.pathAtualizaVeiculo(idVeiculo, veiculoAlteracaoRequest);
		log.info("[finaliza]VeiculoController -  pathAtualizaVeiculo");
	}
	
	@Override
	public void putAlteraVeiculoCompleto(UUID idVeiculo,
			@Valid VeiculoAlteradoRequest veiculoAlteracaoCompletaRequest) {
		log.info("[inicia]VeiculoController - putAlteraVeiculoCompleto");
		log.info("[idVeiculo] {}", idVeiculo);
		veiculoService.putAlteraVeiculoCompleto(idVeiculo, veiculoAlteracaoCompletaRequest);
		log.info("[finaliza]VeiculoController -  putAlteraVeiculoCompleto");
		
	}

	
}
