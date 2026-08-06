package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: com.hihonor.push.sdk.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0960w {

    /* renamed from: a */
    public final String f781a;

    /* renamed from: b */
    public final int f782b;

    public C0960w(String str) {
        this.f781a = str;
        this.f782b = m781a(str);
    }

    /* renamed from: a */
    public static C0960w m782a(String str) {
        return new C0960w(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0960w.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f781a, ((C0960w) obj).f781a);
    }

    public final int hashCode() {
        return this.f782b;
    }

    /* renamed from: a */
    public static int m781a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
