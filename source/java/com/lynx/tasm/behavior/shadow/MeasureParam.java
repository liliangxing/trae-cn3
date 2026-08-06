package com.lynx.tasm.behavior.shadow;

/* loaded from: classes7.dex */
public class MeasureParam {
    public float mWidth = 0.0f;
    public MeasureMode mWidthMode = MeasureMode.UNDEFINED;
    public float mHeight = 0.0f;
    public MeasureMode mHeightMode = MeasureMode.UNDEFINED;

    public void updateConstraints(float f, MeasureMode measureMode, float f2, MeasureMode measureMode2) {
        this.mWidth = f;
        this.mWidthMode = measureMode;
        this.mHeight = f2;
        this.mHeightMode = measureMode2;
    }
}
