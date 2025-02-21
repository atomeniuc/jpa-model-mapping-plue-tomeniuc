package at.spengergasse.plue.jpamodelmapping;

import at.spengergasse.plue.jpamodelmapping.domain.*;

import java.time.LocalDateTime;
import java.util.List;

public class TestFixtures {
    public static Template template() {
        return Template.builder()
                .name("Initial Template")
                .subject("Ticket")
                .body("This is the longest body you have ever seen")
                .build();
    }

    public static Department department() {
        return Department.builder().name("HIF").build();
    }

    public static Notification notification() {
        return Notification.builder()
                .recipient("Max Mustermann")
                .creationTS(LocalDateTime.now())
                .subject("Ticket")
                .body("This is the longest body you have ever seen")
                .template(template())
                .alumni(alumni())
                .build();
    }

    public static Alumni alumni() {
        return Alumni.builder()
                .firstname("Max")
                .lastname("Mustermann")
                .finalYear(2021)
                .department(department())
                .demographicData(null)
                .email("test@gmail.com")
                .promoter(null)
                .tokens(List.of(token(), token2()))
                .build();
    }

    public static Token token() {
        return Token.builder()
                .value("123456")
                .validUntil(LocalDateTime.MAX)
                .tokenType(TokenType.AFFILIATE)
                .used(true)
                .alumni(alumni())
                .build();
    }

    public static Token token2() {
        return Token.builder()
                .value("1234562")
                .validUntil(LocalDateTime.MAX)
                .tokenType(TokenType.AFFILIATE)
                .used(true)
                .alumni(alumni())
                .build();
    }

}
