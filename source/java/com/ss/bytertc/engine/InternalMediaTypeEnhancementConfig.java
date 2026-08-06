package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.MediaTypeEnhancementConfig;

/* loaded from: classes7.dex */
public class InternalMediaTypeEnhancementConfig {
    public boolean adaptiveEnhance;
    public boolean enhanceAudio;
    public boolean enhanceScreenAudio;
    public boolean enhanceScreenVideo;
    public boolean enhanceSignaling;
    public boolean enhanceVideo;

    public InternalMediaTypeEnhancementConfig(MediaTypeEnhancementConfig config) {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
        this.enhanceVideo = false;
        this.enhanceScreenAudio = false;
        this.enhanceScreenVideo = false;
        this.adaptiveEnhance = false;
        this.enhanceSignaling = config.enhanceSignaling;
        this.enhanceAudio = config.enhanceAudio;
        this.enhanceVideo = config.enhanceVideo;
        this.enhanceScreenAudio = config.enhanceScreenAudio;
        this.enhanceScreenVideo = config.enhanceScreenVideo;
        this.adaptiveEnhance = config.adaptiveEnhance;
    }

    boolean getSignalingEnhance() {
        return this.enhanceSignaling;
    }

    boolean getAudioEnhance() {
        return this.enhanceAudio;
    }

    boolean getVideoEnhance() {
        return this.enhanceVideo;
    }

    boolean getScreenAudioEnhance() {
        return this.enhanceScreenAudio;
    }

    boolean getScreenVideoEnhance() {
        return this.enhanceScreenVideo;
    }

    boolean getAdaptiveEnhance() {
        return this.adaptiveEnhance;
    }
}
