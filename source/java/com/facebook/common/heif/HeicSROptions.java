package com.facebook.common.heif;

import com.facebook.common.util.HashCodeUtil;

/* loaded from: classes6.dex */
public class HeicSROptions {
    int chooseAlg;
    public boolean isAdaptiveSr;
    int optimizeLevel;
    public int scaleType;
    public int targetHeight;
    public int targetWidth;
    boolean useOpenGL;

    public HeicSROptions(int i) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), false, i, -1, -1);
    }

    public HeicSROptions(int i, int i2) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), true, 32768, i, i2);
    }

    public HeicSROptions(boolean z, int i) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), z, i, -1, -1);
    }

    public HeicSROptions(boolean z, int i, int i2, int i3) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), z, i, i2, i3);
    }

    public HeicSROptions(boolean z, int i, boolean z2, int i2, int i3, int i4) {
        this.useOpenGL = z;
        this.optimizeLevel = i;
        this.isAdaptiveSr = z2;
        this.scaleType = i2;
        this.targetWidth = i3;
        this.targetHeight = i4;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.targetWidth, this.targetHeight, this.scaleType);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeicSROptions)) {
            return false;
        }
        HeicSROptions heicSROptions = (HeicSROptions) obj;
        return this.targetWidth == heicSROptions.targetWidth && this.targetHeight == heicSROptions.targetHeight && this.scaleType == heicSROptions.scaleType;
    }

    public String toString() {
        return String.format(null, "%b,%d,%dx%d", Boolean.valueOf(this.isAdaptiveSr), Integer.valueOf(this.scaleType), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight));
    }
}
