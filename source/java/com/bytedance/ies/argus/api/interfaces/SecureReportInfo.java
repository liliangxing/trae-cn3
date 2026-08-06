package com.bytedance.ies.argus.api.interfaces;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusInitDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0014HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0004¨\u0006$"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/SecureReportInfo;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "(Ljava/lang/String;)V", "bid", "getBid", "()Ljava/lang/String;", "setBid", "category", "Lorg/json/JSONObject;", "getCategory", "()Lorg/json/JSONObject;", "setCategory", "(Lorg/json/JSONObject;)V", "getEventName", "metrics", "getMetrics", "setMetrics", "sampleLevel", "", "getSampleLevel", "()I", "setSampleLevel", "(I)V", "url", "getUrl", "setUrl", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SecureReportInfo {
    public static final String DEFAULT_BID = "argus_verify_client";
    public static final String ERROR_BID = "argus_hybrid_error";
    public static final String FORCE_HIGH_BID = "argus_hybrid_high";
    public static final int HIGH_SAMPLE_LEVEL = 0;
    public static final int LOW_SAMPLE_LEVEL = 3;
    public static final int MEDIUM_SAMPLE_LEVEL = 2;
    public static final String REWRITE_BID = "argus_hybrid_rewrite";
    private String bid;
    private JSONObject category;
    private final String eventName;
    private JSONObject metrics;
    private int sampleLevel;
    private String url;

    public static /* synthetic */ SecureReportInfo copy$default(SecureReportInfo secureReportInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = secureReportInfo.eventName;
        }
        return secureReportInfo.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    public final SecureReportInfo copy(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new SecureReportInfo(eventName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SecureReportInfo) && Intrinsics.areEqual(this.eventName, ((SecureReportInfo) other).eventName);
    }

    public int hashCode() {
        return this.eventName.hashCode();
    }

    public String toString() {
        return "SecureReportInfo(eventName=" + this.eventName + ')';
    }

    public SecureReportInfo(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.sampleLevel = 3;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final JSONObject getCategory() {
        return this.category;
    }

    public final void setCategory(JSONObject jSONObject) {
        this.category = jSONObject;
    }

    public final JSONObject getMetrics() {
        return this.metrics;
    }

    public final void setMetrics(JSONObject jSONObject) {
        this.metrics = jSONObject;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final int getSampleLevel() {
        return this.sampleLevel;
    }

    public final void setSampleLevel(int i) {
        this.sampleLevel = i;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        this.bid = str;
    }
}
