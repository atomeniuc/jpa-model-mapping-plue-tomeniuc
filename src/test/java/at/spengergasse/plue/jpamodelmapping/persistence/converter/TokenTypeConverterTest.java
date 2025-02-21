package at.spengergasse.plue.jpamodelmapping.persistence.converter;

import at.spengergasse.plue.jpamodelmapping.domain.TokenType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TokenTypeConverterTest {
    private TokenTypeConverter tokenTypeConverter;

    @BeforeEach
    void setUp() {
        tokenTypeConverter = new TokenTypeConverter();
    }

    @ParameterizedTest
    @MethodSource
    void ensureMappingDomainToDbValueWorks(TokenType givenTokenType, String expectedDbValue) {
        assertThat(tokenTypeConverter.convertToDatabaseColumn(givenTokenType)).isEqualTo(expectedDbValue);
    }

    static Stream<Arguments> ensureMappingDomainToDbValueWorks() {
        return Stream.of(
                Arguments.of(TokenType.REGISTRATION, "R"),
                Arguments.of(TokenType.PASSWORD_RESET, "P"),
                Arguments.of(TokenType.AFFILIATE, "A"),
                Arguments.of(TokenType.VOUCHER, "V")
        );
    }

    @ParameterizedTest
    @MethodSource
    void ensureMappingDBValueToDomainWorks(String givenDBValue, TokenType expectedTokenType) {
        assertThat(tokenTypeConverter.convertToEntityAttribute(givenDBValue)).isEqualTo(expectedTokenType);
    }

    static Stream<Arguments> ensureMappingDBValueToDomainWorks() {
        return Stream.of(
                Arguments.of("R", TokenType.REGISTRATION),
                Arguments.of("P", TokenType.PASSWORD_RESET),
                Arguments.of("A", TokenType.AFFILIATE),
                Arguments.of("V", TokenType.VOUCHER)
        );
    }

    @Test
    void ensureMappingDBValueToDomainThrowsExceptionForUnknownDBValue() {
        var iaEx = assertThrows(IllegalArgumentException.class, () ->
                tokenTypeConverter.convertToEntityAttribute("X"));

        assertThat(iaEx).hasMessageStartingWith("Unknown token type: ");
    }
}