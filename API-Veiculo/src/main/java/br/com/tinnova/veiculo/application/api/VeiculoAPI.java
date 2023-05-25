package br.com.tinnova.veiculo.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
