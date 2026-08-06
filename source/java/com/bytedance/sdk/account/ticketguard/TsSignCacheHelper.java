package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.token.TTTokenManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TsSignCacheHelper {
    private static final String SP_NAME = "account_sdk_ts_sign_cache";
    private static SharedPreferences mSp;

    public static void saveTsSign(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = getEditor()) == null) {
            return;
        }
        editor.putString(str, str2).apply();
    }

    public static String getTsSign(String str) {
        SharedPreferences sp;
        if (TextUtils.isEmpty(str) || (sp = getSp()) == null) {
            return null;
        }
        return sp.getString(str, "");
    }

    public static void remove(String str) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = getEditor()) == null) {
            return;
        }
        editor.remove(str).apply();
    }

    private static SharedPreferences getSp() {
        Context applicationContext;
        if (mSp == null && (applicationContext = TTTokenManager.getApplicationContext()) != null) {
            mSp = applicationContext.getSharedPreferences(SP_NAME, 0);
        }
        return mSp;
    }

    private static SharedPreferences.Editor getEditor() {
        SharedPreferences sp = getSp();
        if (sp != null) {
            return sp.edit();
        }
        return null;
    }
}
