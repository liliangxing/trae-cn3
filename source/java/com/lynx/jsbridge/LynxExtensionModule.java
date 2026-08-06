package com.lynx.jsbridge;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class LynxExtensionModule {
    protected LynxContext mContext;
    protected LynxGroup mGroup;

    public abstract void destroy();

    public abstract long getExtensionDelegatePtr();

    public abstract void setUp();

    public LynxExtensionModule(LynxContext lynxContext, LynxGroup lynxGroup, BehaviorRegistry behaviorRegistry) {
        this.mContext = lynxContext;
        this.mGroup = lynxGroup;
    }
}
