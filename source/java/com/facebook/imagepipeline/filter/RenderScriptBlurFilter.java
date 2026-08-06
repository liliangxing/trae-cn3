package com.facebook.imagepipeline.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.facebook.common.internal.Preconditions;

/* loaded from: classes6.dex */
public abstract class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;

    public static boolean canUseRenderScript() {
        return true;
    }

    public static void blurBitmap(Bitmap bitmap, Bitmap bitmap2, Context context, int i) {
        RenderScript renderScript;
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkNotNull(bitmap2);
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(i > 0 && i <= 25);
        try {
            renderScript = RenderScript.create(context);
            try {
                ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap2);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(renderScript, bitmap);
                create.setRadius(i);
                create.setInput(createFromBitmap);
                create.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(bitmap);
                if (renderScript != null) {
                    renderScript.destroy();
                }
            } catch (Throwable th) {
                th = th;
                if (renderScript != null) {
                    renderScript.destroy();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            renderScript = null;
        }
    }
}
