package br.tec.db.voting_api.controller;

import br.tec.db.voting_api.dto.input.VowInputDTO;
import br.tec.db.voting_api.service.VowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vote")
@RequiredArgsConstructor
public class VowController {

    private final VowService vowService;

    @PostMapping("/{agendaId}/register")
    public ResponseEntity<Void> registerVote(@PathVariable Long agendaId, @RequestBody VowInputDTO vowInputDTO) {
        vowService.registerVote(agendaId, vowInputDTO);
        return ResponseEntity.ok().build();
    }
}
