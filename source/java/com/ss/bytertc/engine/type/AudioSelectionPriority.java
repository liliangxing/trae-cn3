package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioSelectionPriority {
    AUDIO_SELECTION_PRIORITY_NORMAL(0),
    AUDIO_SELECTION_PRIORITY_HIGIH(1);

    private int value;

    AudioSelectionPriority(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
