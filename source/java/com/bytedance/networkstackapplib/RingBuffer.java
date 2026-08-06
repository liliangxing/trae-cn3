package com.bytedance.networkstackapplib;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class RingBuffer<T> {
    private final T[] mBuffer;
    private long mCapacity;
    private long mCursor = 0;
    private T mLatestItem = null;

    public RingBuffer(Class<T> cls, int i) {
        this.mCapacity = 0L;
        i = i < 1 ? 1 : i;
        this.mCapacity = i;
        this.mBuffer = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    public int size() {
        return (int) Math.min(this.mBuffer.length, this.mCursor);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            this.mBuffer[i] = null;
        }
        this.mCursor = 0L;
    }

    public void append(T t) {
        T[] tArr = this.mBuffer;
        long j = this.mCursor;
        this.mCursor = 1 + j;
        tArr[indexOf(j)] = t;
        this.mLatestItem = t;
    }

    public T getEarliestItem() {
        long j = this.mCursor;
        if (j == 0) {
            return null;
        }
        if (j <= this.mCapacity) {
            return this.mBuffer[0];
        }
        return this.mBuffer[indexOf(j)];
    }

    public T getLatestItem() {
        return this.mLatestItem;
    }

    public T getNextSlot() {
        long j = this.mCursor;
        this.mCursor = 1 + j;
        int indexOf = indexOf(j);
        T[] tArr = this.mBuffer;
        if (tArr[indexOf] == null) {
            tArr[indexOf] = createNewItem();
        }
        return this.mBuffer[indexOf];
    }

    protected T createNewItem() {
        try {
            return (T) this.mBuffer.getClass().getComponentType().newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    public T[] toArray() {
        T[] tArr = (T[]) Arrays.copyOf(this.mBuffer, size(), this.mBuffer.getClass());
        long j = this.mCursor - 1;
        int length = tArr.length - 1;
        while (length >= 0) {
            tArr[length] = this.mBuffer[indexOf(j)];
            length--;
            j--;
        }
        return tArr;
    }

    private int indexOf(long j) {
        return (int) Math.abs(j % this.mBuffer.length);
    }
}
