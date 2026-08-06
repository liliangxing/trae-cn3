package com.vivo.push.restructure.request;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.ServiceConnectionC1301i;
import com.vivo.push.p009a.C1200a;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.restructure.request.p023a.C1340a;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.util.C1393t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: RequestManager.java */
/* renamed from: com.vivo.push.restructure.request.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1349d {

    /* renamed from: a */
    private Map<Integer, C1347b> f617a;

    /* renamed from: b */
    private Integer f618b;

    /* renamed from: c */
    private HandlerThread f619c;

    /* renamed from: d */
    private Handler f620d;

    /* compiled from: RequestManager.java */
    /* renamed from: com.vivo.push.restructure.request.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class a {

        /* renamed from: a */
        static C1349d f621a = new C1349d(0);
    }

    /* synthetic */ C1349d(byte b) {
        this();
    }

    private C1349d() {
        this.f617a = new ConcurrentHashMap();
        this.f618b = null;
        HandlerThread handlerThread = new HandlerThread("request_timer_task——thread");
        this.f619c = handlerThread;
        handlerThread.start();
        this.f620d = new HandlerC1350e(this, this.f619c.getLooper());
    }

    /* renamed from: a */
    public static C1349d m901a() {
        return a.f621a;
    }

    /* renamed from: b */
    private synchronized Integer m903b() {
        Integer valueOf;
        if (this.f618b == null) {
            this.f618b = 0;
        }
        if (this.f618b.intValue() < 0 || this.f618b.intValue() >= Integer.MAX_VALUE) {
            this.f618b = 0;
        }
        valueOf = Integer.valueOf(this.f618b.intValue() + 1);
        this.f618b = valueOf;
        return new Integer(valueOf.intValue());
    }

    /* renamed from: a */
    public final void m905a(C1347b c1347b) {
        Integer m903b = m903b();
        int m900a = m900a(c1347b.m897a().m882a(m903b.intValue()));
        if (m900a != 0) {
            if (c1347b.m898b() != null) {
                c1347b.m898b().mo671a(m900a);
            }
        } else {
            if (c1347b.m899c() <= 0 || c1347b.m898b() == null) {
                return;
            }
            this.f617a.put(m903b, c1347b);
            this.f620d.sendEmptyMessageDelayed(m903b.intValue(), c1347b.m899c());
        }
    }

    /* renamed from: a */
    public final void m904a(InterfaceC1314a interfaceC1314a) {
        C1340a mo826h;
        int m884b;
        C1341a c1341a;
        if (interfaceC1314a == null || !interfaceC1314a.mo825g() || (m884b = (mo826h = interfaceC1314a.mo826h()).m884b()) <= 0) {
            return;
        }
        this.f620d.removeMessages(m884b);
        C1347b remove = this.f617a.remove(Integer.valueOf(m884b));
        if (remove == null || remove.m898b() == null || remove.m897a() == null) {
            return;
        }
        if (mo826h.m885c() == 0) {
            try {
                c1341a = new C1341a(interfaceC1314a.mo827i());
            } catch (JSONException e) {
                e.printStackTrace();
                c1341a = null;
            }
            if (c1341a != null) {
                remove.m898b().mo672a((InterfaceC1348c) remove.m897a().mo665a(c1341a));
                return;
            } else {
                remove.m898b().mo671a(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
                return;
            }
        }
        remove.m898b().mo671a(mo826h.m885c());
    }

    /* renamed from: a */
    private static int m900a(Intent intent) {
        Context m812b = C1313a.m810a().m812b();
        if (m812b == null) {
            return AVMDLDataLoader.KeyIsLiveGetP2pState;
        }
        ServiceConnectionC1301i m738a = ServiceConnectionC1301i.m738a(m812b, "com.vivo.vms.aidlservice");
        if (m738a.m748a() && !"com.vivo.pushservice".equals(m812b.getPackageName())) {
            if (m738a.m749a(intent.getExtras())) {
                return 0;
            }
            C1393t.m1041b("RequestManager", "send command error by aidl");
            C1393t.m1047c(m812b, "send command error by aidl");
        }
        String mo871k = C1313a.m810a().m815e().mo871k();
        if (TextUtils.isEmpty(mo871k)) {
            return 8001;
        }
        Intent intent2 = new Intent("com.vivo.pushservice.action.METHOD");
        intent2.setPackage(mo871k);
        intent2.setClassName(mo871k, "com.vivo.push.sdk.service.PushService");
        try {
            C1200a.m575a(m812b, intent2);
        } catch (Exception e) {
            C1393t.m1035a("RequestManager", "CommandBridge startService exception: ", e);
        }
        return 0;
    }
}
