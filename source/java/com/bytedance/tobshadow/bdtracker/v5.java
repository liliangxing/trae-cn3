package com.bytedance.tobshadow.bdtracker;

import java.util.UUID;

/* loaded from: classes5.dex */
public class v5 {
    public static h5<String> a = new a();

    /* loaded from: classes5.dex */
    public static class a extends h5<String> {
        @Override // com.bytedance.tobshadow.bdtracker.h5
        public String a(Object[] objArr) {
            return UUID.randomUUID().toString();
        }
    }

    public static String a() {
        return a.b(new Object[0]);
    }
}
