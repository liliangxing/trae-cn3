package com.bytedance.pia.core.api.utils;

/* loaded from: classes4.dex */
public interface IFactory<T> {
    T create();

    default T create(Object obj) {
        return create();
    }
}
