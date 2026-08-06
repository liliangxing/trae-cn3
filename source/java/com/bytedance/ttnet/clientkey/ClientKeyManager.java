package com.bytedance.ttnet.clientkey;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.TTReportAllLog;
import com.bytedance.ttnet.config.JsonOptConfig;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClientKeyManager {
    private static final String CLIENT_KEY_CONFIG_FILE_NAME = "ttnet_client_key_config";
    private static final String CLIENT_KEY_CONFIG_NAME = "client_key_config";
    private static final String CLIENT_KEY_NAME = "client_key";
    private static final String CLIENT_KEY_REQUEST_HEADER_NAME = "x-bd-client-key";
    private static final String CLIENT_KEY_RESPONSE_HEADER_NAME = "x-bd-lanusk";
    private static final String HEADER_SPLIT_STRING = "\r\n";
    private static final String KMS_VERSION_NAME = "kms_version";
    private static final String KMS_VERSION_REQUEST_HEADER_NAME = "x-bd-kmsv";
    private static final String KMS_VERSION_RESPONSE_HEADER_NAME = "x-bd-lanusv";
    private static final String MAX_AGE_NAME = "Max-Age=";
    private static final int RESPONSE_CLIENT_KEY_DEFAULT = 0;
    private static final int RESPONSE_CLIENT_KEY_INVALID = 1;
    private static final int RESPONSE_CLIENT_KEY_NULL = 3;
    private static final int RESPONSE_CLIENT_KEY_SAME_NULL = 2;
    private static final String SESSION_ID_NAME = "session_id";
    private static final String SESSION_TIME_NAME = "session_time";
    private static final String SESSION_URL_NAME = "session_url";
    private static final String TAG = "ClientKeyManager";
    private static volatile boolean mClientKeySignEnabled = false;
    private static Keva mKevaStorage = null;
    private static Map<String, String> sClientKeyHeaders = null;
    private static volatile ClientKeyManager sInstance = null;
    private static boolean sIsMainProcess = true;
    private List<String> mUpdateHostList = new CopyOnWriteArrayList();
    private List<String> mUpdatePathList = new CopyOnWriteArrayList();
    private String mClientKey = "";
    private String mSessionId = "";
    private String mSessionUrl = "";
    private String mKmsVersion = "";
    private boolean mRewriteSessionEnabled = true;

    public static ClientKeyManager inst() {
        if (sInstance == null) {
            synchronized (ClientKeyManager.class) {
                if (sInstance == null) {
                    sInstance = new ClientKeyManager();
                }
            }
        }
        return sInstance;
    }

    private ClientKeyManager() {
    }

    public void InitClientKeyAndSessionInfo(boolean z) {
        sIsMainProcess = z;
        try {
            mKevaStorage = Keva.getRepo(CLIENT_KEY_CONFIG_FILE_NAME, 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Keva keva = mKevaStorage;
        if (keva == null) {
            return;
        }
        String string = keva.getString(CLIENT_KEY_CONFIG_NAME, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                ParseClientKeyConfig(new JSONObject(string));
            } catch (Throwable unused) {
            }
        }
        if (mClientKeySignEnabled) {
            String string2 = mKevaStorage.getString("session_id", "");
            long j = mKevaStorage.getLong(SESSION_TIME_NAME, 0L);
            this.mSessionUrl = mKevaStorage.getString(SESSION_URL_NAME, "");
            this.mClientKey = mKevaStorage.getString(CLIENT_KEY_NAME, "");
            String string3 = mKevaStorage.getString(KMS_VERSION_NAME, "");
            this.mKmsVersion = string3;
            sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, string3);
            if (string2.isEmpty() || this.mSessionUrl.isEmpty()) {
                return;
            }
            String[] split = string2.split(";");
            if (split != null && split.length > 0) {
                this.mSessionId = split[0].trim();
            }
            if (TextUtils.isEmpty(this.mSessionId)) {
                return;
            }
            String ReplaceMaxAgeTime = ReplaceMaxAgeTime(split, j, string2);
            if (!TextUtils.isEmpty(ReplaceMaxAgeTime)) {
                string2 = ReplaceMaxAgeTime;
            }
            if (Logger.debug()) {
                Logger.d(TAG, "client key: " + this.mClientKey + " | kms version: " + this.mKmsVersion + " | session cookie: " + string2 + " | sessionid: " + this.mSessionId + " | session time: " + j + " session url: " + this.mSessionUrl + " config: " + string);
            }
            UpdateCookieInfo(string2);
        }
    }

    private static String ReplaceMaxAgeTime(String[] strArr, long j, String str) {
        String[] strArr2;
        String str2;
        if (strArr != null && strArr.length >= 2) {
            long j2 = 0;
            if (j > 0) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        strArr2 = null;
                        str2 = null;
                        break;
                    }
                    str2 = strArr[i];
                    if (!TextUtils.isEmpty(str2) && str2.toLowerCase().trim().startsWith(MAX_AGE_NAME.toLowerCase())) {
                        strArr2 = str2.split("=");
                        break;
                    }
                    i++;
                }
                if (strArr2 != null && strArr2.length == 2) {
                    try {
                        long parseLong = Long.parseLong(strArr2[1]);
                        if (parseLong <= 0) {
                            return null;
                        }
                        long currentTimeMillis = parseLong - ((System.currentTimeMillis() - j) / 1000);
                        if (currentTimeMillis > 0) {
                            j2 = currentTimeMillis;
                        }
                        return str.replaceFirst(str2.trim(), MAX_AGE_NAME + j2);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return null;
    }

    private void UpdateCookieInfo(String str) {
        Map<String, List<String>> map;
        CookieHandler cookieHandler = CookieHandler.getDefault();
        if (cookieHandler == null) {
            return;
        }
        try {
            URI safeCreateUri = URIUtils.safeCreateUri(this.mSessionUrl);
            if (safeCreateUri == null || (map = cookieHandler.get(safeCreateUri, null)) == null || map.isEmpty() || !map.containsKey("Cookie")) {
                return;
            }
            String obj = map.get("Cookie").toString();
            if (Logger.debug()) {
                Logger.d(TAG, "cookieStr: " + obj + " sessionId: " + this.mSessionId);
            }
            if (!TextUtils.isEmpty(obj)) {
                if (obj.contains(this.mSessionId)) {
                    return;
                }
                refreshSessionCookie(str, cookieHandler, safeCreateUri);
                SendCookieMismatchLog(obj, str);
                return;
            }
            refreshSessionCookie(str, cookieHandler, safeCreateUri);
            SendCookieMismatchLog("empty", str);
        } catch (Throwable unused) {
        }
    }

    private void refreshSessionCookie(String str, CookieHandler cookieHandler, URI uri) throws IOException {
        if (this.mRewriteSessionEnabled) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            linkedHashMap.put("Set-Cookie", arrayList);
            cookieHandler.put(uri, linkedHashMap);
            if (Logger.debug()) {
                Logger.d(TAG, "Refresh session cookie: " + str);
            }
        }
    }

    private void SendCookieMismatchLog(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("report_time", System.currentTimeMillis() + "");
            jSONObject.put("cookie_line", str);
            jSONObject.put("session_id", str2);
            jSONObject.put("url", this.mSessionUrl);
            TTReportAllLog.reportInternalAllLog("cookie_mismatch", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void AddClientKeyHeader(List<Header> list, RetrofitMetrics retrofitMetrics) {
        if (mKevaStorage == null || !mClientKeySignEnabled || TextUtils.isEmpty(this.mClientKey) || TextUtils.isEmpty(this.mKmsVersion)) {
            return;
        }
        if (retrofitMetrics != null) {
            retrofitMetrics.addClientKeyStart();
        }
        list.add(new Header(CLIENT_KEY_REQUEST_HEADER_NAME, this.mClientKey));
        list.add(new Header(KMS_VERSION_REQUEST_HEADER_NAME, this.mKmsVersion));
        if (retrofitMetrics != null) {
            retrofitMetrics.addClientKeyEnd();
        }
    }

    public synchronized void UpdateClientKeyAndSessionInfo(Request request, Response response) {
        if (mKevaStorage != null && mClientKeySignEnabled) {
            if (request.getMetrics() != null) {
                request.getMetrics().updateClientKeyStart();
            }
            try {
                UpdateClientKeyAndSessionInfoInner(request, response);
            } finally {
                if (request.getMetrics() != null) {
                    request.getMetrics().updateClientKeyEnd();
                }
            }
        }
    }

    private void UpdateClientKeyAndSessionInfoInner(Request request, Response response) {
        URI uri;
        boolean z;
        String str;
        int i;
        String str2;
        String str3;
        boolean z2;
        try {
            uri = URIUtils.safeCreateUri(request.getUrl());
        } catch (Throwable unused) {
            uri = null;
        }
        if (uri == null) {
            return;
        }
        if (!this.mUpdateHostList.isEmpty()) {
            Iterator<String> it = this.mUpdateHostList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                } else {
                    if (UrlUtils.matchPattern(uri.getHost(), it.next())) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (!z2) {
                return;
            }
        }
        if (!this.mUpdatePathList.isEmpty()) {
            Iterator<String> it2 = this.mUpdatePathList.iterator();
            while (it2.hasNext()) {
                if (UrlUtils.matchPattern(uri.getPath(), it2.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            List<Header> headers = response.headers("Set-Cookie");
            if (headers != null && !headers.isEmpty()) {
                Iterator<Header> it3 = headers.iterator();
                while (it3.hasNext()) {
                    String trim = it3.next().getValue().trim();
                    if (trim.toLowerCase().startsWith("sessionid=")) {
                        str = trim;
                        break;
                    }
                }
            }
            str = "";
            String[] split = str.split(";");
            String trim2 = (split == null || split.length <= 0) ? "" : split[0].trim();
            if (TextUtils.isEmpty(trim2)) {
                return;
            }
            if (Logger.debug()) {
                Logger.d(TAG, "original sessionid: " + this.mSessionId + " new sessionid: " + trim2);
            }
            Header firstHeader = response.getFirstHeader(CLIENT_KEY_RESPONSE_HEADER_NAME);
            Header firstHeader2 = response.getFirstHeader(KMS_VERSION_RESPONSE_HEADER_NAME);
            if (firstHeader != null && firstHeader2 != null) {
                String value = firstHeader.getValue();
                String value2 = firstHeader2.getValue();
                if (TextUtils.isEmpty(value) || TextUtils.isEmpty(value2)) {
                    i = 1;
                    str3 = "";
                    str2 = str3;
                } else {
                    str3 = value;
                    i = 0;
                    str2 = value2;
                }
            } else if (trim2.equals(this.mSessionId)) {
                String str4 = this.mClientKey;
                str2 = this.mKmsVersion;
                i = 2;
                str3 = str4;
            } else {
                i = 3;
                str3 = "";
                str2 = str3;
            }
            if (i != 0) {
                try {
                    reportClientKeyLog(i, this.mSessionId, trim2, this.mClientKey, str3, this.mKmsVersion, str2, response, uri.getPath());
                } catch (Throwable unused2) {
                }
            }
            this.mClientKey = str3;
            this.mKmsVersion = str2;
            String url = request.getUrl();
            this.mSessionUrl = url;
            this.mSessionId = trim2;
            mKevaStorage.storeString(SESSION_URL_NAME, url);
            mKevaStorage.storeString("session_id", str);
            mKevaStorage.storeString(CLIENT_KEY_NAME, this.mClientKey);
            mKevaStorage.storeString(KMS_VERSION_NAME, this.mKmsVersion);
            mKevaStorage.storeLong(SESSION_TIME_NAME, System.currentTimeMillis());
            sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, this.mKmsVersion);
            if (Logger.debug()) {
                Logger.d(TAG, "save session url: " + this.mSessionUrl + " session cookie: " + str + " client key: " + this.mClientKey + " kms version: " + this.mKmsVersion);
            }
        }
    }

    private static String appendHeaderString(Response response, String str) {
        Header firstHeader = response.getFirstHeader(str);
        if (firstHeader == null) {
            return "";
        }
        return ("" + firstHeader.toString()) + "; ";
    }

    private void reportClientKeyLog(int i, String str, String str2, String str3, String str4, String str5, String str6, Response response, String str7) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("origin_sid", str);
        jSONObject.put("sid", str2);
        jSONObject.put("origin_key", str3);
        jSONObject.put("key", str4);
        jSONObject.put("origin_kms", str5);
        jSONObject.put("kms", str6);
        if (response != null) {
            String str8 = ((appendHeaderString(response, "x-tt-token") + appendHeaderString(response, "x-tt-logid")) + appendHeaderString(response, CLIENT_KEY_RESPONSE_HEADER_NAME)) + appendHeaderString(response, KMS_VERSION_RESPONSE_HEADER_NAME);
            if (!TextUtils.isEmpty(str8)) {
                jSONObject.put("headers", str8);
            }
        }
        TTReportAllLog.reportInternalAllLog(CLIENT_KEY_NAME, jSONObject, i, str7);
    }

    private void ParseClientKeyConfig(JSONObject jSONObject) throws Exception {
        mClientKeySignEnabled = jSONObject.optInt("client_key_sign_enabled", 0) > 0;
        if (!mClientKeySignEnabled) {
            if (Logger.debug()) {
                Logger.d(TAG, "clear client key storage.");
            }
            mKevaStorage.clear();
            return;
        }
        this.mRewriteSessionEnabled = jSONObject.optInt("rewrite_session_enabled", 1) > 0;
        this.mUpdateHostList.clear();
        String optString = jSONObject.optString("update_host_list", null);
        if (!TextUtils.isEmpty(optString)) {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    this.mUpdateHostList.add(string);
                }
            }
        }
        this.mUpdatePathList.clear();
        String optString2 = jSONObject.optString("update_path_list", null);
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        JSONArray jSONArray2 = new JSONArray(optString2);
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            String string2 = jSONArray2.getString(i2);
            if (!TextUtils.isEmpty(string2)) {
                this.mUpdatePathList.add(string2);
            }
        }
    }

    public void OnNetConfigChanged(Object obj) {
        if (mKevaStorage != null && JsonOptConfig.isValid(obj)) {
            try {
                JSONObject jsonObject = JsonOptConfig.jsonObject(obj);
                JSONObject optJSONObject = jsonObject != null ? jsonObject.getJSONObject("data").optJSONObject(CLIENT_KEY_CONFIG_NAME) : null;
                if (optJSONObject == null) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "clear client key storage.");
                    }
                    mClientKeySignEnabled = false;
                    mKevaStorage.clear();
                    return;
                }
                String jSONObject = optJSONObject.toString();
                if (Logger.debug()) {
                    Logger.d(TAG, "config: " + jSONObject);
                }
                mKevaStorage.storeString(CLIENT_KEY_CONFIG_NAME, jSONObject);
                ParseClientKeyConfig(optJSONObject);
            } catch (Throwable unused) {
            }
        }
    }

    private static Map<String, String> constructClientKeyHeaders(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CLIENT_KEY_REQUEST_HEADER_NAME, str);
        hashMap.put(KMS_VERSION_REQUEST_HEADER_NAME, str2);
        return hashMap;
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (mKevaStorage == null || !mClientKeySignEnabled) {
            return null;
        }
        if (sIsMainProcess) {
            return sClientKeyHeaders;
        }
        return constructClientKeyHeaders(mKevaStorage.getString(CLIENT_KEY_NAME, ""), mKevaStorage.getString(KMS_VERSION_NAME, ""));
    }
}
