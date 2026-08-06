package com.bytedance.common.wschannel.heartbeat;

import com.bytedance.common.wschannel.heartbeat.model.AppState;
import okhttp3.Response;

/* loaded from: classes3.dex */
public interface IHeartBeatPolicy {
    void onAppStateUpdate(AppState appState);

    void onConnected(Response response);

    void onDisconnected();

    void onPingSendSuccess();

    void onReceivePong();
}
