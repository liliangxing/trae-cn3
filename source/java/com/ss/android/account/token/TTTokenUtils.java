package com.ss.android.account.token;

import android.text.TextUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.sdk.account.utils.Utils;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.LogHelper;
import com.ss.android.token.TTTokenHeader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTTokenUtils {
    public static final String PASSPORT_CSRF_TOKEN_DEFAULT_KEY_KEY = "passport_csrf_token_default";
    public static final String PASSPORT_CSRF_TOKEN_KEY_KEY = "passport_csrf_token";

    public static List<TTTokenHeader> toHeaders(List<Header> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Header header : list) {
            if (header != null && !TextUtils.isEmpty(header.getName()) && !TextUtils.isEmpty(header.getValue())) {
                arrayList.add(new TTTokenHeader(header.getName(), header.getValue()));
            }
        }
        return arrayList;
    }

    public static String getCsrfToken(String str) {
        String specialCookieInfo = Utils.getSpecialCookieInfo(str, PASSPORT_CSRF_TOKEN_KEY_KEY);
        return TextUtils.isEmpty(specialCookieInfo) ? Utils.getSpecialCookieInfo(str, PASSPORT_CSRF_TOKEN_DEFAULT_KEY_KEY) : specialCookieInfo;
    }

    public static void addTokenInterceptor() {
        RetrofitUtils.addInterceptor(new TTTokenInterceptor());
        LogHelper.m36d("TTTokenUtils", "call addTokenInterceptor");
    }
}
