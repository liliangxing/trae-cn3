package com.bytedance.applog.priority;

import com.bytedance.applog.priority.original.ValueLoader;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeLazyString {
    private final ValueLoader<String> loader;

    public NativeLazyString(final ValueLoader<JSONObject> valueLoader) {
        this.loader = new ValueLoader() { // from class: com.bytedance.applog.priority.NativeLazyString$$ExternalSyntheticLambda0
            @Override // com.bytedance.applog.priority.original.ValueLoader
            public final Object load() {
                String jSONObject;
                jSONObject = ((JSONObject) ValueLoader.this.load()).toString();
                return jSONObject;
            }
        };
    }

    public String getValue() {
        return this.loader.load();
    }
}
