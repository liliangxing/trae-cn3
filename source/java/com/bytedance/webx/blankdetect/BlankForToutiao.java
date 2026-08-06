package com.bytedance.webx.blankdetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.bytedance.webx.blankdetect.BlankUtils;
import com.bytedance.webx.blankdetect.screenshot.FastScreenShot;
import com.bytedance.webx.blankdetect.screenshot.IScreenShot;
import com.bytedance.webx.blankdetect.screenshot.NormalScreenShot;
import com.bytedance.webx.blankdetect.screenshot.ShotResult;
import com.bytedance.webx.blankdetect.screenshot.ViewContentShot;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BlankForToutiao {
    private static final String TAG = "BlankDetectWebViewUtils";
    private static PixBlankDetector detector = new PixBlankDetector();

    public static boolean isWebViewBlank(View view) {
        return getDetectorResult(view).blankState == 1;
    }

    public static BlankUtils.DetectorResult getDetectorResult(View view) {
        return getDetectorResultInner(view, new NormalScreenShot());
    }

    public static BlankUtils.DetectorResult getDetectorResultFast(View view) {
        return getDetectorResultInner(view, new FastScreenShot());
    }

    public static BlankUtils.DetectorResult getDetectorResultOnlyCheckViewContent(View view) {
        return getDetectorResultInner(view, new ViewContentShot());
    }

    public static BlankUtils.DetectorResult getDetectorResultOnlyCheckViewContent(View view, float f) {
        ViewContentShot viewContentShot = new ViewContentShot();
        viewContentShot.setScale(f);
        return getDetectorResultInner(view, viewContentShot);
    }

    private static boolean checkBoundingValid(int i, int i2, BlankUtils.DetectorResult detectorResult) {
        if (i > 0 && i2 > 0) {
            return true;
        }
        Log.w(TAG, "width and height must be > 0");
        detectorResult.errorCode = 4;
        detectorResult.errorMsg = "width and height must be > 0";
        detectorResult.blankState = 3;
        return false;
    }

    private static boolean checkViewValid(View view, BlankUtils.DetectorResult detectorResult) {
        if (view != null) {
            return true;
        }
        detectorResult.errorCode = 1;
        detectorResult.errorMsg = "view is null.";
        detectorResult.blankState = 3;
        return false;
    }

    public static BlankUtils.DetectorResult getDetectorResultInner(View view, IScreenShot iScreenShot) {
        BlankUtils.DetectorResult detectorResult = new BlankUtils.DetectorResult();
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

    private static void screenShotAndCheckBlank(View view, IScreenShot iScreenShot, final BlankUtils.DetectorResult detectorResult) {
        ShotResult shot;
        long currentTimeMillis = System.currentTimeMillis();
        if (iScreenShot instanceof ViewContentShot) {
            ((ViewContentShot) iScreenShot).setShotListener(new ViewContentShot.ShotListener() { // from class: com.bytedance.webx.blankdetect.BlankForToutiao.1
                @Override // com.bytedance.webx.blankdetect.screenshot.ViewContentShot.ShotListener
                public boolean watch(Bitmap bitmap) {
                    BlankForToutiao.checkBlank(bitmap, BlankUtils.DetectorResult.this);
                    return BlankUtils.DetectorResult.this.blankState != 2;
                }
            });
            shot = iScreenShot.shot(view);
        } else {
            shot = iScreenShot.shot(view);
            checkBlank(shot.bitmap, detectorResult);
        }
        iScreenShot.release(view);
        detectorResult.hitCache = shot.hitCache;
        detectorResult.costTime = System.currentTimeMillis() - currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkBlank(Bitmap bitmap, BlankUtils.DetectorResult detectorResult) {
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
