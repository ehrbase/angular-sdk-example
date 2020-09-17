package org.ehrbase.angularsdkexample.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.definition.AtiopathogeneseChoice;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.definition.AtiopathogeneseDvcodedtext;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.definition.AtiopathogeneseDvtext;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.definition.Definingcode;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AtiopathogeneseChoiceDeserializer extends StdDeserializer<AtiopathogeneseChoice> {

    public AtiopathogeneseChoiceDeserializer() {
        super(AtiopathogeneseChoice.class);
    }

    @Override
    public AtiopathogeneseChoice deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // case of DvCodedText
        if (node.has("definingcode")) {
            AtiopathogeneseDvcodedtext dvcodedtext = new AtiopathogeneseDvcodedtext();
            dvcodedtext.setDefiningcode(Definingcode.valueOf(node.get("definingcode").asText()));
            return dvcodedtext;
        } else {
            // case of DvText
            // TODO
            AtiopathogeneseDvtext text = new AtiopathogeneseDvtext();
            text.setValue("EMPTY");
            return text;
        }

    }
}
