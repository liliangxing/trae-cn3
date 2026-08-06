package com.bytedance.ies.bullet.prefetchv2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchParam;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "rawValue", "", "(Ljava/lang/String;)V", "enableAppIdIsolation", "", "getEnableAppIdIsolation", "()Z", "setEnableAppIdIsolation", "(Z)V", "isRawValue", "setRawValue", "getRawValue", "()Ljava/lang/String;", "type", "getType", "setType", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchParam {
    private boolean enableAppIdIsolation;
    private boolean isRawValue;
    private String rawValue;
    private String type;
    private Object value;

    public PrefetchParam(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.type = "";
        this.value = "";
        this.rawValue = "";
        String optString = json.optString("type");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"type\")");
        this.type = optString;
        Object opt = json.opt("value");
        Intrinsics.checkNotNullExpressionValue(opt, "json.opt(\"value\")");
        this.value = opt;
        this.enableAppIdIsolation = json.optBoolean("enableAppIdIsolation", false);
        this.isRawValue = false;
    }

    public PrefetchParam(String rawValue) {
        Intrinsics.checkNotNullParameter(rawValue, "rawValue");
        this.type = "";
        this.value = "";
        this.rawValue = rawValue;
        this.isRawValue = true;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final Object getValue() {
        return this.value;
    }

    public final void setValue(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.value = obj;
    }

    public final boolean getEnableAppIdIsolation() {
        return this.enableAppIdIsolation;
    }

    public final void setEnableAppIdIsolation(boolean z) {
        this.enableAppIdIsolation = z;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public final void setRawValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rawValue = str;
    }

    /* renamed from: isRawValue, reason: from getter */
    public final boolean getIsRawValue() {
        return this.isRawValue;
    }

    public final void setRawValue(boolean z) {
        this.isRawValue = z;
    }
}
