package com.lynx.tasm.fluency;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.fluency.FluencyTracerImpl;
import com.lynx.tasm.fluency.LynxFpsTracer;
import com.ss.android.token.TokenConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FluencyTracerImpl {
    private static final String LYNXSDK_FLUENCY_EVENT = "lynxsdk_fluency_event";
    private final WeakReference<LynxContext> mContext;
    private Map<Integer, LynxFpsTracer> mKeyedTracer = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public FluencyTracerImpl(LynxContext lynxContext) {
        this.mContext = new WeakReference<>(lynxContext);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class FluencyTracerConfig {
        private String scene = "";
        private String tag = "";
        private double pageConfigProbability = -1.0d;
        private LynxBooleanOption enabledBySampling = LynxBooleanOption.UNSET;

        public String getScene() {
            return this.scene;
        }

        public void setScene(String str) {
            this.scene = str;
        }

        public String getTag() {
            return this.tag;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public double getPageConfigProbability() {
            return this.pageConfigProbability;
        }

        public void setPageConfigProbability(double d) {
            this.pageConfigProbability = d;
        }

        public LynxBooleanOption getEnabledBySampling() {
            return this.enabledBySampling;
        }

        public void setEnabledBySampling(LynxBooleanOption lynxBooleanOption) {
            this.enabledBySampling = lynxBooleanOption;
        }
    }

    public void start(int i, FluencyTracerConfig fluencyTracerConfig) {
        LynxFpsTracer lynxFpsTracer = this.mKeyedTracer.get(Integer.valueOf(i));
        if (lynxFpsTracer == null) {
            LynxContext lynxContext = this.mContext.get();
            if (lynxContext == null) {
                return;
            }
            lynxFpsTracer = initLynxTracer(lynxContext, fluencyTracerConfig);
            this.mKeyedTracer.put(Integer.valueOf(i), lynxFpsTracer);
        }
        lynxFpsTracer.start();
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TokenConstants.SCENE_KEY, fluencyTracerConfig.scene);
            hashMap.put("tag", fluencyTracerConfig.tag);
            TraceEvent.instant(0L, "StartFluencyTrace", hashMap);
        }
    }

    public void stop(int i) {
        LynxFpsTracer lynxFpsTracer = this.mKeyedTracer.get(Integer.valueOf(i));
        if (lynxFpsTracer != null) {
            lynxFpsTracer.stop();
            this.mKeyedTracer.remove(Integer.valueOf(i));
        }
        TraceEvent.instant(0L, "StopFluencyTrace");
    }

    private LynxFpsTracer initLynxTracer(LynxContext lynxContext, FluencyTracerConfig fluencyTracerConfig) {
        LynxFpsTracer lynxFpsTracer = new LynxFpsTracer(lynxContext);
        lynxFpsTracer.setFluencyCallback(new LynxFluencyCallback(fluencyTracerConfig, lynxContext.getInstanceId()));
        return lynxFpsTracer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LynxFluencyCallback implements LynxFpsTracer.IFluencyCallback {
        private final FluencyTracerConfig mConfig;
        private final int mInstanceId;

        public LynxFluencyCallback(FluencyTracerConfig fluencyTracerConfig, int i) {
            this.mConfig = fluencyTracerConfig;
            this.mInstanceId = i;
        }

        @Override // com.lynx.tasm.fluency.LynxFpsTracer.IFluencyCallback
        public void report(final LynxFpsTracer.LynxFpsRawMetrics lynxFpsRawMetrics) {
            LynxEventReporter.onEvent(FluencyTracerImpl.LYNXSDK_FLUENCY_EVENT, this.mInstanceId, new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.fluency.FluencyTracerImpl$LynxFluencyCallback$$ExternalSyntheticLambda0
                @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
                public final Map build() {
                    return FluencyTracerImpl.LynxFluencyCallback.this.m9x84bbbe31(lynxFpsRawMetrics);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$report$0$com-lynx-tasm-fluency-FluencyTracerImpl$LynxFluencyCallback */
        public /* synthetic */ Map m9x84bbbe31(LynxFpsTracer.LynxFpsRawMetrics lynxFpsRawMetrics) {
            HashMap hashMap = new HashMap();
            hashMap.put("lynxsdk_fluency_scene", this.mConfig.getScene());
            hashMap.put("lynxsdk_fluency_tag", this.mConfig.getTag());
            hashMap.put("lynxsdk_fluency_maximum_frames", Integer.valueOf(lynxFpsRawMetrics.maximumFrames));
            hashMap.put("lynxsdk_fluency_frames_number", Integer.valueOf(lynxFpsRawMetrics.frames));
            hashMap.put("lynxsdk_fluency_fps", Integer.valueOf(lynxFpsRawMetrics.fps));
            hashMap.put("lynxsdk_fluency_dur", Long.valueOf(lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop1_count", Integer.valueOf(lynxFpsRawMetrics.drop1));
            hashMap.put("lynxsdk_fluency_drop1_duration", Long.valueOf(lynxFpsRawMetrics.drop1Duration));
            hashMap.put("lynxsdk_fluency_drop3_count", Integer.valueOf(lynxFpsRawMetrics.drop3));
            hashMap.put("lynxsdk_fluency_drop3_duration", Long.valueOf(lynxFpsRawMetrics.drop3Duration));
            hashMap.put("lynxsdk_fluency_drop7_count", Integer.valueOf(lynxFpsRawMetrics.drop7));
            hashMap.put("lynxsdk_fluency_drop7_duration", Long.valueOf(lynxFpsRawMetrics.drop7Duration));
            hashMap.put("lynxsdk_fluency_drop25_count", Integer.valueOf(lynxFpsRawMetrics.drop25));
            hashMap.put("lynxsdk_fluency_drop25_duration", Long.valueOf(lynxFpsRawMetrics.drop25Duration));
            hashMap.put("lynxsdk_fluency_drop1_count_per_second", Double.valueOf((lynxFpsRawMetrics.drop1 * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop3_count_per_second", Double.valueOf((lynxFpsRawMetrics.drop3 * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop7_count_per_second", Double.valueOf((lynxFpsRawMetrics.drop7 * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop25_count_per_second", Double.valueOf((lynxFpsRawMetrics.drop25 * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop1_ratio", Double.valueOf((lynxFpsRawMetrics.drop1Duration * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop3_ratio", Double.valueOf((lynxFpsRawMetrics.drop3Duration * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop7_ratio", Double.valueOf((lynxFpsRawMetrics.drop7Duration * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_drop25_ratio", Double.valueOf((lynxFpsRawMetrics.drop25Duration * 1000.0d) / lynxFpsRawMetrics.duration));
            hashMap.put("lynxsdk_fluency_pageconfig_probability", Double.valueOf(this.mConfig.getPageConfigProbability()));
            hashMap.put("lynxsdk_fluency_enabled_by_sampling", Integer.valueOf(this.mConfig.getEnabledBySampling().ordinal()));
            return hashMap;
        }
    }
}
