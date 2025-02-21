package at.spengergasse.plue.jpamodelmapping.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Embeddable
public class DemographicData {
    @NotNull private boolean studied;

    @Column(name = "finished_bachelor", nullable = false)
    @NotNull private boolean finishedBachelor;

    @Column(name = "finished_master", nullable = false)
    @NotNull private boolean finishedMaster;

    @Column(name = "finished_phd", nullable = false)
    @NotNull private boolean finishedPhD;

    @Column(name = "is_self_employed", nullable = false)
    @NotNull private boolean isSelfEmployed;

    @Column(name = "has_employees", nullable = false)
    @NotNull private boolean hasEmployees;

    @Column(name = "has_staff_responsibility", nullable = false)
    @NotNull private boolean hasStaffResponsibility;

    @Column(name = "yearly_income", columnDefinition = "varchar(1) check (value in ('B', 'C', 'D', 'E', 'A'))")
    @NotNull private IncomeRange yearlyIncome;
}
