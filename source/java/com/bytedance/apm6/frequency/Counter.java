package com.bytedance.apm6.frequency;

/* loaded from: classes3.dex */
class Counter {
    private int count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Counter(int i) {
        this.count = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCount(int i) {
        this.count += i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCount() {
        return this.count;
    }
}
