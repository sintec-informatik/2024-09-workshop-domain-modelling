package de.sintec.domainmodellingworkshop.persistence.converters;

import de.sintec.domainmodellingworkshop.core.EMailAddress;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EMailAddressConverter implements AttributeConverter<EMailAddress, String> {
    @Override
    public String convertToDatabaseColumn(EMailAddress eMailAddress) {
        return eMailAddress == null
                ? null
                : eMailAddress.getAddress();
    }

    @Override
    public EMailAddress convertToEntityAttribute(String value) {
        return value == null
                ? null
                : EMailAddress.of(value);
    }
}
