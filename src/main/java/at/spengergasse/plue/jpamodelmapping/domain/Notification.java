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
@Table(name = "notifications")
public class Notification extends AbstractPersistable<Long>{
    @NotNull private String recipient;

    @Column(name = "creation_TS", nullable = false)
    @NotNull LocalDateTime creationTS;

    @NotNull private String subject;

    @NotNull private String body;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_notifications_2_templates"), nullable = false)
    @NotNull private Template template;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_notifications_2_alumni"), nullable = false)
    @NotNull private Alumni alumni;
}
