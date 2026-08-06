package com.bytedance.frameworks.baselib.network.config;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.Headers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class InsecureRequestControlConfig {
    private static final String DISABLE_SHARE_INSECURE_COOKIE_KEY = "disable_share_insecure_cookie";
    private static final String INSECURE_REQUEST_CONTROL_KEY = "insecure_request_control";
    private static final String SECRET_COOKIE_LIST_KEY = "secret_cookie_list";
    private static final String SECRET_HEADER_LIST_KEY = "secret_header_list";
    private static volatile boolean sDisableShareInsecureCookie;
    private static final CopyOnWriteArraySet<String> sSecretCookieSet = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<String> sSecretHeaderSet = new CopyOnWriteArraySet<>();

    public static boolean isDisableShareInsecureCookie() {
        return sDisableShareInsecureCookie;
    }

    public static Set<String> getInSecureCookies(List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = sSecretCookieSet;
        if (copyOnWriteArraySet.isEmpty() || list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (String str : list) {
                if (str != null && str.contains(next + ContainerUtils.KEY_VALUE_DELIMITER)) {
                    hashSet.add(next);
                }
            }
        }
        if (hashSet.size() > 0) {
            return hashSet;
        }
        return null;
    }

    public static Set<String> getInsecureHeaders(Headers headers) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = sSecretHeaderSet;
        if (copyOnWriteArraySet.isEmpty() || headers == null || headers.size() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (headers.get(next) != null) {
                hashSet.add(next);
            }
        }
        if (hashSet.size() > 0) {
            return hashSet;
        }
        return null;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        resetTncConfig();
        JSONObject optJSONObject = jSONObject.optJSONObject(INSECURE_REQUEST_CONTROL_KEY);
        if (optJSONObject == null) {
            return;
        }
        sDisableShareInsecureCookie = optJSONObject.optInt(DISABLE_SHARE_INSECURE_COOKIE_KEY, 0) > 0;
        parseArraySetStringConfig(optJSONObject.optJSONArray(SECRET_COOKIE_LIST_KEY), sSecretCookieSet);
        parseArraySetStringConfig(optJSONObject.optJSONArray(SECRET_HEADER_LIST_KEY), sSecretHeaderSet);
    }

    private static void resetTncConfig() {
        sDisableShareInsecureCookie = false;
        sSecretCookieSet.clear();
        sSecretHeaderSet.clear();
    }

    private static void parseArraySetStringConfig(JSONArray jSONArray, CopyOnWriteArraySet<String> copyOnWriteArraySet) {
        if (jSONArray == null || copyOnWriteArraySet == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArraySet.add(string);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }
}
