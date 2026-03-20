package br.tec.db.voting_api.service;

import br.tec.db.voting_api.domain.Agenda;
import br.tec.db.voting_api.domain.Session;
import br.tec.db.voting_api.domain.Vow;
import br.tec.db.voting_api.dto.input.VowInputDTO;
import br.tec.db.voting_api.exception.BusinessException;
import br.tec.db.voting_api.repository.AgendaRepository;
import br.tec.db.voting_api.repository.SessionRepository;
import br.tec.db.voting_api.repository.VowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VowService {

    private final VowRepository vowRepository;
    private final AgendaRepository agendaRepository;
    private final SessionRepository sessionRepository;


    public void registerVote(Long agendaId, VowInputDTO vowInputDTO) {

        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new BusinessException("Pauta não encontrada"));

        Session session = sessionRepository.findByAgendaId(agendaId)
                .orElseThrow(() -> new BusinessException("Sessão não encontrada"));

        if (LocalDateTime.now().isAfter(session.getClosingDate())) {
            throw new BusinessException("Sessão encerrada");
        }

        if (vowRepository.existsByAssociatedIdAndAgendaId(vowInputDTO.associatedId(), agendaId)) {
            throw new BusinessException("Associado já votou nessa pauta");
        }

        Vow vow = Vow.builder()
                .associatedId(vowInputDTO.associatedId())
                .vote(vowInputDTO.vote())
                .agenda(agenda)
                .build();

        vowRepository.save(vow);
    }

}
