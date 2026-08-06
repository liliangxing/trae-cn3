package com.ss.mediakit.image;

import android.net.Uri;
import android.util.Log;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ImageLoader {
    private static final String BIZ_TAG = "biz_tag";
    private static final long MAX_DELAY_MS = 5000;
    private static final int MDL_UD_MGR_OnInfoKey_READY = 0;
    private static final String SCENE_TAG = "sc";
    private static final String SOURCE_TAG = "s";
    static final String TAG = "Image.Loader";
    private static final ScheduledExecutorService sScheduledExecutorService = Executors.newScheduledThreadPool(4);
    private AVMDLDataLoader mInnerDataLoader = null;
    private LoaderConfig config = new LoaderConfig();
    private volatile int mdlready = 0;

    public int getBid(String str) {
        return 10030;
    }

    public static ImageLoader get() {
        return Holder.instance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class Holder {
        private static final ImageLoader instance = new ImageLoader();

        private Holder() {
        }
    }

    public void setInnerDataLoader(AVMDLDataLoader aVMDLDataLoader) {
        this.mInnerDataLoader = aVMDLDataLoader;
        AVMDLDataLoader aVMDLDataLoader2 = this.mInnerDataLoader;
        aVMDLDataLoader2.getClass();
        aVMDLDataLoader.setDownloaderCallback(new AVMDLDataLoader.MDLDownloaderCallback(aVMDLDataLoader2) { // from class: com.ss.mediakit.image.ImageLoader.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                aVMDLDataLoader2.getClass();
            }

            @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloaderCallback
            public int onInfos(int i, int i2, long j, String str) {
                if (i != -1 || i2 != 0) {
                    return 0;
                }
                Log.i(ImageLoader.TAG, "mdl ready");
                ImageLoader.this.mdlready = 1;
                return 0;
            }
        });
    }

    public AVMDLDataLoader getInnerDataLoader() {
        return this.mInnerDataLoader;
    }

    public void setConfigString(String str) {
        this.config.parse(str);
    }

    public LoaderConfig getConfig() {
        return this.config;
    }

    public boolean canFetchUri(Uri uri, Map<String, String> map) {
        if (this.mdlready == 0) {
            Log.e(TAG, "canFetchForUri: mdl not ready " + uri + ", params: " + map);
            return false;
        }
        Map<String, String> queryMap = getQueryMap(uri);
        Log.i(TAG, "canFetchForUri: " + queryMap + ", params: " + map);
        String str = queryMap.get("biz_tag");
        String str2 = queryMap.get(SCENE_TAG);
        String str3 = queryMap.get(SOURCE_TAG);
        boolean check = this.config.check(str, str2, str3);
        this.config.initTimeOut(str);
        Log.i(TAG, "biz: " + str + ", scene: " + str2 + ", source: " + str3 + ", ret: " + check);
        return check;
    }

    public static Map<String, String> getQueryMap(Uri uri) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            for (String str : uri.getQuery().split("&")) {
                int indexOf = str.indexOf("=");
                if (indexOf >= 0) {
                    linkedHashMap.put(URLDecoder.decode(str.substring(0, indexOf), HTTP.UTF_8), URLDecoder.decode(str.substring(indexOf + 1), HTTP.UTF_8));
                } else {
                    linkedHashMap.put(URLDecoder.decode(str, HTTP.UTF_8), "");
                }
            }
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            th.printStackTrace();
        }
        return linkedHashMap;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return sScheduledExecutorService;
    }

    public int getRetryCount(Map<String, String> map) {
        String str;
        if (!map.containsKey("task:retrycount") || (str = map.get("task:retrycount")) == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("无效的整数格式: " + str, e);
        }
    }

    public long getDelayMs(int i) {
        long baseDelayMs = this.config.getBaseDelayMs();
        for (int i2 = 0; i2 < i; i2++) {
            baseDelayMs *= 2;
        }
        return Math.min(baseDelayMs, MAX_DELAY_MS);
    }
}
