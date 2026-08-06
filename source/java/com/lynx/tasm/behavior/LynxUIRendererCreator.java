package com.lynx.tasm.behavior;

import com.lynx.tasm.IUIRendererCreator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIRendererCreator implements IUIRendererCreator {
    public ILynxUIRenderer createLynxUIRender() {
        return new LynxUIRenderer();
    }
}
