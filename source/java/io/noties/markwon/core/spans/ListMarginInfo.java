package io.noties.markwon.core.spans;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: ListMarginInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/core/spans/ListMarginInfo;", "", "dotDiameter", "", "bulletDotOffset", "listMargin", "(III)V", "getBulletDotOffset", "()I", "getDotDiameter", "getListMargin", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final /* data */ class ListMarginInfo {
    private final int bulletDotOffset;
    private final int dotDiameter;
    private final int listMargin;

    public static /* synthetic */ ListMarginInfo copy$default(ListMarginInfo listMarginInfo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = listMarginInfo.dotDiameter;
        }
        if ((i4 & 2) != 0) {
            i2 = listMarginInfo.bulletDotOffset;
        }
        if ((i4 & 4) != 0) {
            i3 = listMarginInfo.listMargin;
        }
        return listMarginInfo.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDotDiameter() {
        return this.dotDiameter;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBulletDotOffset() {
        return this.bulletDotOffset;
    }

    /* renamed from: component3, reason: from getter */
    public final int getListMargin() {
        return this.listMargin;
    }

    public final ListMarginInfo copy(int dotDiameter, int bulletDotOffset, int listMargin) {
        return new ListMarginInfo(dotDiameter, bulletDotOffset, listMargin);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof ListMarginInfo) {
                ListMarginInfo listMarginInfo = (ListMarginInfo) other;
                if (this.dotDiameter == listMarginInfo.dotDiameter) {
                    if (this.bulletDotOffset == listMarginInfo.bulletDotOffset) {
                        if (this.listMargin == listMarginInfo.listMargin) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.dotDiameter * 31) + this.bulletDotOffset) * 31) + this.listMargin;
    }

    public String toString() {
        return "ListMarginInfo(dotDiameter=" + this.dotDiameter + ", bulletDotOffset=" + this.bulletDotOffset + ", listMargin=" + this.listMargin + ")";
    }

    public ListMarginInfo(int i, int i2, int i3) {
        this.dotDiameter = i;
        this.bulletDotOffset = i2;
        this.listMargin = i3;
    }

    public final int getDotDiameter() {
        return this.dotDiameter;
    }

    public final int getBulletDotOffset() {
        return this.bulletDotOffset;
    }

    public final int getListMargin() {
        return this.listMargin;
    }
}
