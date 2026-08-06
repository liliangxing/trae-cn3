package com.bytedance.router.autowire;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public class TypeWrapper<T> {
    protected final Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected TypeWrapper() {
    }

    public Type getType() {
        return this.type;
    }
}
