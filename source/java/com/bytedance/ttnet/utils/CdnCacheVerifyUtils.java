package com.bytedance.ttnet.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CdnCacheVerifyUtils {
    private static final String HEADER_VERIFY_KEY = "X-TT-VERIFY-ID";
    public static final String KEY_TTNET_RESPONSE_VERIFY = "ttnet_response_verify";
    public static final String KEY_TTNET_RESPONSE_VERIFY_ENABLED = "ttnet_response_verify_enabled";
    private static final String TAG = "CDN_CACHE_VERIFY";
    public static final int VERIFY_ACCESSIBLE = 1;
    public static final int VERIFY_FAIL = 3;
    public static final int VERIFY_SUCCESS = 2;
    public static final int VERIFY_UNDEFINED = -1;
    private static volatile boolean sEnabled;
    private static Lock sReadLock;
    private static ReentrantReadWriteLock sReadWriteLock;
    private static List<Regex> sRegexArray = new ArrayList();
    private static Lock sWriteLock;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class CdnCacheVerifyConfig {
        public int ttnetResponseVerifyEnabled;
        public String verifyRegexsStr;
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        sReadWriteLock = reentrantReadWriteLock;
        sReadLock = reentrantReadWriteLock.readLock();
        sWriteLock = sReadWriteLock.writeLock();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Regex {
        private Pattern pattern;

        public boolean matcher(URI uri) {
            if (uri != null && !TextUtils.isEmpty(uri.getHost()) && this.pattern != null) {
                String host = uri.getHost();
                if (!TextUtils.isEmpty(uri.getPath())) {
                    host = host + uri.getPath();
                }
                try {
                    return this.pattern.matcher(host).matches();
                } catch (IllegalArgumentException unused) {
                }
            }
            return false;
        }

        public boolean setPattern(String str) {
            try {
                this.pattern = Pattern.compile(str);
                return true;
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static void preProcessing(String str, List<Header> list, RetrofitMetrics retrofitMetrics) {
        if (sEnabled) {
            if (retrofitMetrics != null) {
                retrofitMetrics.preCdnCacheVerifyStart();
            }
            try {
                preProcessingImpl(str, list);
            } finally {
                if (retrofitMetrics != null) {
                    retrofitMetrics.preCdnCacheVerifyEnd();
                }
            }
        }
    }

    public static void postProcessing(Request request, Response response, HttpRequestInfo httpRequestInfo) throws IOException {
        if (sEnabled) {
            if (httpRequestInfo == null) {
                Logger.w(TAG, "Req info is null");
            } else {
                postProcessingImpl(request, response, httpRequestInfo);
            }
        }
    }

    private static void preProcessingImpl(String str, List<Header> list) {
        try {
            String cdnCacheVerifyValue = getCdnCacheVerifyValue(URIUtils.safeCreateUri(str));
            if (TextUtils.isEmpty(cdnCacheVerifyValue)) {
                return;
            }
            list.add(new Header(HEADER_VERIFY_KEY, cdnCacheVerifyValue));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String getCdnCacheVerifyValue(URI uri) {
        if (filterRule(uri)) {
            return generateVerifyValue();
        }
        return null;
    }

    private static boolean filterRule(URI uri) {
        try {
            sReadLock.lock();
            Iterator<Regex> it = sRegexArray.iterator();
            while (it.hasNext()) {
                if (it.next().matcher(uri)) {
                    sReadLock.unlock();
                    return true;
                }
            }
            sReadLock.unlock();
            return false;
        } catch (Throwable th) {
            sReadLock.unlock();
            throw th;
        }
    }

    private static String generateVerifyValue() {
        return UUID.randomUUID().toString();
    }

    private static void postProcessingImpl(Request request, Response response, HttpRequestInfo httpRequestInfo) throws IOException {
        Header firstHeader = request.getFirstHeader(HEADER_VERIFY_KEY);
        String value = firstHeader != null ? firstHeader.getValue() : null;
        Header firstHeader2 = response.getFirstHeader(HEADER_VERIFY_KEY);
        String value2 = firstHeader2 != null ? firstHeader2.getValue() : null;
        if (value != null) {
            if (value2 == null) {
                httpRequestInfo.cdnVerifyValue = 1;
                Logger.w(TAG, "Cdn cache verify accessible");
            } else if (value.equals(value2)) {
                httpRequestInfo.cdnVerifyValue = 2;
                Logger.w(TAG, "Cdn cache verify success");
            } else {
                httpRequestInfo.cdnVerifyValue = 3;
                Logger.w(TAG, "Cdn cache verify fail");
                try {
                    response.getBody().mo349in().close();
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.w(TAG, "Cdn cache verify stream close fail:" + th.toString());
                }
            }
            RequestTicketUtil.ICdnCacheVerifyCallback cdnCacheVerifyProcessor = RequestTicketUtil.getCdnCacheVerifyProcessor();
            if (cdnCacheVerifyProcessor != null) {
                if (request.getMetrics() != null) {
                    request.getMetrics().postCdnCacheVerifyStart();
                }
                try {
                    cdnCacheVerifyProcessor.onCallback(request.getUrl(), httpRequestInfo);
                } finally {
                    if (request.getMetrics() != null) {
                        request.getMetrics().postCdnCacheVerifyEnd();
                    }
                }
            }
            if (httpRequestInfo.cdnVerifyValue == 3) {
                throw new CdnCacheVerifyException("Fail to verify cdn cache");
            }
        }
    }

    public static void onLocalConfigUpdate(SharedPreferences sharedPreferences) {
        JSONArray jSONArray;
        int i = sharedPreferences.getInt(KEY_TTNET_RESPONSE_VERIFY_ENABLED, -1);
        String string = sharedPreferences.getString(KEY_TTNET_RESPONSE_VERIFY, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONArray = new JSONArray(string);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            resolveCdnCacheVerify(i, jSONArray);
        }
        jSONArray = null;
        resolveCdnCacheVerify(i, jSONArray);
    }

    public static CdnCacheVerifyConfig onServerConfigUpdate(JSONObject jSONObject) {
        int optInt = jSONObject.optInt(KEY_TTNET_RESPONSE_VERIFY_ENABLED, -1);
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_TTNET_RESPONSE_VERIFY);
        String jSONArray = optJSONArray != null ? optJSONArray.toString() : "";
        resolveCdnCacheVerify(optInt, optJSONArray);
        CdnCacheVerifyConfig cdnCacheVerifyConfig = new CdnCacheVerifyConfig();
        cdnCacheVerifyConfig.ttnetResponseVerifyEnabled = optInt;
        cdnCacheVerifyConfig.verifyRegexsStr = jSONArray;
        return cdnCacheVerifyConfig;
    }

    private static void resolveCdnCacheVerify(int i, JSONArray jSONArray) {
        if (i > 0) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        Regex regex = new Regex();
                        if (regex.setPattern(optString)) {
                            arrayList.add(regex);
                        }
                    }
                }
                setRegexArray(arrayList);
            }
            setEnabled(true);
            return;
        }
        setEnabled(false);
    }

    public static void setEnabled(boolean z) {
        sEnabled = z;
    }

    public static void setRegexArray(List<Regex> list) {
        try {
            sWriteLock.lock();
            sRegexArray = list;
        } finally {
            sWriteLock.unlock();
        }
    }
}
