package com.bytedance.ies.bullet.interaction.predefine.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WasmDisableListConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/model/WasmDisableListConfig;", "", "config", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getConfig", "()Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WasmDisableListConfig {
    private final JSONObject config;

    public WasmDisableListConfig(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final JSONObject getConfig() {
        return this.config;
    }
}
