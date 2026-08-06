package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.service.AbstractC1756an;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.xiaomi.mipush.sdk.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1454m {
    /* renamed from: a */
    public static void m1322a(final Context context) {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.m.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4612);
                    C1454m.m1330c(context);
                    C1454m.m1332d(context, packageInfo);
                    C1454m.m1331c(context, packageInfo);
                } catch (Throwable th) {
                    Log.e("ManifestChecker", "", th);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m1331c(Context context, PackageInfo packageInfo) {
        boolean z;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
        if (packageInfo.permissions != null) {
            for (PermissionInfo permissionInfo : packageInfo.permissions) {
                if (str.equals(permissionInfo.name)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
        }
        if (packageInfo.requestedPermissions != null) {
            for (String str2 : packageInfo.requestedPermissions) {
                if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                    hashSet.remove(str2);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m1332d(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.shouldUseMIUIPush(context) || m1326a(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.getOpenFCMPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.getOpenOPPOPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        if (packageInfo.services != null) {
            for (ServiceInfo serviceInfo : packageInfo.services) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    b bVar = (b) hashMap2.remove(serviceInfo.name);
                    boolean z = bVar.f862a;
                    boolean z2 = bVar.f864b;
                    String str = bVar.f863b;
                    if (z != serviceInfo.enabled) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z)));
                    }
                    if (z2 != serviceInfo.exported) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z2)));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, serviceInfo.permission)) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                    }
                    hashMap.put(serviceInfo.name, serviceInfo.processName);
                    if (hashMap2.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashMap2.isEmpty()) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.keySet().iterator().next()));
        }
        if (!TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        }
        if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
        }
    }

    /* renamed from: a */
    private static boolean m1326a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (m1327a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m1327a(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static ActivityInfo m1321a(PackageManager packageManager, Intent intent, Class<?> cls) {
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m1325a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
        }
        if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa A[EDGE_INSN: B:23:0x00aa->B:24:0x00aa BREAK  A[LOOP:0: B:8:0x0076->B:37:0x0076], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1330c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(AbstractC1756an.f3057q);
        intent.setPackage(packageName);
        try {
            ActivityInfo m1321a = m1321a(packageManager, intent, C1702q.m3463a(context, "com.xiaomi.push.service.receivers.PingReceiver"));
            if (MiPushClient.shouldUseMIUIPush(context)) {
                if (m1321a != null) {
                    m1325a(m1321a, new Boolean[]{true, false});
                }
            } else {
                if (m1321a == null) {
                    throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", "com.xiaomi.push.service.receivers.PingReceiver"));
                }
                m1325a(m1321a, new Boolean[]{true, false});
            }
        } catch (ClassNotFoundException e) {
            AbstractC1417b.m1093a(e);
        }
        Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent2.setPackage(packageName);
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent2, 16384).iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null) {
                try {
                } catch (ClassNotFoundException e2) {
                    AbstractC1417b.m1093a(e2);
                }
                if (!TextUtils.isEmpty(activityInfo.name) && PushMessageReceiver.class.isAssignableFrom(C1702q.m3463a(context, activityInfo.name)) && activityInfo.enabled) {
                    z = true;
                    if (!z) {
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        if (!z) {
            throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
        }
        if (MiPushClient.getOpenHmsPush(context)) {
            m1324a(context, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
            m1324a(context, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
        }
        if (MiPushClient.getOpenVIVOPush(context)) {
            m1324a(context, "com.vivo.pushclient.action.RECEIVE", "com.xiaomi.assemble.control.FTOSPushMessageReceiver");
        }
    }

    /* renamed from: a */
    private static void m1324a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            z = (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) ? false : true;
            if (z) {
                break;
            }
        }
        if (!z) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.m$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class b {

        /* renamed from: a */
        public String f861a;

        /* renamed from: a */
        public boolean f862a;

        /* renamed from: b */
        public String f863b;

        /* renamed from: b */
        public boolean f864b;

        public b(String str, boolean z, boolean z2, String str2) {
            this.f861a = str;
            this.f862a = z;
            this.f864b = z2;
            this.f863b = str2;
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.m$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }
}
