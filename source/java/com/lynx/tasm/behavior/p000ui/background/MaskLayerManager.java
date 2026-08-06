package com.lynx.tasm.behavior.p000ui.background;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MaskLayerManager extends LayerManager {
    private Paint mMaskPaint;

    @Override // com.lynx.tasm.behavior.p000ui.background.LayerManager
    protected boolean isMask() {
        return true;
    }

    public MaskLayerManager(LynxContext lynxContext, Drawable drawable, float f) {
        super(lynxContext, drawable, f);
        this.mMaskPaint = null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.LayerManager
    public void draw(Canvas canvas, RectF rectF, RectF rectF2, RectF rectF3, RectF rectF4, Path path, Path path2, boolean z) {
        int saveLayer = canvas.saveLayer(null, this.mMaskPaint, 31);
        super.draw(canvas, rectF, rectF2, rectF3, rectF4, path, path2, z);
        canvas.restoreToCount(saveLayer);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.LayerManager
    public void setLayerImage(ReadableArray readableArray, LynxBaseUI lynxBaseUI) {
        View view;
        super.setLayerImage(readableArray, lynxBaseUI);
        if (this.mMaskPaint == null) {
            Paint paint = new Paint();
            this.mMaskPaint = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.mMaskPaint.setAntiAlias(true);
            if (!(lynxBaseUI instanceof LynxUI) || (view = ((LynxUI) lynxBaseUI).getView()) == null || view.getLayerType() == 2) {
                return;
            }
            view.setWillNotDraw(false);
            view.setLayerType(2, null);
        }
    }
}
