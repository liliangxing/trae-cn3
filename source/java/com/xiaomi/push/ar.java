package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ar {
    public int a;

    /* renamed from: a, reason: collision with other field name */
    public String f184a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f185a = new HashMap();

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f185a.toString(), this.f184a);
    }

    public String a() {
        return this.f184a;
    }
}
