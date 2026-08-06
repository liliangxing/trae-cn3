package com.vivo.push.p010b;

import android.text.TextUtils;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;
import com.vivo.push.util.C1393t;
import java.util.HashMap;

/* compiled from: ReporterCommand.java */
/* renamed from: com.vivo.push.b.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1228y extends AbstractC1400v {

    /* renamed from: a */
    private HashMap<String, String> f385a;

    /* renamed from: b */
    private long f386b;

    public C1228y() {
        super(2012);
    }

    public C1228y(long j) {
        this();
        this.f386b = j;
    }

    /* renamed from: a */
    public final void m636a(HashMap<String, String> hashMap) {
        this.f385a = hashMap;
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        c1232d.m653a("ReporterCommand.EXTRA_PARAMS", this.f385a);
        c1232d.m652a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f386b);
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        this.f385a = (HashMap) c1232d.m663d("ReporterCommand.EXTRA_PARAMS");
        this.f386b = c1232d.m659b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f386b);
    }

    @Override // com.vivo.push.AbstractC1400v
    public final String toString() {
        return "ReporterCommand（" + this.f386b + ")";
    }

    /* renamed from: e */
    public final void m637e() {
        if (this.f385a == null) {
            C1393t.m1048d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder append = new StringBuilder("report message reportType:").append(this.f386b).append(",msgId:");
        String str = this.f385a.get("messageID");
        if (TextUtils.isEmpty(str)) {
            str = this.f385a.get("message_id");
        }
        C1393t.m1048d("ReporterCommand", append.append(str).toString());
    }
}
