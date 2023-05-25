package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public interface VeiculoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	VeiculoResponse postVeiculo(@Valid @RequestBody VeiculoRequest veiculoRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
    List<VeiculoListResponse> getTodosVeiculos();
	
	@GetMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.OK)
    VeiculoDetalhadoResponse getVeiculoAtravesId(@PathVariable UUID idVeiculo);
	
	@DeleteMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaVeiculoAtravesId(@PathVariable UUID idVeiculo);
	
	@PatchMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void pathAtualizaVeiculo(@PathVariable UUID idVeiculo,
			@Valid @RequestBody VeiculoAlteracaoRequest veiculoAlteracaoRequest);
	
	@PutMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void putAlteraVeiculoCompleto(@PathVariable UUID idVeiculo,
			@Valid @RequestBody VeiculoAlteradoRequest veiculoAlteracaoCompletaRequest);
}
