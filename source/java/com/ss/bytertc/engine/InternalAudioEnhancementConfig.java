package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.AudioEnhancementConfig;

/* loaded from: classes7.dex */
public class InternalAudioEnhancementConfig {
    public boolean enhanceAudio;
    public boolean enhanceSignaling;

    public InternalAudioEnhancementConfig(AudioEnhancementConfig config) {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
        this.enhanceSignaling = config.enhanceSignaling;
        this.enhanceAudio = config.enhanceAudio;
    }

    boolean getSignalingEnhance() {
        return this.enhanceSignaling;
    }

    boolean getAudioEnhance() {
        return this.enhanceAudio;
    }
}
