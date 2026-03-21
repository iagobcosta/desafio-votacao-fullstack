package br.tec.db.voting_api.controller;

import br.tec.db.voting_api.config.ApiVersion;
import br.tec.db.voting_api.dto.input.AgendaInputDTO;
import br.tec.db.voting_api.dto.output.AgendaOutputDTO;
import br.tec.db.voting_api.service.AgendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiVersion.V1 + "/agenda")
@RequiredArgsConstructor
@Tag(name = "Pautas", description = "Endpoints para gerenciamento de pautas")
public class AgendaController {

    private final AgendaService agendaService;

    @Operation(summary = "Criar uma nova pauta")
    @PostMapping
    public ResponseEntity<AgendaOutputDTO> createAgenda(@Valid @RequestBody AgendaInputDTO agendaInputDTO) {
        var agendaOutputDTO = agendaService.createAgenda(agendaInputDTO);
        return ResponseEntity.ok(agendaOutputDTO);
    }
}
