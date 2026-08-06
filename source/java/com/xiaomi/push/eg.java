package com.xiaomi.push;

import java.util.Map;

/* loaded from: classes7.dex */
public class eg implements ee {
    private ee a;

    /* loaded from: classes7.dex */
    private static class a {
        private static eg a = new eg();
    }

    public static eg a() {
        return a.a;
    }

    private eg() {
    }

    @Override // com.xiaomi.push.ee
    public void a(ed edVar) {
        ee eeVar = this.a;
        if (eeVar != null) {
            eeVar.a(edVar);
        }
    }

    @Override // com.xiaomi.push.ee
    public void a(String str, Map<String, Object> map) {
        ee eeVar = this.a;
        if (eeVar != null) {
            eeVar.a(str, map);
        }
    }
}
