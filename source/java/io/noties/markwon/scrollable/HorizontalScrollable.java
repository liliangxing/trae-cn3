package io.noties.markwon.scrollable;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HorizontalScrollable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R$\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollable;", "", "overScale", "", "(F)V", "isScrollable", "", "()Z", "value", "maxScroll", "getMaxScroll", "()F", "setMaxScroll", "over", "getOver", "getOverScale", "scrollX", "getScrollX", "setScrollX$markwon_core_release", "toString", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class HorizontalScrollable {
    private float maxScroll;
    private final float overScale;
    private float scrollX;

    public HorizontalScrollable() {
        this(0.0f, 1, null);
    }

    public HorizontalScrollable(float f) {
        this.overScale = f;
    }

    public /* synthetic */ HorizontalScrollable(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.1f : f);
    }

    public final float getOverScale() {
        return this.overScale;
    }

    public final float getOver() {
        return Math.abs(this.maxScroll) * this.overScale;
    }

    public final float getScrollX() {
        return this.scrollX;
    }

    public final void setScrollX$markwon_core_release(float f) {
        this.scrollX = Math.max((-this.maxScroll) - getOver(), Math.min(getOver(), f));
    }

    public final float getMaxScroll() {
        return this.maxScroll;
    }

    public final void setMaxScroll(float f) {
        this.maxScroll = Math.max(0.0f, f);
    }

    public final boolean isScrollable() {
        return this.maxScroll > 0.0f;
    }

    public String toString() {
        return "HorizontalScrollable(scrollX=" + this.scrollX + ", maxScroll=" + this.maxScroll + ')';
    }
}
