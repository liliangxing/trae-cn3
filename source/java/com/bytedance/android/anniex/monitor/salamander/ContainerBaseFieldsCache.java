package com.bytedance.android.anniex.monitor.salamander;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerBaseFieldsCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/ContainerBaseFieldsCache;", "", "()V", "defauleValue", "", "lynxVersion", "getLynxVersion", "()Ljava/lang/String;", "setLynxVersion", "(Ljava/lang/String;)V", "webEngineVersion", "getWebEngineVersion", "setWebEngineVersion", "webViewType", "getWebViewType", "setWebViewType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class ContainerBaseFieldsCache {
    public static final String defauleValue = "unknown";
    public static final ContainerBaseFieldsCache INSTANCE = new ContainerBaseFieldsCache();
    private static String lynxVersion = "unknown";
    private static String webViewType = "unknown";
    private static String webEngineVersion = "unknown";

    private ContainerBaseFieldsCache() {
    }

    public final String getLynxVersion() {
        return lynxVersion;
    }

    public final void setLynxVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        lynxVersion = str;
    }

    public final String getWebViewType() {
        return webViewType;
    }

    public final void setWebViewType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        webViewType = str;
    }

    public final String getWebEngineVersion() {
        return webEngineVersion;
    }

    public final void setWebEngineVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        webEngineVersion = str;
    }
}
