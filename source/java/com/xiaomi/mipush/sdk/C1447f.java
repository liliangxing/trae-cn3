package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.pushmanager.PushCommonConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1492az;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1699o;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.C1703r;
import com.xiaomi.push.service.C1750ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mipush.sdk.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1447f {
    /* renamed from: a */
    public static void m1284a(Context context, EnumC1445d enumC1445d, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int m1275a = m1275a(context, enumC1445d, str);
        if (m1275a != 0) {
            AbstractC1417b.m1089a("ASSEMBLE_PUSH : send token upload, check:" + m1275a);
            m1285a(context, str);
            EnumC1463v m1301a = C1448g.m1301a(enumC1445d);
            if (m1301a == null) {
                return;
            }
            C1462u.m1373a(context).m1413a((String) null, m1301a, enumC1445d, "upload");
            return;
        }
        AbstractC1417b.m1089a("ASSEMBLE_PUSH : do not need to send token");
    }

    /* renamed from: a */
    private static int m1275a(Context context, EnumC1445d enumC1445d, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String m1280a = m1280a(enumC1445d);
        String string = sharedPreferences.getString(m1280a, "");
        String m1241c = C1443b.m1222a(context).m1241c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(m1280a)) {
            AbstractC1417b.m1089a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        }
        if (TextUtils.isEmpty(string)) {
            return 1;
        }
        if (!string.equals(str)) {
            return 2;
        }
        if (!TextUtils.equals(m1241c, string2)) {
            return 3;
        }
        if (m1290a(enumC1445d)) {
            if (m1274a() != sharedPreferences.getInt(m1293b(enumC1445d), 0)) {
                return 4;
            }
        }
        return 0;
    }

    /* renamed from: a */
    static String m1278a(Context context, EnumC1445d enumC1445d) {
        return m1279a(context, enumC1445d, false);
    }

    /* renamed from: a */
    public static boolean m1291a(C1656ha c1656ha, EnumC1445d enumC1445d) {
        if (c1656ha == null || c1656ha.m3010a() == null || c1656ha.m3010a().m2843a() == null) {
            return false;
        }
        return (enumC1445d == EnumC1445d.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(c1656ha.m3010a().m2843a().get("assemble_push_type"));
    }

    /* renamed from: a */
    public static byte[] m1292a(Context context, C1656ha c1656ha, EnumC1445d enumC1445d) {
        if (m1291a(c1656ha, enumC1445d)) {
            return C1492az.m1596a(m1278a(context, enumC1445d));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1282a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String m1280a = m1280a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI);
        String m1280a2 = m1280a(EnumC1445d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(m1280a, "")) && TextUtils.isEmpty(sharedPreferences.getString(m1280a2, ""))) {
            z = true;
        }
        if (z) {
            C1462u.m1373a(context).m1399a(2, m1280a);
        }
    }

    /* renamed from: a */
    public static void m1283a(Context context, EnumC1445d enumC1445d) {
        String m1280a = m1280a(enumC1445d);
        if (TextUtils.isEmpty(m1280a)) {
            return;
        }
        C1699o.m3458a(context.getSharedPreferences("mipush_extra", 0).edit().putString(m1280a, ""));
    }

    /* renamed from: a */
    public static boolean m1289a(Context context, EnumC1445d enumC1445d) {
        if (C1448g.m1302a(enumC1445d) != null) {
            return C1750ah.m3674a(context).m3686a(C1448g.m1302a(enumC1445d).m2760a(), true);
        }
        return false;
    }

    /* renamed from: a */
    public static void m1287a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i);
    }

    /* renamed from: a */
    public static boolean m1288a(Context context) {
        if (context == null) {
            return false;
        }
        return C1486at.m1545a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static synchronized void m1299d(Context context, EnumC1445d enumC1445d, String str) {
        synchronized (C1447f.class) {
            String m1280a = m1280a(enumC1445d);
            if (TextUtils.isEmpty(m1280a)) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(m1280a, str).putString("last_check_token", C1443b.m1222a(context).m1241c());
            if (m1290a(enumC1445d)) {
                edit.putInt(m1293b(enumC1445d), m1274a());
            }
            edit.putString("syncingToken", "");
            C1699o.m3458a(edit);
            AbstractC1417b.m1089a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }

    /* renamed from: b */
    public static void m1295b(final Context context, final EnumC1445d enumC1445d, final String str) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.mipush.sdk.f.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String[] split = str.split(Constants.WAVE_SEPARATOR);
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str2 = "";
                        break;
                    }
                    String str3 = split[i];
                    if (!TextUtils.isEmpty(str3) && str3.startsWith("token:")) {
                        str2 = str3.substring(str3.indexOf(Constants.COLON_SEPARATOR) + 1);
                        break;
                    }
                    i++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    AbstractC1417b.m1089a("ASSEMBLE_PUSH : receive correct token");
                    C1447f.m1299d(context, enumC1445d, str2);
                    C1447f.m1282a(context);
                    return;
                }
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : receive incorrect token");
            }
        });
    }

    /* renamed from: a */
    private static synchronized void m1285a(Context context, String str) {
        synchronized (C1447f.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("syncingToken", str);
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static synchronized String m1279a(Context context, EnumC1445d enumC1445d, boolean z) {
        synchronized (C1447f.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            if (z) {
                String string = sharedPreferences.getString("syncingToken", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            String m1280a = m1280a(enumC1445d);
            if (TextUtils.isEmpty(m1280a)) {
                return "";
            }
            return sharedPreferences.getString(m1280a, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static PushMessageReceiver m1277a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    resolveInfo = it.next();
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo != null) {
                return (PushMessageReceiver) C1702q.m3463a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e) {
            AbstractC1417b.m1103d(e.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static void m1286a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, m1276a(extras.getString("pushMsg")));
    }

    /* renamed from: b */
    public static void m1294b(Context context) {
        C1446e.m1264a(context).register();
    }

    /* renamed from: c */
    public static void m1297c(Context context) {
        C1446e.m1264a(context).unregister();
    }

    /* renamed from: a */
    public static MiPushMessage m1276a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has(PushCommonConstants.KEY_ALIAS)) {
                    miPushMessage.setAlias(jSONObject.getString(PushCommonConstants.KEY_ALIAS));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has("notifyId")) {
                    miPushMessage.setNotifyId(jSONObject.getInt("notifyId"));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e) {
                AbstractC1417b.m1103d(e.toString());
            }
        }
        return miPushMessage;
    }

    /* renamed from: a */
    public static HashMap<String, String> m1281a(Context context, EnumC1445d enumC1445d) {
        HashMap<String, String> hashMap = new HashMap<>();
        int i = AnonymousClass2.f851a[enumC1445d.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i == 1) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e) {
                AbstractC1417b.m1103d(e.toString());
            }
            str = new C1703r.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m3477a(Constants.PHONE_BRAND, EnumC1458q.HUAWEI.name()).m3477a("token", m1279a(context, enumC1445d, true)).m3477a(Constants.PACKAGE_NAME, context.getPackageName()).m3477a("app_id", Integer.valueOf(applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1)).toString();
        } else if (i == 2) {
            C1703r.a m3477a = new C1703r.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m3477a(Constants.PHONE_BRAND, EnumC1458q.FCM.name()).m3477a("token", m1279a(context, enumC1445d, false)).m3477a(Constants.PACKAGE_NAME, context.getPackageName());
            int m1274a = m1274a();
            if (m1274a != 0) {
                m3477a.m3477a(Constants.VERSION, Integer.valueOf(m1274a));
            } else {
                m3477a.m3477a(Constants.VERSION, Integer.valueOf(BuildConfig.VERSION_CODE));
            }
            str = m3477a.toString();
        } else if (i == 3) {
            str = new C1703r.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m3477a(Constants.PHONE_BRAND, EnumC1458q.OPPO.name()).m3477a("token", m1279a(context, enumC1445d, true)).m3477a(Constants.PACKAGE_NAME, context.getPackageName()).toString();
        } else if (i == 4) {
            C1703r.a m3477a2 = new C1703r.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m3477a(Constants.PHONE_BRAND, EnumC1458q.VIVO.name()).m3477a("token", m1279a(context, enumC1445d, true)).m3477a(Constants.PACKAGE_NAME, context.getPackageName());
            int m1274a2 = m1274a();
            if (m1274a2 != 0) {
                m3477a2.m3477a(Constants.VERSION, Integer.valueOf(m1274a2));
            }
            str = m3477a2.toString();
        }
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.f$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f851a;

        static {
            int[] iArr = new int[EnumC1445d.values().length];
            f851a = iArr;
            try {
                iArr[EnumC1445d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f851a[EnumC1445d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f851a[EnumC1445d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f851a[EnumC1445d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a */
    public static int m1274a() {
        Integer num = (Integer) C1488av.m1569a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    public static boolean m1290a(EnumC1445d enumC1445d) {
        return enumC1445d == EnumC1445d.ASSEMBLE_PUSH_FTOS || enumC1445d == EnumC1445d.ASSEMBLE_PUSH_FCM;
    }

    /* renamed from: a */
    public static String m1280a(EnumC1445d enumC1445d) {
        int i = AnonymousClass2.f851a[enumC1445d.ordinal()];
        if (i == 1) {
            return "hms_push_token";
        }
        if (i == 2) {
            return "fcm_push_token_v2";
        }
        if (i == 3) {
            return "cos_push_token";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    /* renamed from: b */
    public static String m1293b(EnumC1445d enumC1445d) {
        return m1280a(enumC1445d) + "_version";
    }

    /* renamed from: c */
    public static String m1296c(EnumC1445d enumC1445d) {
        int i = AnonymousClass2.f851a[enumC1445d.ordinal()];
        if (i == 1) {
            return "hms_push_error";
        }
        if (i == 2) {
            return "fcm_push_error";
        }
        if (i == 3) {
            return "cos_push_error";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_error";
    }
}
