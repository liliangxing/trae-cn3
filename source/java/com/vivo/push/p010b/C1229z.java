package com.vivo.push.p010b;

import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;
import com.vivo.push.C1232d;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: TagCommand.java */
/* renamed from: com.vivo.push.b.z */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1229z extends C1206c {

    /* renamed from: a */
    private ArrayList<String> f387a;

    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "TagCommand";
    }

    public C1229z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? InstallErrorCode.ERROR_CANCELED : InstallErrorCode.ERROR_TTMD5, str);
        this.f387a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m653a("tags", (Serializable) this.f387a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1206c, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f387a = c1232d.m662c("tags");
    }
}
