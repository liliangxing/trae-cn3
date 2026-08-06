package com.bytedance.android.sdk.bdticketguard;

/* loaded from: classes3.dex */
public final class TTHeader {
    private final String name;
    private final String value;

    public TTHeader(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TTHeader tTHeader = (TTHeader) obj;
        String str = this.name;
        if (str == null ? tTHeader.name != null : !str.equals(tTHeader.name)) {
            return false;
        }
        String str2 = this.value;
        String str3 = tTHeader.value;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.name;
        if (str == null) {
            str = "";
        }
        StringBuilder append = sb.append(str).append(": ");
        String str2 = this.value;
        return append.append(str2 != null ? str2 : "").toString();
    }
}
