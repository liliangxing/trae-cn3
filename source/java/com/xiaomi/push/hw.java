package com.xiaomi.push;

/* loaded from: classes7.dex */
public class hw {
    public final byte a;

    /* renamed from: a, reason: collision with other field name */
    public final String f886a;

    /* renamed from: a, reason: collision with other field name */
    public final short f887a;

    public hw() {
        this("", (byte) 0, (short) 0);
    }

    public hw(String str, byte b, short s) {
        this.f886a = str;
        this.a = b;
        this.f887a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f886a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f887a) + ">";
    }
}
