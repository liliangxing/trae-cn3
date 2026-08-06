package com.lynx.tasm.common;

import com.lynx.tasm.base.Assertions;

/* loaded from: classes7.dex */
public class SingleThreadAsserter {
    private Thread mThread = null;

    public void assertNow() {
        Thread currentThread = Thread.currentThread();
        if (this.mThread == null) {
            this.mThread = currentThread;
        }
        Assertions.assertCondition(this.mThread == currentThread);
    }
}
