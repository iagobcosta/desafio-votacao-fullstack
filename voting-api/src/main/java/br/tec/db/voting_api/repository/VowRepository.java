package br.tec.db.voting_api.repository;

import br.tec.db.voting_api.domain.Vow;
import br.tec.db.voting_api.domain.enums.VowType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VowRepository extends JpaRepository<Vow, Long> {

    @Query("""
    SELECT
        COUNT(v.id)
    FROM Vow v
    WHERE v.agenda.id = :agendaId
    """)
    Long countVotes(Long agendaId);

    @Query("""
    SELECT
        SUM(CASE WHEN v.vote = 'YES' THEN 1 ELSE 0 END),
        SUM(CASE WHEN v.vote = 'NO' THEN 1 ELSE 0 END)
    FROM Vow v
    WHERE v.agenda.id = :agendaId
    """)
    List<Object[]> countResult(Long agendaId);

    boolean existsByAssociatedIdAndAgendaId(String associatedId, Long agendaId);
}
