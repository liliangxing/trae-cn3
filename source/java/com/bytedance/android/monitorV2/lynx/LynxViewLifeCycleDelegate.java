package com.bytedance.android.monitorV2.lynx;

import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxPerfData;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxViewLifeCycleDelegate.kt */
@Deprecated(message = "Error: This interface will be removed in later versions. Do not use this interface again")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016JF\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020 \u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/LynxViewLifeCycleDelegate;", "Lcom/bytedance/android/monitorV2/lynx/ILynxViewLifeCycleDelegate;", "()V", "onDestroy", "", "view", "Lcom/lynx/tasm/LynxView;", "onFirstLoadPerfReady", "lynxPerfData", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "onFirstScreen", "onLoadSuccess", "onPageStart", "url", "", "onPageUpdate", "onReceivedError", "lynxNativeErrorData", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "onReportComponentInfo", "mComponentSet", "", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onTimingSetup", "timingInfo", "", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewLifeCycleDelegate implements ILynxViewLifeCycleDelegate {
    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onPageUpdate(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onPageStart(String url, LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onPageStart(url);
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onRuntimeReady(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onRuntimeReady();
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onReceivedError(LynxNativeErrorData lynxNativeErrorData, LynxView view) {
        Intrinsics.checkNotNullParameter(lynxNativeErrorData, "lynxNativeErrorData");
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onReceivedError(lynxNativeErrorData);
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onFirstLoadPerfReady(LynxPerfData lynxPerfData, LynxView view) {
        Intrinsics.checkNotNullParameter(lynxPerfData, "lynxPerfData");
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onFirstLoadPerfReady(lynxPerfData);
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onUpdatePerfReady(LynxPerfMetric metric, LynxView view) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onUpdatePerfReady(metric);
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onLoadSuccess(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onLoadSuccess();
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onFirstScreen(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onFirstScreen();
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onDestroy(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onDestroy();
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onTimingSetup(LynxView view, Map<String, Object> timingInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onTimingSetup(timingInfo);
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onTimingUpdate(LynxView view, Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onTimingUpdate(timingInfo);
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onReportLynxConfigInfo(LynxConfigInfo info, LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onReportLynxConfigInfo(info);
    }

    @Override // com.bytedance.android.monitorV2.lynx.ILynxViewLifeCycleDelegate
    public void onReportComponentInfo(Set<String> mComponentSet, LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).onBeforeDestroy();
    }
}
