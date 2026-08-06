package com.apm.lite.p019g;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.lite.runtime.C0835p;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.util.UUID;

/* renamed from: com.apm.lite.g.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0758a {

    /* renamed from: a */
    private static volatile UUID f474a = null;

    /* renamed from: b */
    private static String f475b = "";

    private C0758a(Context context) {
        if (f474a == null) {
            synchronized (C0758a.class) {
                if (f474a == null) {
                    String str = null;
                    String m1207a = C0835p.m1198a().m1207a((String) null);
                    if (m1207a != null) {
                        f474a = UUID.fromString(m1207a);
                    } else {
                        try {
                            str = com_apm_lite_g_a_android_provider_Settings$Secure_getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused) {
                        }
                        try {
                            f474a = str != null ? UUID.nameUUIDFromBytes(str.getBytes("utf8")) : UUID.randomUUID();
                        } catch (Throwable unused2) {
                        }
                        try {
                            C0835p.m1198a().m1213c(f474a.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized String m635a(Context context) {
        String str;
        UUID m636a;
        synchronized (C0758a.class) {
            if (TextUtils.isEmpty(f475b) && (m636a = new C0758a(context).m636a()) != null) {
                f475b = m636a.toString();
            }
            str = f475b;
        }
        return str;
    }

    private static String com_apm_lite_g_a_android_provider_Settings$Secure_getString(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    /* renamed from: a */
    public UUID m636a() {
        return f474a;
    }
}
