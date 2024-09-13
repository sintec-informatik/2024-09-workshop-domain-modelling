package de.sintec.domainmodellingworkshop.persistence;

import de.sintec.domainmodellingworkshop.core.Attendee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttendeeEntityMapper {

    AttendeeEntity toEntity(Attendee attendee);

    Attendee toModel(AttendeeEntity attendee);
}
