package com.bytedance.vmsdk.jsbridge;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class MethodDescriptor {
    Method method;
    String name;
    String signature;

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public Method getMethod() {
        return this.method;
    }
}
