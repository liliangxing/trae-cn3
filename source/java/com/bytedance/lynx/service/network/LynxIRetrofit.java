package com.bytedance.lynx.service.network;

/* loaded from: classes4.dex */
public interface LynxIRetrofit {
    <T> T create(Class<T> cls);

    default void setExtraData(Object obj) {
    }
}
