package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;

/* loaded from: classes3.dex */
public class InstallFinishCallback extends CallbackWrapper<InstallFinishEvent, IInstallListener> implements Callback<InstallFinishEvent> {
    public InstallFinishCallback(IInstallListener iInstallListener) {
        super(iInstallListener);
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public void onCall(InstallFinishEvent installFinishEvent) {
        IInstallListener listener = getListener();
        if (listener != null) {
            listener.installFinished(installFinishEvent.getInfo());
        }
    }
}
