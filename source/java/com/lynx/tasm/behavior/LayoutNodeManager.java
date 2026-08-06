package com.lynx.tasm.behavior;

/* loaded from: classes7.dex */
public class LayoutNodeManager {
    public static float UNDEFINED_MAX_SIZE = 1.34217728E8f;
    public static float UNDEFINED_MIN_SIZE;
    protected long mNativePtr = 0;

    private native void nativeAlignNativeNode(long j, int i, float f, float f2);

    private native int nativeGetFlexDirection(long j, int i);

    private native float nativeGetHeight(long j, int i);

    private native int[] nativeGetMargin(long j, int i);

    private native float nativeGetMaxHeight(long j, int i);

    private native float nativeGetMaxWidth(long j, int i);

    private native float nativeGetMinHeight(long j, int i);

    private native float nativeGetMinWidth(long j, int i);

    private native int[] nativeGetPadding(long j, int i);

    private native float nativeGetWidth(long j, int i);

    private native boolean nativeIsDirty(long j, int i);

    private native void nativeMarkDirty(long j, int i);

    private native long nativeMeasureNativeNode(long j, int i, float f, int i2, float f2, int i3, boolean z);

    private native int[] nativeMeasureNativeNodeReturnWithBaseline(long j, int i, float f, int i2, float f2, int i3, boolean z);

    private native void nativeSetMeasureFunc(long j, int i, Object obj);

    private native void nativeSetNeedsLayoutForce(long j, int i);

    public void attachNativePtr(long j) {
        this.mNativePtr = j;
    }

    public void setMeasureFunc(int i, Object obj) {
        nativeSetMeasureFunc(this.mNativePtr, i, obj);
    }

    public void markDirty(int i) {
        nativeMarkDirty(this.mNativePtr, i);
    }

    public void setNeedsLayoutForce(int i) {
        nativeSetNeedsLayoutForce(this.mNativePtr, i);
    }

    public boolean isDirty(int i) {
        return nativeIsDirty(this.mNativePtr, i);
    }

    public long measureNativeNode(int i, float f, int i2, float f2, int i3, boolean z) {
        return nativeMeasureNativeNode(this.mNativePtr, i, f, i2, f2, i3, z);
    }

    public int[] measureNativeNodeReturnWithBaseline(int i, float f, int i2, float f2, int i3, boolean z) {
        return nativeMeasureNativeNodeReturnWithBaseline(this.mNativePtr, i, f, i2, f2, i3, z);
    }

    public void alignNativeNode(int i, float f, float f2) {
        nativeAlignNativeNode(this.mNativePtr, i, f, f2);
    }

    public int getFlexDirection(int i) {
        return nativeGetFlexDirection(this.mNativePtr, i);
    }

    public float getWidth(int i) {
        return nativeGetWidth(this.mNativePtr, i);
    }

    public float getHeight(int i) {
        return nativeGetHeight(this.mNativePtr, i);
    }

    public float getMinWidth(int i) {
        return nativeGetMinWidth(this.mNativePtr, i);
    }

    public float getMaxWidth(int i) {
        return nativeGetMaxWidth(this.mNativePtr, i);
    }

    public float getMinHeight(int i) {
        return nativeGetMinHeight(this.mNativePtr, i);
    }

    public float getMaxHeight(int i) {
        return nativeGetMinHeight(this.mNativePtr, i);
    }

    public int[] getPadding(int i) {
        return nativeGetPadding(this.mNativePtr, i);
    }

    public int[] getMargin(int i) {
        return nativeGetMargin(this.mNativePtr, i);
    }
}
