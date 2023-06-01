package iot.raniot.infrastructure.adapters.repositoriesInterfaces;

import iot.raniot.infrastructure.adapters.entity.InstitutionDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionDBORepository extends ReactiveCrudRepository<InstitutionDBO, Long> {
}
