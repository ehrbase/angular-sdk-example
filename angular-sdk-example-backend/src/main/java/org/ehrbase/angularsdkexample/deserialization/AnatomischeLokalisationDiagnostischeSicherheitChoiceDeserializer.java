package org.ehrbase.angularsdkexample.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.definition.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AnatomischeLokalisationDiagnostischeSicherheitChoiceDeserializer extends StdDeserializer<AnatomischeLokalisationDiagnostischeSicherheitChoice> {

    public AnatomischeLokalisationDiagnostischeSicherheitChoiceDeserializer() {
        super(AnatomischeLokalisationDiagnostischeSicherheitChoice.class);
    }

    @Override
    public AnatomischeLokalisationDiagnostischeSicherheitChoice deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // case of DvCodedText
        if (node.has("diagnostischeSicherheitDefiningcode")) {
            AnatomischeLokalisationDiagnostischeSicherheitDvcodedtext dvcodedtext = new AnatomischeLokalisationDiagnostischeSicherheitDvcodedtext();
            dvcodedtext.setDiagnostischeSicherheitDefiningcode(DiagnostischeSicherheitDefiningcode.valueOf(node.get("diagnostischeSicherheitDefiningcode").asText()));
            return dvcodedtext;
        } else {
            // case of DvText
            // TODO
            AnatomischeLokalisationDiagnostischeSicherheitDvtext text = new AnatomischeLokalisationDiagnostischeSicherheitDvtext();
            text.setDiagnostischeSicherheitValue("EMPTY");
            return text;
        }
    }
}
