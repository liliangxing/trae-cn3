package com.ss.bytertc.engine;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class SubscribeVideoConfig {
    private int priority;
    private int videoIndex;

    public SubscribeVideoConfig(int videoIndex, int priority) {
        this.videoIndex = videoIndex;
        this.priority = priority;
    }

    public int getVideoIndex() {
        return this.videoIndex;
    }

    public int getPriority() {
        return this.priority;
    }

    public String toString() {
        return "SubscribeVideoConfig{videoIndex=" + this.videoIndex + ", priority=" + this.priority + AbstractJsonLexerKt.END_OBJ;
    }
}
