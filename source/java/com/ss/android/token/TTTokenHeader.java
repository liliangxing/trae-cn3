package com.ss.android.token;

/* loaded from: classes7.dex */
public final class TTTokenHeader {
    private final String name;
    private final String value;

    public TTTokenHeader(String str, String str2) {
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
        TTTokenHeader tTTokenHeader = (TTTokenHeader) obj;
        String str = this.name;
        if (str == null ? tTTokenHeader.name != null : !str.equals(tTTokenHeader.name)) {
            return false;
        }
        String str2 = this.value;
        String str3 = tTTokenHeader.value;
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
