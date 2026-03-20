package br.tec.db.voting_api.controller;

import br.tec.db.voting_api.dto.input.SessionInputDTO;
import br.tec.db.voting_api.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/session")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping("/{agendaId}/open")
    public ResponseEntity<Void> openSession(@PathVariable Long agendaId, @RequestBody SessionInputDTO sessionInputDTO) {
        sessionService.openSession(agendaId, sessionInputDTO);
        return ResponseEntity.ok().build();
    }
}
