package com.bytedance.platform.settingsx.api;

/* loaded from: classes4.dex */
public interface ITypeConverter<T> {
    String from(T t);

    T to(String str);
}
