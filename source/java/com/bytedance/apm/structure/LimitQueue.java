package com.bytedance.apm.structure;

import java.util.LinkedList;

/* loaded from: classes3.dex */
public class LimitQueue<T> {
    private LinkedList<T> list = new LinkedList<>();
    private int maxSize;

    public LimitQueue(int i) {
        this.maxSize = i;
    }

    public void enqueue(T t) {
        if (this.list.size() > this.maxSize) {
            this.list.removeFirst();
        }
        this.list.addLast(t);
    }

    public LinkedList<T> toList() {
        return this.list;
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void clear() {
        this.list.clear();
    }
}
