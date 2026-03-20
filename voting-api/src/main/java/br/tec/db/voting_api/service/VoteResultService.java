package br.tec.db.voting_api.service;

import br.tec.db.voting_api.domain.Agenda;
import br.tec.db.voting_api.domain.enums.VowType;
import br.tec.db.voting_api.dto.output.VoteResultOutputDTO;
import br.tec.db.voting_api.exception.BusinessException;
import br.tec.db.voting_api.repository.AgendaRepository;
import br.tec.db.voting_api.repository.VowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteResultService {

    private final AgendaRepository agendaRepository;
    private final VowRepository vowRepository;

    public VoteResultOutputDTO getVowsResults(Long agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new BusinessException("Pauta não encontrada"));

        long totalYes = vowRepository.countByAgendaIdAndVote(agendaId, VowType.YES);
        long totalNo = vowRepository.countByAgendaIdAndVote(agendaId, VowType.NO);

        String result = totalYes > totalNo ? "Sim" : totalYes < totalNo ? "Não" : "Empate";

        return new VoteResultOutputDTO(agendaId, totalYes, totalNo, result);
    }
}
