package com.bytedance.lottie.utils;

/* loaded from: classes4.dex */
public abstract class ObjectPool<T> {
    private T[] mPool = initArray(3);

    protected abstract T[] initArray(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public T poll() {
        T[] tArr = this.mPool;
        T t = tArr[0];
        if (t != null) {
            tArr[0] = null;
            return t;
        }
        T t2 = tArr[1];
        if (t2 != null) {
            tArr[1] = null;
            return t2;
        }
        T t3 = tArr[2];
        if (t3 == null) {
            return null;
        }
        tArr[2] = null;
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void offer(T t) {
        T[] tArr = this.mPool;
        if (tArr[0] == null) {
            tArr[0] = t;
        } else if (tArr[1] == null) {
            tArr[1] = t;
        } else if (tArr[2] == null) {
            tArr[2] = t;
        }
    }
}
