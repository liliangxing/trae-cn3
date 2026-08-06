package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: Rectangle.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/encoder/Rectangle;", "", "x", "", "y", "size", "(III)V", "getSize", "()I", "getX", "getY", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class Rectangle {
    private final int size;
    private final int x;
    private final int y;

    public static /* synthetic */ Rectangle copy$default(Rectangle rectangle, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rectangle.x;
        }
        if ((i4 & 2) != 0) {
            i2 = rectangle.y;
        }
        if ((i4 & 4) != 0) {
            i3 = rectangle.size;
        }
        return rectangle.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final Rectangle copy(int x, int y, int size) {
        return new Rectangle(x, y, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) other;
        return this.x == rectangle.x && this.y == rectangle.y && this.size == rectangle.size;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.x) * 31) + Integer.hashCode(this.y)) * 31) + Integer.hashCode(this.size);
    }

    public String toString() {
        return "Rectangle(x=" + this.x + ", y=" + this.y + ", size=" + this.size + ')';
    }

    public Rectangle(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.size = i3;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }
}
