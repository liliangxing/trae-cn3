package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class r extends Lambda implements Function1<String, String> {
    public static final r a = new r();

    public r() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String invoke(String str) {
        return str == null ? "DDL failed" : (str.hashCode() == -1867169789 && str.equals("success")) ? "DDL response data empty" : str;
    }
}
