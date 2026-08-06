package com.facebook.common.executors;

/* loaded from: classes6.dex */
public abstract class AbstractPriorityRunnable implements PriorityRunnable {
    private int mPriority;

    public AbstractPriorityRunnable() {
        this.mPriority = 1;
    }

    public AbstractPriorityRunnable(int i) {
        this.mPriority = i;
    }

    @Override // com.facebook.common.executors.PriorityRunnable
    public int getPriority() {
        return this.mPriority;
    }
}
