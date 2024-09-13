package de.sintec.domainmodellingworkshop.core;

import de.sintec.domainmodellingworkshop.persistence.AttendeeRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendeeService {

    private final AttendeeRepositoryService repositoryService;

    public Attendee createAttendee() {
        var attendee = new Attendee();

        return this.repositoryService.save(attendee);
    }

    public Optional<Attendee> getAttendee(Long id) {
        return this.repositoryService.findAttendeeById(id);
    }

    public List<Attendee> getAttendees() {
        return this.repositoryService.getAttendees();
    }
}
