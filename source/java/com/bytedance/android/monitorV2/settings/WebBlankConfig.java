package com.bytedance.android.monitorV2.settings;

import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebBlankConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/WebBlankConfig;", "", "()V", "monitorDetectTime", "", "getMonitorDetectTime", "()J", "setMonitorDetectTime", "(J)V", "monitorDetectType", "", "getMonitorDetectType", "()I", "setMonitorDetectType", "(I)V", "stayDuration", "getStayDuration", "setStayDuration", "urlAppInfoList", "", "", "getUrlAppInfoList", "()[Ljava/lang/String;", "setUrlAppInfoList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "urlBlockList", "getUrlBlockList", "setUrlBlockList", "useMonitorDetect", "", "getUseMonitorDetect", "()Z", "setUseMonitorDetect", "(Z)V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class WebBlankConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final WebBlankConfig DEFAULT = new WebBlankConfig();

    @SerializedName("detect_type")
    private int monitorDetectType;

    @SerializedName("use_monitor_detect")
    private boolean useMonitorDetect = true;

    @SerializedName("monitor_detect_time")
    private long monitorDetectTime = 6000;

    @SerializedName("url_blocklist")
    private String[] urlBlockList = new String[0];

    @SerializedName("stay_duration")
    private long stayDuration = OnekeyLoginConfig.OVER_TIME;

    @SerializedName("url_appinfo_list")
    private String[] urlAppInfoList = new String[0];

    public final boolean getUseMonitorDetect() {
        return this.useMonitorDetect;
    }

    public final void setUseMonitorDetect(boolean z) {
        this.useMonitorDetect = z;
    }

    public final long getMonitorDetectTime() {
        return this.monitorDetectTime;
    }

    public final void setMonitorDetectTime(long j) {
        this.monitorDetectTime = j;
    }

    public final int getMonitorDetectType() {
        return this.monitorDetectType;
    }

    public final void setMonitorDetectType(int i) {
        this.monitorDetectType = i;
    }

    public final String[] getUrlBlockList() {
        return this.urlBlockList;
    }

    public final void setUrlBlockList(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.urlBlockList = strArr;
    }

    public final long getStayDuration() {
        return this.stayDuration;
    }

    public final void setStayDuration(long j) {
        this.stayDuration = j;
    }

    public final String[] getUrlAppInfoList() {
        return this.urlAppInfoList;
    }

    public final void setUrlAppInfoList(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.urlAppInfoList = strArr;
    }

    /* compiled from: WebBlankConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/WebBlankConfig$Companion;", "", "()V", XBridge.DEFAULT_NAMESPACE, "Lcom/bytedance/android/monitorV2/settings/WebBlankConfig;", "getDEFAULT", "()Lcom/bytedance/android/monitorV2/settings/WebBlankConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebBlankConfig getDEFAULT() {
            return WebBlankConfig.DEFAULT;
        }
    }
}
