package com.bytedance.android.monitorV2.lynx.impl;

import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxPerfData;
import com.bytedance.applog.server.Api;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: LynxIntegration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\"\u0010\f\u001a\u00020\n2\u0018\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eH&J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0001H&J\b\u0010\u0013\u001a\u00020\nH&J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\nH&J\u001e\u0010\u001b\u001a\u00020\n2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH&J\b\u0010\u001d\u001a\u00020\nH&J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H&J\u0012\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%H&J\b\u0010&\u001a\u00020\nH&J\u001e\u0010'\u001a\u00020\n2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010)H&J\u001e\u0010*\u001a\u00020\n2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010)H&J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-H&R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006."}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegration;", "", "view", "Lcom/lynx/tasm/LynxView;", "(Lcom/lynx/tasm/LynxView;)V", "hostViewRef", "Ljava/lang/ref/WeakReference;", "getHostViewRef$anniex_release", "()Ljava/lang/ref/WeakReference;", "onAttachedToView", "", "onBeforeDestroy", "onCallJSBFinished", "jsbTiming", "", "", "onConfig", Api.KEY_ENCRYPT_RESP_KEY, "value", "onDestroy", "onEventPost", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "onFirstLoadPerfReady", "lynxPerf", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "onFirstScreen", "onJSBInvoked", "jsbInfo", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "data", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "onUpdatePerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class LynxIntegration {
    private final WeakReference<LynxView> hostViewRef;

    public abstract void onAttachedToView();

    public abstract void onBeforeDestroy();

    public abstract void onCallJSBFinished(Map<String, ? extends Object> jsbTiming);

    public abstract void onConfig(String key, Object value);

    public abstract void onDestroy();

    public abstract void onEventPost(HybridEvent event);

    public abstract void onFirstLoadPerfReady(LynxPerfData lynxPerf);

    public abstract void onFirstScreen();

    public abstract void onJSBInvoked(Map<String, ? extends Object> jsbInfo);

    public abstract void onLoadSuccess();

    public abstract void onPageStart(String url);

    public abstract void onReceivedError(LynxNativeErrorData data);

    public abstract void onReportLynxConfigInfo(LynxConfigInfo info);

    public abstract void onRuntimeReady();

    public abstract void onTimingSetup(Map<String, Object> timingInfo);

    public abstract void onTimingUpdate(Map<String, Object> timingInfo);

    public abstract void onUpdatePerfReady(LynxPerfMetric metric);

    public LynxIntegration(LynxView lynxView) {
        this.hostViewRef = new WeakReference<>(lynxView);
    }

    public final WeakReference<LynxView> getHostViewRef$anniex_release() {
        return this.hostViewRef;
    }
}
