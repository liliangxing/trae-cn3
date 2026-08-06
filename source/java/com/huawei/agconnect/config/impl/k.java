package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.platform.godzilla.common.Constant;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* loaded from: classes6.dex */
public class k {
    private final AesDecrypt a;

    public k(Context context, String str) {
        this.a = (TextUtils.isEmpty(a(context, str)) || Build.VERSION.SDK_INT < 26) ? new g(context, str) : new h(context, str);
    }

    private String a(Context context, String str) {
        String a = l.a(context, str, "agc_plugin_", "crypto");
        if (a == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(a), Constant.CHARSET_UTF_8);
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            Log.e("ReaderStrategy", "UnsupportedEncodingException" + e.getMessage());
            return null;
        }
    }

    public String a(String str, String str2) {
        return this.a.decrypt(str, str2);
    }
}
