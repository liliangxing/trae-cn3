package com.vivo.push.p010b;

import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;
import com.vivo.push.C1232d;
import java.util.ArrayList;

/* compiled from: AliasCommand.java */
/* renamed from: com.vivo.push.b.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1204a extends C1206c {

    /* renamed from: a */
    private ArrayList<String> f333a;

    public C1204a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2002 : InstallErrorCode.ERROR_NO_INSTALL_PERMISSION, str);
        this.f333a = arrayList;
    }

    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m655a("tags", this.f333a);
    }

    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f333a = c1232d.m662c("tags");
    }

    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "AliasCommand:" + m1067b();
    }
}
