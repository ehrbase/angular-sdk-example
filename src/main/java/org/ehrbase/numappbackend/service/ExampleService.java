package org.ehrbase.numappbackend.service;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datastructures.Element;
import com.nedap.archie.rm.datastructures.ItemSingle;
import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.datavalues.DvText;
import com.nedap.archie.rm.datavalues.quantity.DvOrdinal;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartySelf;
import org.ehrbase.numappbackend.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.numappbackend.opt.diagnosecomposition.definition.*;
import org.ehrbase.numappbackend.opt.diagnosecomposition.definition.Definingcode;
import org.ehrbase.numappbackend.opt.openereactcarecomposition.OpenEREACTCareComposition;
import org.ehrbase.numappbackend.opt.openereactcarecomposition.definition.*;
import org.ehrbase.numappbackend.opt.shareddefinition.*;
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

    public Optional<OpenEREACTCareComposition> createCareExample() {
        OpenEREACTCareComposition compo = new OpenEREACTCareComposition();

        compo.setLanguage(Language.EN_GB);
        compo.setTerritory(Territory.GB);
        compo.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
        compo.setComposer(new PartySelf());
        compo.setStartTimeValue(OffsetDateTime.of(2020, 04, 02, 12, 00, 00, 00, ZoneOffset.UTC));
        compo.setEndTimeValue(OffsetDateTime.of(2020, 04, 02, 13, 00, 00, 00, ZoneOffset.UTC));
        compo.setSettingDefiningcode(SettingDefiningcode.EMERGENCY_CARE);

        // Start of setAssessment()
        AssessmentSection assessment = new AssessmentSection();

        // Subset: setCovid()
        CovidSection covid = new CovidSection();
        // --
        Covid19ExposureEvaluation expo = new Covid19ExposureEvaluation();
        expo.setHealthRiskDefiningcode(HealthRiskDefiningcode.COVID19_RISK_ASSESSMENT);
        expo.setRiskAssessmentDefiningcode(RiskAssessmentDefiningcode.HIGH_RISK);
        covid.setCovid19Exposure(expo);
        // --
        CovidSymptomsObservation symp = new CovidSymptomsObservation();
        ChestSymptomCluster chest = new ChestSymptomCluster();
        chest.setPresenceDefiningcode(PresenceDefiningcode.PRESENT);
        chest.setSymptomSignNameDefiningcode(SymptomSignNameDefiningcode.N315642008);
        symp.setChestSymptom(Collections.singletonList(chest));
        covid.setCovidSymptoms(symp);
        // --
        LatestCovid19TestObservation latest = new LatestCovid19TestObservation();
        latest.setTestDiagnosisValue("something");
        // --
        LatestCovid19TestOverallTestStatusDvcodedtext status = new LatestCovid19TestOverallTestStatusDvcodedtext();
        status.setOverallTestStatusDefiningcode(OverallTestStatusDefiningcode.FINAL);
        latest.setOverallTestStatus(status);
        // --
        Cluster<Element> result = new Cluster<>();
        Element element = new Element("node ID", new DvText("name"), new DvText("text"));
        result.setItems(Collections.singletonList(element));
        latest.setTestResult(Collections.singletonList(result));
        covid.setLatestCovid19Test(latest);
        assessment.setCovid(covid);

        // Subset: setDenwis()
        DenwisObservation denwis = new DenwisObservation();
        // --
        DenwisBreathingIndicatorElement breath = new DenwisBreathingIndicatorElement();
        // TODO: the following code doesn't make sense, does it?
        breath.setDefiningcode(org.ehrbase.numappbackend.opt.openereactcarecomposition.definition.Definingcode.RIGORS);
        denwis.setBreathingIndicator(Collections.singletonList(breath));
        // --
        DenwisCirculationIndicatorElement circulation = new DenwisCirculationIndicatorElement();
        // TODO: the following code doesn't make sense, does it?
        circulation.setDefiningcode(org.ehrbase.numappbackend.opt.openereactcarecomposition.definition.Definingcode.RIGORS);
        denwis.setCirculationIndicator(Collections.singletonList(circulation));
        // --
        denwis.setQ6Pain(new DvOrdinal(5L, new DvCodedText("test", new CodePhrase("code"))));
        assessment.setDenwis(denwis);

        // Subset: setNews2()
        News2Section news = new News2Section();
        // --
        BloodPressureObservation blood = new BloodPressureObservation();
        blood.setSystolicMagnitude(100D);
        blood.setDiastolicMagnitude(100D);
        news.setBloodPressure(blood);
        // --
        News2ScoreObservation score = new News2ScoreObservation();
        score.setClinicalRiskCategoryDefiningcode(ClinicalRiskCategoryDefiningcode.HIGH);
        score.setSpoScale1(new DvOrdinal(5L, new DvCodedText("value", new CodePhrase("code"))));
        news.setNews2Score(score);
        assessment.setNews2(news);

        // Subset: setSepsis()
        SepsisSection sepsis = new SepsisSection();
        SepsisScreeningObservation screening = new SepsisScreeningObservation();
        // --
        SepsisScreeningRiskFactorsForSepsisElement risk = new SepsisScreeningRiskFactorsForSepsisElement();
        // TODO: the following code doesn't make sense, does it?
        risk.setDefiningcode(org.ehrbase.numappbackend.opt.openereactcarecomposition.definition.Definingcode.RIGORS);
        screening.setRiskFactorsForSepsis(Collections.singletonList(risk));
        // --
        SepsisScreeningRedFlagAcuteElement red = new SepsisScreeningRedFlagAcuteElement();
        // TODO: the following code doesn't make sense, does it?
        red.setDefiningcode(org.ehrbase.numappbackend.opt.openereactcarecomposition.definition.Definingcode.RIGORS);
        screening.setRedFlagAcute(Collections.singletonList(red));
        sepsis.setSepsisScreening(screening);
        assessment.setSepsis(sepsis);

        compo.setAssessment(assessment);

        // Start of setBackground()
        BackgroundSection background = new BackgroundSection();

        // Subset: setAllergies()
        AllergiesEvaluation allergies = new AllergiesEvaluation();
        // TODO: seems to have no real content field
        allergies.setSynopsisValue("missing fields?");
        background.setAllergies(allergies);

        // Subset: setHeight()
        HeightObservation height = new HeightObservation();
        height.setHeightLengthMagnitude(180D);
        background.setHeight(height);

        // Subset: setWeight()
        WeightObservation weight = new WeightObservation();
        weight.setWeightMagnitude(80D);
        background.setWeight(weight);

        // Subset: setFrailty()
        FrailtyObservation frailty = new FrailtyObservation();
        frailty.setAssessment(new DvOrdinal(10L, new DvCodedText("test", new CodePhrase("code"))));
        background.setFrailty(frailty);

        // Subset: setMedication()
        MedicationEvaluation medication = new MedicationEvaluation();
        // TODO: seems to have no real content field
        medication.setSynopsisValue("missing fields?");
        background.setMedication(medication);

        // Subset: setPastHistory()
        PastHistoryEvaluation history = new PastHistoryEvaluation();
        // TODO: seems to have no real content field
        history.setSynopsisValue("missing fields?");
        background.setPastHistory(history);

        compo.setBackground(background);

        return Optional.of(compo);
    }
}
