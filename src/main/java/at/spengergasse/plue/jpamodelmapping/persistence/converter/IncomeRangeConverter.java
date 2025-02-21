package at.spengergasse.plue.jpamodelmapping.persistence.converter;

import at.spengergasse.plue.jpamodelmapping.domain.IncomeRange;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class IncomeRangeConverter implements AttributeConverter<IncomeRange, String> {

    @Override
    public String convertToDatabaseColumn(IncomeRange attribute) {
        return Optional.ofNullable(attribute).map(ctbc -> switch(ctbc) {
            case IncomeRange.BELOW_30000 -> "B";
            case IncomeRange.C_30001_60000 -> "C";
            case IncomeRange.D_60001_100000 -> "D";
            case IncomeRange.E_100001_200000 -> "E";
            case IncomeRange.ABOVE_200000 -> "A";
        }).orElse(null);
    }

    @Override
    public IncomeRange convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).map(ctea -> switch (ctea) {
            case "B" -> IncomeRange.BELOW_30000;
            case "C" -> IncomeRange.C_30001_60000;
            case "D" -> IncomeRange.D_60001_100000;
            case "E" -> IncomeRange.E_100001_200000;
            case "A" -> IncomeRange.ABOVE_200000;
            default -> throw new IllegalArgumentException("Unknown income range: " + ctea);
        }).orElse(null);
    }

}