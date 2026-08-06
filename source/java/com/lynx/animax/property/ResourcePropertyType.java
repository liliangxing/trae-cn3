package com.lynx.animax.property;

/* loaded from: classes6.dex */
public enum ResourcePropertyType {
    IMAGE_DIR_NAME(1),
    IMAGE_FILE_NAME(2),
    IMAGE_WIDTH(3),
    IMAGE_HEIGHT(4),
    FONT_FAMILY(101),
    FONT_STYLE(102),
    FONT_ASCENT(103),
    FONT_PATH(104),
    VIDEO_DIR_NAME(201),
    VIDEO_FILE_NAME(202),
    VIDEO_WIDTH(203),
    VIDEO_HEIGHT(204);

    private final int mValue;

    ResourcePropertyType(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
