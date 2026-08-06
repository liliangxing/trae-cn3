package com.bytedance.apm.structure;

/* loaded from: classes3.dex */
public class LimitStack<T> extends ListStack<T> {
    int maxSize;

    public LimitStack(int i) {
        this.maxSize = i;
    }

    @Override // com.bytedance.apm.structure.ListStack, com.bytedance.apm.structure.IStack
    public void push(T t) {
        if (this.size >= this.maxSize) {
            pop();
        }
        super.push(t);
    }
}
