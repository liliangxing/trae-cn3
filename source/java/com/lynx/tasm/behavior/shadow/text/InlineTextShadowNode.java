package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.utils.LynxBackground;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.DeviceUtils;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class InlineTextShadowNode extends BaseTextShadowNode {
    private static final String TAG = "InlineTextShadowNode";
    private LynxBackground mBackground;
    private int mBackgroundColor = 0;
    private boolean mIsSetBackGroundImage = false;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public boolean isVirtual() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public void setContext(LynxContext lynxContext) {
        super.setContext(lynxContext);
        this.mBackground = new LynxBackground(lynxContext);
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.BACKGROUND_COLOR)
    public void setBackgroundColor(int i) {
        if (this.mBackgroundColor != i) {
            this.mBackgroundColor = i;
            markDirty();
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @LynxProp(name = PropsConstants.VERTICAL_ALIGN)
    public void setVerticalAlign(ReadableArray readableArray) {
        setVerticalAlignOnShadowNode(readableArray);
    }

    @LynxProp(name = PropsConstants.BACKGROUND_IMAGE)
    public void setBackgroundImage(ReadableArray readableArray) {
        markDirty();
        if (readableArray == null) {
            this.mIsSetBackGroundImage = false;
        } else {
            this.mBackground.setLayerImage(readableArray, null);
            this.mIsSetBackGroundImage = true;
        }
    }

    @LynxProp(name = PropsConstants.BACKGROUND_SIZE)
    public void setBackgroundSize(ReadableArray readableArray) {
        this.mBackground.setLayerSize(readableArray);
        markDirty();
    }

    @LynxProp(name = PropsConstants.BACKGROUND_REPEAT)
    public void setBackgroundRepeat(ReadableArray readableArray) {
        this.mBackground.setLayerRepeat(readableArray);
        markDirty();
    }

    @LynxProp(name = PropsConstants.BACKGROUND_POSITION)
    public void setBackgroundPosition(ReadableArray readableArray) {
        this.mBackground.setLayerPosition(readableArray);
        markDirty();
    }

    @LynxPropGroup(names = {PropsConstants.BORDER_RADIUS, PropsConstants.BORDER_TOP_LEFT_RADIUS, PropsConstants.BORDER_TOP_RIGHT_RADIUS, PropsConstants.BORDER_BOTTOM_RIGHT_RADIUS, PropsConstants.BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(int i, ReadableArray readableArray) {
        this.mBackground.setBorderRadius(i, readableArray);
        markDirty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public void buildStyledSpan(int i, int i2, List<BaseTextShadowNode.SetSpanOperation> list) {
        super.buildStyledSpan(i, i2, list);
        if (needGenerateEventTargetSpan()) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, toEventTargetSpan()));
        }
        if (this.mBackgroundColor != 0) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new BackgroundColorSpan(this.mBackgroundColor)));
        }
        if (this.mIsSetBackGroundImage) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new LynxTextBackgroundSpan(i, i2, this.mBackground)));
        }
        if (!MeasureUtils.isUndefined(getTextAttributes().mFontSize)) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new AbsoluteSizeSpan(Math.round(getTextAttributes().mFontSize))));
        }
        if (TextUtils.isEmpty(getTextAttributes().mFontFamily)) {
            return;
        }
        String str = getTextAttributes().mFontFamily;
        int typefaceStyle = getTypefaceStyle();
        Typeface typeface = TypefaceCache.getTypeface(getContext(), str, typefaceStyle);
        if (typeface == null) {
            FontFaceManager.getInstance().getTypeface(getContext(), str, typefaceStyle, new TextShadowNode.WeakTypefaceListener(this));
            typeface = DeviceUtils.getDefaultTypeface();
        } else {
            getTextAttributes().setHasValidTypeface(true);
        }
        list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new FontFamilySpan(typeface)));
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public void setTextAlign(int i) {
        super.setTextAlign(i);
        if (isTextRefactorEnabled()) {
            LLog.e(TAG, "inline-text will no longer support text-align in future, set on root text instead");
        }
    }
}
