package com.bytedance.common.wschannel.heartbeat.smart.state;

import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatStateMachine;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class IdleHeartBeatState implements ISmartHeartBeatState {
    private SmartHeartBeatStateMachine machine;

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState appState) {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public void onEnterThisState() {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
    }

    public IdleHeartBeatState(SmartHeartBeatStateMachine smartHeartBeatStateMachine) {
        this.machine = smartHeartBeatStateMachine;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response response) {
        this.machine.onSecondaryActiveState();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public StateType provideType() {
        return StateType.IDLE;
    }
}
