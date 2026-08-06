package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalRectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public InternalRectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public static InternalRectangle create(int x, int y, int w, int h) {
        return new InternalRectangle(x, y, w, h);
    }
}
