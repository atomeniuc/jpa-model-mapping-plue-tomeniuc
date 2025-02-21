package at.spengergasse.plue.jpamodelmapping.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Entity
@Table(name = "alumnis")
public class Alumni extends AbstractPersistable<Long> {
    @Column(name = "first_name", nullable = false)
    @NotNull private String firstname;

    @Column(name = "last_name", nullable = false)
    @NotNull private String lastname;

    @Column(name = "final_year", nullable = false)
    @NotNull private int finalYear;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull private Department department;

    @Embedded
    @Column(name = "demographic_data", nullable = false)
    @NotNull private DemographicData demographicData;

    @NotNull private String email;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_alumnis_2_promoters"), unique = true)
    private Alumni promoter;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_alumnis_2_tokens"), nullable = false)
    @NotNull List<Token> tokens;
}
