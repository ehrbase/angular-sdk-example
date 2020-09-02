package org.ehrbase.numappbackend.service;

import com.nedap.archie.rm.generic.PartyIdentified;
import org.ehrbase.numappbackend.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.numappbackend.opt.diagnosecomposition.definition.*;
import org.ehrbase.numappbackend.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.numappbackend.opt.shareddefinition.Language;
import org.ehrbase.numappbackend.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.numappbackend.opt.shareddefinition.Territory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.Optional;

@Service
public class ExampleService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Optional<DiagnoseComposition> createExample() {

        logger.info("Creating 'DiagnoseComposition' example");

        DiagnoseComposition compo = new DiagnoseComposition();

        compo.setLanguage(Language.DE);
        compo.setTerritory(Territory.DE);
        compo.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
        compo.setComposer(new PartyIdentified(null, "Test", null));
        compo.setStartTimeValue(OffsetDateTime.of(2020, 04, 02, 12, 00, 00, 00, ZoneOffset.UTC));
        compo.setEndTimeValue(OffsetDateTime.of(2020, 04, 02, 13, 00, 00, 00, ZoneOffset.UTC));
        compo.setSettingDefiningcode(SettingDefiningcode.EMERGENCY_CARE);

        compo.setBerichtIdValue("Bericht ID Value");

        FallidentifikationCluster fallidentifikationCluster = new FallidentifikationCluster();
        fallidentifikationCluster.setFallKennungValue("Fall-Kennung Value");
        compo.setFallidentifikation(fallidentifikationCluster);

        // Start of setProblemDiagnose()
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = new ProblemDiagnoseEvaluation();
        problemDiagnoseEvaluation.setLanguage(Language.DE);
        problemDiagnoseEvaluation.setSubject(new PartyIdentified(null, "Test", null));
        //problemDiagnoseEvaluation.setNameDesProblemsDerDiagnoseValue("Name des Problems der Diagnose Value"); // TODO: problem here. if uncommented:
        // Validation error at /content[openEHR-EHR-EVALUATION.problem_diagnosis.v1]/data[at0001]/items[at0002], TEXT01:Value does not match any defined codes,found:com.nedap.archie.rm.datavalues.DvText@fa07d19b.
        problemDiagnoseEvaluation.setFreitextbeschreibungValue("Freitextbeschreibung Value");
        problemDiagnoseEvaluation.setLokalisationValue("Lokalisation Value");
        // Subset: setAnatomischeLokalisation() // TODO: MULTIPLE
        AnatomischeLokalisationCluster anatomischeLokalisationCluster = new AnatomischeLokalisationCluster();
        anatomischeLokalisationCluster.setNameDerKorperstelleValue("Name der Korperstelle Value");
        anatomischeLokalisationCluster.setLateralitatDefiningcode(LateralitatDefiningcode.LINKS);
        problemDiagnoseEvaluation.setAnatomischeLokalisation(Collections.singletonList(anatomischeLokalisationCluster));
        // Continuing
        problemDiagnoseEvaluation.setDatumDesAuftretensDerErstdiagnoseValue(OffsetDateTime.of(2020, 04, 02, 12, 00, 00, 00, ZoneOffset.UTC));
        problemDiagnoseEvaluation.setFeststellungsdatumValue(OffsetDateTime.of(2020, 04, 02, 12, 00, 00, 00, ZoneOffset.UTC));
        // Subset: setSchweregrad() // TODO: CHOICE!
        AtiopathogeneseSchweregradDvcodedtext schweregradDvcodedtext = new AtiopathogeneseSchweregradDvcodedtext();
        schweregradDvcodedtext.setSchweregradDefiningcode(SchweregradDefiningcode.LEICHT);
        problemDiagnoseEvaluation.setSchweregrad(schweregradDvcodedtext);
        // Subset: setDiagnosedetails()
        DiagnosedetailsCluster details = new DiagnosedetailsCluster();
        details.setBegrundungVonAusnahmenValue("Begrundung Von Ausnamen Value");
        details.setDiagnosetypValue("Diagnosetyp Value");
        details.setVorhandenBeiAufnahmeValue(true);
        details.setVorhandenBeiEntlassungValue(false);
        problemDiagnoseEvaluation.setDiagnosedetails(details);
        // Subset: setAtiopathogenese()
        AtiopathogeneseCluster atiopathogenese = new AtiopathogeneseCluster();
        // Sub-Subset: setAtiologieDerKrankheit // TODO: MULTIPLE
        AtiopathogeneseAtiologieDerKrankheitElement element = new AtiopathogeneseAtiologieDerKrankheitElement();
        AtiopathogeneseDvcodedtext coded = new AtiopathogeneseDvcodedtext();
        coded.setDefiningcode(Definingcode.INFEKTION);
        element.setValue(coded); // TODO: CHOICE
        atiopathogenese.setAtiologieDerKrankheit(Collections.singletonList(element));
        // Sub-Subset: setBeschreibungDesEntstehens // TODO: MULTIPLE
        AtiopathogeneseBeschreibungDesEntstehensElement beschreibung = new AtiopathogeneseBeschreibungDesEntstehensElement();
        beschreibung.setValue("Beschreibung Value");
        atiopathogenese.setBeschreibungDesEntstehens(Collections.singletonList(beschreibung));
        problemDiagnoseEvaluation.setAtiopathogenese(atiopathogenese);
        // Continuing
        problemDiagnoseEvaluation.setDatumZeitpunktDerGenesungValue(OffsetDateTime.of(2020, 04, 02, 12, 00, 00, 00, ZoneOffset.UTC));
        // Subset: setDiagnostischeSicherheit() // TODO: Choice
        AnatomischeLokalisationDiagnostischeSicherheitDvcodedtext sicherheit = new AnatomischeLokalisationDiagnostischeSicherheitDvcodedtext();
        sicherheit.setDiagnostischeSicherheitDefiningcode(DiagnostischeSicherheitDefiningcode.BESTATIGT);
        problemDiagnoseEvaluation.setDiagnostischeSicherheit(sicherheit);
        // Continuing
        problemDiagnoseEvaluation.setDiagnoseerlauterungValue("Diagnoseerlauterung Value");
        problemDiagnoseEvaluation.setLetztesDokumentationsdatumValue(OffsetDateTime.of(2020, 04, 02, 12, 00, 00, 00, ZoneOffset.UTC));

        compo.setProblemDiagnose(problemDiagnoseEvaluation);

        return Optional.of(compo);
    }
}
