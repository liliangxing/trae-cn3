package com.bytedance.push.utils;

import java.util.LinkedList;

/* loaded from: classes4.dex */
public class LimitQueue<E> {
    private int limit;
    private LinkedList<E> queue = new LinkedList<>();

    public LimitQueue(int i) {
        this.limit = i;
    }

    public void offer(E e) {
        if (this.queue.size() >= this.limit) {
            this.queue.poll();
        }
        this.queue.offer(e);
    }

    public E get(int i) {
        return this.queue.get(i);
    }

    public E getLast() {
        return this.queue.getLast();
    }

    public E getFirst() {
        return this.queue.getFirst();
    }

    public int getLimit() {
        return this.limit;
    }

    public int size() {
        return this.queue.size();
    }
}
