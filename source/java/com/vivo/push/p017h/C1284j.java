package com.vivo.push.p017h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.AbstractRunnableC1352s;
import com.vivo.push.p010b.C1213j;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1393t;
import java.util.List;

/* compiled from: OnChangePushStatusReceiveTask.java */
/* renamed from: com.vivo.push.h.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1284j extends AbstractRunnableC1352s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1284j(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    /* renamed from: a */
    private static List<ResolveInfo> m721a(Context context) {
        List<ResolveInfo> list;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            return list;
        }
        Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        try {
            return context.getPackageManager().queryBroadcastReceivers(intent2, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
        } catch (Exception unused2) {
            return list;
        }
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        if (this.f625a.getPackageName().equals(C1366aa.m925a(this.f625a))) {
            return;
        }
        C1213j c1213j = (C1213j) abstractC1400v;
        int m596e = c1213j.m596e();
        int m597f = c1213j.m597f();
        C1393t.m1048d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + m596e + " ; receiverStatus is " + m597f);
        if (m596e == 2) {
            Context context = this.f625a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                C1393t.m1034a("OnChangePushStatusTask", "disableService error: can not find push service.");
            } else {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                    C1393t.m1048d("OnChangePushStatusTask", "disableService push service.");
                } else {
                    C1393t.m1048d("OnChangePushStatusTask", "push service has disabled");
                }
            }
        } else if (m596e == 1) {
            Context context2 = this.f625a;
            Intent intent2 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent2.setPackage(context2.getPackageName());
            List<ResolveInfo> queryIntentServices2 = context2.getPackageManager().queryIntentServices(intent2, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
            if (queryIntentServices2 == null || queryIntentServices2.size() <= 0) {
                C1393t.m1034a("OnChangePushStatusTask", "enableService error: can not find push service.");
            } else {
                PackageManager packageManager2 = context2.getPackageManager();
                ComponentName componentName2 = new ComponentName(context2, queryIntentServices2.get(0).serviceInfo.name);
                if (packageManager2.getComponentEnabledSetting(componentName2) != 1) {
                    packageManager2.setComponentEnabledSetting(componentName2, 1, 1);
                    C1393t.m1048d("OnChangePushStatusTask", "enableService push service.");
                } else {
                    C1393t.m1048d("OnChangePushStatusTask", "push service has enabled");
                }
            }
        } else if (m596e == 0) {
            Context context3 = this.f625a;
            Intent intent3 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent3.setPackage(context3.getPackageName());
            List<ResolveInfo> queryIntentServices3 = context3.getPackageManager().queryIntentServices(intent3, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
            if (queryIntentServices3 == null || queryIntentServices3.size() <= 0) {
                C1393t.m1034a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            } else {
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, queryIntentServices3.get(0).serviceInfo.name);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 0) {
                    packageManager3.setComponentEnabledSetting(componentName3, 0, 1);
                    C1393t.m1048d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    C1393t.m1048d("OnChangePushStatusTask", "push service has defaulted");
                }
            }
        }
        if (m597f == 2) {
            Context context4 = this.f625a;
            List<ResolveInfo> m721a = m721a(context4);
            if (m721a == null || m721a.size() <= 0) {
                C1393t.m1034a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
                return;
            }
            String str = m721a.get(0).activityInfo.name;
            if (TextUtils.isEmpty(str)) {
                C1393t.m1048d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                return;
            }
            PackageManager packageManager4 = context4.getPackageManager();
            ComponentName componentName4 = new ComponentName(context4, str);
            if (packageManager4.getComponentEnabledSetting(componentName4) != 2) {
                packageManager4.setComponentEnabledSetting(componentName4, 2, 1);
                C1393t.m1048d("OnChangePushStatusTask", "push service disableReceiver ");
                return;
            } else {
                C1393t.m1048d("OnChangePushStatusTask", "push service has disableReceiver ");
                return;
            }
        }
        if (m597f == 1) {
            Context context5 = this.f625a;
            List<ResolveInfo> m721a2 = m721a(context5);
            if (m721a2 == null || m721a2.size() <= 0) {
                C1393t.m1034a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
                return;
            }
            String str2 = m721a2.get(0).activityInfo.name;
            if (TextUtils.isEmpty(str2)) {
                C1393t.m1048d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                return;
            }
            PackageManager packageManager5 = context5.getPackageManager();
            ComponentName componentName5 = new ComponentName(context5, str2);
            if (packageManager5.getComponentEnabledSetting(componentName5) != 1) {
                packageManager5.setComponentEnabledSetting(componentName5, 1, 1);
                C1393t.m1048d("OnChangePushStatusTask", "push service enableReceiver ");
                return;
            } else {
                C1393t.m1048d("OnChangePushStatusTask", "push service has enableReceiver ");
                return;
            }
        }
        if (m597f == 0) {
            Context context6 = this.f625a;
            List<ResolveInfo> m721a3 = m721a(context6);
            if (m721a3 == null || m721a3.size() <= 0) {
                C1393t.m1034a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
                return;
            }
            String str3 = m721a3.get(0).activityInfo.name;
            if (TextUtils.isEmpty(str3)) {
                C1393t.m1048d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                return;
            }
            PackageManager packageManager6 = context6.getPackageManager();
            ComponentName componentName6 = new ComponentName(context6, str3);
            if (packageManager6.getComponentEnabledSetting(componentName6) != 0) {
                packageManager6.setComponentEnabledSetting(componentName6, 0, 1);
                C1393t.m1048d("OnChangePushStatusTask", "push service defaultReceiver ");
            } else {
                C1393t.m1048d("OnChangePushStatusTask", "push service has defaulted");
            }
        }
    }
}
