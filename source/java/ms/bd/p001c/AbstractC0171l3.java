package ms.bd.p001c;

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

/* renamed from: ms.bd.c.l3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0171l3 {
    /* renamed from: a */
    public static String m142a(Context context) {
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

    /* renamed from: b */
    public static String m143b(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(m142a(context));
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
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }
}
