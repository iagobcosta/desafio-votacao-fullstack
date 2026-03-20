package br.tec.db.voting_api.service;

import br.tec.db.voting_api.domain.Agenda;
import br.tec.db.voting_api.domain.Session;
import br.tec.db.voting_api.domain.Vow;
import br.tec.db.voting_api.domain.enums.VowType;
import br.tec.db.voting_api.dto.input.VowInputDTO;
import br.tec.db.voting_api.exception.BusinessException;
import br.tec.db.voting_api.repository.AgendaRepository;
import br.tec.db.voting_api.repository.SessionRepository;
import br.tec.db.voting_api.repository.VowRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VowServiceTest {

    @InjectMocks
    private VowService vowService;

    @Mock
    private VowRepository vowRepository;

    @Mock
    private AgendaRepository agendaRepository;

    @Mock
    private SessionRepository sessionRepository;

    @Test
    void mustRegisterVoteWhenSessionOpenAndAssociateDidNotVote() {

        Long agendaId = 1L;
        Agenda agenda = new Agenda();
        agenda.setId(agendaId);

        Session session = new Session();
        session.setClosingDate(LocalDateTime.now().plusMinutes(5));

        VowInputDTO vowInputDTO = new VowInputDTO("12345", VowType.YES);

        when(agendaRepository.findById(agendaId)).thenReturn(Optional.of(agenda));
        when(sessionRepository.findByAgendaId(agendaId)).thenReturn(Optional.of(session));
        when(vowRepository.existsByAssociatedIdAndAgendaId("12345", agendaId)).thenReturn(false);

        vowService.registerVote(agendaId, vowInputDTO);

        verify(vowRepository, times(1)).save(any(Vow.class));
    }

    @Test
    void mustThrowErrorWhenMemberVoted() {

        Long agendaId = 1L;
        Agenda agenda = new Agenda();
        agenda.setId(agendaId);

        Session session = new Session();
        session.setClosingDate(LocalDateTime.now().plusMinutes(5));

        VowInputDTO vowInputDTO = new VowInputDTO("12345", VowType.YES);

        when(agendaRepository.findById(agendaId)).thenReturn(Optional.of(agenda));
        when(sessionRepository.findByAgendaId(agendaId)).thenReturn(Optional.of(session));
        when(vowRepository.existsByAssociatedIdAndAgendaId("12345", agendaId)).thenReturn(true);

        assertThrows(BusinessException.class,
                () -> vowService.registerVote(agendaId, vowInputDTO));
    }

    @Test
    void shouldThrowErrorWhenSessionClose() {

        Long agendaId = 1L;
        Agenda agenda = new Agenda();
        agenda.setId(agendaId);

        Session session = new Session();
        session.setClosingDate(LocalDateTime.now().minusMinutes(1));

        VowInputDTO vowInputDTO = new VowInputDTO("12345", VowType.YES);

        when(agendaRepository.findById(agendaId)).thenReturn(Optional.of(agenda));
        when(sessionRepository.findByAgendaId(agendaId)).thenReturn(Optional.of(session));

        assertThrows(BusinessException.class,
                () -> vowService.registerVote(agendaId, vowInputDTO));
    }
}
