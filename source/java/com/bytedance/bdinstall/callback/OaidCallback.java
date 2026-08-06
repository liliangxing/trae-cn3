package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IOaidObserver;
import com.bytedance.bdinstall.callback.event.OaidChangeEvent;

/* loaded from: classes3.dex */
public class OaidCallback extends CallbackWrapper<OaidChangeEvent, IOaidObserver> implements Callback<OaidChangeEvent> {
    public OaidCallback(IOaidObserver iOaidObserver) {
        super(iOaidObserver);
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public void onCall(OaidChangeEvent oaidChangeEvent) {
        IOaidObserver listener = getListener();
        if (listener != null) {
            listener.onOaidLoaded(oaidChangeEvent.getOaid());
        }
    }
}
