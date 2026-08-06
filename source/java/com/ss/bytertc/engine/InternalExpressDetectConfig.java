package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.VideoEffectExpressionConfig;

/* loaded from: classes7.dex */
public class InternalExpressDetectConfig {
    public boolean enableAgeDetect;
    public boolean enableAttractivenessDetect;
    public boolean enableEmotionDetect;
    public boolean enableGenderDetect;
    public boolean enableHappinessDetect;

    public InternalExpressDetectConfig(VideoEffectExpressionConfig config) {
        this.enableAgeDetect = false;
        this.enableGenderDetect = false;
        this.enableEmotionDetect = false;
        this.enableAttractivenessDetect = false;
        this.enableHappinessDetect = false;
        this.enableAgeDetect = config.enableAgeDetect;
        this.enableGenderDetect = config.enableGenderDetect;
        this.enableEmotionDetect = config.enableEmotionDetect;
        this.enableAttractivenessDetect = config.enableAttractivenessDetect;
        this.enableHappinessDetect = config.enableHappinessDetect;
    }

    boolean enableAgeDetect() {
        return this.enableAgeDetect;
    }

    boolean enableGenderDetect() {
        return this.enableGenderDetect;
    }

    boolean enableEmotionDetect() {
        return this.enableEmotionDetect;
    }

    boolean enableAttractivenessDetect() {
        return this.enableAttractivenessDetect;
    }

    boolean enableHappinessDetect() {
        return this.enableHappinessDetect;
    }
}
