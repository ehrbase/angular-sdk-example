package org.ehrbase.numappbackend.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.ehrbase.numappbackend.opt.diagnosecomposition.definition.AtiopathogeneseSchweregradChoice;
import org.ehrbase.numappbackend.opt.diagnosecomposition.definition.AtiopathogeneseSchweregradDvcodedtext;
import org.ehrbase.numappbackend.opt.diagnosecomposition.definition.AtiopathogeneseSchweregradDvtext;
import org.ehrbase.numappbackend.opt.diagnosecomposition.definition.SchweregradDefiningcode;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AtiopathogeneseSchweregradChoiceDeserializer extends StdDeserializer<AtiopathogeneseSchweregradChoice> {

    public AtiopathogeneseSchweregradChoiceDeserializer() {
            super(AtiopathogeneseSchweregradChoice.class);
    }

    @Override
    public AtiopathogeneseSchweregradChoice deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // case of DvCodedText
        if (node.has("schweregradDefiningcode")) {
            AtiopathogeneseSchweregradDvcodedtext dvcodedtext = new AtiopathogeneseSchweregradDvcodedtext();
            dvcodedtext.setSchweregradDefiningcode(SchweregradDefiningcode.valueOf(node.get("schweregradDefiningcode").asText()));
            return dvcodedtext;
        } else {
            // case of DvText
            // TODO
            AtiopathogeneseSchweregradDvtext text = new AtiopathogeneseSchweregradDvtext();
            text.setSchweregradValue("EMPTY");
            return text;
        }
    }
}
