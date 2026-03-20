package br.tec.db.voting_api.service;

import br.tec.db.voting_api.domain.Agenda;
import br.tec.db.voting_api.dto.input.AgendaInputDTO;
import br.tec.db.voting_api.dto.output.AgendaOutputDTO;
import br.tec.db.voting_api.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaOutputDTO createAgenda(AgendaInputDTO agendaInputDTO) {

        var agenda = Agenda.builder()
                .title(agendaInputDTO.title())
                .description(agendaInputDTO.description())
                .build();

        var agendaSaved = agendaRepository.save(agenda);

        return new AgendaOutputDTO(agendaSaved.getId(), agendaSaved.getTitle(), agendaSaved.getDescription());
    }
}
