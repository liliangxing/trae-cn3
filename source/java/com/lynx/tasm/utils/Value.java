package com.lynx.tasm.utils;

/* loaded from: classes7.dex */
public class Value {
    public final Unit unit;
    public final float value;

    /* loaded from: classes7.dex */
    public enum Unit {
        PX,
        PERCENTAGE
    }

    public Value(float f, Unit unit) {
        this.value = f;
        this.unit = unit;
    }
}
