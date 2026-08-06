package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class p3 {
    public final long a;
    public final String b;
    public final String c;

    public p3(long j, String error, String tag) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        this.a = j;
        this.b = error;
        this.c = tag;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p3)) {
            return false;
        }
        p3 p3Var = (p3) obj;
        return this.a == p3Var.a && Intrinsics.areEqual(this.b, p3Var.b) && Intrinsics.areEqual(this.c, p3Var.c);
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return a.a("Exception(timestamp=").append(this.a).append(", error=").append(this.b).append(", tag=").append(this.c).append(")").toString();
    }
}
