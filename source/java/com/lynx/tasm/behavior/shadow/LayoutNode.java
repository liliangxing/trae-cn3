package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.LayoutNodeManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LayoutNode {
    protected LayoutNodeManager layoutNodeManager;
    private MeasureFunc mMeasureFunc;
    private int mSignature;
    private Style mStyle;
    private boolean mHasMeasureFucSet = false;
    private boolean mHasCustomMeasureFuncSet = false;
    private boolean mIsDirty = false;
    private CustomMeasureFunc mCustomMeasureFunc = null;
    public long mBaseline = 0;

    public void onLayoutBefore() {
    }

    public void attachNativePtr(long j) {
        CustomMeasureFunc customMeasureFunc;
        MeasureFunc measureFunc;
        this.mStyle = new Style(this);
        if (!this.mHasMeasureFucSet && (measureFunc = this.mMeasureFunc) != null) {
            setMeasureFunc(measureFunc);
        } else {
            if (this.mHasCustomMeasureFuncSet || (customMeasureFunc = this.mCustomMeasureFunc) == null) {
                return;
            }
            setCustomMeasureFunc(customMeasureFunc);
        }
    }

    public final int getSignature() {
        return this.mSignature;
    }

    public void setSignature(int i) {
        this.mSignature = i;
    }

    public void setLayoutNodeManager(LayoutNodeManager layoutNodeManager) {
        this.layoutNodeManager = layoutNodeManager;
    }

    public void destroy() {
        this.layoutNodeManager = null;
    }

    public void onLayout(int i, int i2, int i3, int i4) {
        this.mIsDirty = false;
    }

    public void setMeasureFunc(MeasureFunc measureFunc) {
        this.mMeasureFunc = measureFunc;
        LayoutNodeManager layoutNodeManager = this.layoutNodeManager;
        if (layoutNodeManager != null) {
            this.mHasMeasureFucSet = true;
            layoutNodeManager.setMeasureFunc(this.mSignature, this);
        }
    }

    public void setCustomMeasureFunc(CustomMeasureFunc customMeasureFunc) {
        this.mCustomMeasureFunc = customMeasureFunc;
        LayoutNodeManager layoutNodeManager = this.layoutNodeManager;
        if (layoutNodeManager != null) {
            this.mHasCustomMeasureFuncSet = true;
            layoutNodeManager.setMeasureFunc(this.mSignature, this);
        }
    }

    public boolean isDirty() {
        boolean z = this.mIsDirty;
        if (z) {
            return z;
        }
        if (this.layoutNodeManager.isDirty(this.mSignature)) {
            this.mIsDirty = true;
        }
        return this.mIsDirty;
    }

    public void markDirty() {
        if (this.mIsDirty) {
            return;
        }
        this.mIsDirty = true;
        this.layoutNodeManager.markDirty(this.mSignature);
    }

    public void setNeedsLayoutForce() {
        this.layoutNodeManager.setNeedsLayoutForce(this.mSignature);
    }

    public void resetIsDirty() {
        this.mIsDirty = false;
    }

    public Style getStyle() {
        return this.mStyle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFlexDirection() {
        return this.layoutNodeManager.getFlexDirection(this.mSignature);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getWidth() {
        return this.layoutNodeManager.getWidth(this.mSignature);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHeight() {
        return this.layoutNodeManager.getHeight(this.mSignature);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getPadding() {
        return this.layoutNodeManager.getPadding(this.mSignature);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getMargins() {
        return this.layoutNodeManager.getMargin(this.mSignature);
    }

    public float[] measure(float f, int i, float f2, int i2, boolean z) {
        float[] fArr = new float[3];
        MeasureFunc measureFunc = this.mMeasureFunc;
        if (measureFunc != null) {
            long measure = measureFunc.measure(this, f, MeasureMode.fromInt(i), f2, MeasureMode.fromInt(i2));
            fArr[0] = MeasureOutput.getWidth(measure);
            fArr[1] = MeasureOutput.getHeight(measure);
            fArr[2] = (float) this.mBaseline;
        } else if (this.mCustomMeasureFunc != null) {
            MeasureContext measureContext = new MeasureContext(z);
            MeasureParam measureParam = new MeasureParam();
            measureParam.updateConstraints(f, MeasureMode.fromInt(i), f2, MeasureMode.fromInt(i2));
            MeasureResult measure2 = this.mCustomMeasureFunc.measure(measureParam, measureContext);
            fArr[0] = measure2.getWidthResult();
            fArr[1] = measure2.getHeightResult();
            fArr[2] = measure2.getBaselineResult();
        }
        return fArr;
    }

    public void align() {
        if (this.mCustomMeasureFunc != null) {
            this.mCustomMeasureFunc.align(new AlignParam(), new AlignContext());
        }
    }
}
