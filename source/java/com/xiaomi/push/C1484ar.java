package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.ar */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1484ar {

    /* renamed from: a */
    public int f1008a;

    /* renamed from: a */
    public String f1009a;

    /* renamed from: a */
    public Map<String, String> f1010a = new HashMap();

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f1008a), this.f1010a.toString(), this.f1009a);
    }

    /* renamed from: a */
    public String m1525a() {
        return this.f1009a;
    }
}
