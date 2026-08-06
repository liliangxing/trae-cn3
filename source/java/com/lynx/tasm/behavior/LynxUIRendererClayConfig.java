package com.lynx.tasm.behavior;

/* loaded from: classes7.dex */
class LynxUIRendererClayConfig {
    private int imageTextureCacheMaxLimit;
    private int lowEndImageTextureCacheMaxLimit;
    private boolean enableGLFunctorWithRenderkitMode = true;
    private boolean enableTextureViewWithRenderkitMode = false;
    private boolean enableDelegateWithRenderkitMode = false;
    private boolean enableClayRecycleEngine = true;
    private boolean enableClayCompatMode = false;

    public boolean isEnableGLFunctorWithRenderkitMode() {
        return this.enableGLFunctorWithRenderkitMode;
    }

    public void setEnableGLFunctorWithRenderkitMode(boolean z) {
        this.enableGLFunctorWithRenderkitMode = z;
    }

    public boolean isEnableTextureViewWithRenderkitMode() {
        return this.enableTextureViewWithRenderkitMode;
    }

    public void setEnableTextureViewWithRenderkitMode(boolean z) {
        this.enableTextureViewWithRenderkitMode = z;
    }

    public boolean isEnableDelegateWithRenderkitMode() {
        return this.enableDelegateWithRenderkitMode;
    }

    public void setEnableDelegateWithRenderkitMode(boolean z) {
        this.enableDelegateWithRenderkitMode = z;
    }

    public boolean isEnableClayRecycleEngine() {
        return this.enableClayRecycleEngine;
    }

    public void setEnableClayRecycleEngine(boolean z) {
        this.enableClayRecycleEngine = z;
    }

    public boolean isEnableClayCompatMode() {
        return this.enableClayCompatMode;
    }

    public void setEnableClayCompatMode(boolean z) {
        this.enableClayCompatMode = z;
    }

    public int getImageTextureCacheMaxLimit() {
        return this.imageTextureCacheMaxLimit;
    }

    public void setImageTextureCacheMaxLimit(int i) {
        this.imageTextureCacheMaxLimit = i;
    }

    public int getLowEndImageTextureCacheMaxLimit() {
        return this.lowEndImageTextureCacheMaxLimit;
    }

    public void setLowEndImageTextureCacheMaxLimit(int i) {
        this.lowEndImageTextureCacheMaxLimit = i;
    }
}
