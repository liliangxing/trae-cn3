package com.lynx.tasm.behavior.render;

import com.lynx.tasm.behavior.IPaintingContext;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.UIBody;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativePaintingContext implements IPaintingContext {
    private long mNativePtr;
    private PlatformRendererContext mPlatformRendererContext;

    private native long nativeCreatePaintingContext(NativePaintingContext nativePaintingContext, long j);

    @Override // com.lynx.tasm.behavior.IPaintingContext
    public void destroy() {
    }

    public NativePaintingContext(UIBody.UIBodyView uIBodyView, LynxContext lynxContext) {
        this.mNativePtr = 0L;
        this.mPlatformRendererContext = null;
        PlatformRendererContext platformRendererContext = new PlatformRendererContext(uIBodyView, lynxContext);
        this.mPlatformRendererContext = platformRendererContext;
        this.mNativePtr = nativeCreatePaintingContext(this, platformRendererContext.getNativePtr());
    }

    @Override // com.lynx.tasm.behavior.IPaintingContext
    public long getNativePaintingContextPtr() {
        return this.mNativePtr;
    }

    public void attachUIBodyView(UIBody.UIBodyView uIBodyView) {
        this.mPlatformRendererContext.setRootView(uIBodyView);
    }
}
