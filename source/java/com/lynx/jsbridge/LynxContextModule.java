package com.lynx.jsbridge;

import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxContextModule extends LynxModule {
    protected LynxContext mLynxContext;

    public LynxContextModule(LynxContext lynxContext) {
        super(lynxContext);
        this.mLynxContext = lynxContext;
    }

    public LynxContextModule(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mLynxContext = lynxContext;
    }

    @Override // com.lynx.jsbridge.LynxModule
    public void destroy() {
        super.destroy();
    }
}
