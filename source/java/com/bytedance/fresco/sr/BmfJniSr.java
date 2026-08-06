package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import com.bytedance.fresco.nativeheif.Heif;
import com.facebook.common.heif.SRMonitorUtil;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imageutils.FrescoSoLoader;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class BmfJniSr implements ISuperResolution {
    public static final int CONCURRENCY_LIMIT_DEFAULT = 3;
    public static final int HEIGHT_DEFAULT = 2048;
    public static final String INIT_SUCCESS = "success";
    private static final String TAG = "BmfJniSr";
    public static final int WIDTH_DEFAULT = 2048;
    private static final ReentrantLock rwlock = new ReentrantLock();
    private static final byte[] processLock = new byte[0];
    private static int maxWidth = 2048;
    private static int maxHeight = 2048;
    private static int mConcurrencyLimit = 3;
    private static String mProgramCacheDir = "";
    private static boolean isLoadBmfHydraLiteSo = false;

    public static native Bitmap processSrUseJni(int i, int i2, int i3, String str, boolean z, Bitmap bitmap, int i4, int i5, int[] iArr);

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getSRType() {
        return "BMFJNISR";
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getScaleType() {
        return null;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) throws Exception {
        return null;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(int i, Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i2) throws Exception {
        return null;
    }

    private static boolean loadBmfHydraLiteSo() {
        if (isLoadBmfHydraLiteSo) {
            return true;
        }
        try {
            FrescoSoLoader.loadLibrary("bmf_hydra_lite");
            isLoadBmfHydraLiteSo = true;
        } catch (Throwable th) {
            FLog.e(TAG, "loadBmfHydraLiteSo: throwable = " + th);
        }
        return isLoadBmfHydraLiteSo;
    }

    public static String initBMFSR(int i, int i2, int i3, String str) {
        if (!loadBmfHydraLiteSo()) {
            return "load bmf_hydra_lite failed!";
        }
        maxWidth = i <= 0 ? 2048 : i;
        maxHeight = i2 > 0 ? i2 : 2048;
        mProgramCacheDir = str;
        mConcurrencyLimit = i3;
        SRMonitorUtil.setCacheDir(str);
        SRMonitorUtil.setMaxWidth(maxWidth);
        SRMonitorUtil.setMaxHeight(maxHeight);
        SRMonitorUtil.setConcurrencyLimit(mConcurrencyLimit);
        ReentrantLock reentrantLock = rwlock;
        reentrantLock.lock();
        int initBmfSr = Heif.initBmfSr(i, i2, i3, str);
        reentrantLock.unlock();
        return initBmfSr == 0 ? "success" : "BmfJniSr initialization error, res = " + initBmfSr;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(boolean z, Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i, int i2) throws Exception {
        CloseableReference<Bitmap> createBitmap;
        if (i2 == -1) {
            return null;
        }
        if (z) {
            Bitmap processSrUseJni = processSrUseJni(z, bitmap, i, i2);
            if (processSrUseJni == null) {
                throw new Exception("ProcessMultiScaleBitmap result is null!");
            }
            return platformBitmapFactory.createBitmap(processSrUseJni);
        }
        synchronized (processLock) {
            Bitmap processSrUseJni2 = processSrUseJni(z, bitmap, i, i2);
            if (processSrUseJni2 == null) {
                throw new Exception("ProcessMultiScaleBitmap result is null!");
            }
            createBitmap = platformBitmapFactory.createBitmap(processSrUseJni2);
        }
        return createBitmap;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public void destroy() {
        ReentrantLock reentrantLock = rwlock;
        reentrantLock.lock();
        Heif.releaseBmfSr();
        reentrantLock.unlock();
    }

    public static Bitmap processSrUseJni(boolean z, Bitmap bitmap, int i, int i2) {
        return processSrUseJni(maxWidth, maxHeight, mConcurrencyLimit, mProgramCacheDir, z, bitmap, i, i2, null);
    }
}
