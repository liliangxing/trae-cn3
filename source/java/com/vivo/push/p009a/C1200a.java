package com.vivo.push.p009a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;
import com.vivo.push.ServiceConnectionC1301i;
import com.vivo.push.p010b.C1217n;
import com.vivo.push.p016g.C1261b;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1367ab;
import com.vivo.push.util.C1393t;
import java.util.List;

/* compiled from: CommandBridge.java */
/* renamed from: com.vivo.push.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1200a {
    /* renamed from: a */
    public static void m577a(Context context, String str, AbstractC1400v abstractC1400v) {
        boolean mo634d = abstractC1400v.mo634d();
        ServiceConnectionC1301i m738a = ServiceConnectionC1301i.m738a(context, mo634d ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean m748a = m738a.m748a();
        if (TextUtils.isEmpty(abstractC1400v.m1063a())) {
            abstractC1400v.m1066a(context.getPackageName());
        }
        if (m748a && !"com.vivo.pushservice".equals(context.getPackageName())) {
            C1232d c1232d = new C1232d(abstractC1400v.m1063a(), str, new Bundle());
            abstractC1400v.m1065a(c1232d);
            if (m738a.m749a(c1232d.m660b())) {
                return;
            }
            C1393t.m1041b("CommandBridge", "send command error by aidl");
            C1393t.m1047c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, mo634d ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        abstractC1400v.m1064a(intent);
        try {
            m575a(context, intent);
        } catch (Exception e) {
            C1393t.m1035a("CommandBridge", "CommandBridge startService exception: ", e);
        }
    }

    /* renamed from: a */
    public static void m575a(Context context, Intent intent) throws Exception {
        if (context == null) {
            C1393t.m1048d("CommandBridge", "enter startService context is null");
            throw new Exception("context is null");
        }
        try {
            context.startService(intent);
        } catch (Exception e) {
            C1393t.m1035a("CommandBridge", "start service error", e);
            intent.setComponent(null);
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    public static void m576a(Context context, C1217n c1217n, String str) {
        try {
            boolean m932d = C1366aa.m932d(context, str);
            String str2 = m932d ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (TextUtils.isEmpty(str)) {
                C1393t.m1047c(context, "消息接受者包名为空！");
                throw new Exception("消息接受者包名为空！");
            }
            if (m932d || m578a(context, str2, str)) {
                if (TextUtils.isEmpty(c1217n.m1063a())) {
                    c1217n.m1066a(context.getPackageName());
                }
                Intent intent = new Intent();
                intent.setFlags(1048576);
                if (!TextUtils.isEmpty(str2)) {
                    intent.setAction(str2);
                }
                intent.setPackage(str);
                intent.setClassName(str, m932d ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                c1217n.m1068b(intent);
                intent.putExtra("command_type", "reflect_receiver");
                intent.putExtra("security_avoid_pull_rsa", C1261b.m693a().m694a(context).mo690a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", C1367ab.m935a(C1261b.m693a().m694a(context).mo691a()));
                m575a(context, intent);
            }
        } catch (Exception e) {
            C1393t.m1035a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
        }
    }

    /* renamed from: a */
    private static boolean m578a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            C1393t.m1041b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            C1393t.m1041b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
