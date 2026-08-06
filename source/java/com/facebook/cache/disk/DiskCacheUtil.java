package com.facebook.cache.disk;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class DiskCacheUtil {
    private static final int CACHE_MAP_DEFAULT_MAX_SIZE = 1000;
    private static final String TAG = "DiskCacheUtil";
    private static HashMap<String, Integer> mDiskCacheVisitCountMap = new HashMap<>();
    private static boolean mOptDiskCacheLRU = false;
    private static int maxHashMapSize = 1000;

    private DiskCacheUtil() {
    }

    public static void setOptDiskCacheLRU(boolean z) {
        mOptDiskCacheLRU = z;
    }

    public static void setMapMaxSize(int i) {
        maxHashMapSize = i;
    }

    public static boolean isOptDiskCacheLRU() {
        return mOptDiskCacheLRU;
    }

    public static void clearDiskCacheVisitCountMap() {
        if (mOptDiskCacheLRU) {
            try {
                mDiskCacheVisitCountMap.clear();
            } catch (Throwable th) {
                FLog.d(TAG, "clearDiskCacheVisitCountMap mImageLoadDurationMap clear failed! t = " + th);
            }
        }
    }

    public static void newDiskCacheVisitCount(String str) {
        if (mOptDiskCacheLRU) {
            try {
                if (mDiskCacheVisitCountMap.size() > maxHashMapSize) {
                    mDiskCacheVisitCountMap.clear();
                }
                mDiskCacheVisitCountMap.put(str, 1);
            } catch (Throwable th) {
                FLog.d(TAG, "newDiskCacheVisitCount: Throwable = " + th);
            }
        }
    }

    public static int getVisitCount(String str) {
        try {
            if (mOptDiskCacheLRU && !TextUtils.isEmpty(str) && mDiskCacheVisitCountMap.containsKey(str)) {
                return mDiskCacheVisitCountMap.get(str).intValue();
            }
            return 0;
        } catch (Throwable th) {
            FLog.d(TAG, "getVisitCount: Throwable = " + th);
            return 0;
        }
    }

    public static void deleteDiskCacheVisitCount(String str) {
        if (mOptDiskCacheLRU) {
            try {
                mDiskCacheVisitCountMap.remove(str);
            } catch (Throwable th) {
                FLog.d(TAG, "deleteDiskCacheVisitCountById: Throwable = " + th);
            }
        }
    }

    public static void updateDiskCacheVisitCount(String str) {
        if (mOptDiskCacheLRU) {
            try {
                if (mDiskCacheVisitCountMap.size() > maxHashMapSize) {
                    mDiskCacheVisitCountMap.clear();
                }
                if (!mDiskCacheVisitCountMap.containsKey(str)) {
                    mDiskCacheVisitCountMap.put(str, 1);
                } else {
                    mDiskCacheVisitCountMap.put(str, Integer.valueOf(mDiskCacheVisitCountMap.get(str).intValue() + 1));
                }
            } catch (Throwable th) {
                mDiskCacheVisitCountMap.put(str, 1);
                FLog.d(TAG, "updateDiskCacheVisitCount: Throwable = " + th);
            }
        }
    }
}
