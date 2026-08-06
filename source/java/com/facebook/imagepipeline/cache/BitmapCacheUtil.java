package com.facebook.imagepipeline.cache;

import android.text.TextUtils;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.ResizeOptions;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BitmapCacheUtil extends MemoryCacheUtil {
    private static final String TAG = "BitmapCacheUtil";
    private static boolean mOptAnim = false;
    private static int mOptAnimSingleLimit = 4194304;
    private static int mOptAnimTotalLimit = 10485760;
    private static int mReuseRule;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public @interface ReuseRule {
        public static final int BOTH_WH = 0;
        public static final int W_OR_H = 1;
        public static final int W_X_H = 2;
    }

    private BitmapCacheUtil() {
    }

    public static void setOptAnim(boolean z) {
        mOptAnim = z;
    }

    public static boolean isOptAnim() {
        return mOptAnim;
    }

    public static void setOptAnimTotalLimit(int i) {
        mOptAnimTotalLimit = i;
    }

    public static int getOptAnimTotalLimit() {
        return mOptAnimTotalLimit;
    }

    public static void setOptAnimSingleLimit(int i) {
        mOptAnimSingleLimit = i;
    }

    public static int getOptAnimSingleLimit() {
        return mOptAnimSingleLimit;
    }

    public static void setReuseRule(int i) {
        mReuseRule = i;
    }

    public static void insertReuseBitmapCacheMap(CacheKey cacheKey) {
        String uriString;
        if (mOptReuseBitmapCache && cacheKey != null && (cacheKey instanceof BitmapMemoryCacheKey) && !TextUtils.isEmpty(cacheKey.toString()) && cacheKey.toString().contains("resizeOption:")) {
            try {
                if (mReuseBitmapCacheMap.size() > maxHashMapSize) {
                    mReuseBitmapCacheMap.clear();
                }
                ResizeOptions resizeOptions = ((BitmapMemoryCacheKey) cacheKey).getResizeOptions();
                if (resizeOptions == null) {
                    return;
                }
                if (mKeyOnlyUseUri) {
                    uriString = cacheKey.getUriString();
                } else {
                    try {
                        uriString = cacheKey.toString().substring(0, cacheKey.toString().indexOf("resizeOption:"));
                    } catch (Exception unused) {
                        uriString = cacheKey.getUriString();
                    }
                }
                mReuseBitmapCacheMap.put(uriString, resizeOptions.toString());
            } catch (Throwable th) {
                FLog.m430d(TAG, "newDiskCacheVisitCount: Throwable = " + th);
            }
        }
    }

    public static ResizeOptions getOptReuseResizeOption(CacheKey cacheKey) {
        ResizeOptions resizeOptions;
        String uriString;
        try {
        } catch (Throwable th) {
            FLog.m430d(TAG, "getOptReuseResizeOption: 111 Throwable = " + th);
        }
        if (!mOptReuseBitmapCache || !(cacheKey instanceof BitmapMemoryCacheKey) || (resizeOptions = ((BitmapMemoryCacheKey) cacheKey).getResizeOptions()) == null) {
            return null;
        }
        if (mKeyOnlyUseUri) {
            uriString = cacheKey.getUriString();
        } else {
            try {
                uriString = cacheKey.toString().substring(0, cacheKey.toString().indexOf("resizeOption:"));
            } catch (Exception unused) {
                uriString = cacheKey.getUriString();
            }
        }
        String str = mReuseBitmapCacheMap.get(uriString);
        String[] split = TextUtils.isEmpty(str) ? null : str.split("x");
        if (split != null && split.length == 2 && resizeOptions != null) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            int i = mReuseRule;
            if (i != 1) {
                if (i == 2) {
                    if (parseInt * parseInt2 >= resizeOptions.width * resizeOptions.height) {
                        return new ResizeOptions(parseInt, parseInt2);
                    }
                } else if (parseInt >= resizeOptions.width && parseInt2 >= resizeOptions.height) {
                    return new ResizeOptions(parseInt, parseInt2);
                }
            } else if (parseInt >= resizeOptions.width || parseInt2 >= resizeOptions.height) {
                return new ResizeOptions(parseInt, parseInt2);
            }
        }
        return null;
    }
}
