package com.lynx.tasm.behavior.shadow.text;

import com.lynx.react.bridge.Dynamic;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RawTextShadowNode extends ShadowNode {
    private String mText = null;
    private boolean mIsPseudo = false;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public boolean isVirtual() {
        return true;
    }

    @LynxProp(name = PropsConstants.TEXT)
    public void setText(Dynamic dynamic) {
        this.mText = TextHelper.convertRawTextValue(dynamic);
        markDirty();
    }

    @LynxProp(name = "pseudo")
    public void setPsuedo(boolean z) {
        this.mIsPseudo = z;
    }

    public String getText() {
        return this.mText;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public String toString() {
        return getTagName() + " [text: " + this.mText + "]";
    }

    public boolean isPseudo() {
        return this.mIsPseudo;
    }
}
