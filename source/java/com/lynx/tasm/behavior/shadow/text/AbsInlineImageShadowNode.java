package com.lynx.tasm.behavior.shadow.text;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;
import com.lynx.tasm.behavior.p000ui.utils.LynxBackground;
import com.lynx.tasm.behavior.shadow.ShadowStyle;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsInlineImageShadowNode extends BaseTextShadowNode {
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_LOAD = "load";
    public static final String TAG_NAME = "inline-image";
    protected int mBackgroundColor = 0;
    private boolean mBindError;
    private boolean mBindLoad;
    private LynxBackground mComplexBackground;

    public abstract AbsInlineImageSpan generateInlineImageSpan();

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public boolean isVirtual() {
        return true;
    }

    @LynxProp(name = PropsConstants.MODE)
    public abstract void setMode(String str);

    @LynxProp(name = PropsConstants.SRC)
    public abstract void setSource(String str);

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        if (map != null) {
            this.mBindLoad = map.containsKey("load");
            this.mBindError = map.containsKey("error");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyLoadSuccessIfNeeded(int i, int i2) {
        if (this.mBindLoad) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSignature(), "load");
            lynxDetailEvent.addDetail("height", Integer.valueOf(i2));
            lynxDetailEvent.addDetail("width", Integer.valueOf(i));
            getContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyErrorIfNeeded(String str) {
        if (this.mBindError) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSignature(), "error");
            lynxDetailEvent.addDetail("errMsg", str);
            getContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
        }
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.BACKGROUND_COLOR)
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @LynxProp(name = PropsConstants.VERTICAL_ALIGN)
    public void setVerticalAlign(ReadableArray readableArray) {
        setVerticalAlignOnShadowNode(readableArray);
    }

    private LynxBackground getOrCreateComplexBackground() {
        if (this.mComplexBackground == null) {
            this.mComplexBackground = new LynxBackground(getContext());
        }
        return this.mComplexBackground;
    }

    @LynxPropGroup(names = {PropsConstants.BORDER_RADIUS, PropsConstants.BORDER_TOP_LEFT_RADIUS, PropsConstants.BORDER_TOP_RIGHT_RADIUS, PropsConstants.BORDER_BOTTOM_RIGHT_RADIUS, PropsConstants.BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(int i, ReadableArray readableArray) {
        getOrCreateComplexBackground().setBorderRadius(i, readableArray);
    }

    @LynxPropGroup(defaultInt = -1, names = {PropsConstants.BORDER_STYLE, PropsConstants.BORDER_LEFT_STYLE, PropsConstants.BORDER_RIGHT_STYLE, PropsConstants.BORDER_TOP_STYLE, PropsConstants.BORDER_BOTTOM_STYLE})
    public void setBorderStyle(int i, int i2) {
        getOrCreateComplexBackground().setBorderStyle(LynxBaseUI.SPACING_TYPES[i], i2);
    }

    @LynxPropGroup(names = {PropsConstants.BORDER_WIDTH, PropsConstants.BORDER_LEFT_WIDTH, PropsConstants.BORDER_RIGHT_WIDTH, PropsConstants.BORDER_TOP_WIDTH, PropsConstants.BORDER_BOTTOM_WIDTH})
    public void setBorderWidth(int i, int i2) {
        getOrCreateComplexBackground().setBorderWidth(LynxBaseUI.SPACING_TYPES[i], i2);
    }

    @LynxPropGroup(customType = "Color", names = {PropsConstants.BORDER_LEFT_COLOR, PropsConstants.BORDER_RIGHT_COLOR, PropsConstants.BORDER_TOP_COLOR, PropsConstants.BORDER_BOTTOM_COLOR})
    public void setBorderColor(int i, Integer num) {
        getOrCreateComplexBackground().setBorderColorForSpacingIndex(LynxBaseUI.SPACING_TYPES[i + 1], num);
    }

    protected void setSpanVerticalAlign(AbsInlineImageSpan absInlineImageSpan) {
        ShadowStyle shadowStyle = getShadowStyle();
        if (shadowStyle != null) {
            absInlineImageSpan.setVerticalAlign(shadowStyle.verticalAlign, shadowStyle.verticalAlignLength);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void generateStyleSpan(int i, int i2, List<BaseTextShadowNode.SetSpanOperation> list) {
        AbsInlineImageSpan generateInlineImageSpan = generateInlineImageSpan();
        setSpanVerticalAlign(generateInlineImageSpan);
        LynxBackground lynxBackground = this.mComplexBackground;
        if (lynxBackground != null && lynxBackground.getDrawable() != null) {
            this.mComplexBackground.getDrawable().setBounds(0, 0, (int) Math.ceil(getStyle().getWidth()), (int) Math.ceil((int) getStyle().getHeight()));
            this.mComplexBackground.setBackgroundColor(this.mBackgroundColor);
            generateInlineImageSpan.setComplexBackground(this.mComplexBackground);
        } else {
            generateInlineImageSpan.setBackgroundColor(this.mBackgroundColor);
        }
        generateInlineImageSpan.setVerticalShift(getTextAttributes().mBaselineShift);
        list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, generateInlineImageSpan));
        if (needGenerateEventTargetSpan()) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, toEventTargetSpan()));
        }
    }
}
