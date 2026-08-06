package com.edu.onetex.latex;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.forest.model.PreloadConfig;
import com.edu.onetex.ScreenUtilKt;
import kotlin.Metadata;

/* compiled from: LatexParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0005J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/edu/onetex/latex/TexSize;", "", "size", "", Scraps.INNER_UNIT, "", "(FI)V", "density", "getDensity", "()F", "setDensity", "(F)V", "getSize", "getUnit", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toPx", "toString", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class TexSize {
    private float density = ScreenUtilKt.getScreenDensity();
    private final float size;
    private final int unit;

    public static /* synthetic */ TexSize copy$default(TexSize texSize, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = texSize.size;
        }
        if ((i2 & 2) != 0) {
            i = texSize.unit;
        }
        return texSize.copy(f, i);
    }

    /* renamed from: component1, reason: from getter */
    public final float getSize() {
        return this.size;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUnit() {
        return this.unit;
    }

    public final TexSize copy(float size, int unit) {
        return new TexSize(size, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TexSize)) {
            return false;
        }
        TexSize texSize = (TexSize) other;
        return Float.compare(this.size, texSize.size) == 0 && this.unit == texSize.unit;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.size) * 31) + this.unit;
    }

    public String toString() {
        return "TexSize(size=" + this.size + ", unit=" + this.unit + ")";
    }

    public TexSize(float f, int i) {
        this.size = f;
        this.unit = i;
    }

    public final float getSize() {
        return this.size;
    }

    public final int getUnit() {
        return this.unit;
    }

    public final float getDensity() {
        return this.density;
    }

    public final void setDensity(float f) {
        this.density = f;
    }

    public final int toPx() {
        float f;
        float f2;
        float f3;
        int i = this.unit;
        if (i != 0) {
            if (i == 1) {
                f2 = this.size;
                f3 = this.density;
            } else if (i == 2) {
                f2 = this.size;
                f3 = this.density;
            } else {
                f = this.size;
            }
            f = (f2 * f3) + 0.5f;
        } else {
            f = this.size;
        }
        return (int) f;
    }
}
