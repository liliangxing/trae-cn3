package com.lynx.tasm.behavior.p000ui.swiper;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.shadow.AlignContext;
import com.lynx.tasm.behavior.shadow.AlignParam;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.CustomMeasureFunc;
import com.lynx.tasm.behavior.shadow.MeasureContext;
import com.lynx.tasm.behavior.shadow.MeasureParam;
import com.lynx.tasm.behavior.shadow.MeasureResult;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.utils.UnitUtils;

@LynxShadowNode(tagName = "swiper")
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.swiper")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SwiperShadowNode extends CustomLayoutShadowNode implements CustomMeasureFunc {
    private static final String MODE_CAROUSEL = "carousel";
    private static final String MODE_CARRY = "carry";
    private static final String MODE_COVER_FLOW = "coverflow";
    private static final String MODE_DEFAULT = "normal";
    private static final String MODE_FLAT_COVER_FLOW = "flat-coverflow";
    private int mPreviousMargin = -1;
    private int mNextMargin = -1;
    private int mPageMargin = -1;
    private float mXScale = 1.0f;
    private float mYScale = 1.0f;
    private boolean mIsVertical = false;
    private String mMode = "normal";

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public void attachNativePtr(long j) {
        if (this.mCustomLayout) {
            setCustomMeasureFunc(this);
        }
        super.attachNativePtr(j);
    }

    @LynxProp(name = PropsConstants.MODE)
    public void setMode(String str) {
        this.mMode = str;
        if (this.mCustomLayout) {
            markDirty();
        }
    }

    @LynxProp(name = "previous-margin")
    public void setPreviousMargin(Dynamic dynamic) {
        if (dynamic.getType() != ReadableType.String) {
            return;
        }
        String asString = dynamic.asString();
        if (asString.endsWith("px") || asString.endsWith("rpx")) {
            int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(asString, 0.0f, -1.0f, this.mContext.getScreenMetrics());
            if (pxWithDisplayMetrics < 0) {
                pxWithDisplayMetrics = -1;
            }
            this.mPreviousMargin = pxWithDisplayMetrics;
        }
        if (this.mCustomLayout) {
            markDirty();
        }
    }

    @LynxProp(name = "next-margin")
    public void setNextMargin(Dynamic dynamic) {
        if (dynamic.getType() != ReadableType.String) {
            return;
        }
        String asString = dynamic.asString();
        if (asString.endsWith("px") || asString.endsWith("rpx")) {
            int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(asString, 0.0f, -1.0f, this.mContext.getScreenMetrics());
            if (pxWithDisplayMetrics < 0) {
                pxWithDisplayMetrics = -1;
            }
            this.mNextMargin = pxWithDisplayMetrics;
        }
        if (this.mCustomLayout) {
            markDirty();
        }
    }

    @LynxProp(name = "page-margin")
    public void setPageMargin(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.endsWith("px") || asString.endsWith("rpx")) {
                int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(asString, 0.0f, 0.0f, this.mContext.getScreenMetrics());
                if (pxWithDisplayMetrics <= 0) {
                    pxWithDisplayMetrics = 0;
                }
                this.mPageMargin = pxWithDisplayMetrics;
            }
            if (this.mCustomLayout) {
                markDirty();
            }
        }
    }

    @LynxProp(name = "max-x-scale")
    public void setMaxXScale(double d) {
        if (d >= 0.0d) {
            this.mXScale = (float) d;
        }
        if (this.mCustomLayout) {
            markDirty();
        }
    }

    @LynxProp(name = "max-y-scale")
    public void setMaxYScale(double d) {
        if (d >= 0.0d) {
            this.mYScale = (float) d;
        }
        if (this.mCustomLayout) {
            markDirty();
        }
    }

    @LynxProp(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean z) {
        this.mIsVertical = z;
        if (this.mCustomLayout) {
            markDirty();
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.CustomMeasureFunc
    public MeasureResult measure(MeasureParam measureParam, MeasureContext measureContext) {
        float f;
        float f2;
        MeasureParam measureParam2 = null;
        for (int i = 0; i < getChildCount(); i++) {
            ShadowNode childAt = getChildAt(i);
            if (childAt instanceof NativeLayoutNodeRef) {
                NativeLayoutNodeRef nativeLayoutNodeRef = (NativeLayoutNodeRef) childAt;
                if (measureParam2 != null) {
                    nativeLayoutNodeRef.measureNativeNode(measureContext, measureParam2);
                } else {
                    measureParam2 = new MeasureParam();
                    if (this.mMode.equals(MODE_COVER_FLOW) || this.mMode.equals(MODE_FLAT_COVER_FLOW)) {
                        float f3 = this.mPreviousMargin + this.mNextMargin + (this.mPageMargin * 2);
                        measureParam2.updateConstraints(measureParam.mWidth - (this.mIsVertical ? 0.0f : f3), measureParam.mWidthMode, measureParam.mHeight - (this.mIsVertical ? f3 : 0.0f), measureParam.mHeightMode);
                    } else if (this.mMode.equals(MODE_CAROUSEL)) {
                        if (this.mIsVertical) {
                            f = (float) (measureParam.mHeight * 0.8d);
                            f2 = measureParam.mWidth;
                        } else {
                            f = measureParam.mHeight;
                            f2 = (float) (measureParam.mWidth * 0.8d);
                        }
                        measureParam2.updateConstraints(f2, measureParam.mWidthMode, f, measureParam.mHeightMode);
                    } else if (this.mMode.equals(MODE_CARRY)) {
                        float f4 = this.mPreviousMargin + this.mNextMargin + (this.mPageMargin * 2);
                        measureParam2.updateConstraints((measureParam.mWidth - (this.mIsVertical ? 0.0f : f4)) * this.mXScale, measureParam.mWidthMode, (measureParam.mHeight - (this.mIsVertical ? f4 : 0.0f)) * this.mYScale, measureParam.mHeightMode);
                    } else {
                        measureParam2.updateConstraints(measureParam.mWidth, measureParam.mWidthMode, measureParam.mHeight, measureParam.mHeightMode);
                    }
                    nativeLayoutNodeRef.measureNativeNode(measureContext, measureParam2);
                }
            }
        }
        return new MeasureResult(measureParam.mWidth, measureParam.mHeight);
    }

    @Override // com.lynx.tasm.behavior.shadow.CustomMeasureFunc
    public void align(AlignParam alignParam, AlignContext alignContext) {
        for (int i = 0; i < getChildCount(); i++) {
            ShadowNode childAt = getChildAt(i);
            if (childAt instanceof NativeLayoutNodeRef) {
                ((NativeLayoutNodeRef) childAt).alignNativeNode(alignContext, new AlignParam());
            }
        }
    }
}
