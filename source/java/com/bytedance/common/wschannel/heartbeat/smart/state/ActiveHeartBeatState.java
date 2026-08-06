package com.bytedance.common.wschannel.heartbeat.smart.state;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.p007ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatStateMachine;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ActiveHeartBeatState implements ISmartHeartBeatState {
    private final Handler mHandler;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private HeartBeatReactListener reactListener;
    private AtomicBoolean mWaitingForPong = new AtomicBoolean(false);
    private Runnable mTimeoutCheckRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.ActiveHeartBeatState.1
        @Override // java.lang.Runnable
        public void run() {
            if (ActiveHeartBeatState.this.mWaitingForPong.getAndSet(false)) {
                ActiveHeartBeatState.this.disConnect();
                if (ActiveHeartBeatState.this.reactListener != null) {
                    Logger.m190d(OkChannelImpl.TAG, "heartbeat timeout，ready to disconnect");
                    ActiveHeartBeatState.this.reactListener.onHeartBeatTimeout();
                }
            }
        }
    };
    private Runnable mSendHeartBeatRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.ActiveHeartBeatState.2
        @Override // java.lang.Runnable
        public void run() {
            if (ActiveHeartBeatState.this.reactListener != null) {
                ActiveHeartBeatState.this.schedule();
                ActiveHeartBeatState.this.reactListener.onSendPing();
            }
        }
    };

    public ActiveHeartBeatState(HeartBeatReactListener heartBeatReactListener, SmartHeartBeatStateMachine smartHeartBeatStateMachine, SmartHeartBeatMeta smartHeartBeatMeta, Handler handler) {
        this.reactListener = heartBeatReactListener;
        this.machine = smartHeartBeatStateMachine;
        this.meta = smartHeartBeatMeta;
        this.mHandler = handler;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public void onEnterThisState() {
        SmartHeartBeatMeta smartHeartBeatMeta = this.meta;
        smartHeartBeatMeta.setCurrentPingInterval(smartHeartBeatMeta.getMinPingInterval());
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        Logger.m190d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.m190d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState appState) {
        if (appState == AppState.STATE_BACKGROUND) {
            this.machine.onSecondaryActiveState();
            disConnect();
        }
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response response) {
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        disConnect();
        this.machine.onIdleState();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public StateType provideType() {
        return StateType.ACTIVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        long minPingInterval = this.meta.getMinPingInterval();
        Logger.m190d(OkChannelImpl.TAG, "interval :" + minPingInterval + " ms,the next time to send heartbeat is " + Utils.getTimeFormat(System.currentTimeMillis() + minPingInterval));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, minPingInterval);
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, this.meta.getPingTimeOut());
    }
}
