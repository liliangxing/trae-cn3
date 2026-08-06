package com.vivo.push.p010b;

import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;
import com.vivo.push.C1232d;

/* compiled from: AppCommand.java */
/* renamed from: com.vivo.push.b.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1205b extends C1206c {

    /* renamed from: a */
    private String f334a;

    /* renamed from: b */
    private String f335b;

    /* renamed from: c */
    private int f336c;

    /* renamed from: d */
    private boolean f337d;

    public C1205b(boolean z, String str) {
        super(z ? InstallErrorCode.ERROR_SIGNATURE : InstallErrorCode.ERROR_NEED_UPGRADE, str);
        this.f336c = 1;
        this.f337d = false;
    }

    /* renamed from: a */
    public final void m584a(int i) {
        this.f336c = i;
    }

    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m654a("sdk_clients", this.f334a);
        c1232d.m652a(RegistrationHeaderHelper.KEY_SDK_VERSION, 356L);
        c1232d.m654a("PUSH_REGID", this.f335b);
        if (m1067b() == 2007) {
            c1232d.m651a("PUSH_UNBIND_SOURCE_CODE", this.f336c);
        }
    }

    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f334a = c1232d.m650a("sdk_clients");
        this.f335b = c1232d.m650a("PUSH_REGID");
        if (m1067b() == 2007) {
            this.f336c = c1232d.m658b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "AppCommand:" + m1067b();
    }
}
