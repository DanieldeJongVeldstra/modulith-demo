package nl.daniel.dejong;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;

@AnalyzeClasses(packages = "nl.daniel.dejong")
public class ArchitecturalTests {

    @ArchTest
    ArchRule onionArchitecture = JMoleculesArchitectureRules.ensureOnionSimple();
    @ArchTest ArchRule hexagonalArchitecture = JMoleculesArchitectureRules.ensureHexagonal();
    @ArchTest ArchRule dddRules = JMoleculesDddRules.all();
}
