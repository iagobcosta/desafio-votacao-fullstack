package br.tec.db.voting_api.controller;

import br.tec.db.voting_api.dto.output.VoteResultOutputDTO;
import br.tec.db.voting_api.service.VoteResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vote-result")
@RequiredArgsConstructor
public class VoteResultController {

    private final VoteResultService voteResultService;

    @GetMapping("/{agendaId}")
    public ResponseEntity<VoteResultOutputDTO> getVowsResults(@PathVariable Long agendaId) {
        VoteResultOutputDTO voteResultOutputDTO = voteResultService.getVowsResults(agendaId);
        return ResponseEntity.ok(voteResultOutputDTO);
    }
}
