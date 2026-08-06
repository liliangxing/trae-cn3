package com.bytedance.webx.seclink.cache;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.request.CheckUrlResponse;
import com.bytedance.webx.seclink.util.Log;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.framework.common.BundleUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UrlSecLinkCache {
    private static final String KEY_VALID_TIME = "valid_time";
    private static final String TAG = "UrlSecLinkCache";
    private static long VALID_TIME;
    private static UrlSecLinkCache instance;
    private SharedPreferences sharedPreferences;
    private Map<String, UrlLinkCache> urlCacheMap = new ConcurrentHashMap();

    private UrlSecLinkCache() {
        SharedPreferences sharedPreferences = SecLinkFacade.getContext().getSharedPreferences("sec_config", 0);
        this.sharedPreferences = sharedPreferences;
        VALID_TIME = sharedPreferences.getLong(KEY_VALID_TIME, C0878a.f522h);
    }

    public static UrlSecLinkCache getInstance() {
        if (instance == null) {
            synchronized (UrlSecLinkCache.class) {
                if (instance == null) {
                    instance = new UrlSecLinkCache();
                }
            }
        }
        return instance;
    }

    public void setValidTime(long j) {
        if (j >= 0 && j != VALID_TIME) {
            VALID_TIME = j;
            this.sharedPreferences.edit().putLong(KEY_VALID_TIME, j).apply();
        }
    }

    public void saveCache(String str, String str2, CheckUrlResponse checkUrlResponse) {
        try {
            this.urlCacheMap.put(buildCacheKey(str, str2), new UrlLinkCache(checkUrlResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String buildCacheKey(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(BundleUtil.UNDERLINE_TAG).append(str2);
        return sb.toString();
    }

    private void remove(String str) {
        try {
            this.urlCacheMap.remove(str);
            this.urlCacheMap.remove(str + "/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValid(String str) {
        return isValidInner(str) || (str.length() > 0 ? isValidInner(str.substring(0, str.length() - 1)) : false) || isValidInner(new StringBuilder().append(str).append("/").toString());
    }

    private boolean isValidInner(String str) {
        UrlLinkCache urlLinkCache = this.urlCacheMap.get(str);
        if (urlLinkCache == null) {
            return false;
        }
        if (System.currentTimeMillis() - urlLinkCache.createTime <= VALID_TIME) {
            return true;
        }
        Log.m51i(TAG, "UrlSecLinkCache url : " + str + " exceed the time limit.");
        remove(str);
        return false;
    }

    public CheckUrlResponse getValidCache(String str, String str2) {
        UrlLinkCache urlLinkCache;
        String buildCacheKey = buildCacheKey(str, str2);
        try {
            if (!isValid(buildCacheKey)) {
                return null;
            }
            UrlLinkCache urlLinkCache2 = this.urlCacheMap.get(buildCacheKey);
            if (urlLinkCache2 == null) {
                if (buildCacheKey.length() > 0) {
                    UrlLinkCache urlLinkCache3 = this.urlCacheMap.get(buildCacheKey.substring(0, buildCacheKey.length() - 1));
                    if (urlLinkCache3 != null) {
                        return urlLinkCache3.checkUrlResponse;
                    }
                }
                if (buildCacheKey.length() <= 0 || (urlLinkCache = this.urlCacheMap.get(buildCacheKey + "/")) == null) {
                    return null;
                }
                return urlLinkCache.checkUrlResponse;
            }
            return urlLinkCache2.checkUrlResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class UrlLinkCache {
        private CheckUrlResponse checkUrlResponse;
        private long createTime = System.currentTimeMillis();

        UrlLinkCache(CheckUrlResponse checkUrlResponse) {
            this.checkUrlResponse = checkUrlResponse;
        }
    }
}
