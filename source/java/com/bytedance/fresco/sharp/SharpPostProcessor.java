package com.bytedance.fresco.sharp;

import android.graphics.Bitmap;
import coil3.disk.DiskLruCache;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SharpPostProcessor extends BasePostprocessor {
    public static String TAG = "SharpPostProcessor";
    private String failureReason;
    private boolean mAdaptive;
    private int mAlgorithm;
    private CacheKey mCacheKey;
    private float mG0;
    private float mLcWtThr;
    private float mOvrt;
    private ISharpResolution mSharpResolution;
    private int mSharpTemplate;
    private float mThr;
    private float mWt;

    public String getName() {
        return "SharpPostProcessor";
    }

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey(String.format(null, "s%d%d", Integer.valueOf(this.mAlgorithm), Integer.valueOf(this.mSharpTemplate)));
        }
        return this.mCacheKey;
    }

    public SharpPostProcessor(int i) {
        this.failureReason = "";
        this.mSharpTemplate = i;
        this.mAlgorithm = i < 5 ? 3 : 4;
        createSharpTempParams(i);
        this.mSharpResolution = new BMFSharp(this.mAlgorithm);
    }

    public SharpPostProcessor(int i, float f, float f2, float f3, boolean z, float f4, float f5) {
        this.failureReason = "";
        this.mSharpTemplate = 10;
        this.mAlgorithm = i;
        this.mWt = f;
        this.mThr = f2;
        this.mOvrt = f3;
        this.mAdaptive = z;
        this.mG0 = f4;
        this.mLcWtThr = f5;
        this.mSharpResolution = new BMFSharp(i);
    }

    public void updateSharpTemplate(int i) {
        this.mSharpTemplate = i;
        this.mAlgorithm = i < 5 ? 3 : 4;
        createSharpTempParams(i);
    }

    public void updateSharpParams(int i, float f, float f2, float f3, boolean z, float f4, float f5) {
        this.mSharpTemplate = 10;
        this.mAlgorithm = i;
        this.mWt = f;
        this.mThr = f2;
        this.mOvrt = f3;
        this.mAdaptive = z;
        this.mG0 = f4;
        this.mLcWtThr = f5;
        this.mSharpResolution = new BMFSharp(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, Map<String, String> map) {
        String init;
        CloseableReference<Bitmap> closeableReference;
        long currentTimeMillis = System.currentTimeMillis();
        int i = this.mSharpTemplate;
        if (i == 10) {
            map.put(SharpEventTrackingConst.SHARP_MODE, this.mAlgorithm == 3 ? "0" : DiskLruCache.VERSION);
        } else {
            map.put(SharpEventTrackingConst.SHARP_MODE, i < 5 ? "0" : DiskLruCache.VERSION);
        }
        if (!isArgb8888Type(bitmap)) {
            this.failureReason = "The Bitmap config is not ARGB_8888";
        } else {
            if (BMFSharp.isOnlyUserInit()) {
                init = BMFSharp.isInited(this.mAlgorithm);
            } else {
                init = BMFSharp.init(this.mAlgorithm);
            }
            if ("success".equals(init)) {
                try {
                    closeableReference = this.mSharpResolution.process(bitmap, platformBitmapFactory, this.mAlgorithm, this.mWt, this.mThr, this.mOvrt, this.mAdaptive, this.mG0, this.mLcWtThr);
                } catch (Exception e) {
                    this.failureReason = e.getMessage();
                    closeableReference = null;
                    if (closeableReference != null) {
                    }
                    map.put(SharpEventTrackingConst.SHARP_WT, this.mWt + "");
                    map.put(SharpEventTrackingConst.SHARP_THR, this.mThr + "");
                    map.put(SharpEventTrackingConst.SHARP_OVRT, this.mOvrt + "");
                    map.put(SharpEventTrackingConst.SHARP_ADAPTIVE, this.mAdaptive + "");
                    map.put(SharpEventTrackingConst.SHARP_G0, this.mG0 + "");
                    map.put(SharpEventTrackingConst.SHARP_LC_WT_THR, this.mLcWtThr + "");
                    if (closeableReference == null) {
                    }
                } catch (BmfException e2) {
                    this.failureReason = "errCode is " + e2.getCode() + ", " + e2.getMessage();
                    closeableReference = null;
                    if (closeableReference != null) {
                    }
                    map.put(SharpEventTrackingConst.SHARP_WT, this.mWt + "");
                    map.put(SharpEventTrackingConst.SHARP_THR, this.mThr + "");
                    map.put(SharpEventTrackingConst.SHARP_OVRT, this.mOvrt + "");
                    map.put(SharpEventTrackingConst.SHARP_ADAPTIVE, this.mAdaptive + "");
                    map.put(SharpEventTrackingConst.SHARP_G0, this.mG0 + "");
                    map.put(SharpEventTrackingConst.SHARP_LC_WT_THR, this.mLcWtThr + "");
                    if (closeableReference == null) {
                    }
                }
                if (closeableReference != null) {
                    map.put(SharpEventTrackingConst.SHARP_STATUS, "0");
                    map.put(SharpEventTrackingConst.SHARP_DURATION, (System.currentTimeMillis() - currentTimeMillis) + "");
                }
                map.put(SharpEventTrackingConst.SHARP_WT, this.mWt + "");
                map.put(SharpEventTrackingConst.SHARP_THR, this.mThr + "");
                map.put(SharpEventTrackingConst.SHARP_OVRT, this.mOvrt + "");
                map.put(SharpEventTrackingConst.SHARP_ADAPTIVE, this.mAdaptive + "");
                map.put(SharpEventTrackingConst.SHARP_G0, this.mG0 + "");
                map.put(SharpEventTrackingConst.SHARP_LC_WT_THR, this.mLcWtThr + "");
                if (closeableReference == null) {
                    return closeableReference;
                }
                CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(bitmap);
                map.put(SharpEventTrackingConst.SHARP_STATUS, DiskLruCache.VERSION);
                map.put(SharpEventTrackingConst.SHARP_ERROR, this.failureReason);
                return createBitmap;
            }
            this.failureReason = "failed reason is:" + init;
        }
        closeableReference = null;
        map.put(SharpEventTrackingConst.SHARP_WT, this.mWt + "");
        map.put(SharpEventTrackingConst.SHARP_THR, this.mThr + "");
        map.put(SharpEventTrackingConst.SHARP_OVRT, this.mOvrt + "");
        map.put(SharpEventTrackingConst.SHARP_ADAPTIVE, this.mAdaptive + "");
        map.put(SharpEventTrackingConst.SHARP_G0, this.mG0 + "");
        map.put(SharpEventTrackingConst.SHARP_LC_WT_THR, this.mLcWtThr + "");
        if (closeableReference == null) {
        }
    }

    public void destroy() {
        this.mSharpResolution.destroy(this.mAlgorithm);
    }

    private boolean isArgb8888Type(Bitmap bitmap) {
        return bitmap.getConfig() == Bitmap.Config.ARGB_8888;
    }

    public void createSharpTempParams(int i) {
        this.mThr = 3.0f;
        this.mAdaptive = true;
        this.mG0 = 1200.0f;
        this.mLcWtThr = 1.0f;
        switch (i) {
            case 1:
                this.mWt = 4.0f;
                this.mOvrt = 0.3f;
                return;
            case 2:
                this.mWt = 3.0f;
                this.mOvrt = 0.2f;
                return;
            case 3:
            case 8:
                this.mWt = 2.0f;
                this.mOvrt = 0.1f;
                return;
            case 4:
                this.mWt = 1.0f;
                this.mOvrt = 0.1f;
                return;
            case 5:
                this.mWt = 5.0f;
                this.mOvrt = 0.3f;
                return;
            case 6:
                this.mWt = 4.0f;
                this.mOvrt = 0.2f;
                return;
            case 7:
                this.mWt = 3.0f;
                this.mOvrt = 0.1f;
                return;
            default:
                FLog.d(TAG, "Illegal parameter type, use default value");
                this.mWt = 4.0f;
                this.mOvrt = 0.3f;
                return;
        }
    }
}
