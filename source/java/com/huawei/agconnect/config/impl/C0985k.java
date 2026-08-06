package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.agconnect.config.impl.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0985k {

    /* renamed from: a */
    private final AesDecrypt f851a;

    public C0985k(Context context, String str) {
        this.f851a = (TextUtils.isEmpty(m821a(context, str)) || Build.VERSION.SDK_INT < 26) ? new C0981g(context, str) : new C0982h(context, str);
    }

    /* renamed from: a */
    private String m821a(Context context, String str) {
        String m824a = C0986l.m824a(context, str, "agc_plugin_", "crypto");
        if (m824a == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(m824a), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            Log.e("ReaderStrategy", "UnsupportedEncodingException" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public String m822a(String str, String str2) {
        return this.f851a.decrypt(str, str2);
    }
}
