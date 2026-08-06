package com.bytedance.android.monitorV2.lynx;

import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxPerfData;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: LynxViewLifeCycleDelegate.kt */
@Deprecated(message = "Error: This interface will be removed in later versions. Do not use this interface again")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0012\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001bH&JF\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006#"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/ILynxViewLifeCycleDelegate;", "", "onDestroy", "", "view", "Lcom/lynx/tasm/LynxView;", "onFirstLoadPerfReady", "lynxPerfData", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "onFirstScreen", "onLoadSuccess", "onPageStart", "url", "", "onPageUpdate", "onReceivedError", "lynxNativeErrorData", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "onReportComponentInfo", "mComponentSet", "", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ILynxViewLifeCycleDelegate {
    void onDestroy(LynxView view);

    void onFirstLoadPerfReady(LynxPerfData lynxPerfData, LynxView view);

    void onFirstScreen(LynxView view);

    void onLoadSuccess(LynxView view);

    void onPageStart(String url, LynxView view);

    void onPageUpdate(LynxView view);

    void onReceivedError(LynxNativeErrorData lynxNativeErrorData, LynxView view);

    void onReportComponentInfo(Set<String> mComponentSet, LynxView view);

    void onReportLynxConfigInfo(LynxConfigInfo info, LynxView view);

    void onRuntimeReady(LynxView view);

    void onTimingSetup(LynxView view, Map<String, Object> timingInfo);

    void onTimingUpdate(LynxView view, Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag);

    void onUpdatePerfReady(LynxPerfMetric metric, LynxView view);
}
