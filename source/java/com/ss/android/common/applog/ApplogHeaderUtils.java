package com.ss.android.common.applog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.android.deviceregister.base.Oaid;
import com.ss.android.pushmanager.PushCommonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ApplogHeaderUtils {
    public static final String KEY_SERIAL_NUMBER = "serial_number";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_UDID = "udid";
    static final String KEY_MC = "mc";
    static final String KEY_BUILD_SERIAL = "build_serial";
    static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    static String[] EXTRA_KEYS = {KEY_MC, KEY_BUILD_SERIAL, KEY_ALIYUN_UUID, "udid", "serial_number", "sim_serial_number"};
    static String[] HEADER_KEYS = new String[AppLog.BASE_HEADER_KEYS.length + 6];

    /* renamed from: com_ss_android_common_applog_ApplogHeaderUtils_com_ss_android_deviceregister_base_Oaid_getOaidId */
    private static String m58xeb290ece(Oaid oaid) throws JSONException {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String oaidId = oaid.getOaidId();
        heliosApiHook.postInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, oaidId, extraInfo, true);
        return oaidId;
    }

    static {
        System.arraycopy(AppLog.BASE_HEADER_KEYS, 0, HEADER_KEYS, 0, AppLog.BASE_HEADER_KEYS.length);
        System.arraycopy(EXTRA_KEYS, 0, HEADER_KEYS, AppLog.BASE_HEADER_KEYS.length + 0, EXTRA_KEYS.length);
    }

    public static void updateAppLogHeader(Context context, JSONObject jSONObject) throws JSONException {
        String m58xeb290ece = m58xeb290ece(Oaid.instance(context));
        if (TextUtils.isEmpty(m58xeb290ece)) {
            return;
        }
        jSONObject.put(PushCommonConstants.KEY_OAID, m58xeb290ece);
    }

    public static JSONObject updateEventTimelyHeader(Context context, JSONObject jSONObject) {
        String m58xeb290ece = m58xeb290ece(Oaid.instance(context));
        if (TextUtils.isEmpty(m58xeb290ece)) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject, HEADER_KEYS);
            try {
                jSONObject2.put(PushCommonConstants.KEY_OAID, m58xeb290ece);
            } catch (JSONException unused) {
            }
            return jSONObject2;
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }
}
