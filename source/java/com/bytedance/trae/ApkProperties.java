package com.bytedance.trae;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bytedance.lego.init.util.InitContext;
import com.bytedance.trae.utils.ApkUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ApkProperties {
    public static final String KEY_UMENG_CHANNEL = "meta_umeng_channel";
    private static final String TAG = "ApkProperties";
    private static ApkProperties sTtProperties;
    private JSONObject mJSONObject;

    private ApkProperties(Context context) {
        try {
            this.mJSONObject = tryLoadPropertiesFromApk(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONObject tryLoadPropertiesFromApk(Context context) {
        try {
            String findIdStringValue = ApkUtil.findIdStringValue(getApkPath(context), 1903654775);
            if (TextUtils.isEmpty(findIdStringValue)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(findIdStringValue);
            if (checkChannelValid(jSONObject)) {
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean checkChannelValid(JSONObject jSONObject) {
        try {
            return !TextUtils.isEmpty(jSONObject.getString(KEY_UMENG_CHANNEL));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static ApkProperties inst(Context context) {
        if (sTtProperties == null) {
            synchronized (ApkProperties.class) {
                if (sTtProperties == null) {
                    sTtProperties = new ApkProperties(context);
                }
            }
        }
        return sTtProperties;
    }

    private Object readKey(String str) {
        try {
            JSONObject jSONObject = this.mJSONObject;
            if (jSONObject != null) {
                return jSONObject.get(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getString(String str, String str2) {
        Object readKey = readKey(str);
        return !(readKey instanceof String) ? str2 : (String) readKey;
    }

    public int getInt(String str, int i) {
        Object readKey = readKey(str);
        return !(readKey instanceof Integer) ? i : ((Integer) readKey).intValue();
    }

    public Boolean getBoolean(String str, Boolean bool) {
        Object readKey = readKey(str);
        return !(readKey instanceof Boolean) ? bool : (Boolean) readKey;
    }

    public Object get(String str) {
        return readKey(str);
    }

    private String getApkPath(Context context) {
        Context context2;
        ApplicationInfo applicationInfo;
        if (context != null && (context instanceof Application)) {
            Application application = (Application) context;
            if (application.getBaseContext() != null) {
                context2 = application.getBaseContext();
                if (context2 != null || (applicationInfo = context2.getApplicationInfo()) == null) {
                    return null;
                }
                return applicationInfo.sourceDir;
            }
        }
        context2 = (Context) InitContext.getCommonParams("base");
        if (context2 != null) {
        }
        return null;
    }
}
