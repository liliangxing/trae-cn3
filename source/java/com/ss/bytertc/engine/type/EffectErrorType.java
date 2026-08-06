package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum EffectErrorType {
    OK(0),
    EFFECT_ERROR_VIRTUAL_BACKFROUND_FAILURE(1),
    EFFECT_ERROR_CHILD_PROC_TERMINATE(2);

    private int value;

    EffectErrorType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static EffectErrorType fromId(int id) {
        for (EffectErrorType effectErrorType : values()) {
            if (effectErrorType.value() == id) {
                return effectErrorType;
            }
        }
        return null;
    }
}
