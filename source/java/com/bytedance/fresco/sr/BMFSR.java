package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.bytedance.bmf_mods_api.VideoSuperResolutionAPI;
import com.bytedance.bmf_mods_lite_api.SuperResolutionLiteApi;
import com.bytedance.bmf_mods_lite_api.bean.MultiScaleParams;
import com.bytedance.bmf_mods_lite_api.bean.SharpLevelParams;
import com.facebook.common.heif.SRMonitorUtil;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HWClosableReleaser;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class BMFSR implements ISuperResolution {
    public static final int HEIGHT_DEFAULT = 1440;
    public static final String INIT_SUCCESS = "success";
    private static final String TAG = "BMFSR";
    public static final int WIDTH_DEFAULT = 1440;
    private static int algorithmType;
    private static VideoSuperResolutionAPI api;
    private static SuperResolutionLiteApi api2;
    private static int backendType;
    private static boolean inited;
    private static boolean inited2;
    private static int mBitmapOptimizeLevel;
    private static int mHWPlan;
    private static String mProgramCacheDir;
    private static int mStageType;
    private static int scaleType;
    private static final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private static final byte[] processLock = new byte[0];
    private static int maxWidth = 1440;
    private static int maxHeight = 1440;
    private static boolean mSrOptByTasks = false;
    private static int mQueuingTaskNum = 4;

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getSRType() {
        return TAG;
    }

    public static void setHWPlan(int i) {
        mHWPlan = i;
    }

    public BMFSR(int i, int i2, int i3) {
        algorithmType = i;
        backendType = i2;
        scaleType = i3;
    }

    public BMFSR(int i, int i2, int i3, int i4, int i5) {
        SRMonitorUtil.setMaxWidth(i4);
        SRMonitorUtil.setMaxHeight(i5);
        algorithmType = i;
        backendType = i2;
        scaleType = i3;
        maxWidth = i4;
        maxHeight = i5;
    }

    public static void initMaxWH(int i, int i2) {
        SRMonitorUtil.setMaxWidth(i);
        SRMonitorUtil.setMaxHeight(i2);
        if (i <= 0) {
            i = 1440;
        }
        maxWidth = i;
        if (i2 <= 0) {
            i2 = 1440;
        }
        maxHeight = i2;
    }

    public static void initProgramCacheDir(String str) {
        mProgramCacheDir = str;
    }

    public static void initSrOptTaskConfig(boolean z, int i) {
        mSrOptByTasks = z;
        mQueuingTaskNum = i;
    }

    public static String initBMFSR(int i, int i2, String str, boolean z, boolean z2, int i3) {
        return initBMFSR(0, 0, i, i2, str, z, z2, i3);
    }

    public static String initBMFSR(int i, int i2, int i3, int i4, String str, boolean z, boolean z2, int i5) {
        SRMonitorUtil.setStageType(i);
        SRMonitorUtil.setUseOpenGL(z);
        SRMonitorUtil.setOptimizeLevel(i2);
        SRMonitorUtil.setCacheDir(str);
        if (i3 <= 0) {
            i3 = 1440;
        }
        maxWidth = i3;
        if (i4 <= 0) {
            i4 = 1440;
        }
        maxHeight = i4;
        SRMonitorUtil.setMaxWidth(i3);
        SRMonitorUtil.setMaxHeight(maxHeight);
        mProgramCacheDir = str;
        algorithmType = i == 1 ? 4 : z ? 7 : 8;
        backendType = z ? 3 : 2;
        scaleType = 32768;
        mSrOptByTasks = z2;
        mQueuingTaskNum = i5;
        mStageType = i;
        mBitmapOptimizeLevel = i2;
        if (i == 1) {
            FrescoCacheMonitorUtil.setOptHardWareForSRProcessor((i2 & 1) > 0);
            FrescoCacheMonitorUtil.setEnableSaveAfterSrPostBitmap((i2 & 2) == 0);
        }
        return init(i);
    }

    public static int getBmfSRStageType() {
        return mStageType;
    }

    public static int getBitmapOptimizeLevel() {
        return mBitmapOptimizeLevel;
    }

    public static int getMaxWidth() {
        return maxWidth;
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static Object getImplByName(int i, String str) throws Exception {
        Class<?> cls = Class.forName((i == 0 ? "com.bytedance.bmf_mods." : "com.bytedance.bmf_mods_lite.") + str);
        if (cls != null) {
            return cls.newInstance();
        }
        return null;
    }

    @Deprecated
    public static Object getImplByName(String str) throws Exception {
        return getImplByName(getBmfSRStageType(), str);
    }

    public static String init(int i) {
        String str;
        int Init;
        ReadWriteLock readWriteLock = rwlock;
        readWriteLock.readLock().lock();
        if (i == 0 && inited) {
            readWriteLock.readLock().unlock();
            return "success";
        }
        if (i == 1 && inited2) {
            readWriteLock.readLock().unlock();
            return "success";
        }
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock().lock();
        try {
            if (i == 0) {
                api = (VideoSuperResolutionAPI) getImplByName(i, "VideoSuperResolution");
            } else {
                api2 = (SuperResolutionLiteApi) getImplByName(i, "VideoSuperResolution");
            }
            str = "";
        } catch (Exception e) {
            FLog.i(TAG, (i == 0 ? "VideoSuperResolutionAPI" : "SuperResolutionLiteApi") + " class not found, " + e.getMessage());
            String str2 = (i == 0 ? "VideoSuperResolutionAPI" : "SuperResolutionLiteApi") + " class not found, " + e.getMessage();
            e.printStackTrace();
            str = str2;
        }
        if (i == 0) {
            if (api == null) {
                FLog.i(TAG, "VideoSuperResolutionAPI is null after initialization");
                String str3 = str + "VideoSuperResolutionAPI is null after initialization";
                rwlock.writeLock().unlock();
                return str3;
            }
        } else if (api2 == null) {
            FLog.i(TAG, "SuperResolutionLiteApi is null after initialization");
            String str4 = str + "SuperResolutionLiteApi is null after initialization";
            rwlock.writeLock().unlock();
            return str4;
        }
        if (i == 0) {
            Init = api.Init(algorithmType, backendType, scaleType, 6, "", "", mProgramCacheDir, maxWidth, maxHeight, 1);
            inited = Init == 0;
        } else {
            Init = api2.Init(4, backendType, scaleType, 6, "", "", mProgramCacheDir, maxWidth, maxHeight, 1);
            inited2 = Init == 0;
        }
        if (Init == 0) {
            FLog.i(TAG, i != 0 ? "SuperResolutionLiteApi initialization success" : "VideoSuperResolutionAPI");
        } else {
            FLog.e(TAG, i == 0 ? "VideoSuperResolutionAPI" : "SuperResolutionLiteApi initialization error, res = " + Init);
            str = str + (i == 0 ? "VideoSuperResolutionAPI" : "SuperResolutionLiteApi") + " initialization error, res = " + Init;
        }
        rwlock.writeLock().unlock();
        if (i == 0) {
            if (inited) {
                return "success";
            }
        } else if (inited2) {
            return "success";
        }
        return str;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) throws Exception {
        CloseableReference<Bitmap> createBitmap;
        if (mSrOptByTasks && api.GetQueuingTaskNum() > mQueuingTaskNum) {
            throw new SRTaskTooManyException(-200000, "Do not do SRProcess because the current number of sr tasks:" + api.GetQueuingTaskNum() + ", mQueuingTaskNum:" + mQueuingTaskNum);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (api == null) {
            return null;
        }
        synchronized (processLock) {
            createBitmap = platformBitmapFactory.createBitmap(api.ProcessBitmap(bitmap, width, height));
        }
        return createBitmap;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(boolean z, Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i, int i2) throws Exception {
        CloseableReference<Bitmap> createBitmap;
        VideoSuperResolutionAPI videoSuperResolutionAPI = api;
        if (videoSuperResolutionAPI == null || i2 == -1) {
            return null;
        }
        if (z) {
            if (mSrOptByTasks && videoSuperResolutionAPI.GetQueuingTaskNum() > mQueuingTaskNum) {
                throw new SRTaskTooManyException(-200000, "Do not do SRProcess because the current number of sr tasks:" + api.GetQueuingTaskNum() + ", mQueuingTaskNum:" + mQueuingTaskNum);
            }
            Bitmap ProcessMultiScaleBitmap = api.ProcessMultiScaleBitmap(bitmap, i, i2);
            if (ProcessMultiScaleBitmap == null) {
                throw new Exception("ProcessMultiScaleBitmap result is null!");
            }
            return platformBitmapFactory.createBitmap(ProcessMultiScaleBitmap);
        }
        synchronized (processLock) {
            Bitmap ProcessMultiScaleBitmap2 = api.ProcessMultiScaleBitmap(bitmap, i, i2);
            if (ProcessMultiScaleBitmap2 == null) {
                throw new Exception("ProcessMultiScaleBitmap result is null!");
            }
            createBitmap = platformBitmapFactory.createBitmap(ProcessMultiScaleBitmap2);
        }
        return createBitmap;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(int i, Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i2) throws Exception {
        SuperResolutionLiteApi superResolutionLiteApi = api2;
        if (superResolutionLiteApi == null || i2 == -1) {
            return null;
        }
        if (mSrOptByTasks && superResolutionLiteApi.GetQueuingTaskNum() > mQueuingTaskNum) {
            throw new SRTaskTooManyException(-200000, "Do not do SRProcess because the current number of sr tasks:" + api.GetQueuingTaskNum() + ", mQueuingTaskNum:" + mQueuingTaskNum);
        }
        MultiScaleParams multiScaleParams = new MultiScaleParams(i2);
        if ((i & 2) > 0) {
            if (mHWPlan == 0) {
                Bitmap ProcessMultiScaleBitmap = api2.ProcessMultiScaleBitmap(bitmap, i, multiScaleParams, (SharpLevelParams) null);
                if (ProcessMultiScaleBitmap == null) {
                    throw new Exception("ProcessMultiScaleBitmap2 result is null!");
                }
                return CloseableReference.of(ProcessMultiScaleBitmap, HWClosableReleaser.getInstance());
            }
            if (HWClosableReleaser.getInstance().canAddBitmap(bitmap)) {
                Bitmap ProcessMultiScaleBitmap2 = api2.ProcessMultiScaleBitmap(bitmap, i, multiScaleParams, (SharpLevelParams) null);
                if (ProcessMultiScaleBitmap2 == null) {
                    throw new Exception("ProcessMultiScaleBitmap2 result is null!");
                }
                CloseableReference<Bitmap> of = CloseableReference.of(ProcessMultiScaleBitmap2, HWClosableReleaser.getInstance());
                HWClosableReleaser.getInstance().addBitmap(ProcessMultiScaleBitmap2);
                return of;
            }
            throw new Exception("ProcessMultiScaleBitmap2 HW Bitmap Pool is full");
        }
        Bitmap ProcessMultiScaleBitmap3 = api2.ProcessMultiScaleBitmap(bitmap, i, multiScaleParams, (SharpLevelParams) null);
        if (ProcessMultiScaleBitmap3 == null) {
            throw new Exception("ProcessMultiScaleBitmap2 result is null!");
        }
        return platformBitmapFactory.createBitmap(ProcessMultiScaleBitmap3);
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public void destroy() {
        ReadWriteLock readWriteLock = rwlock;
        readWriteLock.writeLock().lock();
        VideoSuperResolutionAPI videoSuperResolutionAPI = api;
        if (videoSuperResolutionAPI != null && inited) {
            videoSuperResolutionAPI.Free();
        }
        inited = false;
        readWriteLock.writeLock().unlock();
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getScaleType() {
        int i = scaleType;
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? DiskLruCache.VERSION : "1.4" : "1.3" : "1.2" : "1.1" : ExifInterface.GPS_MEASUREMENT_2D : "1.5";
    }
}
