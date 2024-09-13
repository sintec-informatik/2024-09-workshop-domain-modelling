package de.sintec.domainmodellingworkshop.web;

import de.sintec.domainmodellingworkshop.core.Attendee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttendeeDtoMapper {

    AttendeeDto toDto(Attendee attendee);

    Attendee toModel(AttendeeDto attendee);
}
