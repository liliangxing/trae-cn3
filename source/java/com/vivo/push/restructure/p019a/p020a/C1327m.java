package com.vivo.push.restructure.p019a.p020a;

import android.text.TextUtils;
import com.vivo.push.p010b.C1211h;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.util.C1393t;

/* compiled from: NodeReportItem.java */
/* renamed from: com.vivo.push.restructure.a.a.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1327m {

    /* renamed from: a */
    private String f578a;

    /* renamed from: b */
    private String f579b;

    public C1327m(InterfaceC1314a interfaceC1314a, String str) {
        if (interfaceC1314a != null) {
            this.f578a = interfaceC1314a.mo819a();
        }
        this.f579b = str;
    }

    /* renamed from: a */
    public final C1211h m848a() {
        if (TextUtils.isEmpty(this.f578a) || TextUtils.isEmpty(this.f579b)) {
            C1393t.m1039a("convertOffLineMsg() error, mMessageID = " + this.f578a + ", mNodeArrayInfo = " + this.f579b);
            return null;
        }
        return new C1211h(this.f578a, this.f579b);
    }
}
