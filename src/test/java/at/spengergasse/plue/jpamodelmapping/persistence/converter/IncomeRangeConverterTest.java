package at.spengergasse.plue.jpamodelmapping.persistence.converter;

import at.spengergasse.plue.jpamodelmapping.domain.IncomeRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IncomeRangeConverterTest {
    private IncomeRangeConverter incomeRangeConverter;

    @BeforeEach
    void setUp() {
        incomeRangeConverter = new IncomeRangeConverter();
    }

    @ParameterizedTest
    @MethodSource
    void ensureMappingDomainToDbValueWorks(IncomeRange givenIncomeRange, String expectedDbValue) {
        assertThat(incomeRangeConverter.convertToDatabaseColumn(givenIncomeRange)).isEqualTo(expectedDbValue);
    }

    static Stream<Arguments> ensureMappingDomainToDbValueWorks() {
        return Stream.of(
                Arguments.of(IncomeRange.BELOW_30000, "B"),
                Arguments.of(IncomeRange.C_30001_60000, "C"),
                Arguments.of(IncomeRange.D_60001_100000, "D"),
                Arguments.of(IncomeRange.E_100001_200000, "E"),
                Arguments.of(IncomeRange.ABOVE_200000, "A")
        );
    }

    @ParameterizedTest
    @MethodSource
    void ensureMappingDBValueToDomainWorks(String givenDBValue, IncomeRange expectedIncomeRange) {
        assertThat(incomeRangeConverter.convertToEntityAttribute(givenDBValue)).isEqualTo(expectedIncomeRange);
    }

    static Stream<Arguments> ensureMappingDBValueToDomainWorks() {
        return Stream.of(
                Arguments.of("B", IncomeRange.BELOW_30000),
                Arguments.of("C", IncomeRange.C_30001_60000),
                Arguments.of("D", IncomeRange.D_60001_100000),
                Arguments.of("E", IncomeRange.E_100001_200000),
                Arguments.of("A", IncomeRange.ABOVE_200000)
        );
    }

    @Test
    void ensureMappingDBValueToDomainThrowsExceptionForUnknownDBValue() {
        var iaEx = assertThrows(IllegalArgumentException.class, () ->
                incomeRangeConverter.convertToEntityAttribute("X"));

        assertThat(iaEx).hasMessageStartingWith("Unknown income range: ");
    }
}