package org.ehrbase.angularsdkexample.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.nedap.archie.rm.generic.PartyProxy;
import com.nedap.archie.rm.generic.PartySelf;
import com.nedap.archie.rm.support.identification.PartyRef;
import openEHR.v1.template.DvIdentifier;

import java.io.IOException;
import java.util.List;

public class PartyProxyDeserializer extends StdDeserializer<PartyProxy> {

    public PartyProxyDeserializer() {
        super(PartyProxy.class);
    }

    @Override
    public PartyProxy deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // TODO deserialize into either PartyIdentified or PartySelf, with values if available
        PartyRef externalRef = null;
        String name = null;
        List<DvIdentifier> identifiers = null;

        if (node.has("externalRef")) {
            JsonNode externalRefNode = node.get("externalRef");
        }

        return new PartySelf();
    }
}
