package com.bytedance.push.settings;

/* loaded from: classes4.dex */
public interface ITypeConverter<T> {
    String from(T t);

    T to(String str);
}
