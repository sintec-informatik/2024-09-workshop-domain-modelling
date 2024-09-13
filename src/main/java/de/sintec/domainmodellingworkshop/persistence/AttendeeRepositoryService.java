package de.sintec.domainmodellingworkshop.persistence;

import de.sintec.domainmodellingworkshop.core.Attendee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendeeRepositoryService {

    private final AttendeeRepository repository;
    private final AttendeeEntityMapper mapper;

    public Attendee save(Attendee attendee) {
        var savedEntity = this.repository.saveAndFlush(this.mapper.toEntity(attendee));
        return this.mapper.toModel(savedEntity);
    }

    public Optional<Attendee> findAttendeeById(Long id) {
        return this.repository
                .findById(id)
                .map(this.mapper::toModel);
    }

    public List<Attendee> getAttendees() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toModel)
                .toList();
    }
}
