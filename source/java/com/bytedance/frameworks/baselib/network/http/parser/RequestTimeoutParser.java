package com.bytedance.frameworks.baselib.network.http.parser;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RequestTimeoutParser {
    private static final String CONNECT_TIMEOUT = "conn_to";
    private static final String HOST_KEY_EQ = "host_eq";
    private static final String HOST_KEY_WC = "host_wc";
    private static final String PATH_KEY_CONTAIN = "path_contain";
    private static final String PATH_KEY_EQ = "path_eq";
    private static final String PATH_KEY_PATTERN = "path_pattern";
    private static final String PATH_KEY_PREFIX = "path_prefix";
    private static final String PROTECT_TIMEOUT = "pro_to";
    private static final String READ_TIMEOUT = "read_to";
    private static final String TIMEOUT_CONFIG_ENABLE = "enabled";
    private static final String TIMEOUT_CONFIG_KEY = "to_config_v1";
    private static final String TIMEOUT_CONFIG_RULE_LIST = "rule_list";
    private static final int TYPE_HOST_EQ = 1;
    private static final int TYPE_HOST_NONE = 0;
    private static final int TYPE_HOST_WC = 2;
    private static final int TYPE_PATH_CONTAIN = 5;
    private static final int TYPE_PATH_EQ = 3;
    private static final int TYPE_PATH_PATTERN = 6;
    private static final int TYPE_PATH_PREFIX = 4;
    private static final String VALUE = "value";
    private static final String WRITE_TIMEOUT = "write_to";
    private static Lock sReadLock;
    private static ReentrantReadWriteLock sReadWriteLock;
    private static JSONObject sTimeoutConfigData;
    private static Lock sWriteLock;

    /* loaded from: classes2.dex */
    public static class SocketTimeoutParam {
        public int connectTimeout;
        public int readTimeout;
        public int writeTimeout;
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        sReadWriteLock = reentrantReadWriteLock;
        sReadLock = reentrantReadWriteLock.readLock();
        sWriteLock = sReadWriteLock.writeLock();
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            sWriteLock.lock();
            sTimeoutConfigData = jSONObject.optJSONObject(TIMEOUT_CONFIG_KEY);
        } finally {
            sWriteLock.unlock();
        }
    }

    public static int getRequestTimeout(URL url, SocketTimeoutParam socketTimeoutParam) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        int i;
        JSONArray jSONArray;
        int i2;
        JSONObject optJSONObject;
        if (url == null) {
            return -1;
        }
        try {
            sReadLock.lock();
            jSONObject = sTimeoutConfigData;
        } catch (Throwable unused) {
        }
        if (jSONObject != null) {
            if ((jSONObject.optInt(TIMEOUT_CONFIG_ENABLE, 0) > 0) && (optJSONArray = sTimeoutConfigData.optJSONArray(TIMEOUT_CONFIG_RULE_LIST)) != null && optJSONArray.length() != 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        JSONArray jSONArray2 = null;
                        if (optJSONObject2.has(HOST_KEY_EQ)) {
                            jSONArray = optJSONObject2.optJSONArray(HOST_KEY_EQ);
                            i = 1;
                        } else if (optJSONObject2.has(HOST_KEY_WC)) {
                            jSONArray = optJSONObject2.optJSONArray(HOST_KEY_WC);
                            i = 2;
                        } else {
                            i = 0;
                            jSONArray = null;
                        }
                        if (jSONArray != null && hitRule(url.getHost(), jSONArray, i)) {
                            if (optJSONObject2.has(PATH_KEY_EQ)) {
                                jSONArray2 = optJSONObject2.optJSONArray(PATH_KEY_EQ);
                                i2 = 3;
                            } else if (optJSONObject2.has(PATH_KEY_PREFIX)) {
                                jSONArray2 = optJSONObject2.optJSONArray(PATH_KEY_PREFIX);
                                i2 = 4;
                            } else if (optJSONObject2.has(PATH_KEY_CONTAIN)) {
                                jSONArray2 = optJSONObject2.optJSONArray(PATH_KEY_CONTAIN);
                                i2 = 5;
                            } else if (optJSONObject2.has(PATH_KEY_PATTERN)) {
                                jSONArray2 = optJSONObject2.optJSONArray(PATH_KEY_PATTERN);
                                i2 = 6;
                            } else {
                                i2 = 0;
                            }
                            if (jSONArray2 != null && hitRule(url.getPath(), jSONArray2, i2) && (optJSONObject = optJSONObject2.optJSONObject("value")) != null) {
                                socketTimeoutParam.connectTimeout = optJSONObject.optInt(CONNECT_TIMEOUT, -1);
                                socketTimeoutParam.readTimeout = optJSONObject.optInt(READ_TIMEOUT, -1);
                                socketTimeoutParam.writeTimeout = optJSONObject.optInt(WRITE_TIMEOUT, -1);
                                int optInt = optJSONObject.optInt(PROTECT_TIMEOUT, -1);
                                sReadLock.unlock();
                                return optInt;
                            }
                        }
                    }
                }
                sReadLock.unlock();
                return -1;
            }
        }
        sReadLock.unlock();
        return -1;
    }

    private static boolean hitRule(String str, JSONArray jSONArray, int i) {
        if (str != null && !str.isEmpty() && jSONArray != null && jSONArray.length() != 0) {
            try {
                switch (i) {
                    case 1:
                    case 3:
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String optString = jSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString) && str.equals(optString)) {
                                return true;
                            }
                        }
                        return false;
                    case 2:
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            String optString2 = jSONArray.optString(i3);
                            if (!TextUtils.isEmpty(optString2) && UrlUtils.matchPattern(str, optString2)) {
                                return true;
                            }
                        }
                        return false;
                    case 4:
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            String optString3 = jSONArray.optString(i4);
                            if (!TextUtils.isEmpty(optString3) && str.startsWith(optString3)) {
                                return true;
                            }
                        }
                        return false;
                    case 5:
                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                            String optString4 = jSONArray.optString(i5);
                            if (!TextUtils.isEmpty(optString4) && str.contains(optString4)) {
                                return true;
                            }
                        }
                        return false;
                    case 6:
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            String optString5 = jSONArray.optString(i6);
                            if (!TextUtils.isEmpty(optString5) && str.matches(optString5)) {
                                return true;
                            }
                        }
                        return false;
                    default:
                        return false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
