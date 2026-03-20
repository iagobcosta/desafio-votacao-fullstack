## [0.6.0] - 2026-03-20
### Added
- Integration tests using H2 database
- Full voting flow test:
  - create pauta
  - open session
  - vote
  - get result

## [0.5.0]
### Added
- Unit tests for vote service
- Test coverage for:
    - successful vote
    - duplicate vote
    - closed session validation

## [0.4.0]
### Added
- Voting result endpoint
- Optimized vote counting directly in database
- Result calculation (SIM venceu / NAO venceu / Empate)

## [0.3.0]
### Added
- Vote registration endpoint
- Validation: associate can vote only once per pauta
- Validation: vote only allowed while session is open

## [0.2.0]
### Added
- Voting session creation with default duration rule

## [0.1.0]
### Added
- Create pauta endpoint