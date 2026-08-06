package com.bytedance.android.monitorV2.lynx_helper;

import com.bytedance.android.monitorV2.checker.DoubleReportChecker;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxPerfData;
import com.bytedance.android.monitorV2.lynx.impl.LynxIntegration;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MonitorLynxViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u001e\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017J\b\u0010!\u001a\u00020\tH\u0016J\u001e\u0010\"\u001a\u00020\t2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010$H\u0016J>\u0010%\u001a\u00020\t2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010$2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020'\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx_helper/MonitorLynxViewClient;", "Lcom/lynx/tasm/LynxViewClient;", "lynxViewRef", "Ljava/lang/ref/WeakReference;", "Lcom/lynx/tasm/LynxView;", "(Ljava/lang/ref/WeakReference;)V", "lynxViewDataManager", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegration;", "onCallJSBFinished", "", "jsbTiming", "", "", "", "onDestroy", "onFirstLoadPerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "onFirstScreen", "onJSBInvoked", "jsbInfo", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "error", "Lcom/lynx/tasm/LynxError;", "onReportComponentInfo", "mComponentSet", "", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "updateTiming", "", "flag", "onUpdatePerfReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorLynxViewClient extends LynxViewClient {
    private final LynxIntegration lynxViewDataManager;
    private final WeakReference<LynxView> lynxViewRef;

    public MonitorLynxViewClient(WeakReference<LynxView> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "lynxViewRef");
        this.lynxViewRef = weakReference;
        this.lynxViewDataManager = LynxViewDataManager.INSTANCE.getOrCreate(weakReference.get());
    }

    public void onPageStart(String url) {
        this.lynxViewDataManager.onPageStart(url);
    }

    public void onLoadSuccess() {
        this.lynxViewDataManager.onLoadSuccess();
    }

    public void onFirstScreen() {
        this.lynxViewDataManager.onFirstScreen();
    }

    public void onRuntimeReady() {
        this.lynxViewDataManager.onRuntimeReady();
    }

    public void onFirstLoadPerfReady(LynxPerfMetric metric) {
        if (metric != null) {
            LynxIntegration lynxIntegration = this.lynxViewDataManager;
            LynxPerfData lynxPerfData = new LynxPerfData();
            lynxPerfData.setFp(metric.getFirsPageLayout());
            lynxPerfData.setFmp(metric.getFirsPageLayout());
            lynxPerfData.setTti(metric.getTti());
            lynxPerfData.setLayout(metric.getLayout());
            lynxPerfData.setDiffRootCreate(metric.getDiffRootCreate());
            lynxPerfData.setDiffSameRoot(metric.getDiffSameRoot());
            lynxPerfData.setTasmRndDecodeFinishLoadTemplate(metric.getTasmEndDecodeFinishLoadTemplate());
            lynxPerfData.setTasmBinaryDecode(metric.getTasmBinaryDecode());
            lynxPerfData.setTasmFinishLoadTemplate(metric.getTasmFinishLoadTemplate());
            lynxPerfData.setRenderPage(metric.getRenderPage());
            lynxPerfData.setSourceJsonObj(metric.toJSONObject());
            lynxIntegration.onFirstLoadPerfReady(lynxPerfData);
        }
    }

    public void onUpdatePerfReady(LynxPerfMetric metric) {
        if (metric != null) {
            this.lynxViewDataManager.onUpdatePerfReady(metric);
        }
    }

    public void onReceivedError(LynxError error) {
        if (error != null) {
            LynxIntegration lynxIntegration = this.lynxViewDataManager;
            LynxNativeErrorData lynxNativeErrorData = new LynxNativeErrorData();
            lynxNativeErrorData.setScene("lynx_error");
            lynxNativeErrorData.setErrorCode(error.getErrorCode());
            lynxNativeErrorData.setErrorMsg(error.getMsg());
            lynxIntegration.onReceivedError(lynxNativeErrorData);
        }
    }

    public void onDestroy() {
        this.lynxViewDataManager.onDestroy();
    }

    public void onTimingSetup(final Map<String, Object> timingInfo) {
        if (Switches.lynxMonitor.isEnabled()) {
            HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx_helper.MonitorLynxViewClient$onTimingSetup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m374invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m374invoke() {
                    LynxIntegration lynxIntegration;
                    LynxIntegration lynxIntegration2;
                    LynxIntegration lynxIntegration3;
                    LynxIntegration lynxIntegration4;
                    try {
                        lynxIntegration = MonitorLynxViewClient.this.lynxViewDataManager;
                        if (lynxIntegration instanceof LynxViewDataManager) {
                            DoubleReportChecker doubleReportChecker = DoubleReportChecker.INSTANCE;
                            JSONObject jSONObject = new JSONObject(timingInfo);
                            MonitorLynxViewClient monitorLynxViewClient = MonitorLynxViewClient.this;
                            lynxIntegration2 = monitorLynxViewClient.lynxViewDataManager;
                            LynxView view = ((LynxViewDataManager) lynxIntegration2).getView();
                            jSONObject.put("url", view != null ? view.getTemplateUrl() : null);
                            lynxIntegration3 = monitorLynxViewClient.lynxViewDataManager;
                            jSONObject.put("view_visible", ((LynxViewDataManager) lynxIntegration3).getViewVisible());
                            lynxIntegration4 = monitorLynxViewClient.lynxViewDataManager;
                            jSONObject.put("view_attached", ((LynxViewDataManager) lynxIntegration4).getViewAttached());
                            Unit unit = Unit.INSTANCE;
                            doubleReportChecker.reportTea("bd_hybrid_monitor_lynx_setup_timing", jSONObject);
                        }
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
            });
        }
        this.lynxViewDataManager.onTimingSetup(timingInfo);
    }

    public void onTimingUpdate(Map<String, Object> timingInfo, final Map<String, Long> updateTiming, String flag) {
        if (Switches.lynxMonitor.isEnabled()) {
            HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx_helper.MonitorLynxViewClient$onTimingUpdate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m375invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m375invoke() {
                    LynxIntegration lynxIntegration;
                    LynxIntegration lynxIntegration2;
                    LynxIntegration lynxIntegration3;
                    LynxIntegration lynxIntegration4;
                    try {
                        lynxIntegration = MonitorLynxViewClient.this.lynxViewDataManager;
                        if (lynxIntegration instanceof LynxViewDataManager) {
                            DoubleReportChecker doubleReportChecker = DoubleReportChecker.INSTANCE;
                            JSONObject optJSONObject = new JSONObject(updateTiming).optJSONObject("__lynx_timing_actual_fmp");
                            MonitorLynxViewClient monitorLynxViewClient = MonitorLynxViewClient.this;
                            lynxIntegration2 = monitorLynxViewClient.lynxViewDataManager;
                            LynxView view = ((LynxViewDataManager) lynxIntegration2).getView();
                            optJSONObject.put("url", view != null ? view.getTemplateUrl() : null);
                            lynxIntegration3 = monitorLynxViewClient.lynxViewDataManager;
                            optJSONObject.put("view_visible", ((LynxViewDataManager) lynxIntegration3).getViewVisible());
                            lynxIntegration4 = monitorLynxViewClient.lynxViewDataManager;
                            optJSONObject.put("view_attached", ((LynxViewDataManager) lynxIntegration4).getViewAttached());
                            Unit unit = Unit.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(optJSONObject, "JSONObject(updateTiming …                        }");
                            doubleReportChecker.reportTea("bd_hybrid_monitor_lynx_update_timing", optJSONObject);
                        }
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
            });
        }
        this.lynxViewDataManager.onTimingUpdate(timingInfo);
    }

    @Deprecated(message = "Deprecated in Java")
    public void onReportLynxConfigInfo(LynxConfigInfo info) {
        this.lynxViewDataManager.onReportLynxConfigInfo(info);
    }

    public void onReportComponentInfo(Set<String> mComponentSet) {
        this.lynxViewDataManager.onBeforeDestroy();
    }

    public void onCallJSBFinished(Map<String, ? extends Object> jsbTiming) {
        this.lynxViewDataManager.onCallJSBFinished(jsbTiming);
    }

    public void onJSBInvoked(Map<String, ? extends Object> jsbInfo) {
        this.lynxViewDataManager.onJSBInvoked(jsbInfo);
    }
}
