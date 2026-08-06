package com.xiaomi.push;

/* loaded from: classes7.dex */
public class aq implements as {
    private final String a;
    private final String b;

    public aq(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.as
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.as
    public String b() {
        return this.b;
    }
}
