package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.HeaderUpdateListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;

/* loaded from: classes3.dex */
public class HeaderUpdateCallback extends CallbackWrapper<HeaderChangeEvent, HeaderUpdateListener> implements Callback<HeaderChangeEvent> {
    public HeaderUpdateCallback(HeaderUpdateListener headerUpdateListener) {
        super(headerUpdateListener);
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public void onCall(HeaderChangeEvent headerChangeEvent) {
        HeaderUpdateListener listener = getListener();
        if (listener != null) {
            listener.onHeaderUpdate(headerChangeEvent.getHeaderCopy());
        }
    }
}
