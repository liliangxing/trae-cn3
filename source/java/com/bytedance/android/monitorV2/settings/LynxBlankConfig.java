package com.bytedance.android.monitorV2.settings;

import com.bytedance.ies.xbridge.XBridge;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxBlankConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/LynxBlankConfig;", "", "()V", "stayDuration", "", "getStayDuration", "()J", "setStayDuration", "(J)V", "urlBlockList", "", "", "getUrlBlockList", "()[Ljava/lang/String;", "setUrlBlockList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxBlankConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LynxBlankConfig DEFAULT = new LynxBlankConfig();

    @SerializedName("url_blocklist")
    private String[] urlBlockList = new String[0];

    @SerializedName("stay_duration")
    private long stayDuration = 2000;

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

    /* compiled from: LynxBlankConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/LynxBlankConfig$Companion;", "", "()V", XBridge.DEFAULT_NAMESPACE, "Lcom/bytedance/android/monitorV2/settings/LynxBlankConfig;", "getDEFAULT", "()Lcom/bytedance/android/monitorV2/settings/LynxBlankConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxBlankConfig getDEFAULT() {
            return LynxBlankConfig.DEFAULT;
        }
    }
}
