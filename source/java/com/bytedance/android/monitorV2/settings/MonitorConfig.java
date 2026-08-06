package com.bytedance.android.monitorV2.settings;

import com.bytedance.ies.xbridge.XBridge;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MonitorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/MonitorConfig;", "", "()V", "enableHandlePerfMix", "", "getEnableHandlePerfMix", "()Z", "setEnableHandlePerfMix", "(Z)V", "enableKernelBlankLog", "getEnableKernelBlankLog", "setEnableKernelBlankLog", "enableLynxNavigationFix", "getEnableLynxNavigationFix", "setEnableLynxNavigationFix", "enableVirtualAid", "getEnableVirtualAid", "setEnableVirtualAid", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class MonitorConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MonitorConfig DEFAULT = new MonitorConfig();

    @SerializedName("is_enable_virtual_aid")
    private boolean enableVirtualAid = true;

    @SerializedName("is_enable_handle_perfmix")
    private boolean enableHandlePerfMix = true;

    @SerializedName("is_enable_kernel_blank_log")
    private boolean enableKernelBlankLog = true;

    @SerializedName("is_enable_lynx_navigation_fix")
    private boolean enableLynxNavigationFix = true;

    public final boolean getEnableVirtualAid() {
        return this.enableVirtualAid;
    }

    public final void setEnableVirtualAid(boolean z) {
        this.enableVirtualAid = z;
    }

    public final boolean getEnableHandlePerfMix() {
        return this.enableHandlePerfMix;
    }

    public final void setEnableHandlePerfMix(boolean z) {
        this.enableHandlePerfMix = z;
    }

    public final boolean getEnableKernelBlankLog() {
        return this.enableKernelBlankLog;
    }

    public final void setEnableKernelBlankLog(boolean z) {
        this.enableKernelBlankLog = z;
    }

    public final boolean getEnableLynxNavigationFix() {
        return this.enableLynxNavigationFix;
    }

    public final void setEnableLynxNavigationFix(boolean z) {
        this.enableLynxNavigationFix = z;
    }

    /* compiled from: MonitorConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/MonitorConfig$Companion;", "", "()V", XBridge.DEFAULT_NAMESPACE, "Lcom/bytedance/android/monitorV2/settings/MonitorConfig;", "getDEFAULT", "()Lcom/bytedance/android/monitorV2/settings/MonitorConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MonitorConfig getDEFAULT() {
            return MonitorConfig.DEFAULT;
        }
    }
}
