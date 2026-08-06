package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class ResizeOptions {
    public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667f;
    public final int height;
    public final float maxBitmapSize;
    public final float roundUpFraction;
    public final int width;

    @Nullable
    public static ResizeOptions forDimensions(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        return new ResizeOptions(i, i2);
    }

    @Nullable
    public static ResizeOptions forSquareSize(int i) {
        if (i <= 0) {
            return null;
        }
        return new ResizeOptions(i, i);
    }

    public ResizeOptions(int i, int i2) {
        this(i, i2, BitmapUtil.MAX_BITMAP_SIZE);
    }

    public ResizeOptions(int i, int i2, float f) {
        this(i, i2, f, 0.6666667f);
    }

    public ResizeOptions(int i, int i2, float f, float f2) {
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        this.width = i;
        this.height = i2;
        this.maxBitmapSize = f;
        this.roundUpFraction = f2;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.width, this.height);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizeOptions)) {
            return false;
        }
        ResizeOptions resizeOptions = (ResizeOptions) obj;
        return this.width == resizeOptions.width && this.height == resizeOptions.height;
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.width), Integer.valueOf(this.height));
    }
}
