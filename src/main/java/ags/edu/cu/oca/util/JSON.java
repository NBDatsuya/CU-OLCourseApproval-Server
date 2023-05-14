package ags.edu.cu.oca.util;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

public class JSON {
    public static final Jsonb JSONB =
            JsonbBuilder.newBuilder().withConfig(
                    new JsonbConfig().withDateFormat(
                            "yyyy-MM-dd HH:mm:ss", null
                    )
            ).build();
}
