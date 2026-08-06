package com.vivo.push.restructure.p019a.p020a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.http.legacy.protocol.HTTP;
import com.vivo.push.PushClient;
import com.vivo.push.p016g.C1261b;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.sdk.C1353a;
import com.vivo.push.util.C1365a;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1367ab;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1393t;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CheckNode.java */
/* renamed from: com.vivo.push.restructure.a.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1317c extends AbstractC1315a<InterfaceC1314a> {

    /* renamed from: b */
    private static final List<Integer> f567b = Arrays.asList(3);

    @Override // com.vivo.push.restructure.p019a.p020a.AbstractC1315a
    /* renamed from: a */
    protected final /* bridge */ /* synthetic */ int mo834a(InterfaceC1314a interfaceC1314a) {
        return a2(interfaceC1314a);
    }

    public C1317c(InterfaceC1314a interfaceC1314a, C1324j c1324j) {
        super("CheckNode", interfaceC1314a, c1324j);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(InterfaceC1314a interfaceC1314a) {
        try {
        } catch (Exception e) {
            C1393t.m1036a("CheckNode", e);
        }
        if (!C1313a.m810a().m815e().mo873m().isAgreePrivacyStatement()) {
            C1393t.m1048d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");
            return 2809;
        }
        Intent mo820b = interfaceC1314a.mo820b();
        String m912b = C1353a.m908a().m912b();
        if (!TextUtils.isEmpty(m912b) && m912b.contains("CommandService")) {
            if (!(mo820b != null && m840a(mo820b) && m841a(mo820b, interfaceC1314a))) {
                C1393t.m1034a("CheckNode", " !checkIntentIsSecurity(intent)");
                return 2801;
            }
        }
        Context m812b = C1313a.m810a().m812b();
        String packageName = m812b.getPackageName();
        String stringExtra = mo820b.getStringExtra("command_type");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = mo820b.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = mo820b.getIntExtra("method", -1);
            }
            if (f567b.contains(Integer.valueOf(intExtra)) && C1366aa.m931c(m812b, packageName) && !C1366aa.m929b(m812b)) {
                C1393t.m1034a("CheckNode", "METHOD_ON_MESSAGE is not support");
                return 2803;
            }
            String action = mo820b.getAction();
            if (TextUtils.isEmpty(C1313a.m810a().m815e().mo855a(m812b, action))) {
                C1393t.m1048d("CheckNode", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                mo820b.setPackage(packageName);
                m812b.sendBroadcast(mo820b);
                return 2802;
            }
            return 0;
        }
        C1393t.m1034a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2801;
    }

    /* renamed from: a */
    private static boolean m840a(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("security_avoid_pull");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String m923a = C1365a.m920a(C1313a.m810a().m812b()).m923a(stringExtra);
                    if ("com.vivo.pushservice".equals(m923a)) {
                        return true;
                    }
                    C1393t.m1034a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(m923a)));
                    return false;
                } catch (Exception e) {
                    C1393t.m1034a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
                    return false;
                }
            }
            C1393t.m1034a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        } catch (Exception unused) {
            C1393t.m1034a("CheckNode", "getStringExtra error");
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m841a(Intent intent, InterfaceC1314a interfaceC1314a) {
        try {
            Context m812b = C1313a.m810a().m812b();
            String m961b = C1373ah.m961b(m812b, "com.vivo.pushservice");
            C1393t.m1048d("CheckNode", " 配置的验签参数 = ".concat(String.valueOf(m961b)));
            if (!TextUtils.equals(m961b, PushClient.DEFAULT_REQUEST_ID)) {
                return true;
            }
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                if (C1261b.m693a().m694a(m812b).mo692a("com.vivo.pushservice".getBytes(HTTP.UTF_8), C1367ab.m936a(stringExtra2), Base64.decode(stringExtra, 2))) {
                    C1393t.m1048d("CheckNode", " RSA验签通过  ");
                    return true;
                }
                C1393t.m1046c("CheckNode", " 验签参数传入错误 securityContent = " + stringExtra + " publickKey= " + stringExtra2 + " receivedMsg isempty? " + (interfaceC1314a == null) + " receivedMsg isClickMsg? " + (interfaceC1314a == null ? false : interfaceC1314a.mo829k()));
                if (interfaceC1314a != null && interfaceC1314a.mo829k() && (TextUtils.equals(stringExtra, "com.vivo.pushservice") || TextUtils.equals(stringExtra2, "com.vivo.pushservice"))) {
                    return true;
                }
                C1393t.m1048d("CheckNode", " RSA验签 不通过  ");
                return false;
            }
            C1393t.m1034a("CheckNode", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        } catch (Exception e) {
            C1393t.m1034a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
            return true;
        }
    }
}
