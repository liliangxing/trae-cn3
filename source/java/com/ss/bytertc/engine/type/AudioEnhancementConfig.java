package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public class AudioEnhancementConfig {
    public boolean enhanceAudio;
    public boolean enhanceSignaling;

    public AudioEnhancementConfig() {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
    }

    public AudioEnhancementConfig(boolean enhanceSignaling, boolean enhanceAudio) {
        this.enhanceSignaling = enhanceSignaling;
        this.enhanceAudio = enhanceAudio;
    }
}
