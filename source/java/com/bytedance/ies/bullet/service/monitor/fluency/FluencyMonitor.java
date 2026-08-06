package com.bytedance.ies.bullet.service.monitor.fluency;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: FluencyMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/fluency/FluencyMonitor;", "", "()V", "enableFluencyCollection", "", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "hasStarted", "reporter", "Lcom/bytedance/ies/bullet/service/monitor/fluency/FluencyReporter;", "startMillis", "", "initCallback", "", "initRecordConfig", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "isEnableFluencyCollection", "resetForNextPeriod", "startFluencyMonitor", "extraCategory", "Lorg/json/JSONObject;", "stopFluencyMonitor", "stopFluencyMonitorOnMainThread", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FluencyMonitor {
    private static final String TAG = "FluencyMonitor";
    private static final String TYPE = "bullet_fluency_tracer";
    private boolean enableFluencyCollection;
    private boolean hasStarted;
    private long startMillis;
    private FluencyReporter reporter = new FluencyReporter();
    private FpsTracer fpsTracer = new FpsTracer(TYPE);

    public FluencyMonitor() {
        initCallback();
    }

    private final void initCallback() {
        this.fpsTracer.setIFPSCallBack(new FpsTracer.IFPSCallBack() { // from class: com.bytedance.ies.bullet.service.monitor.fluency.FluencyMonitor$initCallback$1
            public final void fpsCallBack(double d) {
                FluencyReporter fluencyReporter;
                String format = String.format(new String(), Arrays.copyOf(new Object[]{"get fps from callBack:%s", String.valueOf(d)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
                Log.i("FluencyMonitor", format);
                fluencyReporter = FluencyMonitor.this.reporter;
                fluencyReporter.fpsCallBack(d);
            }
        });
        this.fpsTracer.setDropFrameCallback(new FpsTracer.IDropFrameCallback() { // from class: com.bytedance.ies.bullet.service.monitor.fluency.FluencyMonitor$initCallback$2
            public final void dropFrame(JSONObject jSONObject) {
                FluencyReporter fluencyReporter;
                String format = String.format(new String(), Arrays.copyOf(new Object[]{"get dropFrame data from callBack:%s", jSONObject.toString()}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
                Log.i("FluencyMonitor", format);
                fluencyReporter = FluencyMonitor.this.reporter;
                fluencyReporter.dropFrame(jSONObject);
            }
        });
    }

    public final void initRecordConfig(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        if (bulletContext.getUseCardMode()) {
            Log.d(TAG, "useCardMode is true. Ignore initRecordConfig");
            return;
        }
        this.enableFluencyCollection = Intrinsics.areEqual(new BooleanParam(bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_ENABLE_FLUENCY_COLLECTION, false).getValue(), true);
        Log.i(TAG, this + " enableFluencyCollection:" + this.enableFluencyCollection);
        this.reporter.injectInfoRecordNeed(bulletContext);
    }

    /* renamed from: isEnableFluencyCollection, reason: from getter */
    public final boolean getEnableFluencyCollection() {
        return this.enableFluencyCollection;
    }

    public final void startFluencyMonitor(JSONObject extraCategory) {
        Intrinsics.checkNotNullParameter(extraCategory, "extraCategory");
        if (this.hasStarted) {
            return;
        }
        Log.i(TAG, "startFluencyMonitor");
        this.reporter.setExtraCategoryStart(extraCategory);
        this.startMillis = SystemClock.uptimeMillis();
        this.fpsTracer.start();
        this.hasStarted = true;
    }

    public final void stopFluencyMonitor(final JSONObject extraCategory) {
        Intrinsics.checkNotNullParameter(extraCategory, "extraCategory");
        if (this.hasStarted) {
            Log.i(TAG, "stopFluencyMonitor");
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.ies.bullet.service.monitor.fluency.FluencyMonitor$stopFluencyMonitor$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FluencyMonitor.this.stopFluencyMonitorOnMainThread(extraCategory);
                    }
                });
            } else {
                stopFluencyMonitorOnMainThread(extraCategory);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopFluencyMonitorOnMainThread(JSONObject extraCategory) {
        this.reporter.setExtraCategoryEnd(extraCategory);
        this.reporter.setDuration(SystemClock.uptimeMillis() - this.startMillis);
        this.fpsTracer.stop();
        this.hasStarted = false;
        resetForNextPeriod();
    }

    /* renamed from: hasStarted, reason: from getter */
    public final boolean getHasStarted() {
        return this.hasStarted;
    }

    public final void resetForNextPeriod() {
        this.startMillis = 0L;
    }
}
