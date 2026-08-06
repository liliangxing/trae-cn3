package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.bytedance.bmf_mods_api.BmfException;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.heif.SRMonitorUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SRPostProcessor extends BasePostprocessor {
    public static String TAG = "SRPostProcessor";
    private String failureReason;
    private CacheKey mCacheKey;
    private boolean mEnableAllSr;
    private int mScaleType;
    private ISuperResolution mSuperResolution;
    private boolean mUseOpenGl;

    public String getName() {
        return "SRPostProcessor";
    }

    public String getScaleType(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? DiskLruCache.VERSION : "1.4" : "1.3" : "1.2" : "1.1" : ExifInterface.GPS_MEASUREMENT_2D : "1.5";
    }

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey(String.format(null, "s%d%b", Integer.valueOf(this.mScaleType), Boolean.valueOf(this.mEnableAllSr)));
        }
        return this.mCacheKey;
    }

    public SRPostProcessor(int i, boolean z) {
        this.failureReason = "";
        this.mUseOpenGl = true;
        this.mEnableAllSr = z;
        this.mScaleType = i;
        if (FrescoCacheMonitorUtil.isUseJniSr()) {
            this.mSuperResolution = new BmfJniSr();
        } else {
            boolean z2 = this.mUseOpenGl;
            this.mSuperResolution = new BMFSR(z2 ? 7 : 8, z2 ? 3 : 2, 32768);
        }
    }

    @Deprecated
    public SRPostProcessor(boolean z, int i, boolean z2) {
        this.failureReason = "";
        this.mUseOpenGl = z;
        this.mEnableAllSr = z2;
        this.mScaleType = i;
        if (FrescoCacheMonitorUtil.isUseJniSr()) {
            this.mSuperResolution = new BmfJniSr();
        } else {
            boolean z3 = this.mUseOpenGl;
            this.mSuperResolution = new BMFSR(z3 ? 7 : 8, z3 ? 3 : 2, 32768);
        }
    }

    public SRPostProcessor(int i, int i2, int i3, boolean z) {
        this.failureReason = "";
        this.mUseOpenGl = true;
        this.mEnableAllSr = z;
        this.mScaleType = i;
        if (FrescoCacheMonitorUtil.isUseJniSr()) {
            this.mSuperResolution = new BmfJniSr();
        } else {
            boolean z2 = this.mUseOpenGl;
            this.mSuperResolution = new BMFSR(z2 ? 7 : 8, z2 ? 3 : 2, 32768, i2, i3);
        }
    }

    @Deprecated
    public SRPostProcessor(int i, int i2, int i3, int i4, boolean z) {
        this.failureReason = "";
        this.mUseOpenGl = true;
        this.mEnableAllSr = z;
        this.mScaleType = i2;
        if (FrescoCacheMonitorUtil.isUseJniSr()) {
            this.mSuperResolution = new BmfJniSr();
        } else {
            this.mSuperResolution = new BMFSR(i, this.mUseOpenGl ? 3 : 2, 32768, i3, i4);
        }
    }

    public void updateScaleTypeAndEnableAllSr(int i, boolean z) {
        this.mEnableAllSr = z;
        this.mScaleType = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x030a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026d  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, Map<String, String> map) {
        String str;
        String init;
        ?? r14;
        String str2;
        String str3;
        CloseableReference<Bitmap> closeableReference;
        int i;
        String str4;
        int i2;
        CloseableReference<Bitmap> processMultiScaleBitmap;
        float f;
        int i3;
        int i4;
        String str5;
        String str6;
        Bitmap bitmap2 = bitmap;
        if (map != null && "0".equalsIgnoreCase(map.get(SREventTrackingConst.SR_STATUS))) {
            try {
                return platformBitmapFactory.createBitmap(bitmap2);
            } catch (Throwable unused) {
                return null;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        map.put(SREventTrackingConst.SR_MODE, this.mSuperResolution.getSRType());
        String str7 = "";
        if (!isProcessableBitmapConfig(bitmap)) {
            this.failureReason = "The Bitmap config is not support sr, config is:" + bitmap.getConfig();
            str2 = DiskLruCache.VERSION;
            str3 = SREventTrackingConst.SR_ERROR;
            str4 = "";
            i3 = 26;
        } else {
            if (FrescoCacheMonitorUtil.isUseJniSr()) {
                int maxWidth = SRMonitorUtil.getMaxWidth();
                int maxHeight = SRMonitorUtil.getMaxHeight();
                int concurrencyLimit = SRMonitorUtil.getConcurrencyLimit();
                str = "";
                String cacheDir = SRMonitorUtil.getCacheDir();
                init = BmfJniSr.initBMFSR(maxWidth, maxHeight, concurrencyLimit, cacheDir);
                r14 = cacheDir;
            } else {
                str = "";
                init = BMFSR.init(BMFSR.getBmfSRStageType());
                r14 = str7;
            }
            if ("success".equals(init)) {
                try {
                    try {
                        int i5 = 7;
                        try {
                            if (this.mEnableAllSr) {
                                String str8 = map.get(SREventTrackingConst.SR_STRETCH);
                                r14 = 0;
                                r14 = 0;
                                try {
                                    f = Float.parseFloat(str8);
                                } catch (Exception unused2) {
                                    f = 0.0f;
                                }
                                int scaleType = getScaleType(str8);
                                try {
                                    if (FrescoCacheMonitorUtil.isOptAutoSr() && f > 0.0f) {
                                        try {
                                            if (f < FrescoCacheMonitorUtil.getStretchAboveForSR()) {
                                                r14 = 26;
                                                r14 = 26;
                                                Bitmap copy = (Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) ? bitmap2 : bitmap2.copy(Bitmap.Config.ARGB_8888, false);
                                                try {
                                                    map.put(SREventTrackingConst.SR_STATUS, DiskLruCache.VERSION);
                                                    map.put(SREventTrackingConst.SR_ERROR, "倍率小于设置的允许超分倍率" + FrescoCacheMonitorUtil.getStretchAboveForSR());
                                                    return platformBitmapFactory.createBitmap(copy);
                                                } catch (Exception e) {
                                                    e = e;
                                                    bitmap2 = copy;
                                                    str2 = DiskLruCache.VERSION;
                                                    str3 = SREventTrackingConst.SR_ERROR;
                                                    this.failureReason = e.getMessage();
                                                    i2 = r14;
                                                    closeableReference = null;
                                                    i = i2;
                                                    if (closeableReference != null) {
                                                    }
                                                    map.put(SREventTrackingConst.SR_MAX_WIDTH, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxWidth() : BMFSR.getMaxWidth()) + str4);
                                                    map.put(SREventTrackingConst.SR_MAX_HEIGHT, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxHeight() : BMFSR.getMaxHeight()) + str4);
                                                    map.put(SREventTrackingConst.SR_SCALE_TYPE, this.mScaleType + str4);
                                                    map.put(SREventTrackingConst.SR_IS_ENABLE_ALL, this.mEnableAllSr + str4);
                                                    if (closeableReference == null) {
                                                    }
                                                    return closeableReference;
                                                } catch (BmfException e2) {
                                                    e = e2;
                                                    bitmap2 = copy;
                                                    str2 = DiskLruCache.VERSION;
                                                    str3 = SREventTrackingConst.SR_ERROR;
                                                    this.failureReason = "errCode is " + e.getCode() + ", " + e.getMessage();
                                                    i2 = r14;
                                                    closeableReference = null;
                                                    i = i2;
                                                    if (closeableReference != null) {
                                                    }
                                                    map.put(SREventTrackingConst.SR_MAX_WIDTH, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxWidth() : BMFSR.getMaxWidth()) + str4);
                                                    map.put(SREventTrackingConst.SR_MAX_HEIGHT, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxHeight() : BMFSR.getMaxHeight()) + str4);
                                                    map.put(SREventTrackingConst.SR_SCALE_TYPE, this.mScaleType + str4);
                                                    map.put(SREventTrackingConst.SR_IS_ENABLE_ALL, this.mEnableAllSr + str4);
                                                    if (closeableReference == null) {
                                                    }
                                                    return closeableReference;
                                                }
                                            }
                                        } catch (BmfException e3) {
                                            e = e3;
                                            str2 = DiskLruCache.VERSION;
                                            str3 = SREventTrackingConst.SR_ERROR;
                                            r14 = 26;
                                            this.failureReason = "errCode is " + e.getCode() + ", " + e.getMessage();
                                            i2 = r14;
                                            closeableReference = null;
                                            i = i2;
                                            if (closeableReference != null) {
                                            }
                                            map.put(SREventTrackingConst.SR_MAX_WIDTH, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxWidth() : BMFSR.getMaxWidth()) + str4);
                                            map.put(SREventTrackingConst.SR_MAX_HEIGHT, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxHeight() : BMFSR.getMaxHeight()) + str4);
                                            map.put(SREventTrackingConst.SR_SCALE_TYPE, this.mScaleType + str4);
                                            map.put(SREventTrackingConst.SR_IS_ENABLE_ALL, this.mEnableAllSr + str4);
                                            if (closeableReference == null) {
                                            }
                                            return closeableReference;
                                        } catch (Exception e4) {
                                            e = e4;
                                            str2 = DiskLruCache.VERSION;
                                            str3 = SREventTrackingConst.SR_ERROR;
                                            r14 = 26;
                                            this.failureReason = e.getMessage();
                                            i2 = r14;
                                            closeableReference = null;
                                            i = i2;
                                            if (closeableReference != null) {
                                            }
                                            map.put(SREventTrackingConst.SR_MAX_WIDTH, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxWidth() : BMFSR.getMaxWidth()) + str4);
                                            map.put(SREventTrackingConst.SR_MAX_HEIGHT, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxHeight() : BMFSR.getMaxHeight()) + str4);
                                            map.put(SREventTrackingConst.SR_SCALE_TYPE, this.mScaleType + str4);
                                            map.put(SREventTrackingConst.SR_IS_ENABLE_ALL, this.mEnableAllSr + str4);
                                            if (closeableReference == null) {
                                            }
                                            return closeableReference;
                                        }
                                    }
                                    r14 = 26;
                                    r14 = 26;
                                    r14 = 26;
                                    if (scaleType > 0) {
                                        if (FrescoCacheMonitorUtil.isUseJniSr()) {
                                            ISuperResolution iSuperResolution = this.mSuperResolution;
                                            boolean z = this.mUseOpenGl;
                                            str3 = SREventTrackingConst.SR_ERROR;
                                            str2 = DiskLruCache.VERSION;
                                            r14 = 26;
                                            processMultiScaleBitmap = iSuperResolution.processMultiScaleBitmap(z, bitmap, platformBitmapFactory, 7, scaleType);
                                        } else {
                                            str2 = DiskLruCache.VERSION;
                                            str3 = SREventTrackingConst.SR_ERROR;
                                            if (BMFSR.getBmfSRStageType() == 0) {
                                                ISuperResolution iSuperResolution2 = this.mSuperResolution;
                                                boolean z2 = this.mUseOpenGl;
                                                if (!z2) {
                                                    i5 = 8;
                                                }
                                                processMultiScaleBitmap = iSuperResolution2.processMultiScaleBitmap(z2, bitmap, platformBitmapFactory, i5, scaleType);
                                            } else {
                                                processMultiScaleBitmap = this.mSuperResolution.processMultiScaleBitmap(BMFSR.getBitmapOptimizeLevel(), bitmap2, platformBitmapFactory, scaleType);
                                            }
                                        }
                                    } else {
                                        str2 = DiskLruCache.VERSION;
                                        str3 = SREventTrackingConst.SR_ERROR;
                                        this.failureReason = "The scale is abnormal, scale = " + scaleType;
                                        processMultiScaleBitmap = null;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                } catch (BmfException e6) {
                                    e = e6;
                                }
                            } else {
                                str2 = DiskLruCache.VERSION;
                                str3 = SREventTrackingConst.SR_ERROR;
                                r14 = 26;
                                r14 = 26;
                                r14 = 26;
                                if (FrescoCacheMonitorUtil.isUseJniSr()) {
                                    processMultiScaleBitmap = this.mSuperResolution.processMultiScaleBitmap(this.mUseOpenGl, bitmap, platformBitmapFactory, 7, this.mScaleType);
                                } else if (BMFSR.getBmfSRStageType() == 0) {
                                    ISuperResolution iSuperResolution3 = this.mSuperResolution;
                                    boolean z3 = this.mUseOpenGl;
                                    if (!z3) {
                                        i5 = 8;
                                    }
                                    processMultiScaleBitmap = iSuperResolution3.processMultiScaleBitmap(z3, bitmap, platformBitmapFactory, i5, this.mScaleType);
                                } else {
                                    processMultiScaleBitmap = this.mSuperResolution.processMultiScaleBitmap(BMFSR.getBitmapOptimizeLevel(), bitmap2, platformBitmapFactory, this.mScaleType);
                                }
                            }
                            closeableReference = processMultiScaleBitmap;
                            i = r14;
                        } catch (Exception e7) {
                            e = e7;
                        } catch (BmfException e8) {
                            e = e8;
                        }
                    } catch (BmfException e9) {
                        e = e9;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
                if (closeableReference != null) {
                    map.put(SREventTrackingConst.SR_STATUS, "0");
                    str4 = str;
                    map.put(SREventTrackingConst.SR_DURATION, (System.currentTimeMillis() - currentTimeMillis) + str4);
                    map.put(SREventTrackingConst.SR_WIDTH, ((Bitmap) closeableReference.get()).getWidth() + str4);
                    map.put(SREventTrackingConst.SR_HEIGHT, ((Bitmap) closeableReference.get()).getHeight() + str4);
                    i4 = i;
                    if (!this.mEnableAllSr) {
                        map.put(SREventTrackingConst.SR_STRETCH, getScaleType(this.mScaleType));
                        i4 = i;
                    }
                } else {
                    str4 = str;
                    i4 = i;
                }
                map.put(SREventTrackingConst.SR_MAX_WIDTH, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxWidth() : BMFSR.getMaxWidth()) + str4);
                map.put(SREventTrackingConst.SR_MAX_HEIGHT, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxHeight() : BMFSR.getMaxHeight()) + str4);
                map.put(SREventTrackingConst.SR_SCALE_TYPE, this.mScaleType + str4);
                map.put(SREventTrackingConst.SR_IS_ENABLE_ALL, this.mEnableAllSr + str4);
                if (closeableReference == null) {
                    try {
                        if (Build.VERSION.SDK_INT >= i4 && bitmap2.getConfig() == Bitmap.Config.HARDWARE) {
                            bitmap2 = bitmap2.copy(Bitmap.Config.ARGB_8888, false);
                        }
                        closeableReference = platformBitmapFactory.createBitmap(bitmap2);
                        str5 = str2;
                        try {
                            map.put(SREventTrackingConst.SR_STATUS, str5);
                            str6 = str3;
                            try {
                                map.put(str6, this.failureReason);
                            } catch (Throwable th) {
                                th = th;
                                map.put(SREventTrackingConst.SR_STATUS, str5);
                                map.put(str6, th.getMessage());
                                return closeableReference;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str6 = str3;
                            map.put(SREventTrackingConst.SR_STATUS, str5);
                            map.put(str6, th.getMessage());
                            return closeableReference;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str5 = str2;
                    }
                }
                return closeableReference;
            }
            str2 = DiskLruCache.VERSION;
            str3 = SREventTrackingConst.SR_ERROR;
            str4 = str;
            i3 = 26;
            this.failureReason = "failed reason is:" + init;
        }
        closeableReference = null;
        i4 = i3;
        map.put(SREventTrackingConst.SR_MAX_WIDTH, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxWidth() : BMFSR.getMaxWidth()) + str4);
        map.put(SREventTrackingConst.SR_MAX_HEIGHT, (!FrescoCacheMonitorUtil.isUseJniSr() ? SRMonitorUtil.getMaxHeight() : BMFSR.getMaxHeight()) + str4);
        map.put(SREventTrackingConst.SR_SCALE_TYPE, this.mScaleType + str4);
        map.put(SREventTrackingConst.SR_IS_ENABLE_ALL, this.mEnableAllSr + str4);
        if (closeableReference == null) {
        }
        return closeableReference;
    }

    public void destroy() {
        this.mSuperResolution.destroy();
    }

    private boolean isProcessableBitmapConfig(Bitmap bitmap) {
        return FrescoCacheMonitorUtil.isUseJniSr() ? bitmap.getConfig() == Bitmap.Config.ARGB_8888 : (BMFSR.getBitmapOptimizeLevel() & 1) > 0 ? Build.VERSION.SDK_INT > 29 && bitmap.getConfig() == Bitmap.Config.HARDWARE : bitmap.getConfig() == Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getScaleType(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case 50:
                if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 48564:
                if (str.equals("1.1")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 48565:
                if (str.equals("1.2")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 48566:
                if (str.equals("1.3")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 48567:
                if (str.equals("1.4")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 48568:
                if (str.equals("1.5")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 49524:
                if (str.equals("2.0")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 6:
                return 2;
            case 1:
                return 4;
            case 2:
                return 8;
            case 3:
                return 16;
            case 4:
                return 32;
            case 5:
                return 1;
            default:
                return -1;
        }
    }
}
