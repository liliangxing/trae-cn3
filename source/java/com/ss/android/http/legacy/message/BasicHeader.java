package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.Header;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.ParseException;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BasicHeader implements Header, Cloneable {
    private final String name;
    private final String value;

    public BasicHeader(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = str;
        this.value = str2;
    }

    @Override // com.ss.android.http.legacy.Header
    public String getName() {
        return this.name;
    }

    @Override // com.ss.android.http.legacy.Header
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return BasicLineFormatter.DEFAULT.formatHeader((CharArrayBuffer) null, this).toString();
    }

    @Override // com.ss.android.http.legacy.Header
    public HeaderElement[] getElements() throws ParseException {
        String str = this.value;
        return str != null ? BasicHeaderValueParser.parseElements(str, (HeaderValueParser) null) : new HeaderElement[0];
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
