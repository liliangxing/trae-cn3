package com.xiaomi.push;

/* renamed from: com.xiaomi.push.aq */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1483aq implements InterfaceC1485as {

    /* renamed from: a */
    private final String f1006a;

    /* renamed from: b */
    private final String f1007b;

    public C1483aq(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f1006a = str;
        this.f1007b = str2;
    }

    @Override // com.xiaomi.push.InterfaceC1485as
    /* renamed from: a */
    public String mo1523a() {
        return this.f1006a;
    }

    @Override // com.xiaomi.push.InterfaceC1485as
    /* renamed from: b */
    public String mo1524b() {
        return this.f1007b;
    }
}
