package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.InstallInfo;

/* loaded from: classes3.dex */
public class InstallFinishEvent {
    private InstallInfo info;

    public InstallFinishEvent(InstallInfo installInfo) {
        this.info = installInfo;
    }

    public InstallInfo getInfo() {
        return this.info;
    }
}
