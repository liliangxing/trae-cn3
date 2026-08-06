package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;

/* compiled from: SettingsCache.java */
/* renamed from: com.vivo.push.util.ac */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1368ac implements InterfaceC1378e {

    /* renamed from: a */
    private ContentResolver f651a;

    private static String com_vivo_push_util_ac_android_provider_Settings$System_getString(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102003, "android/provider/Settings$System", "getString", Settings.System.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102003, "android/provider/Settings$System", "getString", Settings.System.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.System.getString(contentResolver, str);
        heliosApiHook.postInvoke(102003, "android/provider/Settings$System", "getString", Settings.System.class, objArr, string, extraInfo, true);
        return string;
    }

    @Override // com.vivo.push.util.InterfaceC1378e
    /* renamed from: a */
    public final boolean mo939a(Context context) {
        if (!C1386m.m1011b()) {
            return false;
        }
        this.f651a = context.getContentResolver();
        return true;
    }

    @Override // com.vivo.push.util.InterfaceC1378e
    /* renamed from: a */
    public final String mo938a(String str, String str2) {
        try {
            return com_vivo_push_util_ac_android_provider_Settings$System_getString(this.f651a, str);
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1041b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
