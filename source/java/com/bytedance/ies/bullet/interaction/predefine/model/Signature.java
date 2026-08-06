package com.bytedance.ies.bullet.interaction.predefine.model;

import com.bytedance.android.monitorV2.constant.ReportConst;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: MetaModelConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/model/Signature;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "development", "", "getDevelopment", "()Ljava/lang/String;", ReportConst.ValidationReport.MODULE, "getModule", "production", "getProduction", "type", "getType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class Signature {
    private final String development;
    private final String module;
    private final String production;
    private final String type;

    public Signature(JSONObject jSONObject) {
        this.type = jSONObject != null ? jSONObject.optString("type") : null;
        this.development = jSONObject != null ? jSONObject.optString("development") : null;
        this.production = jSONObject != null ? jSONObject.optString("production") : null;
        this.module = jSONObject != null ? jSONObject.optString(ReportConst.ValidationReport.MODULE) : null;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDevelopment() {
        return this.development;
    }

    public final String getProduction() {
        return this.production;
    }

    public final String getModule() {
        return this.module;
    }
}
