package com.bytedance.platform.godzilla.anr.sp;

import android.os.Looper;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class LinkedListProxyForWorks<E> extends LinkedList<E> {
    private static final Object LOCK = new Object();
    private LinkedList<Runnable> mRealList;

    public LinkedListProxyForWorks(LinkedList<Runnable> linkedList) {
        this.mRealList = linkedList;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E e) {
        boolean add;
        synchronized (LOCK) {
            add = this.mRealList.add((Runnable) e);
        }
        return add;
    }

    @Override // java.util.LinkedList
    public Object clone() {
        LinkedList linkedList;
        super.clone();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return new LinkedList();
        }
        synchronized (LOCK) {
            linkedList = new LinkedList(this.mRealList);
        }
        return linkedList;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QueuedWorkProxyAboveOrEqualsAndroid0.reSendMessageToQueueWork();
            return;
        }
        synchronized (LOCK) {
            this.mRealList.clear();
        }
    }
}
