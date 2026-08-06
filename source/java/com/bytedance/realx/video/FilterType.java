package com.bytedance.realx.video;

/* loaded from: classes4.dex */
public enum FilterType {
    Origin(9),
    Bilinear(10),
    Bicubic(11),
    BOX(12);

    private final int value;

    FilterType(int value) {
        this.value = value;
    }

    public int toInt() {
        return this.value;
    }

    public static FilterType fromValue(int value) {
        switch (value) {
            case 10:
                return Bilinear;
            case 11:
                return Bicubic;
            case 12:
                return BOX;
            default:
                return Origin;
        }
    }
}
