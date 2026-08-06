package com.bytedance.android.monitorV2.webview.blank;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewBlankDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/blank/WebViewBlankDetector;", "", "()V", "TAG", "", "detector", "Lcom/bytedance/android/monitorV2/webview/blank/WebViewPixelChecker;", "checkBlank", "", "tmpMap", "Landroid/graphics/Bitmap;", "state", "Lcom/bytedance/android/monitorV2/webview/blank/DetectResult;", "checkBoundingValid", "", "width", "", "height", "checkViewValid", "view", "Landroid/view/View;", "pixelDetect", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebViewBlankDetector {
    private static final String TAG = "WebViewBlankDetector";
    public static final WebViewBlankDetector INSTANCE = new WebViewBlankDetector();
    private static final WebViewPixelChecker detector = new WebViewPixelChecker(0, 1, null);

    private WebViewBlankDetector() {
    }

    public final DetectResult pixelDetect(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        DetectResult detectResult = new DetectResult();
        if (!checkViewValid(view, detectResult)) {
            return detectResult;
        }
        Context context = view.getContext();
        if (context == null || context.getResources() == null) {
            detectResult.setErrorCode(4);
            detectResult.setErrorMsg("context or context.getResources is null");
            detectResult.setBlankState(3);
            return detectResult;
        }
        if (!checkBoundingValid(view.getWidth(), view.getHeight(), detectResult)) {
            return detectResult;
        }
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            detectResult.setErrorCode(2);
            detectResult.setErrorMsg("current thread is not main thread.");
            detectResult.setBlankState(3);
            return detectResult;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ShotResult shot = new WebViewShotService().shot(view);
            detectResult.setCollectTime(System.currentTimeMillis() - currentTimeMillis);
            checkBlank(shot.getBitmap(), detectResult);
            detectResult.setCalculateTime((System.currentTimeMillis() - currentTimeMillis) - detectResult.getCollectTime());
            detectResult.setCostTime(System.currentTimeMillis() - currentTimeMillis);
            detectResult.setHitCache(shot.getHitCache());
            detectResult.setBitmap(shot.getBitmap());
            return detectResult;
        } catch (Throwable th) {
            Log.e(TAG, "isViewPureColor", th);
            detectResult.setErrorCode(4);
            detectResult.setErrorMsg(th.getMessage());
            detectResult.setBlankState(3);
            detectResult.setCostTime(System.currentTimeMillis() - currentTimeMillis);
            return detectResult;
        }
    }

    private final boolean checkBoundingValid(int width, int height, DetectResult state) {
        if (width > 0 && height > 0) {
            return true;
        }
        Log.w(TAG, "width and height must be > 0");
        state.setErrorCode(4);
        state.setErrorMsg("width and height must be > 0");
        state.setBlankState(3);
        return false;
    }

    private final boolean checkViewValid(View view, DetectResult state) {
        if (view != null) {
            return true;
        }
        state.setErrorCode(1);
        state.setErrorMsg("view is null.");
        state.setBlankState(3);
        return false;
    }

    private final void checkBlank(Bitmap tmpMap, DetectResult state) {
        if (tmpMap != null) {
            state.setConfig(tmpMap.getConfig());
            int width = tmpMap.getWidth();
            int height = tmpMap.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            int pixel = tmpMap.getPixel(0, 0);
            state.setDetectPixel(pixel);
            WebViewPixelChecker webViewPixelChecker = detector;
            webViewPixelChecker.setOriginPix(pixel);
            state.setBlankState(webViewPixelChecker.doDetect(tmpMap) ? 1 : 2);
            return;
        }
        state.setErrorCode(3);
        state.setErrorMsg("bitmap is null.");
        state.setBlankState(3);
    }
}
