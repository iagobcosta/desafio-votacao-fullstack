package br.tec.db.voting_api.dto.output;

public record VoteResultOutputDTO(
        Long agendaId,
        long totalYes,
        long totalNo,
        String result
) { }
