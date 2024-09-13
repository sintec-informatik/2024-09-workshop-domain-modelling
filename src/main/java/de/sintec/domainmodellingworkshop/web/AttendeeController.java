package de.sintec.domainmodellingworkshop.web;

import de.sintec.domainmodellingworkshop.core.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequiredArgsConstructor
public class AttendeeController {

    private final AttendeeService attendeeService;
    private final AttendeeDtoMapper mapper;

    @PostMapping("/attendees")
    public ResponseEntity<AttendeeDto> createAttendee(AttendeeDto attendeeInput) {
        var input = this.mapper.toModel(attendeeInput);
        var attendee = attendeeService.createAttendee(input);

        var uri = MvcUriComponentsBuilder.
                fromMethodCall(on(AttendeeController.class).getAttendee(0L))
                .buildAndExpand(attendee.getId())
                .encode()
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(this.mapper.toDto(attendee));
    }

    @GetMapping("/attendees")
    public ResponseEntity<List<AttendeeDto>> getAttendees() {
        var attendees = attendeeService.getAttendees();

        var body = attendees
                .stream()
                .map(this.mapper::toDto)
                .toList();

        return ResponseEntity.ok(body);
    }

    @GetMapping("/attendees/{id}")
    public ResponseEntity<AttendeeDto> getAttendee(@PathVariable Long id) {
        var attendeeResult = attendeeService.getAttendee(id);

        return attendeeResult
                .map(model -> ResponseEntity.ok(this.mapper.toDto(model)))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
