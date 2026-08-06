package com.bytedance.ies.bullet.service.base;

import com.bytedance.android.monitorV2.constant.ReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IPrefetchService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PrefetchV2Data;", "", "globalPropsName", "", ReportConst.ValidationReport.BODY, "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getBody", "()Lorg/json/JSONObject;", "getGlobalPropsName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PrefetchV2Data {
    private final JSONObject body;
    private final String globalPropsName;

    public static /* synthetic */ PrefetchV2Data copy$default(PrefetchV2Data prefetchV2Data, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prefetchV2Data.globalPropsName;
        }
        if ((i & 2) != 0) {
            jSONObject = prefetchV2Data.body;
        }
        return prefetchV2Data.copy(str, jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGlobalPropsName() {
        return this.globalPropsName;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getBody() {
        return this.body;
    }

    public final PrefetchV2Data copy(String globalPropsName, JSONObject body) {
        return new PrefetchV2Data(globalPropsName, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrefetchV2Data)) {
            return false;
        }
        PrefetchV2Data prefetchV2Data = (PrefetchV2Data) other;
        return Intrinsics.areEqual(this.globalPropsName, prefetchV2Data.globalPropsName) && Intrinsics.areEqual(this.body, prefetchV2Data.body);
    }

    public int hashCode() {
        String str = this.globalPropsName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        JSONObject jSONObject = this.body;
        return hashCode + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "PrefetchV2Data(globalPropsName=" + this.globalPropsName + ", body=" + this.body + ')';
    }

    public PrefetchV2Data(String str, JSONObject jSONObject) {
        this.globalPropsName = str;
        this.body = jSONObject;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final String getGlobalPropsName() {
        return this.globalPropsName;
    }
}
