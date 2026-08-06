package com.lynx.tasm.behavior.shadow;

/* loaded from: classes7.dex */
public class MeasureResult {
    private static final int NUM_RESULT = 3;
    private static final int RESULT_BASELINE = 2;
    private static final int RESULT_HEIGHT = 1;
    private static final int RESULT_WIDTH = 0;
    private float[] measureResult;

    public MeasureResult(float f, float f2) {
        this.measureResult = r0;
        float[] fArr = {f, f2, 0.0f};
    }

    public MeasureResult(float f, float f2, float f3) {
        this.measureResult = r0;
        float[] fArr = {f, f2, f3};
    }

    public float getWidthResult() {
        return this.measureResult[0];
    }

    public float getHeightResult() {
        return this.measureResult[1];
    }

    public float getBaselineResult() {
        return this.measureResult[2];
    }
}
