package com.bytedance.bdinstall.callback;

/* loaded from: classes3.dex */
public abstract class CallbackWrapper<Event, Listener> {
    private final Listener listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackWrapper(Listener listener) {
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Listener getListener() {
        return this.listener;
    }
}
