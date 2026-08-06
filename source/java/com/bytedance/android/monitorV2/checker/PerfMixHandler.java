package com.bytedance.android.monitorV2.checker;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.hybridSetting.SettingsParseManager;
import com.bytedance.android.monitorV2.settings.MonitorConfig;
import com.bytedance.android.monitorV2.settings.MonitorSettingsCenter;
import com.bytedance.android.monitorV2.util.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PerfMixHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/PerfMixHandler;", "", "mixEvents", "", "", "(Ljava/util/List;)V", "mixHandler", "Ljava/util/HashMap;", "Lcom/bytedance/android/monitorV2/checker/AbsMixHandler;", "Lkotlin/collections/HashMap;", "work", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWork", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setWork", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "capture", "", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "enableHandlePerfMix", "", "stop", "fmpEnd", "", "result", "Lorg/json/JSONObject;", "hybridType", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PerfMixHandler {
    public static final String REQUEST_DUR = "request_dur";
    public static final String RES_TEMPLATE_DUR = "res_template_dur";
    public static final String SUB_RES_DUR = "sub_res_dur";
    private static final String TAG = "PerfMixHandler";
    private final List<String> mixEvents;
    private final HashMap<String, AbsMixHandler> mixHandler;
    private AtomicBoolean work;

    public PerfMixHandler(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "mixEvents");
        this.mixEvents = list;
        this.mixHandler = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(ReportConst.Event.RES_LOADER_PERF_TEMPLATE, new TemplateMixHandler()), TuplesKt.to(ReportConst.Event.RES_LOADER_PERF, new ResMixHandler()), TuplesKt.to(ReportConst.Event.JSB_PER_V2, new RequestJSBV2MixHandler()), TuplesKt.to("jsbPerf", new RequestJSBMixHandler())});
        this.work = new AtomicBoolean(true);
    }

    public final AtomicBoolean getWork() {
        return this.work;
    }

    public final void setWork(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.work = atomicBoolean;
    }

    public final void capture(CommonEvent event) {
        JSONObject jsonObject;
        AbsMixHandler absMixHandler;
        Intrinsics.checkNotNullParameter(event, "event");
        if (enableHandlePerfMix() && this.work.get() && this.mixEvents.contains(event.getEventType())) {
            String eventType = event.getEventType();
            BaseNativeInfo nativeInfo = event.getNativeInfo();
            if (nativeInfo == null || (jsonObject = nativeInfo.toJsonObject()) == null || (absMixHandler = this.mixHandler.get(eventType)) == null) {
                return;
            }
            absMixHandler.handle(jsonObject);
        }
    }

    public final void stop(long fmpEnd, JSONObject result, String hybridType) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(hybridType, "hybridType");
        if (enableHandlePerfMix() && this.work.get()) {
            this.work.compareAndSet(true, false);
            JsonUtils.safePut(result, "fmp_end", fmpEnd);
            Iterator<T> it = this.mixEvents.iterator();
            while (it.hasNext()) {
                AbsMixHandler absMixHandler = this.mixHandler.get((String) it.next());
                if (absMixHandler != null) {
                    absMixHandler.result(fmpEnd, result);
                }
            }
        }
    }

    private final boolean enableHandlePerfMix() {
        Object obj;
        MonitorConfig monitorConfig;
        try {
            Result.Companion companion = Result.Companion;
            MonitorSettingsCenter settingsCenter = SettingsParseManager.INSTANCE.getSettingsCenter();
            obj = Result.constructor-impl(Boolean.valueOf((settingsCenter == null || (monitorConfig = (MonitorConfig) settingsCenter.obtainSettings(MonitorConfig.class)) == null) ? true : monitorConfig.getEnableHandlePerfMix()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = true;
        }
        return ((Boolean) obj).booleanValue();
    }
}
