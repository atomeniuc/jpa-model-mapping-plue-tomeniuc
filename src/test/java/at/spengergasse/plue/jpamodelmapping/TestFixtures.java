package at.spengergasse.plue.jpamodelmapping;

import at.spengergasse.plue.jpamodelmapping.domain.Department;
import at.spengergasse.plue.jpamodelmapping.domain.Template;

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


}
