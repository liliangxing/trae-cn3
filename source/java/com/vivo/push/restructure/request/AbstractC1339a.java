package com.vivo.push.restructure.request;

import android.content.Intent;
import android.os.Bundle;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.request.p023a.C1345c;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;

/* compiled from: BaseCommand.java */
/* renamed from: com.vivo.push.restructure.request.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1339a<I extends InterfaceC1342b, O extends InterfaceC1342b> {

    /* renamed from: a */
    private int f597a;

    /* renamed from: b */
    private I f598b;

    /* renamed from: a */
    public abstract O mo665a(C1341a c1341a);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1339a(int i, I i2) {
        this.f597a = i;
        this.f598b = i2;
    }

    /* renamed from: a */
    public final Intent m882a(int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("client_pkgname", C1313a.m810a().m812b().getPackageName());
        bundle.putBoolean("support_rf", true);
        C1345c c1345c = new C1345c(this.f597a, i);
        C1341a c1341a = new C1341a();
        c1345c.mo673a(c1341a);
        bundle.putString("cf_content", c1341a.m896e());
        C1341a c1341a2 = new C1341a();
        this.f598b.mo673a(c1341a2);
        bundle.putString("content", c1341a2.m896e());
        intent.putExtras(bundle);
        return intent;
    }
}
