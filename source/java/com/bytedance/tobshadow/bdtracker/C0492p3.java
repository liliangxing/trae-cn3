package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.p3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0492p3 {

    /* renamed from: a */
    public final long f913a;

    /* renamed from: b */
    public final String f914b;

    /* renamed from: c */
    public final String f915c;

    public C0492p3(long j, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        Intrinsics.checkParameterIsNotNull(str2, "tag");
        this.f913a = j;
        this.f914b = str;
        this.f915c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0492p3)) {
            return false;
        }
        C0492p3 c0492p3 = (C0492p3) obj;
        return this.f913a == c0492p3.f913a && Intrinsics.areEqual(this.f914b, c0492p3.f914b) && Intrinsics.areEqual(this.f915c, c0492p3.f915c);
    }

    public int hashCode() {
        long j = this.f913a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.f914b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f915c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return C0380a.m252a("Exception(timestamp=").append(this.f913a).append(", error=").append(this.f914b).append(", tag=").append(this.f915c).append(")").toString();
    }
}
