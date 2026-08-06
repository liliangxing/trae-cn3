package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.LynxProp;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomLayoutShadowNode extends ShadowNode {
    public boolean mCustomLayout = false;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public boolean supportInlineView() {
        return true;
    }

    @LynxProp(name = "custom-layout")
    public void setCustomLayout(boolean z) {
        this.mCustomLayout = z;
    }

    public MeasureResult measureNativeNode(MeasureContext measureContext, MeasureParam measureParam) {
        long measureNativeNode = this.layoutNodeManager.measureNativeNode(getSignature(), measureParam.mWidth, measureParam.mWidthMode.intValue(), measureParam.mHeight, measureParam.mHeightMode.intValue(), measureContext.mFinalMeasure);
        return new MeasureResult(MeasureOutput.getWidth(measureNativeNode), MeasureOutput.getHeight(measureNativeNode));
    }

    public void alignNativeNode(AlignContext alignContext, AlignParam alignParam) {
        this.layoutNodeManager.alignNativeNode(getSignature(), alignParam.getTopOffset(), alignParam.getLeftOffset());
    }
}
