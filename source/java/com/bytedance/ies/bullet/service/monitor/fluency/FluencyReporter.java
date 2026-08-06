package com.bytedance.ies.bullet.service.monitor.fluency;

import android.util.Log;
import bolts.Task;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.perf.monitor.ReportConst;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: FluencyReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/fluency/FluencyReporter;", "Lcom/bytedance/apm/trace/fps/FpsTracer$IFPSCallBack;", "Lcom/bytedance/apm/trace/fps/FpsTracer$IDropFrameCallback;", "()V", "bid", "", "dropFrames", "Lorg/json/JSONObject;", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "extraCategoryEnd", "extraCategoryStart", "fps", "", "identifider", "Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", ReportConst.KEY_SCENE, "Lcom/bytedance/ies/bullet/core/common/Scenes;", "clear", "", "dropFrame", "fpsCallBack", "injectInfoRecordNeed", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "mergeAndReport", "setDuration", "setExtraCategoryEnd", "extraCategory", "setExtraCategoryStart", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FluencyReporter implements FpsTracer.IFPSCallBack, FpsTracer.IDropFrameCallback {
    private static final String BDX_MONITOR_FLUENCY = "bdx_monitor_fluency";
    private static final String TAG = "FluencyMonitor";
    private String bid;
    private JSONObject dropFrames;
    private JSONObject extraCategoryEnd;
    private JSONObject extraCategoryStart;
    private BulletLoadUriIdentifier identifider;
    private Scenes scene;
    private long duration = -1;
    private double fps = -1.0d;

    public void dropFrame(JSONObject dropFrames) {
        Log.i(TAG, "dropFrame");
        this.dropFrames = dropFrames;
        mergeAndReport();
    }

    public void fpsCallBack(double fps) {
        Log.i(TAG, "fpsCallBack");
        this.fps = fps;
    }

    public final void injectInfoRecordNeed(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        this.identifider = bulletContext.getUriIdentifier();
        this.bid = bulletContext.getBid();
        this.scene = bulletContext.getScene();
    }

    public final void setExtraCategoryStart(JSONObject extraCategory) {
        Intrinsics.checkNotNullParameter(extraCategory, "extraCategory");
        this.extraCategoryStart = extraCategory;
    }

    public final void setExtraCategoryEnd(JSONObject extraCategory) {
        Intrinsics.checkNotNullParameter(extraCategory, "extraCategory");
        this.extraCategoryEnd = extraCategory;
    }

    public final void setDuration(long duration) {
        this.duration = duration;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        if (r9.dropFrames != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mergeAndReport() {
        boolean z;
        JSONObject jSONObject = this.extraCategoryStart;
        Object opt = jSONObject != null ? jSONObject.opt(FluencyHelper.STAGE) : null;
        JSONObject jSONObject2 = this.extraCategoryEnd;
        Object opt2 = jSONObject2 != null ? jSONObject2.opt(FluencyHelper.STAGE) : null;
        if (opt != null && opt2 != null && Intrinsics.areEqual(opt, opt2) && this.duration >= 0) {
            double d = this.fps;
            z = false;
            if (d >= 0) {
                if (d <= FpsUtil.getRefreshRate()) {
                }
            }
        }
        z = true;
        if (z) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "FluencyMonitor-mergeAndReport,stage is wrong and didn't report", null, null, 6, null);
            clear();
        } else {
            Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.service.monitor.fluency.FluencyReporter$mergeAndReport$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    BulletLoadUriIdentifier bulletLoadUriIdentifier;
                    JSONObject jSONObject3;
                    Scenes scenes;
                    double d2;
                    JSONObject jSONObject4;
                    long j;
                    String str;
                    ReportInfo reportInfo = new ReportInfo("bdx_monitor_fluency", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                    FluencyReporter fluencyReporter = FluencyReporter.this;
                    bulletLoadUriIdentifier = fluencyReporter.identifider;
                    reportInfo.setPageIdentifier(bulletLoadUriIdentifier);
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject3 = fluencyReporter.extraCategoryEnd;
                    JSONObject wrap = JsonUtilsKt.wrap(jSONObject5, jSONObject3);
                    scenes = fluencyReporter.scene;
                    wrap.put("view_type", scenes != null ? scenes.getTag() : null);
                    reportInfo.setCategory(wrap);
                    FluencyHelper fluencyHelper = FluencyHelper.INSTANCE;
                    d2 = fluencyReporter.fps;
                    jSONObject4 = fluencyReporter.dropFrames;
                    j = fluencyReporter.duration;
                    reportInfo.setMetrics(fluencyHelper.collectFluencyMetrics(d2, jSONObject4, j));
                    String format = String.format(new String(), Arrays.copyOf(new Object[]{"mergeAndReport,data:%s", reportInfo.toString()}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
                    Log.i("FluencyMonitor", format);
                    IServiceCenter instance = ServiceCenter.INSTANCE.instance();
                    str = FluencyReporter.this.bid;
                    if (str == null) {
                        str = "default_bid";
                    }
                    MonitorReportService monitorReportService = (IMonitorReportService) instance.get(str, IMonitorReportService.class);
                    if (monitorReportService == null) {
                        monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
                    }
                    monitorReportService.report(reportInfo);
                    FluencyReporter.this.clear();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clear() {
        this.duration = -1L;
        this.fps = -1.0d;
        this.dropFrames = null;
        this.extraCategoryStart = null;
        this.extraCategoryEnd = null;
    }
}
