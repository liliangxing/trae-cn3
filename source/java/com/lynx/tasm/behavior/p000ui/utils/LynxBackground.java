package com.lynx.tasm.behavior.p000ui.utils;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.UIShadowProxy;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBackground extends LynxDrawableManager<BackgroundDrawable> {
    private int mColor;

    public LynxBackground(LynxContext lynxContext) {
        super(lynxContext);
        this.mColor = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lynx.tasm.behavior.p000ui.utils.LynxDrawableManager
    public BackgroundDrawable createLayerDrawable() {
        return new BackgroundDrawable(this.mContext, this.mFontSize);
    }

    public void setBackgroundColor(int i) {
        this.mColor = i;
        if (i == 0 && this.mLayerDrawable == 0) {
            return;
        }
        getOrCreateViewLayer().setColor(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lynx.tasm.behavior.p000ui.utils.LynxDrawableManager
    public BackgroundDrawable getDrawable() {
        return (BackgroundDrawable) super.getDrawable();
    }

    public boolean setBorderRadius(int i, ReadableArray readableArray) {
        int i2 = 0;
        if (readableArray == null || readableArray.size() <= 0) {
            if (i == 0) {
                int i3 = 0;
                while (i3 < 4) {
                    i3++;
                    setBorderRadiusCorner(i3, new BorderRadius.Corner());
                }
            } else {
                setBorderRadiusCorner(i, new BorderRadius.Corner());
            }
            return false;
        }
        if (i == 0) {
            LLog.DCHECK(readableArray.size() == 16);
            while (i2 < 4) {
                int i4 = i2 + 1;
                setBorderRadiusCorner(i4, BorderRadius.Corner.toCorner(readableArray, i2 * 4));
                i2 = i4;
            }
        } else {
            LLog.DCHECK(readableArray.size() == 4);
            setBorderRadiusCorner(i, BorderRadius.Corner.toCorner(readableArray, 0));
        }
        return true;
    }

    public void setBorderColorForSpacingIndex(int i, Integer num) {
        setBorderColor(i, num == null ? 1.0E21f : num.intValue() & TypedValue.COMPLEX_MANTISSA_MASK, num != null ? num.intValue() >>> 24 : 1.0E21f);
    }

    public void setBorderColor(int i, float f, float f2) {
        getOrCreateViewLayer().setBorderColor(i, f, f2);
    }

    public void setBorderRadiusCorner(int i, BorderRadius.Corner corner) {
        getOrCreateViewLayer().setBorderRadiusCorner(i, corner);
    }

    public void setBorderStyle(int i, int i2) {
        getOrCreateViewLayer().setBorderStyle(i, i2);
    }

    public int getBackgroundColor() {
        return this.mColor;
    }

    public BorderRadius getBorderRadius() {
        if (this.mLayerDrawable == 0) {
            return null;
        }
        return ((BackgroundDrawable) this.mLayerDrawable).getBorderRadius();
    }

    public void setBoxShadowInsetDrawer(UIShadowProxy.InsetDrawer insetDrawer) {
        getOrCreateViewLayer().setBoxShadowInsetDrawer(insetDrawer);
    }

    public UIShadowProxy.InsetDrawer getBoxShadowInsetDrawer() {
        if (this.mLayerDrawable != 0) {
            return ((BackgroundDrawable) this.mLayerDrawable).getBoxShadowInsetDrawer();
        }
        return null;
    }
}
