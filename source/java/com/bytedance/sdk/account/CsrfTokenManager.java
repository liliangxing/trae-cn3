package com.bytedance.sdk.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.account.utils.Utils;
import com.ss.android.token.TTTokenManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CsrfTokenManager {
    public static final String PASSPORT_CSRF_TOKEN_DEFAULT_KEY_KEY = "passport_csrf_token_default";
    public static final String PASSPORT_CSRF_TOKEN_KEY_KEY = "passport_csrf_token";
    public static final String SP_KEY_CSRF_TOKEN = "csrf_token";
    public static final String SP_NAME = "CsrfTokenManager_sp";
    private static String csrfToken;
    private static volatile boolean isInited;

    /* renamed from: sp */
    private static SharedPreferences f0sp;

    public static void tryInit() {
        if (isInited) {
            return;
        }
        synchronized (CsrfTokenManager.class) {
            if (!isInited) {
                Context applicationContext = TTTokenManager.getApplicationContext();
                if (applicationContext == null) {
                    return;
                }
                SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(SP_NAME, 0);
                f0sp = sharedPreferences;
                csrfToken = sharedPreferences.getString(SP_KEY_CSRF_TOKEN, null);
                isInited = true;
            }
        }
    }

    public static void setCsrfToken(String str) {
        tryInit();
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, csrfToken)) {
            return;
        }
        csrfToken = str;
        f0sp.edit().putString(SP_KEY_CSRF_TOKEN, str).apply();
    }

    public static Pair<Integer, String> getCsrfToken(String str) {
        int i;
        String csrfTokenFromCookie = getCsrfTokenFromCookie(str);
        if (TextUtils.isEmpty(csrfTokenFromCookie)) {
            csrfTokenFromCookie = getCsrfTokenFromSp();
            i = !TextUtils.isEmpty(csrfTokenFromCookie) ? -2 : 0;
        } else {
            i = 1;
        }
        return new Pair<>(Integer.valueOf(i), csrfTokenFromCookie);
    }

    public static String getCsrfTokenFromCookie(String str) {
        String specialCookieInfo = Utils.getSpecialCookieInfo(str, "passport_csrf_token");
        return TextUtils.isEmpty(specialCookieInfo) ? Utils.getSpecialCookieInfo(str, "passport_csrf_token_default") : specialCookieInfo;
    }

    public static String getCsrfTokenFromSp() {
        tryInit();
        return csrfToken;
    }

    public static boolean getCsrfTokenStatus() {
        tryInit();
        return !TextUtils.isEmpty(csrfToken);
    }

    public static String getCsrfTokenLocation() {
        boolean z = !TextUtils.isEmpty(getCsrfTokenFromSp());
        boolean z2 = !TextUtils.isEmpty(getCsrfTokenFromCookie(TTTokenManager.getHost()));
        return (z && z2) ? "both" : z ? "sp" : z2 ? "cookie" : "none";
    }
}
