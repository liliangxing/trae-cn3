package com.ss.bytertc.engine.video;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public String toString() {
        return "Rectangle{x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + AbstractJsonLexerKt.END_OBJ;
    }
}
