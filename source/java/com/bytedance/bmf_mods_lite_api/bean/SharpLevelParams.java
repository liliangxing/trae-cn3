package com.bytedance.bmf_mods_lite_api.bean;

/* loaded from: classes3.dex */
public class SharpLevelParams {
    public boolean disableNonIdentityMatrixCvt;
    public boolean enableOvershootReduction;
    public float overshootCoefficiency;
    public float overshootThreshold;
    public int sharpLevel;

    public SharpLevelParams() {
        this.enableOvershootReduction = false;
        this.overshootThreshold = 0.0f;
        this.overshootCoefficiency = 0.0f;
        this.disableNonIdentityMatrixCvt = false;
    }

    public SharpLevelParams(int sharpLevel) {
        this.enableOvershootReduction = false;
        this.overshootThreshold = 0.0f;
        this.overshootCoefficiency = 0.0f;
        this.disableNonIdentityMatrixCvt = false;
        this.sharpLevel = sharpLevel;
    }

    public SharpLevelParams(boolean enableOvershootReduction, float overshootThreshold, float overshootCoefficiency) {
        this.disableNonIdentityMatrixCvt = false;
        this.enableOvershootReduction = enableOvershootReduction;
        this.overshootThreshold = overshootThreshold;
        this.overshootCoefficiency = overshootCoefficiency;
        this.sharpLevel = SRConfig.SHARP_LEVEL_DEFAULT;
    }

    public SharpLevelParams(boolean enableOvershootReduction, float overshootThreshold, float overshootCoefficiency, boolean disableNonIdentityMatrixCvt) {
        this.enableOvershootReduction = enableOvershootReduction;
        this.overshootThreshold = overshootThreshold;
        this.overshootCoefficiency = overshootCoefficiency;
        this.disableNonIdentityMatrixCvt = disableNonIdentityMatrixCvt;
        this.sharpLevel = SRConfig.SHARP_LEVEL_DEFAULT;
    }
}
