package com.lynx.tasm;

import com.lynx.tasm.ClayDelegate;
import com.lynx.tasm.behavior.LynxUIRendererClayCreator;
import com.lynx.tasm.behavior.LynxUIRendererCreator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxUIRendererBuilder {
    private LynxViewBuilder mLynxViewBuilder;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum LynxUIRenderMode {
        Native,
        Clay
    }

    public LynxUIRendererBuilder(LynxViewBuilder lynxViewBuilder) {
        this.mLynxViewBuilder = lynxViewBuilder;
    }

    /* renamed from: com.lynx.tasm.LynxUIRendererBuilder$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static /* synthetic */ class C14991 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$tasm$LynxUIRendererBuilder$LynxUIRenderMode;

        static {
            int[] iArr = new int[LynxUIRenderMode.values().length];
            $SwitchMap$com$lynx$tasm$LynxUIRendererBuilder$LynxUIRenderMode = iArr;
            try {
                iArr[LynxUIRenderMode.Native.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$tasm$LynxUIRendererBuilder$LynxUIRenderMode[LynxUIRenderMode.Clay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public LynxUIRendererBuilder setLynxUIRenderMode(LynxUIRenderMode lynxUIRenderMode) {
        int i = C14991.$SwitchMap$com$lynx$tasm$LynxUIRendererBuilder$LynxUIRenderMode[lynxUIRenderMode.ordinal()];
        if (i == 1) {
            this.mLynxViewBuilder.setUIRendererCreator(new LynxUIRendererCreator());
        } else if (i == 2) {
            this.mLynxViewBuilder.setUIRendererCreator(new LynxUIRendererClayCreator());
        }
        return this;
    }

    public LynxUIRendererBuilder setUseTextureViewInRenderkitMode(boolean z) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setUseTextureViewInRenderkitMode(z);
        }
        return this;
    }

    public LynxUIRendererBuilder setLowEndImageTextureCacheMaxLimit(int i) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setLowEndImageTextureCacheMaxLimit(i);
        }
        return this;
    }

    public LynxUIRendererBuilder setImageTextureCacheMaxLimit(int i) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setImageTextureCacheMaxLimit(i);
        }
        return this;
    }

    public LynxUIRendererBuilder setClayRenderMode(ClayDelegate.RenderMode renderMode) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setClayRenderMode(renderMode);
        }
        return this;
    }

    public LynxUIRendererBuilder setEnableGLFunctorInRenderkitMode(boolean z) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setEnableGLFunctorInRenderkitMode(z);
        }
        return this;
    }

    public LynxUIRendererBuilder setEnableDelegateInRenderkitMode(boolean z) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setEnableDelegateInRenderkitMode(z);
        }
        return this;
    }

    public LynxUIRendererBuilder setEnableClayRecycleEngine(boolean z) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setEnableClayRecycleEngine(z);
        }
        return this;
    }

    public LynxUIRendererBuilder setEnableClayCompatMode(boolean z) {
        LynxUIRendererClayCreator uIRendererCreator = this.mLynxViewBuilder.getUIRendererCreator();
        if (uIRendererCreator instanceof LynxUIRendererClayCreator) {
            uIRendererCreator.setEnableClayCompatMode(z);
        }
        return this;
    }
}
