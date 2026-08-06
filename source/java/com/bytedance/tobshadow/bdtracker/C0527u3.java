package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.u3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0527u3 {

    /* renamed from: a */
    public final long f1097a;

    /* renamed from: b */
    public final long f1098b;

    /* renamed from: c */
    public final long f1099c;

    /* renamed from: d */
    public final int f1100d;

    /* renamed from: e */
    public final String f1101e;

    public C0527u3(long j, long j2, long j3, int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        this.f1097a = j;
        this.f1098b = j2;
        this.f1099c = j3;
        this.f1100d = i;
        this.f1101e = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0527u3)) {
            return false;
        }
        C0527u3 c0527u3 = (C0527u3) obj;
        return this.f1097a == c0527u3.f1097a && this.f1098b == c0527u3.f1098b && this.f1099c == c0527u3.f1099c && this.f1100d == c0527u3.f1100d && Intrinsics.areEqual(this.f1101e, c0527u3.f1101e);
    }

    public int hashCode() {
        long j = this.f1097a;
        long j2 = this.f1098b;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f1099c;
        int i2 = (((i + ((int) ((j3 >>> 32) ^ j3))) * 31) + this.f1100d) * 31;
        String str = this.f1101e;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return C0380a.m252a("Network(requestStart=").append(this.f1097a).append(", requestEnd=").append(this.f1098b).append(", duration=").append(this.f1099c).append(", httpStatus=").append(this.f1100d).append(", error=").append(this.f1101e).append(")").toString();
    }
}
