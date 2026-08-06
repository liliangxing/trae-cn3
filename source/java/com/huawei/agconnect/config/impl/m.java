package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
class m implements ConfigReader {
    private final Map<String, String> a = new ConcurrentHashMap();
    private final k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, String str) {
        this.b = new k(context, str);
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        String str3 = this.a.get(str);
        if (str3 != null) {
            return str3;
        }
        String a = this.b.a(str, str2);
        if (a == null) {
            return str2;
        }
        this.a.put(str, a);
        return a;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
