package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class l3 {
    public static String a(Context context) {
        try {
            String ms_bd_c_l3_android_provider_Settings$Secure_getString = ms_bd_c_l3_android_provider_Settings$Secure_getString(context.getContentResolver(), "default_input_method");
            return !TextUtils.isEmpty(ms_bd_c_l3_android_provider_Settings$Secure_getString) ? ms_bd_c_l3_android_provider_Settings$Secure_getString.contains("/") ? ms_bd_c_l3_android_provider_Settings$Secure_getString.split("/")[0] : ms_bd_c_l3_android_provider_Settings$Secure_getString : "null_";
        } catch (Throwable th) {
            try {
                return "null_" + th.getMessage();
            } catch (Throwable unused) {
                return "null_";
            }
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(a(context));
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]").append(packageName);
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static String ms_bd_c_l3_android_provider_Settings$Secure_getString(ContentResolver contentResolver, String str) {
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
}
