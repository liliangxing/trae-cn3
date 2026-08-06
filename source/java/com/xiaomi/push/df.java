package com.xiaomi.push;

/* loaded from: classes7.dex */
public class df {
    private static volatile df a;

    /* renamed from: a, reason: collision with other field name */
    private de f315a;

    public static df a() {
        if (a == null) {
            synchronized (df.class) {
                if (a == null) {
                    a = new df();
                }
            }
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public de m9747a() {
        return this.f315a;
    }

    public void a(de deVar) {
        this.f315a = deVar;
    }
}
