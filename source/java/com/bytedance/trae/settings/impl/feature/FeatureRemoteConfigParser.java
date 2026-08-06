package com.bytedance.trae.settings.impl.feature;

import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeatureRemoteConfigParser.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;", "", "<init>", "()V", RLMonitorReporter.PARSE, "", "", "", "json", "scope", "Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FeatureRemoteConfigParser {
    public static final FeatureRemoteConfigParser INSTANCE = new FeatureRemoteConfigParser();

    private FeatureRemoteConfigParser() {
    }

    public final Map<String, Boolean> parse(String json, FeatureCapabilityScope scope) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(scope, "scope");
        JsonObject asJsonObject = JsonParser.parseString(json).getAsJsonObject().getAsJsonObject(scope.getRemoteKey());
        if (asJsonObject == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<Map.Entry> entrySet = asJsonObject.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
        for (Map.Entry entry : entrySet) {
            Intrinsics.checkNotNull(entry);
            String str = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
                linkedHashMap.put(str, Boolean.valueOf(jsonElement.getAsBoolean()));
            }
        }
        return linkedHashMap;
    }
}
