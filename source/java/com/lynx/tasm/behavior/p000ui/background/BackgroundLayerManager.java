package com.lynx.tasm.behavior.p000ui.background;

import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackgroundLayerManager extends LayerManager {
    @Override // com.lynx.tasm.behavior.p000ui.background.LayerManager
    protected boolean isMask() {
        return false;
    }

    public BackgroundLayerManager(LynxContext lynxContext, Drawable drawable, float f) {
        super(lynxContext, drawable, f);
    }

    public boolean hasBackgroundLayers() {
        return hasImageLayers();
    }
}
