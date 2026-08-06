package com.bytedance.apm.util;

/* loaded from: classes3.dex */
public abstract class AbsMinHeap<T> {
    private T[] mData;

    private int left(int i) {
        return ((i + 1) << 1) - 1;
    }

    private int right(int i) {
        return (i + 1) << 1;
    }

    abstract boolean compare(T t, T t2);

    public AbsMinHeap(T[] tArr) {
        this.mData = tArr;
        buildHeap(tArr.length);
    }

    public void buildHeap(int i) {
        for (int i2 = (i / 2) - 1; i2 >= 0; i2--) {
            heapify(i2, i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (compare(r2[r0], r2[r5]) != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
    
        if (compare(r2[r1], r2[r0]) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void heapify(int i, int i2) {
        int right = right(i);
        int left = left(i);
        if (right < i2) {
            T[] tArr = this.mData;
        }
        right = i;
        if (left < i2) {
            T[] tArr2 = this.mData;
        }
        left = right;
        if (left == i) {
            return;
        }
        swap(i, left);
        heapify(left, i2);
    }

    public void swap(int i, int i2) {
        T[] tArr = this.mData;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public T getRoot() {
        return this.mData[0];
    }

    public void setRoot(T t) {
        T[] tArr = this.mData;
        tArr[0] = t;
        heapify(0, tArr.length);
    }
}
