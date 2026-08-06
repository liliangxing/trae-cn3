package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.agconnect.config.impl.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class C0987m implements ConfigReader {

    /* renamed from: a */
    private final Map<String, String> f852a = new ConcurrentHashMap();

    /* renamed from: b */
    private final C0985k f853b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0987m(Context context, String str) {
        this.f853b = new C0985k(context, str);
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        String str3 = this.f852a.get(str);
        if (str3 != null) {
            return str3;
        }
        String m822a = this.f853b.m822a(str, str2);
        if (m822a == null) {
            return str2;
        }
        this.f852a.put(str, m822a);
        return m822a;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
