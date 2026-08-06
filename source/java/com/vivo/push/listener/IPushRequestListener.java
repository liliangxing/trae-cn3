package com.vivo.push.listener;

/* loaded from: classes7.dex */
public interface IPushRequestListener<T, V> {
    void onFail(V v);

    void onSuccess(T t);
}
