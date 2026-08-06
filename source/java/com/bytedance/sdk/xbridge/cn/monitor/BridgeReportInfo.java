package com.bytedance.sdk.xbridge.cn.monitor;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XBridgeCallMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0013\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0017HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u0004¨\u0006&"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/monitor/BridgeReportInfo;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "(Ljava/lang/String;)V", "category", "Lorg/json/JSONObject;", "getCategory", "()Lorg/json/JSONObject;", "setCategory", "(Lorg/json/JSONObject;)V", "getEventName", "()Ljava/lang/String;", "highFrequency", "", "getHighFrequency", "()Z", "setHighFrequency", "(Z)V", "metrics", "getMetrics", "setMetrics", "sampleLevel", "", "getSampleLevel", "()Ljava/lang/Integer;", "setSampleLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "url", "getUrl", "setUrl", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BridgeReportInfo {
    private JSONObject category;
    private final String eventName;
    private boolean highFrequency;
    private JSONObject metrics;
    private Integer sampleLevel;
    private String url;

    public static /* synthetic */ BridgeReportInfo copy$default(BridgeReportInfo bridgeReportInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bridgeReportInfo.eventName;
        }
        return bridgeReportInfo.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    public final BridgeReportInfo copy(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new BridgeReportInfo(eventName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BridgeReportInfo) && Intrinsics.areEqual(this.eventName, ((BridgeReportInfo) other).eventName);
    }

    public int hashCode() {
        return this.eventName.hashCode();
    }

    public String toString() {
        return "BridgeReportInfo(eventName=" + this.eventName + ')';
    }

    public BridgeReportInfo(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
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

    public final boolean getHighFrequency() {
        return this.highFrequency;
    }

    public final void setHighFrequency(boolean z) {
        this.highFrequency = z;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final Integer getSampleLevel() {
        return this.sampleLevel;
    }

    public final void setSampleLevel(Integer num) {
        this.sampleLevel = num;
    }
}
