package com.lynx.tasm.behavior.ui.background;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* loaded from: classes7.dex */
public abstract class BackgroundLayerDrawable extends Drawable {
    private Path mPath;

    public abstract int getImageHeight();

    public abstract int getImageWidth();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public abstract boolean isReady();

    public abstract void onAttach();

    public abstract void onDetach();

    public abstract void onSizeChanged(int i, int i2);

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    public void setBitmapConfig(Bitmap.Config config) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setEnableBitmapGradient(boolean z) {
    }

    public void setLynxUI(LynxBaseUI lynxBaseUI) {
    }

    public void setPathEffect(Path path) {
        this.mPath = path;
    }

    public Path getPathEffect() {
        return this.mPath;
    }
}
