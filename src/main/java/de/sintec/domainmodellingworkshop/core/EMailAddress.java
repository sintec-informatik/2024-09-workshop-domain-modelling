package de.sintec.domainmodellingworkshop.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.ValidationException;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.regex.Pattern;

@EqualsAndHashCode
@ToString
public final class EMailAddress {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

    private final String address;

    private EMailAddress(String address) {
        this.address = address;
    }

    @JsonValue
    public String getAddress() {
        return address;
    }

    @JsonCreator
    public static EMailAddress of(String value) {
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new ValidationException("Invalid email address");
        }

        return new EMailAddress(value);
    }
}
