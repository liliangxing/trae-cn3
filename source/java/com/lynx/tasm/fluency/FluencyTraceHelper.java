package com.lynx.tasm.fluency;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fluency.FluencyTracerImpl;
import java.security.SecureRandom;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FluencyTraceHelper {
    public static final double UNKNOWN_FLUENCY_PAGECONFIG_PROBABILITY = -1.0d;
    private LynxBooleanOption mEnabled;
    private double mPageConfigProbability;
    private boolean mProbabilityDetermined;

    @Deprecated
    private String mScene;
    private final SecureRandom mSecureRandom;
    private ForceStatus mStatus;

    @Deprecated
    private String mTag;
    private FluencyTracerImpl mTracer;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum ForceStatus {
        FORCED_ON,
        FORCED_OFF,
        NON_FORCED
    }

    public FluencyTraceHelper(LynxContext lynxContext) {
        this.mSecureRandom = new SecureRandom();
        this.mPageConfigProbability = -1.0d;
        this.mStatus = ForceStatus.NON_FORCED;
        this.mProbabilityDetermined = false;
        this.mEnabled = LynxBooleanOption.UNSET;
        this.mScene = "";
        this.mTag = "";
        setPageConfigProbability(lynxContext.getEnableLynxScrollFluency());
        this.mTracer = new FluencyTracerImpl(lynxContext);
    }

    @Deprecated
    public FluencyTraceHelper(LynxContext lynxContext, String str, String str2) {
        this.mSecureRandom = new SecureRandom();
        this.mPageConfigProbability = -1.0d;
        this.mStatus = ForceStatus.NON_FORCED;
        this.mProbabilityDetermined = false;
        this.mEnabled = LynxBooleanOption.UNSET;
        this.mScene = "";
        this.mTag = "";
        if (FluencySample.isEnable() && lynxContext != null) {
            this.mScene = str;
            this.mTag = str2;
            this.mTracer = new FluencyTracerImpl(lynxContext);
        }
    }

    public void setPageConfigProbability(double d) {
        this.mPageConfigProbability = d;
        this.mProbabilityDetermined = false;
        updateStatus();
    }

    public void setEnabledBySampling(LynxBooleanOption lynxBooleanOption) {
        if (this.mEnabled == lynxBooleanOption) {
            return;
        }
        this.mEnabled = lynxBooleanOption;
        updateStatus();
    }

    private void updateStatus() {
        if (this.mPageConfigProbability >= 0.0d) {
            if (!this.mProbabilityDetermined || this.mStatus == ForceStatus.NON_FORCED) {
                this.mProbabilityDetermined = true;
                if (this.mSecureRandom.nextDouble() <= this.mPageConfigProbability) {
                    this.mStatus = ForceStatus.FORCED_ON;
                    return;
                } else {
                    this.mStatus = ForceStatus.FORCED_OFF;
                    return;
                }
            }
            return;
        }
        if (this.mEnabled != LynxBooleanOption.UNSET) {
            this.mStatus = this.mEnabled == LynxBooleanOption.TRUE ? ForceStatus.FORCED_ON : ForceStatus.FORCED_OFF;
        }
    }

    public boolean shouldSendAllScrollEvent() {
        if (this.mStatus == ForceStatus.NON_FORCED) {
            return FluencySample.isEnable();
        }
        return this.mStatus == ForceStatus.FORCED_ON;
    }

    @Deprecated
    public void start() {
        if (this.mTracer == null) {
            return;
        }
        FluencyTracerImpl.FluencyTracerConfig fluencyTracerConfig = new FluencyTracerImpl.FluencyTracerConfig();
        fluencyTracerConfig.setScene(this.mScene);
        fluencyTracerConfig.setTag(this.mTag);
        fluencyTracerConfig.setPageConfigProbability(this.mPageConfigProbability);
        this.mTracer.start(0, fluencyTracerConfig);
    }

    @Deprecated
    public void stop() {
        FluencyTracerImpl fluencyTracerImpl = this.mTracer;
        if (fluencyTracerImpl == null) {
            return;
        }
        fluencyTracerImpl.stop(0);
    }

    public void start(int i, String str, String str2) {
        if (this.mTracer == null || !shouldSendAllScrollEvent()) {
            return;
        }
        FluencyTracerImpl.FluencyTracerConfig fluencyTracerConfig = new FluencyTracerImpl.FluencyTracerConfig();
        fluencyTracerConfig.setScene(str);
        fluencyTracerConfig.setTag(str2);
        fluencyTracerConfig.setPageConfigProbability(this.mPageConfigProbability);
        fluencyTracerConfig.setEnabledBySampling(this.mEnabled);
        this.mTracer.start(i, fluencyTracerConfig);
    }

    public void stop(int i) {
        if (this.mTracer == null || !shouldSendAllScrollEvent()) {
            return;
        }
        this.mTracer.stop(i);
    }
}
