package de.sintec.domainmodellingworkshop.persistence;

import de.sintec.domainmodellingworkshop.core.EMailAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class AttendeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private EMailAddress emailAddress;
}
