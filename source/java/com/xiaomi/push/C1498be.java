package com.xiaomi.push;

import org.json.JSONArray;

/* renamed from: com.xiaomi.push.be */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1498be extends JSONArray implements InterfaceC1497bd {

    /* renamed from: a */
    private int f1057a = 2;

    @Override // com.xiaomi.push.InterfaceC1497bd
    /* renamed from: a */
    public int mo1650a() {
        return this.f1057a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof InterfaceC1497bd) {
            this.f1057a += ((InterfaceC1497bd) obj).mo1650a();
        }
        return super.put(obj);
    }
}
