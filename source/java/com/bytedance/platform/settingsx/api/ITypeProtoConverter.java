package com.bytedance.platform.settingsx.api;

/* loaded from: classes4.dex */
public interface ITypeProtoConverter<T> {
    byte[] from(T t);

    T to(byte[] bArr);
}
