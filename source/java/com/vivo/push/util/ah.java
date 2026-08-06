package com.vivo.push.util;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Utility.java */
/* loaded from: classes7.dex */
public final class ah {
    private static String[] b;
    private static String[] a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] d = {"com.vivo.push.sdk.RegistrationReceiver"};
    private static String[] e = new String[0];
    private static Map<String, Bundle> f = new ConcurrentHashMap();

    public static long a(Context context) {
        String a2 = aa.a(context);
        if (TextUtils.isEmpty(a2)) {
            t.a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return a(context, a2);
    }

    public static long a(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.sdk_version");
        if (a2 == null) {
            a2 = a(context, str, "sdk_version");
        }
        if (a2 != null) {
            try {
                return Long.parseLong(a2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                t.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        t.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    public static String b(Context context, String str) {
        Object a2 = a(context, str, "verification_status");
        return a2 != null ? a2.toString() : "";
    }

    public static Object a(Context context, String str, String str2) {
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f;
            Object obj = (map == null || map.size() <= 0 || (bundle = f.get(str)) == null) ? null : bundle.get(str2);
            if (obj != null) {
                return obj;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                Object obj2 = r0 != null ? r0.get(str2) : obj;
                try {
                    if (f.size() > 300) {
                        return obj2;
                    }
                    f.put(str, r0);
                    return obj2;
                } catch (Exception e2) {
                    r0 = obj2;
                    e = e2;
                    t.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return r0;
                }
            } catch (Exception e3) {
                e = e3;
                r0 = obj;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) throws VivoPushException {
        String obj;
        t.d("Utility", "check PushService AndroidManifest declearation !");
        String a2 = aa.a(context);
        boolean d2 = aa.d(context, context.getPackageName());
        boolean c2 = aa.c(context, context.getPackageName());
        if (!c2 && !d2) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        }
        if (c2) {
            c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
        } else {
            c = new String[]{"com.vivo.push.sdk.service.CommandService"};
        }
        d = new String[0];
        a = new String[0];
        if (d2) {
            b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
        } else {
            b = new String[]{"android.permission.INTERNET"};
        }
        if (d2) {
            long a3 = a(context, context.getPackageName());
            long j = context.getPackageName().equals(a2) ? 1356L : 356L;
            if (a3 == -1) {
                throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
            }
            if (a3 != j) {
                throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(j)));
            }
        }
        String[] strArr = b;
        if (strArr == null || strArr.length <= 0) {
            t.c("Utility", "checkPermissions sPermissions is empty");
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    throw new VivoPushException("localPackageManager is null");
                }
                String[] strArr2 = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr2 == null) {
                    throw new VivoPushException("Permissions is null!");
                }
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    for (String str2 : strArr2) {
                        int i2 = str.equals(str2) ? 0 : i2 + 1;
                    }
                    throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr2));
                }
            } catch (Exception e2) {
                throw new VivoPushException(e2.getMessage());
            }
        }
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            for (String str3 : d) {
                a(str3, activityInfoArr, a2);
            }
            try {
                if (context.getPackageManager() == null) {
                    throw new VivoPushException("localPackageManager is null");
                }
                ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                if (serviceInfoArr == null) {
                    throw new VivoPushException("serviceInfos is null");
                }
                for (String str4 : c) {
                    a(str4, serviceInfoArr, a2);
                }
                if (e.length > 0) {
                    try {
                        if (context.getPackageManager() == null) {
                            throw new VivoPushException("localPackageManager is null");
                        }
                        ActivityInfo[] activityInfoArr2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                        if (activityInfoArr2 == null) {
                            throw new VivoPushException("activityInfos is null");
                        }
                        for (String str5 : e) {
                            a(str5, activityInfoArr2, a2);
                        }
                    } catch (Exception e3) {
                        throw new VivoPushException("error " + e3.getMessage());
                    }
                }
                try {
                    if (a(context, context.getPackageName(), "local_iv") != null) {
                        String packageName = context.getPackageName();
                        Object a4 = a(context, packageName, "com.vivo.push.api_key");
                        String str6 = "";
                        if (a4 != null) {
                            obj = a4.toString();
                        } else {
                            Object a5 = a(context, packageName, "api_key");
                            obj = a5 != null ? a5.toString() : "";
                        }
                        if (TextUtils.isEmpty(obj)) {
                            throw new VivoPushException("com.vivo.push.api_key is null");
                        }
                        String packageName2 = context.getPackageName();
                        Object a6 = a(context, packageName2, "com.vivo.push.app_id");
                        if (a6 != null) {
                            str6 = a6.toString();
                        } else {
                            Object a7 = a(context, packageName2, "app_id");
                            if (a7 != null) {
                                str6 = a7.toString();
                            }
                        }
                        if (TextUtils.isEmpty(str6)) {
                            throw new VivoPushException("com.vivo.push.app_id is null");
                        }
                        if (d2 && a(context, context.getPackageName()) == -1) {
                            throw new VivoPushException("sdkversion is null");
                        }
                        return;
                    }
                    throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
                } catch (Exception e4) {
                    throw new VivoPushException("getMetaValue error " + e4.getMessage());
                }
            } catch (Exception e5) {
                throw new VivoPushException("error " + e5.getMessage());
            }
        } catch (Exception e6) {
            throw new VivoPushException(e6.getMessage());
        }
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (!componentInfo.enabled) {
                    throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
                }
                a(componentInfo, str2);
                return;
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a0, code lost:
    
        if (r1 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008e, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008c, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00a5: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:65:0x00a5 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009d A[Catch: Exception -> 0x00a3, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x00a3, blocks: (B:45:0x0089, B:40:0x008e, B:37:0x009d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey c(Context context) {
        ContentProviderClient contentProviderClient;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        try {
            try {
                try {
                    contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.x.a);
                    if (contentProviderClient != null) {
                        try {
                            t.a("Utility", "client is null");
                            cursor = contentProviderClient.query(com.vivo.push.x.a, null, null, null, null);
                        } catch (Exception e2) {
                            e = e2;
                            cursor = null;
                            e.printStackTrace();
                            if (cursor != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor3 != null) {
                                try {
                                    cursor3.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                            if (contentProviderClient != null) {
                                contentProviderClient.close();
                            }
                            throw th;
                        }
                    } else {
                        cursor = null;
                    }
                    if (cursor == null) {
                        try {
                            cursor = context.getContentResolver().query(com.vivo.push.x.a, null, null, null, null);
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                    if (cursor == null) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (contentProviderClient != null) {
                            contentProviderClient.close();
                        }
                        return null;
                    }
                    while (cursor.moveToNext()) {
                        if ("pushkey".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                            String string = cursor.getString(cursor.getColumnIndex("value"));
                            t.d("Utility", "result key : ".concat(String.valueOf(string)));
                            PublicKey a2 = ab.a(string);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (contentProviderClient != null) {
                                contentProviderClient.close();
                            }
                            return a2;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor3 = cursor2;
                }
            } catch (Exception e4) {
                e = e4;
                contentProviderClient = null;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                contentProviderClient = null;
            }
        } catch (Exception unused4) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dd A[Catch: Exception -> 0x00d9, TRY_LEAVE, TryCatch #3 {Exception -> 0x00d9, blocks: (B:66:0x00d5, B:57:0x00dd), top: B:65:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) {
        Throwable th;
        ContentProviderClient contentProviderClient;
        Cursor cursor = null;
        Object[] objArr = 0;
        Cursor query = null;
        Object[] objArr2 = 0;
        try {
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            t.a("Utility", "close", e2);
                            throw th;
                        }
                    }
                    if (0 != 0) {
                        throw th;
                    }
                    (objArr == true ? 1 : 0).close();
                    throw th;
                }
            } catch (Exception e3) {
                t.a("Utility", "close", e3);
            }
        } catch (Exception e4) {
            e = e4;
            contentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
        }
        if (context == null) {
            t.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.x.b);
        if (contentProviderClient != null) {
            try {
                t.a("Utility", "client is null");
                query = contentProviderClient.query(com.vivo.push.x.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"356", packageName, String.valueOf(i)}, null);
            } catch (Exception e5) {
                e = e5;
                t.a("Utility", "isSupport", e);
                if (0 != 0) {
                    (objArr2 == true ? 1 : 0).close();
                }
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                }
                return false;
            }
        }
        if (query == null) {
            query = context.getContentResolver().query(com.vivo.push.x.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"356", packageName, String.valueOf(i)}, null);
        }
        if (query == null) {
            t.a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e6) {
                    t.a("Utility", "close", e6);
                }
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return false;
        }
        if (!query.moveToFirst() || (query.getInt(query.getColumnIndex("permission")) & 1) == 0) {
            if (query != null) {
                query.close();
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return false;
        }
        if (query != null) {
            try {
                query.close();
            } catch (Exception e7) {
                t.a("Utility", "close", e7);
            }
        }
        if (contentProviderClient != null) {
            contentProviderClient.close();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cf A[Catch: Exception -> 0x00cb, TRY_LEAVE, TryCatch #3 {Exception -> 0x00cb, blocks: (B:64:0x00c7, B:55:0x00cf), top: B:63:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2, long j) {
        Throwable th;
        ContentProviderClient contentProviderClient;
        Cursor cursor = null;
        Object[] objArr = 0;
        Cursor query = null;
        Object[] objArr2 = 0;
        try {
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            t.a("Utility", "close", e2);
                            throw th;
                        }
                    }
                    if (0 != 0) {
                        throw th;
                    }
                    (objArr == true ? 1 : 0).close();
                    throw th;
                }
            } catch (Exception e3) {
                t.a("Utility", "close", e3);
            }
        } catch (Exception e4) {
            e = e4;
            contentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
        }
        if (context == null) {
            t.a("Utility", "context is null");
            return false;
        }
        contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.x.c);
        if (contentProviderClient != null) {
            try {
                t.a("Utility", "client is null");
                query = contentProviderClient.query(com.vivo.push.x.c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
            } catch (Exception e5) {
                e = e5;
                t.a("Utility", "isOverdue", e);
                if (0 != 0) {
                    (objArr2 == true ? 1 : 0).close();
                }
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                }
                return false;
            }
        }
        if (query == null) {
            query = context.getContentResolver().query(com.vivo.push.x.c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
        }
        if (query == null) {
            t.a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e6) {
                    t.a("Utility", "close", e6);
                }
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return false;
        }
        if (!query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
        if (query != null) {
            try {
                query.close();
            } catch (Exception e7) {
                t.a("Utility", "close", e7);
            }
        }
        if (contentProviderClient != null) {
            contentProviderClient.close();
        }
        return parseBoolean;
    }

    public static boolean a(Context context, String str, boolean z) {
        Cursor a2;
        Cursor cursor = null;
        try {
            try {
                try {
                    Uri uri = com.vivo.push.x.e;
                    String[] strArr = new String[2];
                    strArr[0] = str;
                    strArr[1] = z ? "1" : "0";
                    a2 = a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            t.a("Utility", "close", e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                t.a("Utility", "syncAgreePrivacyStatement", e3);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Exception e4) {
            t.a("Utility", "close", e4);
        }
        if (a2 == null) {
            t.a("Utility", "cursor is null");
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception e5) {
                    t.a("Utility", "close", e5);
                }
            }
            return false;
        }
        if (!a2.moveToFirst()) {
            if (a2 != null) {
                a2.close();
            }
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(a2.getString(a2.getColumnIndex("agreePrivacyStatement")));
        if (a2 != null) {
            try {
                a2.close();
            } catch (Exception e6) {
                t.a("Utility", "close", e6);
            }
        }
        return parseBoolean;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Cursor a(Uri uri, String str, String[] strArr, Context context) {
        ContentProviderClient contentProviderClient;
        Cursor query;
        ContentProviderClient contentProviderClient2 = null;
        try {
            if (context == null) {
                t.a("Utility", "context is null");
                return null;
            }
            contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            if (contentProviderClient != null) {
                try {
                    try {
                        t.a("Utility", "client is null");
                        query = contentProviderClient.query(uri, null, str, strArr, null);
                    } catch (Exception e2) {
                        e = e2;
                        t.a("Utility", "queryContentResolver", e);
                        if (contentProviderClient != null) {
                            try {
                                contentProviderClient.close();
                            } catch (Exception e3) {
                                t.a("Utility", "close", e3);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    contentProviderClient2 = contentProviderClient;
                    if (contentProviderClient2 != null) {
                        try {
                            contentProviderClient2.close();
                        } catch (Exception e4) {
                            t.a("Utility", "close", e4);
                        }
                    }
                    throw th;
                }
            } else {
                query = null;
            }
            if (query == null) {
                query = context.getContentResolver().query(uri, null, str, strArr, null);
            }
            if (query != null) {
                if (contentProviderClient != null) {
                    try {
                        contentProviderClient.close();
                    } catch (Exception e5) {
                        t.a("Utility", "close", e5);
                    }
                }
                return query;
            }
            t.a("Utility", "cursor is null");
            if (contentProviderClient != null) {
                try {
                    contentProviderClient.close();
                } catch (Exception e6) {
                    t.a("Utility", "close", e6);
                }
            }
            return null;
        } catch (Exception e7) {
            e = e7;
            contentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            if (contentProviderClient2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int d(Context context, String str) {
        String obj;
        int intValue;
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            t.a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
            return 0;
        }
        Object a2 = a(context, str, "sdk_version_vivo");
        if (a2 instanceof String) {
            obj = (String) a2;
        } else {
            if (a2 instanceof Integer) {
                intValue = ((Integer) a2).intValue();
                str2 = "";
                if (intValue <= 0) {
                    return intValue;
                }
                try {
                    return Integer.parseInt(str2);
                } catch (Exception e2) {
                    t.a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e2)));
                    return 0;
                }
            }
            if (a2 == null) {
                return 0;
            }
            obj = a2.toString();
        }
        str2 = obj;
        intValue = 0;
        if (intValue <= 0) {
        }
    }

    public static int c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            t.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
            return 0;
        }
        int a2 = (int) a(context, str);
        return a2 <= 0 ? d(context, str) : a2;
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }
}
