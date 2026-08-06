package com.lynx.tasm.behavior.p000ui.utils;

import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxMask extends LynxDrawableManager<MaskDrawable> {
    public LynxMask(LynxContext lynxContext) {
        super(lynxContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.utils.LynxDrawableManager
    public MaskDrawable createLayerDrawable() {
        return new MaskDrawable(this.mContext, this.mFontSize);
    }
}
