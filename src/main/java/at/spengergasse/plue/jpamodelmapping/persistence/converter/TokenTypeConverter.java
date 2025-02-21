package at.spengergasse.plue.jpamodelmapping.persistence.converter;

import at.spengergasse.plue.jpamodelmapping.domain.TokenType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class TokenTypeConverter implements AttributeConverter<TokenType, String> {

    @Override
    public String convertToDatabaseColumn(TokenType attribute) {
        return Optional.ofNullable(attribute).map(ctbc -> switch(ctbc) {
            case REGISTRATION -> "R";
            case PASSWORD_RESET -> "P";
            case AFFILIATE -> "A";
            case VOUCHER -> "V";
        }).orElse(null);
    }

    @Override
    public TokenType convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).map(ctea -> switch (ctea) {
            case "R" -> TokenType.REGISTRATION;
            case "P" -> TokenType.PASSWORD_RESET;
            case "A" -> TokenType.AFFILIATE;
            case "V" -> TokenType.VOUCHER;
            default -> throw new IllegalArgumentException("Unknown token type: " + ctea);
        }).orElse(null);
    }
}
