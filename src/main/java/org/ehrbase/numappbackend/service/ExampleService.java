package org.ehrbase.numappbackend.service;

import com.nedap.archie.rm.generic.PartyIdentified;
import org.ehrbase.numappbackend.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.numappbackend.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.numappbackend.opt.shareddefinition.Language;
import org.ehrbase.numappbackend.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.numappbackend.opt.shareddefinition.Territory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
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

        return Optional.of(compo);
    }
}
