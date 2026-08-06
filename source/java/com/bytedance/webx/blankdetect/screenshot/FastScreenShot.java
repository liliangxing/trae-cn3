package com.bytedance.webx.blankdetect.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

/* loaded from: classes6.dex */
public class FastScreenShot implements IScreenShot {
    protected static final float SCALE = 0.1f;
    private static final String TAG = "FastScreenShot";
    protected float scale = 0.1f;
    protected static final Bitmap.Config QUALITY = Bitmap.Config.ARGB_8888;
    protected static Bitmap cacheBitmap = null;

    @Override // com.bytedance.webx.blankdetect.screenshot.IScreenShot
    public void release(View view) {
    }

    @Override // com.bytedance.webx.blankdetect.screenshot.IScreenShot
    public ShotResult shot(View view) {
        Bitmap bitmap;
        Bitmap bitmap2;
        ShotResult shotResult = new ShotResult();
        int width = (int) ((view.getWidth() * this.scale) + 0.5f);
        int height = (int) ((view.getHeight() * this.scale) + 0.5f);
        if (width <= 0 || height <= 0) {
            width = view.getWidth();
            height = view.getHeight();
        }
        Bitmap bitmap3 = cacheBitmap;
        boolean z = true;
        if (bitmap3 != null && !bitmap3.isRecycled() && cacheBitmap.getWidth() == width && cacheBitmap.getHeight() == height) {
            Log.i(TAG, "hit cache");
            bitmap = cacheBitmap;
            shotResult.hitCache = 1;
            z = false;
        } else {
            shotResult.hitCache = 2;
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = newBitmap(view, width, height);
        }
        if (bitmap != null) {
            tryDraw(view, bitmap);
            if (z && (bitmap2 = cacheBitmap) != null && !bitmap2.isRecycled()) {
                cacheBitmap.recycle();
            }
            cacheBitmap = bitmap;
        }
        shotResult.bitmap = bitmap;
        return shotResult;
    }

    private Bitmap newBitmap(View view, int i, int i2) {
        try {
            return Bitmap.createBitmap(view.getContext().getResources().getDisplayMetrics(), i, i2, QUALITY);
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "OOM", e);
            return null;
        }
    }

    protected void tryDraw(View view, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        float f = this.scale;
        canvas.scale(f, f);
        view.computeScroll();
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
    }
}
