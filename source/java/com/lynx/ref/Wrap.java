package com.lynx.ref;

/* loaded from: classes6.dex */
class Wrap {
    private Object obj;

    public Wrap(Object obj) {
        this.obj = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T get() {
        return (T) this.obj;
    }
}
