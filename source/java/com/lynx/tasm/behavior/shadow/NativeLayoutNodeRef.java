package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.EventTargetSpan;
import com.lynx.tasm.behavior.shadow.text.NativeLayoutNodeSpan;
import com.lynx.tasm.event.EventsListener;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeLayoutNodeRef extends ShadowNode {
    private String mIdSelector;
    private int mSpanEnd;
    private int mSpanOriginEnd;
    private int mSpanOriginStart;
    private int mSpanStart;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public boolean needGenerateEventTargetSpan() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public boolean supportInlineView() {
        return true;
    }

    public void updateNativeNodeIndex(int i) {
        this.mSpanStart += i;
        this.mSpanEnd += i;
    }

    public void resetNativeNodeIndex() {
        this.mSpanStart = this.mSpanOriginStart;
        this.mSpanEnd = this.mSpanOriginEnd;
    }

    public int getSpanStart() {
        return this.mSpanStart;
    }

    public int getSpanEnd() {
        return this.mSpanEnd;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @LynxProp(name = PropsConstants.VERTICAL_ALIGN)
    public void setVerticalAlign(ReadableArray readableArray) {
        setVerticalAlignOnShadowNode(readableArray);
    }

    @LynxProp(name = PropsConstants.ID_SELECTOR)
    public void setIdSelector(String str) {
        this.mIdSelector = str;
    }

    public String getIdSelector() {
        return this.mIdSelector;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void setContext(LynxContext lynxContext) {
        super.setContext(lynxContext);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class InlineViewEventSpan extends EventTargetSpan {
        public InlineViewEventSpan(int i, Map<String, EventsListener> map, EventTarget.EnableStatus enableStatus, boolean z, EventTarget.EnableStatus enableStatus2, EventTarget.PointerEventsValue pointerEventsValue, ReadableMap readableMap) {
            super(i, map, enableStatus, z, enableStatus2, pointerEventsValue, readableMap);
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public EventTargetSpan toEventTargetSpan() {
        return new InlineViewEventSpan(getSignature(), this.mEvents, this.mIgnoreFocus, this.mEnableTouchPseudoPropagation, this.mEventThrough, this.mPointerEvents, this.mDataset);
    }

    public NativeLayoutNodeSpan generateStyleSpan(int i, int i2, List<BaseTextShadowNode.SetSpanOperation> list) {
        this.mSpanOriginStart = i;
        this.mSpanStart = i;
        this.mSpanOriginEnd = i2;
        this.mSpanEnd = i2;
        NativeLayoutNodeSpan nativeLayoutNodeSpan = new NativeLayoutNodeSpan();
        if (getShadowStyle() != null) {
            nativeLayoutNodeSpan.setVerticalAlign(getShadowStyle().verticalAlign, getShadowStyle().verticalAlignLength);
        }
        list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, nativeLayoutNodeSpan));
        if (needGenerateEventTargetSpan()) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, toEventTargetSpan()));
        }
        return nativeLayoutNodeSpan;
    }

    public MeasureResult measureNativeNode(MeasureContext measureContext, MeasureParam measureParam) {
        if (isDestroyed()) {
            reportNullError("measureNativeNode for null, tag: " + getTagName());
            return new MeasureResult(0.0f, 0.0f);
        }
        if (getShadowStyle() != null && getShadowStyle().verticalAlign == 1) {
            int[] measureNativeNodeReturnWithBaseline = this.layoutNodeManager.measureNativeNodeReturnWithBaseline(getSignature(), measureParam.mWidth, measureParam.mWidthMode.intValue(), measureParam.mHeight, measureParam.mHeightMode.intValue(), measureContext.mFinalMeasure);
            return new MeasureResult(measureNativeNodeReturnWithBaseline[0], measureNativeNodeReturnWithBaseline[1], measureNativeNodeReturnWithBaseline[2]);
        }
        long measureNativeNode = this.layoutNodeManager.measureNativeNode(getSignature(), measureParam.mWidth, measureParam.mWidthMode.intValue(), measureParam.mHeight, measureParam.mHeightMode.intValue(), measureContext.mFinalMeasure);
        return new MeasureResult(MeasureOutput.getWidth(measureNativeNode), MeasureOutput.getHeight(measureNativeNode));
    }

    public MeasureResult measureNativeNodeWithBaseline(MeasureContext measureContext, MeasureParam measureParam) {
        if (isDestroyed()) {
            reportNullError("measureNativeNode for null, tag: " + getTagName());
            return new MeasureResult(0.0f, 0.0f);
        }
        int[] measureNativeNodeReturnWithBaseline = this.layoutNodeManager.measureNativeNodeReturnWithBaseline(getSignature(), measureParam.mWidth, measureParam.mWidthMode.intValue(), measureParam.mHeight, measureParam.mHeightMode.intValue(), measureContext.mFinalMeasure);
        return new MeasureResult(measureNativeNodeReturnWithBaseline[0], measureNativeNodeReturnWithBaseline[1], measureNativeNodeReturnWithBaseline[2]);
    }

    public void alignNativeNode(AlignContext alignContext, AlignParam alignParam) {
        if (isDestroyed()) {
            reportNullError("alignNativeNode for null, tag: " + getTagName());
        } else {
            this.layoutNodeManager.alignNativeNode(getSignature(), alignParam.getTopOffset(), alignParam.getLeftOffset());
        }
    }
}
