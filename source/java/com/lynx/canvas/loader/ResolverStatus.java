package com.lynx.canvas.loader;

/* loaded from: classes6.dex */
public enum ResolverStatus {
    PENDING("Pending"),
    RESOLVED("Resolved"),
    REJECTED("Rejected");

    private final String status;

    ResolverStatus(String str) {
        this.status = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.status;
    }
}
