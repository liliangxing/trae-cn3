package com.bytedance.fresco.sharp;

import android.graphics.Bitmap;
import com.bytedance.bmf_mods_lite_api.SharpenApi;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class BMFSharp implements ISharpResolution {
    public static final int HEIGHT_DEFAULT = 4096;
    public static final String INIT_SUCCESS = "success";
    public static final int POOL_SIZE_DEFAULT = 2;
    private static final String TAG = "BMFSharp";
    public static final int WIDTH_DEFAULT = 4096;
    private static int mAlgorithmType = 0;
    private static boolean mOnlyUserInit = true;
    private static String mProgramCacheDir;
    private static SharpenApi v1Api;
    private static boolean v1Inited;
    private static SharpenApi v2Api;
    private static boolean v2Inited;
    private static final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private static final byte[] processLock = new byte[0];
    private static int maxWidth = 4096;
    private static int maxHeight = 4096;
    private static int mPoolSize = 2;
    private static boolean mSharpOptByTasks = false;
    private static int mQueuingTaskNum = 4;

    public BMFSharp(int i) {
        mAlgorithmType = i;
    }

    public BMFSharp(int i, int i2, String str) {
        mAlgorithmType = i;
        mPoolSize = i2;
        mProgramCacheDir = str;
    }

    public BMFSharp(int i, int i2, int i3, int i4, String str) {
        mAlgorithmType = i;
        maxWidth = i2;
        maxHeight = i3;
        mPoolSize = i4;
        mProgramCacheDir = str;
    }

    public static String initBMFSharp(int i, int i2, int i3, int i4, String str, boolean z, int i5) {
        mAlgorithmType = i;
        if (i2 <= 0) {
            i2 = 4096;
        }
        maxWidth = i2;
        if (i3 <= 0) {
            i3 = 4096;
        }
        maxHeight = i3;
        mPoolSize = i4;
        mProgramCacheDir = str;
        mSharpOptByTasks = z;
        mQueuingTaskNum = i5;
        return init(i);
    }

    public static int getMaxWidth() {
        return maxWidth;
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static Object getImplByName(String str) throws Exception {
        Class<?> cls = Class.forName("com.bytedance.bmf_mods_lite." + str);
        if (cls != null) {
            return cls.newInstance();
        }
        return null;
    }

    public static void setOnlyUserInit(boolean z) {
        mOnlyUserInit = z;
    }

    public static boolean isOnlyUserInit() {
        return mOnlyUserInit;
    }

    public static String isInited(int i) {
        return (i == 3 && v1Inited) ? "success" : (i == 4 && v2Inited) ? "success" : "The business has not been initialized yet";
    }

    public static String init(int i) {
        String str;
        String str2;
        String str3;
        int i2;
        int Init;
        ReadWriteLock readWriteLock = rwlock;
        readWriteLock.readLock().lock();
        if (i == 3 && v1Inited) {
            readWriteLock.readLock().unlock();
            return "success";
        }
        if (i == 4 && v2Inited) {
            readWriteLock.readLock().unlock();
            return "success";
        }
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock().lock();
        try {
            if (i == 3) {
                v1Api = (SharpenApi) getImplByName("Sharpen");
            } else {
                v2Api = (SharpenApi) getImplByName("Sharpen");
            }
            str = "";
        } catch (Exception e) {
            FLog.i(TAG, "Sharpen class not found, " + e.getMessage());
            String str4 = "Sharpen class not found, " + e.getMessage();
            e.printStackTrace();
            str = str4;
        }
        if (i == 3) {
            if (v1Api == null) {
                FLog.i(TAG, "SharpenApi is null after initialization");
                String str5 = str + "SharpenApi is null after initialization";
                rwlock.writeLock().unlock();
                return str5;
            }
        } else if (v2Api == null) {
            FLog.i(TAG, "SharpenApi is null after initialization");
            String str6 = str + "SharpenApi is null after initialization";
            rwlock.writeLock().unlock();
            return str6;
        }
        if (i == 3) {
            SharpenApi sharpenApi = v1Api;
            int i3 = maxWidth;
            int i4 = maxHeight;
            int i5 = mPoolSize;
            String str7 = mProgramCacheDir;
            str2 = TAG;
            str3 = "success";
            i2 = 3;
            Init = sharpenApi.Init(i, i3, i4, i5, str7, 1, 4.0f, 3.0f, 0.3f, true, 1200.0f, 1.0f);
        } else {
            str2 = TAG;
            str3 = "success";
            i2 = 3;
            Init = v2Api.Init(i, maxWidth, maxHeight, mPoolSize, mProgramCacheDir, 1, 5.0f, 3.0f, 0.3f, true, 1200.0f, 1.0f);
        }
        if (Init == 0) {
            FLog.i(str2, "SharpenApi initialization success");
        } else {
            FLog.e(str2, "SharpenApi initialization error, res = " + Init);
            str = str + "SharpenApi initialization error, res = " + Init;
        }
        if (i == i2) {
            v1Inited = Init == 0;
        } else {
            v2Inited = Init == 0;
        }
        rwlock.writeLock().unlock();
        return (i != i2 ? !v2Inited : !v1Inited) ? str : str3;
    }

    @Override // com.bytedance.fresco.sharp.ISharpResolution
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory, int i, float f, float f2, float f3, boolean z, float f4, float f5) throws Exception {
        Bitmap ProcessBitmap;
        CloseableReference<Bitmap> createBitmap;
        if (mSharpOptByTasks && ((i == 3 && v1Api.getQueuingTaskNum() > mQueuingTaskNum) || (i == 4 && v2Api.getQueuingTaskNum() > mQueuingTaskNum))) {
            throw new SharpTaskTooManyException(-200000, "Do not do SharpProcess because the current number of sharp tasks:" + v1Api.getQueuingTaskNum() + ", mQueuingTaskNum:" + mQueuingTaskNum);
        }
        if (i == 3 && v1Api == null) {
            return null;
        }
        if (i == 4 && v2Api == null) {
            return null;
        }
        synchronized (processLock) {
            if (i == 3) {
                ProcessBitmap = v1Api.ProcessBitmap(bitmap, f, f2, f3, z, f4, f5);
            } else {
                ProcessBitmap = v2Api.ProcessBitmap(bitmap, f, f2, f3, z, f4, f5);
            }
            if (ProcessBitmap == null) {
                throw new Exception("ProcessMultiScaleBitmap result is null!");
            }
            createBitmap = platformBitmapFactory.createBitmap(ProcessBitmap);
        }
        return createBitmap;
    }

    @Override // com.bytedance.fresco.sharp.ISharpResolution
    public void destroy(int i) {
        ReadWriteLock readWriteLock = rwlock;
        readWriteLock.writeLock().lock();
        if (i == 3) {
            SharpenApi sharpenApi = v1Api;
            if (sharpenApi != null && v1Inited) {
                sharpenApi.Free();
            }
            v1Inited = false;
        } else {
            SharpenApi sharpenApi2 = v2Api;
            if (sharpenApi2 != null && v2Inited) {
                sharpenApi2.Free();
            }
            v2Inited = false;
        }
        readWriteLock.writeLock().unlock();
    }
}
