package com.bytedance.keva;

/* loaded from: classes4.dex */
class ValueAccessWrapper {
    long accessTime;
    Object value;

    public ValueAccessWrapper(Object obj, long j) {
        this.value = obj;
        this.accessTime = j;
    }
}
