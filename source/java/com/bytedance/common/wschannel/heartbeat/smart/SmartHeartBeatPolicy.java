package com.bytedance.common.wschannel.heartbeat.smart;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.p007ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.StateType;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SmartHeartBeatPolicy extends BaseHeartBeatPolicy<SmartHeartBeatMeta> {
    private AppState currentAppState;
    private AtomicBoolean mWaitingForPong;
    private ISmartHeartBeatState state;

    public SmartHeartBeatPolicy(SmartHeartBeatMeta smartHeartBeatMeta) {
        super(smartHeartBeatMeta);
        this.mWaitingForPong = new AtomicBoolean(false);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy
    public void init(final HeartBeatReactListener heartBeatReactListener, Handler handler) {
        new SmartHeartBeatStateMachine().init(new HeartBeatReactListener() { // from class: com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatPolicy.1
            @Override // com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener
            public void onHeartBeatTimeout() {
                heartBeatReactListener.onHeartBeatTimeout();
                HeartBeatMonitor.getInstance().onPingTimeout();
            }

            @Override // com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener
            public void onSendPing() {
                heartBeatReactListener.onSendPing();
            }
        }, this, (SmartHeartBeatMeta) this.mMeta, handler);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.state.onReceivePong();
        HeartBeatMonitor.getInstance().onPingSuccess();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        this.mWaitingForPong.set(true);
        this.state.onPingSendSuccess();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState appState) {
        Logger.m190d(OkChannelImpl.TAG, "update current appstate: " + appState + " " + this.state + " " + Thread.currentThread().getName());
        this.currentAppState = appState;
        this.state.onAppStateUpdate(appState);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response response) {
        this.state.onConnected(response);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        this.state.onDisconnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(ISmartHeartBeatState iSmartHeartBeatState) {
        ISmartHeartBeatState iSmartHeartBeatState2 = this.state;
        if (iSmartHeartBeatState2 != null && iSmartHeartBeatState2.provideType() != StateType.IDLE) {
            ((SmartHeartBeatMeta) this.mMeta).setPreviousState(this.state.provideType());
        }
        this.state = iSmartHeartBeatState;
        AppState appState = this.currentAppState;
        if (appState != null) {
            iSmartHeartBeatState.onAppStateUpdate(appState);
        } else {
            iSmartHeartBeatState.onAppStateUpdate(AppState.STATE_BACKGROUND);
        }
        this.state.onEnterThisState();
    }

    StateType getCurrentStateType() {
        ISmartHeartBeatState iSmartHeartBeatState = this.state;
        if (iSmartHeartBeatState == null) {
            return null;
        }
        return iSmartHeartBeatState.provideType();
    }
}
