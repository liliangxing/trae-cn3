package com.vivo.push;

import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.p011c.C1231a;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.p021b.InterfaceC1331a;
import com.vivo.push.util.C1393t;

/* compiled from: SubscribeImpl.java */
/* renamed from: com.vivo.push.z */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1404z implements InterfaceC1304k {

    /* renamed from: a */
    private C1403y f735a = new C1403y();

    /* renamed from: b */
    private C1403y f736b = new C1403y();

    /* renamed from: c */
    private C1231a f737c;

    /* renamed from: d */
    private volatile String f738d;

    /* renamed from: e */
    private InterfaceC1331a f739e;

    public C1404z(C1231a c1231a, InterfaceC1331a interfaceC1331a) {
        this.f737c = c1231a;
        this.f739e = interfaceC1331a;
    }

    @Override // com.vivo.push.InterfaceC1304k
    /* renamed from: a */
    public final void mo754a(IPushActionListener iPushActionListener, String str, String str2) {
        if (!this.f737c.m644c() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(AVMDLDataLoader.KeyIsLiveRecvDataTimeout);
        } else {
            C1306m.m762a().m785b(iPushActionListener, str, str2);
        }
    }

    @Override // com.vivo.push.InterfaceC1304k
    /* renamed from: a */
    public final int mo753a() {
        return m1073c();
    }

    @Override // com.vivo.push.InterfaceC1304k
    /* renamed from: b */
    public final String mo757b() {
        if (!TextUtils.isEmpty(this.f738d)) {
            return this.f738d;
        }
        String m1074d = m1074d();
        if (TextUtils.isEmpty(m1074d)) {
            m1074d = this.f739e.mo866f();
            C1357t.m917b(new RunnableC1201aa(this, m1074d));
        }
        this.f738d = m1074d;
        C1393t.m1048d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(m1074d)));
        return m1074d;
    }

    @Override // com.vivo.push.InterfaceC1304k
    /* renamed from: a */
    public final void mo756a(String str, String str2, String str3) {
        m1075d(str);
        this.f739e.mo857a(str2);
        this.f739e.mo859b(str3);
    }

    @Override // com.vivo.push.InterfaceC1304k
    /* renamed from: a */
    public final void mo755a(String str) {
        m1075d(str);
        this.f739e.mo862d();
        this.f739e.mo858b();
    }

    @Override // com.vivo.push.InterfaceC1304k
    /* renamed from: b */
    public final void mo758b(String str) {
        m1075d(str);
        C1306m.m762a().m790e();
        this.f739e.mo868h();
        this.f739e.mo862d();
        this.f739e.mo858b();
    }

    @Override // com.vivo.push.InterfaceC1304k
    /* renamed from: c */
    public final void mo759c(String str) {
        m1075d(str);
    }

    /* renamed from: d */
    private void m1075d(String str) {
        this.f738d = str;
        this.f739e.mo861c(this.f738d);
    }

    /* renamed from: c */
    private int m1073c() {
        if (!this.f737c.m645d()) {
            return AVMDLDataLoader.KeyIsLivePlayInfoAudioMixingStart;
        }
        if (this.f736b.m1071a()) {
            C1393t.m1048d("SubscribeImpl", "isAppSubscribe 两秒内重复调用  ");
            return 1002;
        }
        int i = 1;
        try {
            String mo677a = new C1243e(1, C1313a.m810a().m812b().getPackageName(), "", "", C1313a.m810a().m815e().mo866f()).mo677a();
            C1393t.m1048d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(mo677a)));
            String m638a = C1231a.m638a(C1313a.m810a().m812b(), mo677a);
            C1393t.m1048d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(m638a)));
            if (!TextUtils.isEmpty(m638a)) {
                i = 1 ^ (Boolean.parseBoolean(((C1259g) C1259g.f441a.mo682a(m638a)).m689b()) ? 1 : 0);
            }
        } catch (Exception e) {
            C1393t.m1035a("SubscribeImpl", "isAppSubscribe", e);
        }
        C1393t.m1048d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i)));
        return i;
    }

    /* renamed from: d */
    private String m1074d() {
        String str = "";
        if (!this.f737c.m645d()) {
            C1393t.m1048d("SubscribeImpl", "getRegidByCoreSdk 系统不支持查询regid  ");
            return "";
        }
        if (this.f735a.m1071a()) {
            C1393t.m1048d("SubscribeImpl", "getRegidByCoreSdk 两秒内重复调用  ");
            return "";
        }
        try {
            String mo677a = new C1243e(2, C1313a.m810a().m812b().getPackageName(), "", "", C1313a.m810a().m815e().mo866f()).mo677a();
            C1393t.m1048d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(mo677a)));
            String m638a = C1231a.m638a(C1313a.m810a().m812b(), mo677a);
            C1393t.m1048d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(m638a)));
            if (!TextUtils.isEmpty(m638a)) {
                str = ((C1259g) C1259g.f441a.mo682a(m638a)).m689b();
            }
        } catch (Exception e) {
            C1393t.m1035a("SubscribeImpl", "getRegidByCoreSdk", e);
        }
        C1393t.m1048d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(str)));
        return str;
    }
}
