package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class u3 {
    public final long a;
    public final long b;
    public final long c;
    public final int d;
    public final String e;

    public u3(long j, long j2, long j3, int i, String error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = i;
        this.e = error;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u3)) {
            return false;
        }
        u3 u3Var = (u3) obj;
        return this.a == u3Var.a && this.b == u3Var.b && this.c == u3Var.c && this.d == u3Var.d && Intrinsics.areEqual(this.e, u3Var.e);
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.c;
        int i2 = (((i + ((int) ((j3 >>> 32) ^ j3))) * 31) + this.d) * 31;
        String str = this.e;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return a.a("Network(requestStart=").append(this.a).append(", requestEnd=").append(this.b).append(", duration=").append(this.c).append(", httpStatus=").append(this.d).append(", error=").append(this.e).append(")").toString();
    }
}
