package com.lynx.animax.service;

/* loaded from: classes6.dex */
public final class ServiceScope {
    public static final ServiceScope DEFAULT = new ServiceScope("default");
    private final String value;

    public static ServiceScope of(String str) {
        return new ServiceScope(str);
    }

    private ServiceScope(String str) {
        this.value = str.toLowerCase();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceScope) {
            return this.value.equals(((ServiceScope) obj).value);
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return this.value;
    }
}
