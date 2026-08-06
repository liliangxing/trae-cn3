package com.bytedance.android.monitorV2.lynx.impl;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxPerfData;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.Utilities;
import com.bytedance.android.monitorV2.util.Utilities$runAsyncQuietly$1;
import com.bytedance.applog.server.Api;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxPerfMetric;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxIntegrationProxy.kt */
@Deprecated(message = "Error: This class will be removed in later versions. Do not use this class again")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\f2\u0018\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\u001e\u0010\u001d\u001a\u00020\f2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0012\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\fH\u0016J\u001e\u0010)\u001a\u00020\f2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0018\u00010+H\u0016J\u001e\u0010,\u001a\u00020\f2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0018\u00010+H\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0016J\u0016\u00100\u001a\u00020\f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\f02H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegrationProxy;", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegration;", "invoker", "runInBackground", "", "(Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegration;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isEnableGlobally", "onAttachedToView", "", "onBeforeDestroy", "onCallJSBFinished", "jsbTiming", "", "", "onConfig", Api.KEY_ENCRYPT_RESP_KEY, "value", "onDestroy", "onEventPost", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "onFirstLoadPerfReady", "lynxPerf", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "onFirstScreen", "onJSBInvoked", "jsbInfo", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "data", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "onUpdatePerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "runInternal", "closure", "Lkotlin/Function0;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxIntegrationProxy extends LynxIntegration {
    private final String TAG;
    private final LynxIntegration invoker;
    private boolean runInBackground;

    public /* synthetic */ LynxIntegrationProxy(LynxIntegration lynxIntegration, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lynxIntegration, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxIntegrationProxy(LynxIntegration lynxIntegration, boolean z) {
        super(lynxIntegration.getHostViewRef$anniex_release().get());
        Intrinsics.checkNotNullParameter(lynxIntegration, "invoker");
        this.invoker = lynxIntegration;
        this.runInBackground = z;
        this.TAG = "LynxLifecycleProxy";
    }

    public final String getTAG() {
        return this.TAG;
    }

    private final boolean isEnableGlobally() {
        SwitchConfig switchConfig = HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch();
        Intrinsics.checkNotNullExpressionValue(switchConfig, "getInstance().hybridSettingManager.switch");
        boolean z = switchConfig.isEnableMonitor() && switchConfig.isLynxEnableMonitor();
        return getHostViewRef$anniex_release().get() != null ? LynxViewDataManager.INSTANCE.getOrCreate(getHostViewRef$anniex_release().get()).getViewConf().getEnableMonitor() && z : z;
    }

    private final void runInternal(Function0<Unit> closure) {
        if (isEnableGlobally()) {
            if (this.runInBackground) {
                Utilities utilities = Utilities.INSTANCE;
                HybridMonitorSingleExecutor.INSTANCE.execute(new Utilities$runAsyncQuietly$1(closure));
                return;
            }
            Utilities utilities2 = Utilities.INSTANCE;
            try {
                closure.invoke();
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onEventPost(final HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onEventPost$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m350invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m350invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onEventPost(event);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onAttachedToView() {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onAttachedToView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m345invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m345invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onAttachedToView();
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onPageStart(final String url) {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onPageStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m355invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m355invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onPageStart(url);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onLoadSuccess() {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onLoadSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m354invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m354invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onLoadSuccess();
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onDestroy() {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onDestroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m349invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m349invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onDestroy();
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onUpdatePerfReady(final LynxPerfMetric metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onUpdatePerfReady$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m361invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m361invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onUpdatePerfReady(metric);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onReportLynxConfigInfo(final LynxConfigInfo info) {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onReportLynxConfigInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m357invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m357invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onReportLynxConfigInfo(info);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onConfig(final String key, final Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m348invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m348invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onConfig(key, value);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onCallJSBFinished(final Map<String, ? extends Object> jsbTiming) {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onCallJSBFinished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m347invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m347invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onCallJSBFinished(jsbTiming);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onJSBInvoked(final Map<String, ? extends Object> jsbInfo) {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onJSBInvoked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m353invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m353invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onJSBInvoked(jsbInfo);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onReceivedError(final LynxNativeErrorData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onReceivedError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m356invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m356invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onReceivedError(data);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onFirstLoadPerfReady(final LynxPerfData lynxPerf) {
        Intrinsics.checkNotNullParameter(lynxPerf, "lynxPerf");
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onFirstLoadPerfReady$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m351invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m351invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onFirstLoadPerfReady(lynxPerf);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onRuntimeReady() {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onRuntimeReady$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m358invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m358invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onRuntimeReady();
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onFirstScreen() {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onFirstScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m352invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m352invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onFirstScreen();
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onTimingSetup(final Map<String, Object> timingInfo) {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onTimingSetup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m359invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m359invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onTimingSetup(timingInfo);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onTimingUpdate(final Map<String, Object> timingInfo) {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onTimingUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m360invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m360invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onTimingUpdate(timingInfo);
            }
        });
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onBeforeDestroy() {
        runInternal(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxIntegrationProxy$onBeforeDestroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m346invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m346invoke() {
                LynxIntegration lynxIntegration;
                lynxIntegration = LynxIntegrationProxy.this.invoker;
                lynxIntegration.onBeforeDestroy();
            }
        });
    }
}
