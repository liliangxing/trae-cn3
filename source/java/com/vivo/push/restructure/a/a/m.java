package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.t;

/* compiled from: NodeReportItem.java */
/* loaded from: classes7.dex */
final class m {
    private String a;
    private String b;

    public m(com.vivo.push.restructure.a.a aVar, String str) {
        if (aVar != null) {
            this.a = aVar.a();
        }
        this.b = str;
    }

    public final com.vivo.push.b.h a() {
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            t.a("convertOffLineMsg() error, mMessageID = " + this.a + ", mNodeArrayInfo = " + this.b);
            return null;
        }
        return new com.vivo.push.b.h(this.a, this.b);
    }
}
