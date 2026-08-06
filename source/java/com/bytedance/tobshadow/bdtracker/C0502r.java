package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.bytedance.tobshadow.bdtracker.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0502r extends Lambda implements Function1<String, String> {

    /* renamed from: a */
    public static final C0502r f967a = new C0502r();

    public C0502r() {
        super(1);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String invoke(String str) {
        return str == null ? "DDL failed" : (str.hashCode() == -1867169789 && str.equals("success")) ? "DDL response data empty" : str;
    }
}
