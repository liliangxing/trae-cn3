package com.bytedance.bdinstall.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;

/* loaded from: classes3.dex */
public class HardwareUtils {
    private static String com_bytedance_bdinstall_util_HardwareUtils_android_provider_Settings$Secure_getString(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    public static String getSecureAndroidId(Context context) {
        try {
            return com_bytedance_bdinstall_util_HardwareUtils_android_provider_Settings$Secure_getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
