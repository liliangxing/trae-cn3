package com.bytedance.apm.util;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes3.dex */
public class TopK<E extends Comparable> {
    private int maxSize;
    private PriorityQueue<E> queue;

    public TopK(int i) {
        if (i <= 0) {
            throw new IllegalStateException();
        }
        this.maxSize = i;
        this.queue = new PriorityQueue<>(i, new Comparator<E>() { // from class: com.bytedance.apm.util.TopK.1
            @Override // java.util.Comparator
            public int compare(E e, E e2) {
                return e.compareTo(e2);
            }
        });
    }

    public void add(E e) {
        if (this.queue.size() < this.maxSize) {
            this.queue.add(e);
        } else if (e.compareTo(this.queue.peek()) > 0) {
            this.queue.poll();
            this.queue.add(e);
        }
    }

    public List<E> toList() {
        return new ArrayList(this.queue);
    }

    public List<E> sortedList() {
        ArrayList arrayList = new ArrayList(this.queue);
        Collections.sort(arrayList);
        return arrayList;
    }

    public int size() {
        return this.queue.size();
    }

    public void clear() {
        this.queue.clear();
    }
}
