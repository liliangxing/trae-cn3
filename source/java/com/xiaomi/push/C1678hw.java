package com.xiaomi.push;

/* renamed from: com.xiaomi.push.hw */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1678hw {

    /* renamed from: a */
    public final byte f2770a;

    /* renamed from: a */
    public final String f2771a;

    /* renamed from: a */
    public final short f2772a;

    public C1678hw() {
        this("", (byte) 0, (short) 0);
    }

    public C1678hw(String str, byte b, short s) {
        this.f2771a = str;
        this.f2770a = b;
        this.f2772a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f2771a + "' type:" + ((int) this.f2770a) + " field-id:" + ((int) this.f2772a) + ">";
    }
}
