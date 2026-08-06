package com.bytedance.platform.godzilla.anr.sp;

import java.util.LinkedList;

/* loaded from: classes4.dex */
public class LinkedListProxyForFinishers<E> extends LinkedList<E> {
    private LinkedList<Runnable> mRealList;

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public E poll() {
        return null;
    }

    public LinkedListProxyForFinishers(LinkedList<Runnable> linkedList) {
        this.mRealList = linkedList;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E e) {
        return this.mRealList.add((Runnable) e);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        return this.mRealList.remove(obj);
    }
}
