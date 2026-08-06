package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public class MediaTypeEnhancementConfig {
    public boolean adaptiveEnhance;
    public boolean enhanceAudio;
    public boolean enhanceScreenAudio;
    public boolean enhanceScreenVideo;
    public boolean enhanceSignaling;
    public boolean enhanceVideo;

    public MediaTypeEnhancementConfig() {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
        this.enhanceVideo = false;
        this.enhanceScreenAudio = false;
        this.enhanceScreenVideo = false;
        this.adaptiveEnhance = true;
    }

    public MediaTypeEnhancementConfig(boolean enhanceSignaling, boolean enhanceAudio, boolean enhanceVideo, boolean enhanceScreenAudio, boolean enhanceScreenVideo) {
        this.adaptiveEnhance = true;
        this.enhanceSignaling = enhanceSignaling;
        this.enhanceAudio = enhanceAudio;
        this.enhanceVideo = enhanceVideo;
        this.enhanceScreenAudio = enhanceScreenAudio;
        this.enhanceScreenVideo = enhanceScreenVideo;
    }

    public MediaTypeEnhancementConfig(boolean enhanceSignaling, boolean enhanceAudio, boolean enhanceVideo, boolean enhanceScreenAudio, boolean enhanceScreenVideo, boolean adaptiveEnhance) {
        this.enhanceSignaling = enhanceSignaling;
        this.enhanceAudio = enhanceAudio;
        this.enhanceVideo = enhanceVideo;
        this.enhanceScreenAudio = enhanceScreenAudio;
        this.enhanceScreenVideo = enhanceScreenVideo;
        this.adaptiveEnhance = adaptiveEnhance;
    }
}
