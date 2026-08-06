package com.bytedance.android.monitorV2.experiment;

import kotlin.Metadata;

/* compiled from: HostExperimentManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/monitorV2/experiment/HostExperimentManager;", "", "()V", "disableRegexList", "", "getDisableRegexList", "()Z", "setDisableRegexList", "(Z)V", "enableBidRegexOptimize", "getEnableBidRegexOptimize", "setEnableBidRegexOptimize", "enableKernelBlankDetect", "getEnableKernelBlankDetect", "setEnableKernelBlankDetect", "enablePreSample", "getEnablePreSample", "setEnablePreSample", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class HostExperimentManager {
    public static final HostExperimentManager INSTANCE = new HostExperimentManager();
    private static boolean disableRegexList;
    private static boolean enableBidRegexOptimize;
    private static boolean enableKernelBlankDetect;
    private static boolean enablePreSample;

    private HostExperimentManager() {
    }

    public final boolean getEnableBidRegexOptimize() {
        return enableBidRegexOptimize;
    }

    public final void setEnableBidRegexOptimize(boolean z) {
        enableBidRegexOptimize = z;
    }

    public final boolean getEnableKernelBlankDetect() {
        return enableKernelBlankDetect;
    }

    public final void setEnableKernelBlankDetect(boolean z) {
        enableKernelBlankDetect = z;
    }

    public final boolean getEnablePreSample() {
        return enablePreSample;
    }

    public final void setEnablePreSample(boolean z) {
        enablePreSample = z;
    }

    public final boolean getDisableRegexList() {
        return disableRegexList;
    }

    public final void setDisableRegexList(boolean z) {
        disableRegexList = z;
    }
}
