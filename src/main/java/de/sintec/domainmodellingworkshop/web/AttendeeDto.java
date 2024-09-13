package de.sintec.domainmodellingworkshop.web;

import de.sintec.domainmodellingworkshop.core.EMailAddress;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AttendeeDto {

    private Long id;

    private EMailAddress emailAddress;
}
