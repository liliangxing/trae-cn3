package com.ss.bytertc.base.media;

/* loaded from: classes7.dex */
public class Size {
    public int height;
    public int width;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Size)) {
            return false;
        }
        Size size = (Size) other;
        return this.width == size.width && this.height == size.height;
    }

    public int hashCode() {
        return (this.width * 65537) + 1 + this.height;
    }
}
