package com.lynx.tasm.group;

/* loaded from: classes7.dex */
public class BitmapSize {
    private final int height;
    private final String source;
    private final int width;

    public BitmapSize(String str, int i, int i2) {
        this.source = str;
        this.width = i;
        this.height = i2;
    }

    public String getSource() {
        return this.source;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        return this.source + ": " + this.width + " - " + this.height;
    }
}
