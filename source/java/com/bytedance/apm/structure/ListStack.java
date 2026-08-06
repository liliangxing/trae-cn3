package com.bytedance.apm.structure;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class ListStack<T> implements IStack<T> {
    private List<T> list = new LinkedList();
    private int top = 0;
    int size = 0;

    @Override // com.bytedance.apm.structure.IStack
    public void clear() {
    }

    @Override // com.bytedance.apm.structure.IStack
    public T pop() {
        T t = this.list.get(this.top - 1);
        this.list.remove(this.top - 1);
        this.size--;
        return t;
    }

    @Override // com.bytedance.apm.structure.IStack
    public void push(T t) {
        this.list.add(t);
        this.size++;
        this.top++;
    }

    @Override // com.bytedance.apm.structure.IStack
    public T peek() {
        return this.list.get(this.top - 1);
    }

    @Override // com.bytedance.apm.structure.IStack
    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.list.size();
    }
}
