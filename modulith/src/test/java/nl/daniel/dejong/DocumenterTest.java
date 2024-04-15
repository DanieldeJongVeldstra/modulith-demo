package nl.daniel.dejong;


import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class DocumenterTest {

    ApplicationModules modules = ApplicationModules.of(Application.class);

    @Test
    void createModuleDocumentation() {
        new org.springframework.modulith.docs.Documenter(modules).writeDocumentation(
                org.springframework.modulith.docs.Documenter.DiagramOptions.defaults(),
                org.springframework.modulith.docs.Documenter.CanvasOptions.defaults().revealInternals()
        );
    }
}
