package com.bytedance.common.wschannel.server;

/* loaded from: classes3.dex */
public interface IEnableObserver {

    /* loaded from: classes3.dex */
    public interface OnWsChannelEnableChangedObserver {
        void onWsChannelEnableChange(boolean z);
    }

    boolean isEnable();

    void setEnableListener(OnWsChannelEnableChangedObserver onWsChannelEnableChangedObserver);

    void startLoad();
}
