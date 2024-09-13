package de.sintec.domainmodellingworkshop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<AttendeeEntity, Long> {
}
