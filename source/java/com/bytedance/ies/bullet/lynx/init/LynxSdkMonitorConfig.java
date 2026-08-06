package com.bytedance.ies.bullet.lynx.init;

import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: LynxSdkMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;", "", "()V", "configUrls", "", "", "getConfigUrls", "()Ljava/util/List;", "setConfigUrls", "(Ljava/util/List;)V", "header", "Lorg/json/JSONObject;", "getHeader", "()Lorg/json/JSONObject;", "setHeader", "(Lorg/json/JSONObject;)V", "oversea", "", "getOversea", "()Z", "setOversea", "(Z)V", "reportUrls", "getReportUrls", "setReportUrls", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxSdkMonitorConfig {
    private List<String> configUrls;
    private JSONObject header;
    private boolean oversea;
    private List<String> reportUrls;

    public final JSONObject getHeader() {
        return this.header;
    }

    public final void setHeader(JSONObject jSONObject) {
        this.header = jSONObject;
    }

    public final boolean getOversea() {
        return this.oversea;
    }

    public final void setOversea(boolean z) {
        this.oversea = z;
    }

    public final List<String> getConfigUrls() {
        return this.configUrls;
    }

    public final void setConfigUrls(List<String> list) {
        this.configUrls = list;
    }

    public final List<String> getReportUrls() {
        return this.reportUrls;
    }

    public final void setReportUrls(List<String> list) {
        this.reportUrls = list;
    }
}
