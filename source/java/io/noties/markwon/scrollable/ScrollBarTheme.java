package io.noties.markwon.scrollable;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ScrollBarTheme.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/scrollable/ScrollBarTheme;", "", "scrollBarWidth", "", "scrollBarHeight", "scrollBarPadding", "", "scrollBarColor", "(IIFI)V", "getScrollBarColor", "()I", "getScrollBarHeight", "getScrollBarPadding", "()F", "getScrollBarWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final /* data */ class ScrollBarTheme {
    private final int scrollBarColor;
    private final int scrollBarHeight;
    private final float scrollBarPadding;
    private final int scrollBarWidth;

    public static /* synthetic */ ScrollBarTheme copy$default(ScrollBarTheme scrollBarTheme, int i, int i2, float f, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = scrollBarTheme.scrollBarWidth;
        }
        if ((i4 & 2) != 0) {
            i2 = scrollBarTheme.scrollBarHeight;
        }
        if ((i4 & 4) != 0) {
            f = scrollBarTheme.scrollBarPadding;
        }
        if ((i4 & 8) != 0) {
            i3 = scrollBarTheme.scrollBarColor;
        }
        return scrollBarTheme.copy(i, i2, f, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getScrollBarWidth() {
        return this.scrollBarWidth;
    }

    /* renamed from: component2, reason: from getter */
    public final int getScrollBarHeight() {
        return this.scrollBarHeight;
    }

    /* renamed from: component3, reason: from getter */
    public final float getScrollBarPadding() {
        return this.scrollBarPadding;
    }

    /* renamed from: component4, reason: from getter */
    public final int getScrollBarColor() {
        return this.scrollBarColor;
    }

    public final ScrollBarTheme copy(int scrollBarWidth, int scrollBarHeight, float scrollBarPadding, int scrollBarColor) {
        return new ScrollBarTheme(scrollBarWidth, scrollBarHeight, scrollBarPadding, scrollBarColor);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof ScrollBarTheme) {
                ScrollBarTheme scrollBarTheme = (ScrollBarTheme) other;
                if (this.scrollBarWidth == scrollBarTheme.scrollBarWidth) {
                    if ((this.scrollBarHeight == scrollBarTheme.scrollBarHeight) && Float.compare(this.scrollBarPadding, scrollBarTheme.scrollBarPadding) == 0) {
                        if (this.scrollBarColor == scrollBarTheme.scrollBarColor) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.scrollBarWidth * 31) + this.scrollBarHeight) * 31) + Float.floatToIntBits(this.scrollBarPadding)) * 31) + this.scrollBarColor;
    }

    public String toString() {
        return "ScrollBarTheme(scrollBarWidth=" + this.scrollBarWidth + ", scrollBarHeight=" + this.scrollBarHeight + ", scrollBarPadding=" + this.scrollBarPadding + ", scrollBarColor=" + this.scrollBarColor + ")";
    }

    public ScrollBarTheme(int i, int i2, float f, int i3) {
        this.scrollBarWidth = i;
        this.scrollBarHeight = i2;
        this.scrollBarPadding = f;
        this.scrollBarColor = i3;
    }

    public final int getScrollBarWidth() {
        return this.scrollBarWidth;
    }

    public /* synthetic */ ScrollBarTheme(int i, int i2, float f, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, f, i3);
    }

    public final int getScrollBarHeight() {
        return this.scrollBarHeight;
    }

    public final float getScrollBarPadding() {
        return this.scrollBarPadding;
    }

    public final int getScrollBarColor() {
        return this.scrollBarColor;
    }
}
