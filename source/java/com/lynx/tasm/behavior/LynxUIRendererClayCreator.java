package com.lynx.tasm.behavior;

import com.lynx.tasm.ClayDelegate;
import com.lynx.tasm.IUIRendererCreator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIRendererClayCreator implements IUIRendererCreator {
    private final LynxUIRendererClayConfig config = new LynxUIRendererClayConfig();

    public LynxUIRendererClayCreator setLowEndImageTextureCacheMaxLimit(int i) {
        this.config.setLowEndImageTextureCacheMaxLimit(i);
        return this;
    }

    public LynxUIRendererClayCreator setImageTextureCacheMaxLimit(int i) {
        this.config.setImageTextureCacheMaxLimit(i);
        return this;
    }

    public LynxUIRendererClayCreator setUseTextureViewInRenderkitMode(boolean z) {
        this.config.setEnableTextureViewWithRenderkitMode(z);
        return this;
    }

    public LynxUIRendererClayCreator setEnableGLFunctorInRenderkitMode(boolean z) {
        this.config.setEnableGLFunctorWithRenderkitMode(z);
        return this;
    }

    /* renamed from: com.lynx.tasm.behavior.LynxUIRendererClayCreator$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C00401 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$tasm$ClayDelegate$RenderMode;

        static {
            int[] iArr = new int[ClayDelegate.RenderMode.values().length];
            $SwitchMap$com$lynx$tasm$ClayDelegate$RenderMode = iArr;
            try {
                iArr[ClayDelegate.RenderMode.TEXTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$tasm$ClayDelegate$RenderMode[ClayDelegate.RenderMode.SYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$tasm$ClayDelegate$RenderMode[ClayDelegate.RenderMode.SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LynxUIRendererClayCreator setClayRenderMode(ClayDelegate.RenderMode renderMode) {
        int i = C00401.$SwitchMap$com$lynx$tasm$ClayDelegate$RenderMode[renderMode.ordinal()];
        if (i == 1) {
            setUseTextureViewInRenderkitMode(true).setEnableGLFunctorInRenderkitMode(false);
        } else if (i == 2) {
            setUseTextureViewInRenderkitMode(false).setEnableGLFunctorInRenderkitMode(true);
        } else {
            setUseTextureViewInRenderkitMode(false).setEnableGLFunctorInRenderkitMode(false);
        }
        return this;
    }

    public LynxUIRendererClayCreator setEnableDelegateInRenderkitMode(boolean z) {
        this.config.setEnableDelegateWithRenderkitMode(z);
        return this;
    }

    public LynxUIRendererClayCreator setEnableClayRecycleEngine(boolean z) {
        this.config.setEnableClayRecycleEngine(z);
        return this;
    }

    public LynxUIRendererClayCreator setEnableClayCompatMode(boolean z) {
        this.config.setEnableClayCompatMode(z);
        return this;
    }

    public ILynxUIRenderer createLynxUIRender() {
        LynxUIRendererClay.tryInitClaySo();
        if (LynxUIRendererClay.isClayInited()) {
            return new LynxUIRendererClay(this.config);
        }
        return new LynxUIRenderer();
    }
}
