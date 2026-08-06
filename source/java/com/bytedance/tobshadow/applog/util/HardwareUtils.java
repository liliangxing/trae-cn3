package com.bytedance.tobshadow.applog.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0563z4;
import java.util.Collections;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class HardwareUtils {
    public static final String GLOBAL_CACHE_GET_ANDROID_ID = "Secure.getString_android_id";

    /* renamed from: com.bytedance.tobshadow.applog.util.HardwareUtils$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0367a implements C0563z4.a {

        /* renamed from: a */
        public final /* synthetic */ Context f417a;

        public C0367a(Context context) {
            this.f417a = context;
        }

        /* renamed from: com_bytedance_tobshadow_applog_util_HardwareUtils$a_android_provider_Settings$Secure_getString */
        private static String m239xd9976c6(ContentResolver contentResolver, String str) {
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

        @Override // com.bytedance.tobshadow.bdtracker.C0563z4.a
        /* renamed from: a */
        public String mo240a() {
            LoggerImpl.global().debug(Collections.singletonList("HardwareUtils"), "[DeviceMeta] Try to get android id by secure.getString", new Object[0]);
            return m239xd9976c6(this.f417a.getContentResolver(), "android_id");
        }
    }

    public static String getOperatorName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public static int getScreenOrientation(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        return defaultDisplay.getWidth() <= defaultDisplay.getHeight() ? 1 : 2;
    }

    public static String getSecureAndroidId(Context context) {
        try {
            return C0563z4.m765a(context).m766a(GLOBAL_CACHE_GET_ANDROID_ID, new C0367a(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(Collections.singletonList("HardwareUtils"), "Get androidId failed", th, new Object[0]);
            return null;
        }
    }

    public static String getSimCountryIso(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getSimCountryIso();
        }
        return null;
    }
}
