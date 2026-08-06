package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HWPushHelper {

    /* renamed from: a */
    private static boolean f786a;

    public static synchronized void setConnectTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > 5000;
        }
        return z;
    }

    public static synchronized void setGetTokenTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized boolean shouldGetToken(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L)) > 172800000;
        }
        return z;
    }

    public static boolean isHmsTokenSynced(Context context) {
        String m1279a = C1447f.m1279a(context, EnumC1445d.ASSEMBLE_PUSH_HUAWEI, false);
        String m1335a = C1457p.m1333a(context).m1335a(EnumC1463v.UPLOAD_HUAWEI_TOKEN);
        return (TextUtils.isEmpty(m1279a) || TextUtils.isEmpty(m1335a) || !"synced".equals(m1335a)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r2 = r3.getString("pushMsg");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void notifyHmsNotificationMessageClicked(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has("pushMsg")) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            } catch (Exception e) {
                AbstractC1417b.m1103d(e.toString());
            }
        }
        PushMessageReceiver m1277a = C1447f.m1277a(context);
        if (m1277a != null) {
            MiPushMessage m1276a = C1447f.m1276a(str2);
            if (m1276a.getExtra().containsKey("notify_effect")) {
                return;
            }
            m1277a.onNotificationMessageClicked(context, m1276a);
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (Exception e) {
            AbstractC1417b.m1103d(e.toString());
        }
        PushMessageReceiver m1277a = C1447f.m1277a(context);
        if (m1277a != null) {
            m1277a.onReceivePassThroughMessage(context, C1447f.m1276a(str2));
        }
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager m1268a = C1446e.m1264a(context).m1268a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI);
        if (m1268a != null) {
            m1268a.register();
        }
    }

    public static void uploadToken(Context context, String str) {
        C1447f.m1284a(context, EnumC1445d.ASSEMBLE_PUSH_HUAWEI, str);
    }

    public static void reportError(String str, int i) {
        C1447f.m1287a(str, i);
    }

    public static boolean hasNetwork(Context context) {
        return C1447f.m1288a(context);
    }

    public static void setNeedConnect(boolean z) {
        f786a = z;
    }

    public static boolean needConnect() {
        return f786a;
    }

    public static void convertMessage(Intent intent) {
        C1447f.m1286a(intent);
    }
}
