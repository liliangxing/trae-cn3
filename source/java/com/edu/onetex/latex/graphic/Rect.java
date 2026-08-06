package com.edu.onetex.latex.graphic;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* compiled from: Rect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/edu/onetex/latex/graphic/Rect;", "", "x", "", "y", "w", RXScreenCaptureService.KEY_HEIGHT, "(FFFF)V", "getH", "()F", "setH", "(F)V", "getW", "setW", "getX", "setX", "getY", "setY", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class Rect {
    private float h;
    private float w;
    private float x;
    private float y;

    public Rect(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.w = f3;
        this.h = f4;
    }

    public final float getH() {
        return this.h;
    }

    public final float getW() {
        return this.w;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final void setH(float f) {
        this.h = f;
    }

    public final void setW(float f) {
        this.w = f;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final void setY(float f) {
        this.y = f;
    }
}
