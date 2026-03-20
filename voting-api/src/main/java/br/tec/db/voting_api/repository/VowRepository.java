package br.tec.db.voting_api.repository;

import br.tec.db.voting_api.domain.Vow;
import br.tec.db.voting_api.domain.enums.VowType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VowRepository extends JpaRepository<Vow, Long> {

    boolean existsByAssociatedIdAndAgendaId(String associatedId, Long agendaId);

    long countByAgendaIdAndVote(Long agendaId, VowType vote);
}
