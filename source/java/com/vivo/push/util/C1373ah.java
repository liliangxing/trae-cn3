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
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ttnet.org.chromium.base.TTProcessUtils;
import com.vivo.push.C1402x;
import com.vivo.push.PushClient;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Utility.java */
/* renamed from: com.vivo.push.util.ah */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1373ah {

    /* renamed from: b */
    private static String[] f666b;

    /* renamed from: a */
    private static String[] f665a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: c */
    private static String[] f667c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: d */
    private static String[] f668d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: e */
    private static String[] f669e = new String[0];

    /* renamed from: f */
    private static Map<String, Bundle> f670f = new ConcurrentHashMap();

    /* renamed from: a */
    public static long m951a(Context context) {
        String m925a = C1366aa.m925a(context);
        if (TextUtils.isEmpty(m925a)) {
            C1393t.m1034a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return m952a(context, m925a);
    }

    /* renamed from: a */
    public static long m952a(Context context, String str) {
        Object m954a = m954a(context, str, "com.vivo.push.sdk_version");
        if (m954a == null) {
            m954a = m954a(context, str, RegistrationHeaderHelper.KEY_SDK_VERSION);
        }
        if (m954a != null) {
            try {
                return Long.parseLong(m954a.toString());
            } catch (Exception e) {
                e.printStackTrace();
                C1393t.m1035a("Utility", "getSdkVersionCode error ", e);
                return -1L;
            }
        }
        C1393t.m1034a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* renamed from: b */
    public static String m961b(Context context, String str) {
        Object m954a = m954a(context, str, "verification_status");
        return m954a != null ? m954a.toString() : "";
    }

    /* renamed from: a */
    public static Object m954a(Context context, String str, String str2) {
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f670f;
            Object obj = (map == null || map.size() <= 0 || (bundle = f670f.get(str)) == null) ? null : bundle.get(str2);
            if (obj != null) {
                return obj;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                Object obj2 = r0 != null ? r0.get(str2) : obj;
                try {
                    if (f670f.size() > 300) {
                        return obj2;
                    }
                    f670f.put(str, r0);
                    return obj2;
                } catch (Exception e) {
                    r0 = obj2;
                    e = e;
                    C1393t.m1034a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return r0;
                }
            } catch (Exception e2) {
                e = e2;
                r0 = obj;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* renamed from: a */
    public static Object m955a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
    
        r10 = r10 + 1;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m963b(Context context) throws VivoPushException {
        String obj;
        C1393t.m1048d("Utility", "check PushService AndroidManifest declearation !");
        String m925a = C1366aa.m925a(context);
        boolean m932d = C1366aa.m932d(context, context.getPackageName());
        boolean m931c = C1366aa.m931c(context, context.getPackageName());
        if (!m931c && !m932d) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        }
        if (m931c) {
            f667c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
        } else {
            f667c = new String[]{"com.vivo.push.sdk.service.CommandService"};
        }
        f668d = new String[0];
        f665a = new String[0];
        if (m932d) {
            f666b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
        } else {
            f666b = new String[]{"android.permission.INTERNET"};
        }
        if (m932d) {
            long m952a = m952a(context, context.getPackageName());
            long j = context.getPackageName().equals(m925a) ? 1356L : 356L;
            if (m952a == -1) {
                throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
            }
            if (m952a != j) {
                throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(j)));
            }
        }
        String[] strArr = f666b;
        if (strArr == null || strArr.length <= 0) {
            C1393t.m1046c("Utility", "checkPermissions sPermissions is empty");
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
            } catch (Exception e) {
                throw new VivoPushException(e.getMessage());
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
            for (String str3 : f668d) {
                m957a(str3, activityInfoArr, m925a);
            }
            try {
                if (context.getPackageManager() == null) {
                    throw new VivoPushException("localPackageManager is null");
                }
                ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                if (serviceInfoArr == null) {
                    throw new VivoPushException("serviceInfos is null");
                }
                for (String str4 : f667c) {
                    m957a(str4, serviceInfoArr, m925a);
                }
                if (f669e.length > 0) {
                    try {
                        if (context.getPackageManager() == null) {
                            throw new VivoPushException("localPackageManager is null");
                        }
                        ActivityInfo[] activityInfoArr2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                        if (activityInfoArr2 == null) {
                            throw new VivoPushException("activityInfos is null");
                        }
                        for (String str5 : f669e) {
                            m957a(str5, activityInfoArr2, m925a);
                        }
                    } catch (Exception e2) {
                        throw new VivoPushException("error " + e2.getMessage());
                    }
                }
                try {
                    if (m954a(context, context.getPackageName(), "local_iv") != null) {
                        String packageName = context.getPackageName();
                        Object m954a = m954a(context, packageName, "com.vivo.push.api_key");
                        String str6 = "";
                        if (m954a != null) {
                            obj = m954a.toString();
                        } else {
                            Object m954a2 = m954a(context, packageName, "api_key");
                            obj = m954a2 != null ? m954a2.toString() : "";
                        }
                        if (TextUtils.isEmpty(obj)) {
                            throw new VivoPushException("com.vivo.push.api_key is null");
                        }
                        String packageName2 = context.getPackageName();
                        Object m954a3 = m954a(context, packageName2, "com.vivo.push.app_id");
                        if (m954a3 != null) {
                            str6 = m954a3.toString();
                        } else {
                            Object m954a4 = m954a(context, packageName2, "app_id");
                            if (m954a4 != null) {
                                str6 = m954a4.toString();
                            }
                        }
                        if (TextUtils.isEmpty(str6)) {
                            throw new VivoPushException("com.vivo.push.app_id is null");
                        }
                        if (m932d && m952a(context, context.getPackageName()) == -1) {
                            throw new VivoPushException("sdkversion is null");
                        }
                        return;
                    }
                    throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
                } catch (Exception e3) {
                    throw new VivoPushException("getMetaValue error " + e3.getMessage());
                }
            } catch (Exception e4) {
                throw new VivoPushException("error " + e4.getMessage());
            }
        } catch (Exception e5) {
            throw new VivoPushException(e5.getMessage());
        }
    }

    /* renamed from: a */
    private static void m957a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (!componentInfo.enabled) {
                    throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
                }
                m956a(componentInfo, str2);
                return;
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    /* renamed from: a */
    private static void m956a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f665a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX)) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    /* renamed from: b */
    public static String m962b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e) {
            e.printStackTrace();
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
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey m965c(Context context) {
        ContentProviderClient contentProviderClient;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        try {
            try {
                try {
                    contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(C1402x.f728a);
                    if (contentProviderClient != null) {
                        try {
                            C1393t.m1034a("Utility", "client is null");
                            cursor = contentProviderClient.query(C1402x.f728a, null, null, null, null);
                        } catch (Exception e) {
                            e = e;
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
                            cursor = context.getContentResolver().query(C1402x.f728a, null, null, null, null);
                        } catch (Exception e2) {
                            e = e2;
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
                            C1393t.m1048d("Utility", "result key : ".concat(String.valueOf(string)));
                            PublicKey m936a = C1367ab.m936a(string);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (contentProviderClient != null) {
                                contentProviderClient.close();
                            }
                            return m936a;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor3 = cursor2;
                }
            } catch (Exception e3) {
                e = e3;
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
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m967d(Context context) {
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
                        } catch (Exception e) {
                            C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e);
                            throw th;
                        }
                    }
                    if (0 != 0) {
                        throw th;
                    }
                    (objArr == true ? 1 : 0).close();
                    throw th;
                }
            } catch (Exception e2) {
                C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e2);
            }
        } catch (Exception e3) {
            e = e3;
            contentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
        }
        if (context == null) {
            C1393t.m1034a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(C1402x.f729b);
        if (contentProviderClient != null) {
            try {
                C1393t.m1034a("Utility", "client is null");
                query = contentProviderClient.query(C1402x.f729b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"356", packageName, String.valueOf(i)}, null);
            } catch (Exception e4) {
                e = e4;
                C1393t.m1035a("Utility", "isSupport", e);
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
            query = context.getContentResolver().query(C1402x.f729b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"356", packageName, String.valueOf(i)}, null);
        }
        if (query == null) {
            C1393t.m1034a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e5);
                }
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return false;
        }
        if (!query.moveToFirst() || (query.getInt(query.getColumnIndex(CloudControlInf.PERMISSION)) & 1) == 0) {
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
            } catch (Exception e6) {
                C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e6);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m958a(Context context, String str, String str2, long j) {
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
                        } catch (Exception e) {
                            C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e);
                            throw th;
                        }
                    }
                    if (0 != 0) {
                        throw th;
                    }
                    (objArr == true ? 1 : 0).close();
                    throw th;
                }
            } catch (Exception e2) {
                C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e2);
            }
        } catch (Exception e3) {
            e = e3;
            contentProviderClient = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
        }
        if (context == null) {
            C1393t.m1034a("Utility", "context is null");
            return false;
        }
        contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(C1402x.f730c);
        if (contentProviderClient != null) {
            try {
                C1393t.m1034a("Utility", "client is null");
                query = contentProviderClient.query(C1402x.f730c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
            } catch (Exception e4) {
                e = e4;
                C1393t.m1035a("Utility", "isOverdue", e);
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
            query = context.getContentResolver().query(C1402x.f730c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j)}, null);
        }
        if (query == null) {
            C1393t.m1034a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e5);
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
            } catch (Exception e6) {
                C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e6);
            }
        }
        if (contentProviderClient != null) {
            contentProviderClient.close();
        }
        return parseBoolean;
    }

    /* renamed from: a */
    public static boolean m959a(Context context, String str, boolean z) {
        Cursor m953a;
        Cursor cursor = null;
        try {
            try {
                try {
                    Uri uri = C1402x.f732e;
                    String[] strArr = new String[2];
                    strArr[0] = str;
                    strArr[1] = z ? PushClient.DEFAULT_REQUEST_ID : "0";
                    m953a = m953a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e);
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                C1393t.m1035a("Utility", "syncAgreePrivacyStatement", e2);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Exception e3) {
            C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e3);
        }
        if (m953a == null) {
            C1393t.m1034a("Utility", "cursor is null");
            if (m953a != null) {
                try {
                    m953a.close();
                } catch (Exception e4) {
                    C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e4);
                }
            }
            return false;
        }
        if (!m953a.moveToFirst()) {
            if (m953a != null) {
                m953a.close();
            }
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(m953a.getString(m953a.getColumnIndex("agreePrivacyStatement")));
        if (m953a != null) {
            try {
                m953a.close();
            } catch (Exception e5) {
                C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e5);
            }
        }
        return parseBoolean;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Cursor m953a(Uri uri, String str, String[] strArr, Context context) {
        ContentProviderClient contentProviderClient;
        Cursor query;
        ContentProviderClient contentProviderClient2 = null;
        try {
            if (context == null) {
                C1393t.m1034a("Utility", "context is null");
                return null;
            }
            contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            if (contentProviderClient != null) {
                try {
                    try {
                        C1393t.m1034a("Utility", "client is null");
                        query = contentProviderClient.query(uri, null, str, strArr, null);
                    } catch (Exception e) {
                        e = e;
                        C1393t.m1035a("Utility", "queryContentResolver", e);
                        if (contentProviderClient != null) {
                            try {
                                contentProviderClient.close();
                            } catch (Exception e2) {
                                C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e2);
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
                        } catch (Exception e3) {
                            C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e3);
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
                    } catch (Exception e4) {
                        C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e4);
                    }
                }
                return query;
            }
            C1393t.m1034a("Utility", "cursor is null");
            if (contentProviderClient != null) {
                try {
                    contentProviderClient.close();
                } catch (Exception e5) {
                    C1393t.m1035a("Utility", PushCommonConstants.VALUE_CLOSE, e5);
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
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
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int m966d(Context context, String str) {
        String obj;
        int intValue;
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            C1393t.m1034a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
            return 0;
        }
        Object m954a = m954a(context, str, "sdk_version_vivo");
        if (m954a instanceof String) {
            obj = (String) m954a;
        } else {
            if (m954a instanceof Integer) {
                intValue = ((Integer) m954a).intValue();
                str2 = "";
                if (intValue <= 0) {
                    return intValue;
                }
                try {
                    return Integer.parseInt(str2);
                } catch (Exception e) {
                    C1393t.m1034a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e)));
                    return 0;
                }
            }
            if (m954a == null) {
                return 0;
            }
            obj = m954a.toString();
        }
        str2 = obj;
        intValue = 0;
        if (intValue <= 0) {
        }
    }

    /* renamed from: c */
    public static int m964c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C1393t.m1034a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
            return 0;
        }
        int m952a = (int) m952a(context, str);
        return m952a <= 0 ? m966d(context, str) : m952a;
    }

    /* renamed from: a */
    public static boolean m960a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }
}
