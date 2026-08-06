package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AttributeDescriptor {
    private String mName;
    private JavaOnlyArray mValue;

    public AttributeDescriptor(String str, JavaOnlyArray javaOnlyArray) {
        this.mName = str;
        this.mValue = javaOnlyArray;
    }

    public String getName() {
        return this.mName;
    }

    public JavaOnlyArray getValue() {
        return this.mValue;
    }
}
