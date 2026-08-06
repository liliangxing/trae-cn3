package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.BaseFrescoControllerListener;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.cache.DealCacheHelper;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoControllerListener extends BaseFrescoControllerListener {
    private static final int FROM_BITMAP_MEMORYCACHE = 3;
    private static final int FROM_CACHE = 1;
    private static final int FROM_DISKCACHE = 2;
    private static final int FROM_ENCODE_MEMORYCACHE = 1;
    private static final int FROM_NETWORK = 0;
    private static final int FROM_UNKNOW = -1;
    private static final int HASH_MAP_DEFAULT_MAX_SIZE = 50;
    public static final String IMAGE_MONITOR_USER_SENCE = "image_sensible_monitor";
    public static final String IMAGE_MONITOR_WASTE = "image_waste_show";
    private static final int NOT_FROM_CACHE = 0;
    private static final String TAG = "UserSenceListener";
    private static boolean mForceRunInSubThread = false;
    private static int mHashMapMaxSize = 50;
    private static boolean mHashMapOpt = false;
    private static boolean mIsRecordSensible = true;
    private static boolean mIsRecordWaste = true;
    private static HashMap<ImageRequest, Long> mImageLoadDurationMap = new HashMap<>();
    private static SparseArray<Long> mImageLoadDurationOptMap = new SparseArray<>();
    private static boolean mUseOptHashMap = false;

    private int getHitCache(int i) {
        return (i == 2 || i == 1 || i == 3) ? 1 : 0;
    }

    private int getHitType(int i) {
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public void setIsRecordWaste(boolean z) {
        mIsRecordWaste = z;
    }

    public void setIsRecordSensible(boolean z) {
        mIsRecordSensible = z;
    }

    public static void setUseOptHashMap(boolean z) {
        mUseOptHashMap = z;
    }

    public static void forceRunInSubThread(boolean z) {
        mForceRunInSubThread = z;
    }

    public static void setHashMapOpt(boolean z) {
        mHashMapOpt = z;
    }

    public static boolean isHashMapOpt() {
        return mHashMapOpt;
    }

    public static void setMapMaxSize(int i) {
        mHashMapMaxSize = i;
    }

    public static int getMapMaxSize() {
        return mHashMapMaxSize;
    }

    public static void clearHashMap() {
        try {
            if (mUseOptHashMap) {
                mImageLoadDurationOptMap.clear();
            } else {
                mImageLoadDurationMap.clear();
            }
        } catch (Throwable th) {
            FLog.d(TAG, "clearHashMap mImageLoadDurationMap clear failed! t = " + th);
        }
    }

    public void onControllerStart(ImageRequest imageRequest, long j) {
        try {
            if (mUseOptHashMap) {
                if (mHashMapOpt && mImageLoadDurationOptMap.size() > mHashMapMaxSize) {
                    mImageLoadDurationOptMap.clear();
                }
                if (imageRequest != null) {
                    mImageLoadDurationOptMap.put(imageRequest.hashCode(), Long.valueOf(j));
                    return;
                }
                return;
            }
            if (mHashMapOpt && mImageLoadDurationMap.size() > mHashMapMaxSize) {
                mImageLoadDurationMap.clear();
            }
            mImageLoadDurationMap.put(imageRequest, Long.valueOf(j));
        } catch (Throwable th) {
            FLog.d(TAG, "onControllerStart mImageLoadDurationMap put element failed! t = " + th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0135 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:68:0x0131, B:70:0x0135, B:74:0x013f), top: B:67:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013f A[Catch: all -> 0x0145, TRY_LEAVE, TryCatch #1 {all -> 0x0145, blocks: (B:68:0x0131, B:70:0x0135, B:74:0x013f), top: B:67:0x0131 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFinalImageSet(String str, Object obj, Animatable animatable, ImageRequest imageRequest, final Map map) {
        final ImageFormat imageFormat;
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        if (imageRequest == null) {
            FLog.e(TAG, "imageRequest is null");
            return;
        }
        boolean logTypeSwitch = MonitorUtils.getLogTypeSwitch(IMAGE_MONITOR_USER_SENCE);
        final String uri = (imageRequest == null || imageRequest.getSourceUri() == null) ? "" : imageRequest.getSourceUri().toString();
        int i6 = -1;
        if (obj instanceof CloseableImage) {
            CloseableImage closeableImage = (CloseableImage) obj;
            int imageCount = closeableImage.getImageCount();
            ImageFormat imageFormat2 = closeableImage.getImageFormat();
            i2 = getFrom(closeableImage);
            i = imageCount;
            imageFormat = imageFormat2;
        } else {
            imageFormat = null;
            i = -1;
            i2 = -1;
        }
        final SizeDeterminer sizeDeterminer = imageRequest.getSizeDeterminer();
        if (sizeDeterminer == null || sizeDeterminer.getView() == null) {
            i3 = -1;
            z = false;
            z2 = false;
        } else {
            int height = sizeDeterminer.getView().getHeight();
            i6 = sizeDeterminer.getView().getWidth();
            Rect rect = new Rect();
            z2 = sizeDeterminer.getView().getGlobalVisibleRect(rect) || sizeDeterminer.getView().isShown();
            boolean z4 = sizeDeterminer.getView().getGlobalVisibleRect(rect) && sizeDeterminer.getView().isShown();
            i3 = height;
            z = z4;
        }
        if (mIsRecordWaste) {
            i5 = i2;
            JSONObject jSONObject = new JSONObject();
            i4 = i;
            try {
                z3 = z2;
                try {
                    jSONObject.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, map.get("drawableWidth") + "x" + map.get("drawableHeight"));
                    jSONObject.put(FrescoMonitorConst.IMAGE_TYPE, imageFormat == null ? "undefined" : imageFormat.getName());
                    jSONObject.put(FrescoMonitorConst.LOG_TYPE, IMAGE_MONITOR_WASTE);
                    jSONObject.put("uri", uri);
                    jSONObject.put(FrescoMonitorConst.SCENE_TAG, map.get(FrescoMonitorConst.SCENE_TAG));
                    try {
                        addTagsFromMonitorHook(jSONObject, uri);
                    } catch (RuntimeException e) {
                        FLog.e(TAG, "RuntimeException error is: ", e);
                    }
                } catch (JSONException unused) {
                    FLog.w(TAG, "JSONException in FrescoControllerListener");
                    FrescoMonitor.onImageShowCallback(z, jSONObject);
                    if (logTypeSwitch) {
                    }
                    try {
                        if (!mUseOptHashMap) {
                        }
                        return;
                    } catch (Throwable th) {
                        FLog.d(TAG, "onFinalImageSet mImageLoadDurationMap put element failed! t = " + th);
                        return;
                    }
                }
            } catch (JSONException unused2) {
                z3 = z2;
            }
            FrescoMonitor.onImageShowCallback(z, jSONObject);
        } else {
            z3 = z2;
            i4 = i;
            i5 = i2;
        }
        if ((logTypeSwitch || sizeDeterminer == null || sizeDeterminer.getView() == null) && !FrescoCacheMonitorUtil.isOptSensibleMonitor()) {
            if (!mUseOptHashMap) {
                mImageLoadDurationOptMap.remove(imageRequest.hashCode());
            } else {
                mImageLoadDurationMap.remove(imageRequest);
            }
            return;
        }
        final int loadDuration = getLoadDuration(imageRequest);
        if (mForceRunInSubThread && Looper.myLooper() == Looper.getMainLooper()) {
            final int i7 = i6;
            final int i8 = i3;
            final boolean z5 = z3;
            final int i9 = i4;
            final int i10 = i5;
            DealCacheHelper.getIOExecutor().execute(new Runnable() { // from class: com.optimize.statistics.FrescoControllerListener.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FrescoControllerListener.this.upload(i7, i8, map, loadDuration, imageFormat, uri, z5, i9, i10, sizeDeterminer);
                    } catch (Throwable th2) {
                        FLog.w(FrescoControllerListener.TAG, "upload throwable is : " + th2);
                    }
                }
            });
        } else {
            upload(i6, i3, map, loadDuration, imageFormat, uri, z3, i4, i5, sizeDeterminer);
        }
        try {
            if (mUseOptHashMap) {
                mImageLoadDurationOptMap.remove(imageRequest.hashCode());
            } else {
                mImageLoadDurationMap.remove(imageRequest);
            }
        } catch (Throwable th2) {
            FLog.d(TAG, "onFinalImageSet2 mImageLoadDurationMap put element failed! t = " + th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upload(int i, int i2, Map map, int i3, ImageFormat imageFormat, String str, boolean z, int i4, int i5, SizeDeterminer sizeDeterminer) {
        JSONObject jSONObject = new JSONObject();
        if (mIsRecordSensible) {
            try {
                jSONObject.put("view_width", i);
                jSONObject.put("view_height", i2);
                jSONObject.put("image_width", map.get("drawableWidth"));
                jSONObject.put("image_height", map.get("drawableHeight"));
                jSONObject.put("duration", i3);
                jSONObject.put(FrescoMonitorConst.URI_QUERY_PARAM_FROM, i5);
                jSONObject.put(FrescoMonitorConst.IMAGE_TYPE, imageFormat == null ? "undefined" : imageFormat.getName());
                jSONObject.put(FrescoMonitorConst.IMAGE_SDK_VERSION, BuildConfig.FRESCOVERSION);
                jSONObject.put(FrescoMonitorConst.LOG_TYPE, IMAGE_MONITOR_USER_SENCE);
                jSONObject.put(FrescoMonitorConst.IMAGE_COUNT, i4);
                jSONObject.put(FrescoMonitorConst.TIMESTAMP, System.currentTimeMillis());
                jSONObject.put("uri", str);
                jSONObject.put(FrescoMonitorConst.SCENE_TAG, map.get(FrescoMonitorConst.SCENE_TAG));
                try {
                    addTagsFromMonitorHook(jSONObject, str);
                } catch (RuntimeException e) {
                    FLog.e(TAG, "RuntimeException error is: ", e);
                }
                Context context = sizeDeterminer.getView().getContext();
                if (context instanceof Activity) {
                    jSONObject.put("page_tag", ((Activity) context).getClass().getSimpleName());
                }
                jSONObject.put("exception_tag", 1);
                jSONObject.put("hit_cache", getHitCache(i5));
                jSONObject.put("hit_type", getHitType(i5));
            } catch (JSONException unused) {
                FLog.w(TAG, "JSONException in FrescoControllerListener");
            }
            if (FrescoCacheMonitorUtil.isOptSensibleMonitor() || z) {
                FrescoMonitor.onSensibleCallback(jSONObject);
                MonitorUtils.monitorCommonLog(IMAGE_MONITOR_USER_SENCE, jSONObject);
                FLog.d(TAG, "User sence tracking upload successful, content: " + jSONObject);
            }
        }
    }

    public void onFailure(String str, ImageRequest imageRequest, Throwable th) {
        try {
            if (!mUseOptHashMap) {
                mImageLoadDurationMap.remove(imageRequest);
            } else if (imageRequest != null) {
                mImageLoadDurationOptMap.remove(imageRequest.hashCode());
            }
        } catch (Throwable th2) {
            FLog.d(TAG, "onFailure mImageLoadDurationMap put element failed! t = " + th2);
        }
    }

    public void onRelease(String str, ImageRequest imageRequest) {
        try {
            if (!mUseOptHashMap) {
                mImageLoadDurationMap.remove(imageRequest);
            } else if (imageRequest != null) {
                mImageLoadDurationOptMap.remove(imageRequest.hashCode());
            }
        } catch (Throwable th) {
            FLog.d(TAG, "onRelease mImageLoadDurationMap put element failed! t = " + th);
        }
    }

    private int getFrom(CloseableImage closeableImage) {
        if (closeableImage.isRequestInternet()) {
            return 0;
        }
        if (closeableImage.isHitDiskCache()) {
            return 2;
        }
        if (closeableImage.isHitEncodeMemoryCache()) {
            return 1;
        }
        return closeableImage.isHitBitmapMemoryCache() ? 3 : -1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002e -> B:7:0x002f). Please report as a decompilation issue!!! */
    private int getLoadDuration(ImageRequest imageRequest) {
        long j;
        if (mUseOptHashMap) {
            if (imageRequest != null) {
                j = mImageLoadDurationOptMap.get(imageRequest.hashCode()).longValue();
            }
            j = -1;
        } else {
            if (mImageLoadDurationMap.containsKey(imageRequest)) {
                j = mImageLoadDurationMap.get(imageRequest).longValue();
            }
            j = -1;
        }
        if (j != -1) {
            return (int) (System.currentTimeMillis() - j);
        }
        return -1;
    }

    private void addTagsFromMonitorHook(JSONObject jSONObject, String str) {
        Map map;
        Map map2;
        Pair<Boolean, Map<String, Object>> pair;
        Map map3;
        IMonitorHook monitorHook = FrescoMonitor.getMonitorHook();
        if (monitorHook != null) {
            try {
                pair = monitorHook.onMonitorCompleted(null, null, null, jSONObject, true);
            } catch (Exception unused) {
                pair = null;
            }
            if (pair != null && (map3 = (Map) pair.second) != null) {
                try {
                    for (String str2 : map3.keySet()) {
                        jSONObject.put(str2, map3.get(str2));
                    }
                } catch (JSONException unused2) {
                }
            }
        }
        if (FrescoCacheMonitorUtil.isOptListenerAnr()) {
            Iterator<IMonitorHookV2> it = FrescoMonitor.sNewMonitorHookV2s.iterator();
            while (it.hasNext()) {
                Pair<Boolean, Map<String, Object>> onMonitorCompleted = it.next().onMonitorCompleted(null, null, null, jSONObject, true, false);
                if (onMonitorCompleted != null && (map2 = (Map) onMonitorCompleted.second) != null) {
                    try {
                        for (String str3 : map2.keySet()) {
                            jSONObject.put(str3, map2.get(str3));
                        }
                    } catch (JSONException unused3) {
                    }
                }
            }
        } else {
            synchronized (FrescoMonitor.sMonitorHookV2s) {
                Iterator<IMonitorHookV2> it2 = FrescoMonitor.sMonitorHookV2s.iterator();
                while (it2.hasNext()) {
                    Pair<Boolean, Map<String, Object>> onMonitorCompleted2 = it2.next().onMonitorCompleted(null, null, null, jSONObject, true, false);
                    if (onMonitorCompleted2 != null && (map = (Map) onMonitorCompleted2.second) != null) {
                        try {
                            for (String str4 : map.keySet()) {
                                jSONObject.put(str4, map.get(str4));
                            }
                        } catch (JSONException unused4) {
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(jSONObject.optString("biz_tag"))) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("biz_tag");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = parse.getQueryParameter(FrescoMonitorConst.URI_QUERY_PARAM_FROM);
            }
            if (queryParameter != null) {
                try {
                    jSONObject.put("biz_tag", queryParameter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
