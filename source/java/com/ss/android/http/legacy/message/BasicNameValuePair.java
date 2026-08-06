package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.bytedance.frameworks.baselib.network.http.util.LangUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.http.legacy.NameValuePair;

@Deprecated
/* loaded from: classes7.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable {
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = str;
        this.value = str2;
    }

    @Override // com.ss.android.http.legacy.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // com.ss.android.http.legacy.NameValuePair
    public String getValue() {
        return this.value;
    }

    public String toString() {
        int length = this.name.length();
        String str = this.value;
        if (str != null) {
            length += str.length() + 1;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(length);
        charArrayBuffer.append(this.name);
        if (this.value != null) {
            charArrayBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            charArrayBuffer.append(this.value);
        }
        return charArrayBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        return this.name.equals(basicNameValuePair.name) && LangUtils.equals(this.value, basicNameValuePair.value);
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
