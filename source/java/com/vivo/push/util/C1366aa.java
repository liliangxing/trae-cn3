package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.text.TextUtils;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.ttm.player.MediaPlayer;
import com.vivo.push.C1402x;
import com.vivo.push.model.C1307a;
import com.vivo.push.restructure.p021b.InterfaceC1332b;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: PushPackageUtils.java */
/* renamed from: com.vivo.push.util.aa */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1366aa {

    /* renamed from: a */
    private static Boolean f648a;

    /* renamed from: b */
    private static String f649b;

    /* renamed from: a */
    public static C1307a m924a(Context context, InterfaceC1332b interfaceC1332b) {
        C1307a c1307a;
        C1307a m933e;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        C1307a m930c = m930c(applicationContext);
        if (m930c != null) {
            C1393t.m1048d("PushPackageUtils", "get system push info :".concat(String.valueOf(m930c)));
            return m930c;
        }
        List<String> mo879a = interfaceC1332b.mo879a(applicationContext);
        C1307a m933e2 = m933e(applicationContext, applicationContext.getPackageName());
        if (mo879a == null || mo879a.size() <= 0) {
            if (m933e2 != null && m933e2.m809d()) {
                m930c = m933e2;
            }
            C1393t.m1034a("PushPackageUtils", "findAllPushPackages error: find no package!");
            m933e2 = m930c;
        } else {
            C1307a c1307a2 = null;
            String mo938a = C1371af.m948b(applicationContext).mo938a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(mo938a) || !m927a(applicationContext, mo938a, "com.vivo.pushservice.action.METHOD") || (c1307a = m933e(applicationContext, mo938a)) == null || !c1307a.m809d()) {
                c1307a = null;
            }
            if (m933e2 == null || !m933e2.m809d()) {
                m933e2 = null;
            }
            if (c1307a == null) {
                c1307a = null;
            }
            if (m933e2 == null || (c1307a != null && (!m933e2.m808c() ? !(c1307a.m808c() || m933e2.m807b() > c1307a.m807b()) : !(c1307a.m808c() && m933e2.m807b() > c1307a.m807b())))) {
                m933e2 = c1307a;
            }
            HashMap hashMap = new HashMap();
            if (m933e2 == null) {
                m933e2 = null;
            } else if (m933e2.m808c()) {
                c1307a2 = m933e2;
                m933e2 = null;
            }
            int size = mo879a.size();
            for (int i = 0; i < size; i++) {
                String str = mo879a.get(i);
                if (!TextUtils.isEmpty(str) && (m933e = m933e(applicationContext, str)) != null) {
                    hashMap.put(str, m933e);
                    if (m933e.m809d()) {
                        if (m933e.m808c()) {
                            if (c1307a2 == null || m933e.m807b() > c1307a2.m807b()) {
                                c1307a2 = m933e;
                            }
                        } else if (m933e2 == null || m933e.m807b() > m933e2.m807b()) {
                            m933e2 = m933e;
                        }
                    }
                }
            }
            if (m933e2 == null) {
                C1393t.m1048d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                m933e2 = c1307a2;
            }
        }
        if (m933e2 != null) {
            if (m933e2.m808c()) {
                C1393t.m1038a(applicationContext, "查找最优包为:" + m933e2.m802a() + "(" + m933e2.m807b() + ", Black)");
                C1393t.m1048d("PushPackageUtils", "finSuitablePushPackage" + m933e2.m802a() + "(" + m933e2.m807b() + ", Black)");
            } else {
                C1393t.m1038a(applicationContext, "查找最优包为:" + m933e2.m802a() + "(" + m933e2.m807b() + ")");
                C1393t.m1048d("PushPackageUtils", "finSuitablePushPackage" + m933e2.m802a() + "(" + m933e2.m807b() + ")");
            }
        } else {
            C1393t.m1043b(applicationContext, "查找最优包为空!");
            C1393t.m1048d("PushPackageUtils", "finSuitablePushPackage is null");
        }
        return m933e2;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f8 A[Catch: Exception -> 0x00dc, TRY_ENTER, TryCatch #3 {Exception -> 0x00dc, blocks: (B:78:0x00d8, B:80:0x00e0, B:31:0x00f8, B:33:0x00fd), top: B:7:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd A[Catch: Exception -> 0x00dc, TRY_LEAVE, TryCatch #3 {Exception -> 0x00dc, blocks: (B:78:0x00d8, B:80:0x00e0, B:31:0x00f8, B:33:0x00fd), top: B:7:0x0012 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m925a(Context context) {
        String str;
        ContentProviderClient contentProviderClient;
        Cursor query;
        if (!TextUtils.isEmpty(f649b)) {
            return f649b;
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(C1402x.f728a);
                    if (contentProviderClient != null) {
                        try {
                            C1393t.m1034a("PushPackageUtils", "client is null");
                            query = contentProviderClient.query(C1402x.f728a, null, null, null, null);
                        } catch (Exception e) {
                            e = e;
                            str = null;
                            C1393t.m1035a("PushPackageUtils", "getSystemPush", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (contentProviderClient != null) {
                                contentProviderClient.close();
                            }
                            return str;
                        }
                    } else {
                        query = null;
                    }
                    if (query == null) {
                        try {
                            try {
                                query = context.getContentResolver().query(C1402x.f728a, null, null, null, null);
                            } catch (Throwable th) {
                                th = th;
                                cursor = query;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        C1393t.m1035a("PushPackageUtils", PushCommonConstants.VALUE_CLOSE, e2);
                                        throw th;
                                    }
                                }
                                if (contentProviderClient != null) {
                                    contentProviderClient.close();
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = null;
                            cursor = query;
                            C1393t.m1035a("PushPackageUtils", "getSystemPush", e);
                            if (cursor != null) {
                            }
                            if (contentProviderClient != null) {
                            }
                            return str;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                contentProviderClient = null;
                str = null;
            } catch (Throwable th3) {
                th = th3;
                contentProviderClient = null;
            }
        } catch (Exception e5) {
            C1393t.m1035a("PushPackageUtils", PushCommonConstants.VALUE_CLOSE, e5);
        }
        if (query == null) {
            C1393t.m1034a("PushPackageUtils", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e6) {
                    C1393t.m1035a("PushPackageUtils", PushCommonConstants.VALUE_CLOSE, e6);
                }
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return null;
        }
        boolean z = false;
        str = null;
        while (query.moveToNext()) {
            try {
                if ("pushPkgName".equals(query.getString(query.getColumnIndex("name")))) {
                    str = query.getString(query.getColumnIndex("value"));
                } else if ("pushEnable".equals(query.getString(query.getColumnIndex("name")))) {
                    z = Boolean.parseBoolean(query.getString(query.getColumnIndex("value")));
                }
            } catch (Exception e7) {
                e = e7;
                cursor = query;
                C1393t.m1035a("PushPackageUtils", "getSystemPush", e);
                if (cursor != null) {
                }
                if (contentProviderClient != null) {
                }
                return str;
            }
        }
        f649b = str;
        if (TextUtils.isEmpty(str)) {
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e8) {
                    C1393t.m1035a("PushPackageUtils", PushCommonConstants.VALUE_CLOSE, e8);
                }
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return null;
        }
        if (z) {
            if (query != null) {
                query.close();
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return str;
        }
        if (query != null) {
            try {
                query.close();
            } catch (Exception e9) {
                C1393t.m1035a("PushPackageUtils", PushCommonConstants.VALUE_CLOSE, e9);
            }
        }
        if (contentProviderClient != null) {
            contentProviderClient.close();
        }
        return null;
    }

    /* renamed from: c */
    private static C1307a m930c(Context context) {
        String m925a = m925a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(m925a)) {
            return null;
        }
        C1307a c1307a = new C1307a(m925a);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m925a, 128);
            if (packageInfo != null) {
                c1307a.m803a(packageInfo.versionCode);
                c1307a.m805a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                c1307a.m804a(C1373ah.m952a(context, m925a));
            }
            c1307a.m806a(m926a(context, m925a));
            return c1307a;
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1042b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
            return null;
        }
    }

    /* renamed from: e */
    private static C1307a m933e(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (m927a(context, str, "com.vivo.pushservice.action.METHOD") || m927a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                C1307a c1307a = new C1307a(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        c1307a.m803a(packageInfo.versionCode);
                        c1307a.m805a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        c1307a.m804a(C1373ah.m952a(context, str));
                    }
                    c1307a.m806a(m926a(context, str));
                    return c1307a;
                } catch (Exception e) {
                    C1393t.m1035a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m926a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                C1393t.m1034a("PushPackageUtils", "isEnablePush error: can not find push service.");
            } else {
                int size = queryIntentServices.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i);
                    if (resolveInfo != null && resolveInfo.serviceInfo != null) {
                        String str2 = resolveInfo.serviceInfo.name;
                        boolean z2 = resolveInfo.serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z3);
                        }
                    }
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m927a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
        } catch (Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }

    /* renamed from: c */
    public static boolean m931c(Context context, String str) {
        return m927a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* renamed from: d */
    public static boolean m932d(Context context, String str) {
        return m927a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    /* renamed from: f */
    private static String m934f(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b : digest) {
                    String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                C1393t.m1034a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e)));
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m929b(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f648a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(m934f(context, str)));
        f648a = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: b */
    public static int m928b(Context context, String str) {
        int i = m927a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (m927a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i;
    }
}
