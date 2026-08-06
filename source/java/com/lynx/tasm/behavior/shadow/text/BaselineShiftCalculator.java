package com.lynx.tasm.behavior.shadow.text;

import java.util.List;

/* loaded from: classes7.dex */
public class BaselineShiftCalculator {
    private List<Float> mTextFontMetricForVerticalAlign;

    public BaselineShiftCalculator(List<Float> list) {
        this.mTextFontMetricForVerticalAlign = list;
    }

    public float calcBaselineShiftAscender(int i, float f, float f2, float f3) {
        float f4 = f3 - f2;
        switch (i) {
            case 2:
                f = (-f4) * 0.1f;
                break;
            case 3:
                f = f4 * 0.1f;
                break;
            case 4:
            case 5:
                f = f2 - this.mTextFontMetricForVerticalAlign.get(0).floatValue();
                break;
            case 6:
                f = (f3 + f2 + this.mTextFontMetricForVerticalAlign.get(2).floatValue()) * 0.5f;
                break;
            case 7:
            case 8:
                f = f3 - this.mTextFontMetricForVerticalAlign.get(1).floatValue();
                break;
            case 9:
                break;
            case 10:
                f = (f * this.mTextFontMetricForVerticalAlign.get(3).floatValue()) / 100.0f;
                break;
            case 11:
                f = (((-this.mTextFontMetricForVerticalAlign.get(0).floatValue()) - this.mTextFontMetricForVerticalAlign.get(1).floatValue()) + f2 + f3) * 0.5f;
                break;
            default:
                f = 0.0f;
                break;
        }
        return (-f) + f2;
    }

    public float getMaxFontDescent() {
        return this.mTextFontMetricForVerticalAlign.get(1).floatValue();
    }

    public float getMaxFontAscent() {
        return this.mTextFontMetricForVerticalAlign.get(0).floatValue();
    }
}
