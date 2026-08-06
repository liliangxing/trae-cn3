package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.bytedance.frameworks.baselib.network.http.util.LangUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;

@Deprecated
/* loaded from: classes7.dex */
public class BasicHeaderElement implements HeaderElement, Cloneable {
    private final String name;
    private final NameValuePair[] parameters;
    private final String value;

    public BasicHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = str;
        this.value = str2;
        if (nameValuePairArr != null) {
            this.parameters = nameValuePairArr;
        } else {
            this.parameters = new NameValuePair[0];
        }
    }

    public BasicHeaderElement(String str, String str2) {
        this(str, str2, null);
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public String getName() {
        return this.name;
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public String getValue() {
        return this.value;
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public NameValuePair[] getParameters() {
        return (NameValuePair[]) this.parameters.clone();
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public int getParameterCount() {
        return this.parameters.length;
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public NameValuePair getParameter(int i) {
        return this.parameters[i];
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public NameValuePair getParameterByName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        int i = 0;
        while (true) {
            NameValuePair[] nameValuePairArr = this.parameters;
            if (i >= nameValuePairArr.length) {
                return null;
            }
            NameValuePair nameValuePair = nameValuePairArr[i];
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderElement)) {
            return false;
        }
        BasicHeaderElement basicHeaderElement = (BasicHeaderElement) obj;
        return this.name.equals(basicHeaderElement.name) && LangUtils.equals(this.value, basicHeaderElement.value) && LangUtils.equals((Object[]) this.parameters, (Object[]) basicHeaderElement.parameters);
    }

    public int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
        int i = 0;
        while (true) {
            NameValuePair[] nameValuePairArr = this.parameters;
            if (i >= nameValuePairArr.length) {
                return hashCode;
            }
            hashCode = LangUtils.hashCode(hashCode, nameValuePairArr[i]);
            i++;
        }
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.name);
        if (this.value != null) {
            charArrayBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            charArrayBuffer.append(this.value);
        }
        for (int i = 0; i < this.parameters.length; i++) {
            charArrayBuffer.append("; ");
            charArrayBuffer.append(this.parameters[i]);
        }
        return charArrayBuffer.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
