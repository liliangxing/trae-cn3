package com.bytedance.apm.structure;

/* loaded from: classes3.dex */
public interface IStack<T> {
    void clear();

    boolean isEmpty();

    T peek();

    T pop();

    void push(T t);
}
