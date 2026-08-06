package com.bytedance.webx.blankdetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.bytedance.webx.blankdetect.screenshot.FastScreenShot;
import com.bytedance.webx.blankdetect.screenshot.IScreenShot;
import com.bytedance.webx.blankdetect.screenshot.NormalScreenShot;
import com.bytedance.webx.blankdetect.screenshot.ShotResult;

/* loaded from: classes6.dex */
public class BlankUtils {
    private static final String TAG = "BlankDetectWebViewUtils";
    private static PixBlankDetector detector = new PixBlankDetector();

    /* loaded from: classes6.dex */
    public static class DetectorResult {
        public static final int BLANK_SCREEN = 1;
        public static final int DETECT_FAIL = 3;
        public static final int NORMAL_SCREEN = 2;
        public Bitmap.Config config;
        public long costTime;
        public int detectPixel;
        public String errorMsg;
        public int blankState = 3;
        public int errorCode = -1;
        public int hitCache = 0;
    }

    public static boolean isWebViewBlank(View view) {
        return getDetectorResult(view).blankState == 1;
    }

    public static DetectorResult getDetectorResult(View view) {
        return getDetectorResultInner(view, new NormalScreenShot());
    }

    public static DetectorResult getDetectorResultFast(View view) {
        return getDetectorResultInner(view, new FastScreenShot());
    }

    private static boolean checkBoundingValid(int i, int i2, DetectorResult detectorResult) {
        if (i > 0 && i2 > 0) {
            return true;
        }
        Log.w(TAG, "width and height must be > 0");
        detectorResult.errorCode = 4;
        detectorResult.errorMsg = "width and height must be > 0";
        detectorResult.blankState = 3;
        return false;
    }

    private static boolean checkViewValid(View view, DetectorResult detectorResult) {
        if (view != null) {
            return true;
        }
        detectorResult.errorCode = 1;
        detectorResult.errorMsg = "view is null.";
        detectorResult.blankState = 3;
        return false;
    }

    public static DetectorResult getDetectorResultInner(View view, IScreenShot iScreenShot) {
        DetectorResult detectorResult = new DetectorResult();
        if (!checkViewValid(view, detectorResult)) {
            return detectorResult;
        }
        Context context = view.getContext();
        if (context == null || context.getResources() == null) {
            detectorResult.errorCode = 4;
            detectorResult.errorMsg = "context or context.getResources is null";
            detectorResult.blankState = 3;
            return detectorResult;
        }
        if (!checkBoundingValid(view.getWidth(), view.getHeight(), detectorResult)) {
            return detectorResult;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            detectorResult.errorCode = 2;
            detectorResult.errorMsg = "current thread is not main thread.";
            detectorResult.blankState = 3;
            return detectorResult;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            screenShotAndCheckBlank(view, iScreenShot, detectorResult);
            return detectorResult;
        } catch (Throwable th) {
            Log.e(TAG, "isViewPureColor", th);
            detectorResult.errorCode = 4;
            detectorResult.errorMsg = th.getMessage();
            detectorResult.blankState = 3;
            detectorResult.costTime = System.currentTimeMillis() - currentTimeMillis;
            return detectorResult;
        }
    }

    private static void screenShotAndCheckBlank(View view, IScreenShot iScreenShot, DetectorResult detectorResult) {
        long currentTimeMillis = System.currentTimeMillis();
        ShotResult shot = iScreenShot.shot(view);
        checkBlank(shot.bitmap, detectorResult);
        iScreenShot.release(view);
        detectorResult.hitCache = shot.hitCache;
        detectorResult.costTime = System.currentTimeMillis() - currentTimeMillis;
    }

    private static void checkBlank(Bitmap bitmap, DetectorResult detectorResult) {
        if (bitmap != null) {
            detectorResult.config = bitmap.getConfig();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            int pixel = bitmap.getPixel(0, 0);
            detectorResult.detectPixel = pixel;
            detector.setOriginPix(pixel);
            detectorResult.blankState = detector.doDetect(bitmap) ? 1 : 2;
            return;
        }
        detectorResult.errorCode = 3;
        detectorResult.errorMsg = "bitmap is null.";
        detectorResult.blankState = 3;
    }
}
