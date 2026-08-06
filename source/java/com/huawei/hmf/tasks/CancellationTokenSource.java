package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;

/* loaded from: classes6.dex */
public class CancellationTokenSource {
    public c impl = new c();

    public void cancel() {
        this.impl.a();
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
