package at.spengergasse.plue.jpamodelmapping.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tokens")
public class Token extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true)
    @NotNull private String value;

    @Column(name = "valid_until", nullable = false)
    @NotNull private LocalDateTime validUntil;

    @Column(name = "token_type", columnDefinition = "varchar(1) check (value in ('R', 'P', 'A', 'V'))")
    @NotNull private TokenType tokenType;

    @NotNull boolean used;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_tokens_2_alumnis"), nullable = false)
    @NotNull private Alumni alumni;
}
