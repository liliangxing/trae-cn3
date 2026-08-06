package com.bytedance.android.monitorV2.webview.blank;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewShotService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/blank/WebViewShotService;", "", "()V", "newBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "width", "", "height", "shot", "Lcom/bytedance/android/monitorV2/webview/blank/ShotResult;", "tryDraw", "", "bitmap", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewShotService {
    private static final float SCALE = 0.1f;
    private static final String TAG = "WebViewShotService";
    private static Bitmap cacheBitmap;
    private static final Bitmap.Config QUALITY = Bitmap.Config.ARGB_8888;
    private static float scale = 0.1f;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ShotResult shot(View view) throws Exception, Error {
        Bitmap bitmap;
        Bitmap bitmap2;
        Intrinsics.checkNotNullParameter(view, "view");
        ShotResult shotResult = new ShotResult();
        int width = (int) ((view.getWidth() * scale) + 0.5f);
        int height = (int) ((view.getHeight() * scale) + 0.5f);
        if (width <= 0 || height <= 0) {
            width = view.getWidth();
            height = view.getHeight();
        }
        Bitmap bitmap3 = cacheBitmap;
        boolean z = true;
        if (bitmap3 != null) {
            Intrinsics.checkNotNull(bitmap3);
            if (!bitmap3.isRecycled()) {
                Bitmap bitmap4 = cacheBitmap;
                Intrinsics.checkNotNull(bitmap4);
                if (bitmap4.getWidth() == width) {
                    Bitmap bitmap5 = cacheBitmap;
                    Intrinsics.checkNotNull(bitmap5);
                    if (bitmap5.getHeight() == height) {
                        Log.i(TAG, "hit cache");
                        bitmap = cacheBitmap;
                        shotResult.setHitCache(1);
                        z = false;
                        if (bitmap == null) {
                            bitmap = newBitmap(view, width, height);
                        }
                        if (bitmap != null) {
                            tryDraw(view, bitmap);
                            if (z && (bitmap2 = cacheBitmap) != null) {
                                Intrinsics.checkNotNull(bitmap2);
                                if (!bitmap2.isRecycled()) {
                                    Bitmap bitmap6 = cacheBitmap;
                                    Intrinsics.checkNotNull(bitmap6);
                                    bitmap6.recycle();
                                }
                            }
                            cacheBitmap = bitmap;
                        }
                        shotResult.setBitmap(bitmap);
                        return shotResult;
                    }
                }
            }
        }
        shotResult.setHitCache(2);
        bitmap = null;
        if (bitmap == null) {
        }
        if (bitmap != null) {
        }
        shotResult.setBitmap(bitmap);
        return shotResult;
    }

    private final Bitmap newBitmap(View view, int width, int height) throws OutOfMemoryError {
        return Bitmap.createBitmap(view.getContext().getResources().getDisplayMetrics(), width, height, QUALITY);
    }

    private final void tryDraw(View view, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        float f = scale;
        canvas.scale(f, f);
        view.computeScroll();
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
    }
}
