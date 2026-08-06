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
public class SecondaryActiveHeartBeatState implements ISmartHeartBeatState {
    private AppState currentAppState;
    private final Handler mHandler;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private HeartBeatReactListener reactListener;
    private int totalSuccessCount = 0;
    private AtomicBoolean mWaitingForPong = new AtomicBoolean(false);
    private Runnable mTimeoutCheckRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.SecondaryActiveHeartBeatState.1
        @Override // java.lang.Runnable
        public void run() {
            if (SecondaryActiveHeartBeatState.this.mWaitingForPong.getAndSet(false)) {
                SecondaryActiveHeartBeatState.this.disConnect();
                if (SecondaryActiveHeartBeatState.this.reactListener != null) {
                    Logger.m190d(OkChannelImpl.TAG, "heartbeat timeout，ready to disconnect");
                    SecondaryActiveHeartBeatState.this.totalSuccessCount = 0;
                    SecondaryActiveHeartBeatState.this.reactListener.onHeartBeatTimeout();
                }
            }
        }
    };
    private Runnable mSendHeartBeatRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.SecondaryActiveHeartBeatState.2
        @Override // java.lang.Runnable
        public void run() {
            if (SecondaryActiveHeartBeatState.this.reactListener != null) {
                SecondaryActiveHeartBeatState.this.schedule();
                SecondaryActiveHeartBeatState.this.reactListener.onSendPing();
            }
        }
    };

    public SecondaryActiveHeartBeatState(HeartBeatReactListener heartBeatReactListener, SmartHeartBeatStateMachine smartHeartBeatStateMachine, SmartHeartBeatMeta smartHeartBeatMeta, Handler handler) {
        this.reactListener = heartBeatReactListener;
        this.machine = smartHeartBeatStateMachine;
        this.meta = smartHeartBeatMeta;
        this.mHandler = handler;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public void onEnterThisState() {
        this.totalSuccessCount = 0;
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        int i = this.totalSuccessCount + 1;
        this.totalSuccessCount = i;
        if (i >= this.meta.getNetStableTestCount()) {
            if (this.currentAppState == AppState.STATE_BACKGROUND) {
                if (this.meta.getPreviousState() == StateType.STABLE) {
                    this.machine.onStableState();
                } else {
                    this.machine.onPlumbState();
                }
            } else if (this.currentAppState == AppState.STATE_FOREGROUND) {
                this.machine.onActiveState();
            } else {
                throw new IllegalStateException("Error app state: " + this.currentAppState);
            }
            disConnect();
        }
        Logger.m190d(OkChannelImpl.TAG, "receive pong, success times：" + this.totalSuccessCount + ", current appstate: " + this.currentAppState);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.m190d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState appState) {
        this.currentAppState = appState;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response response) {
        this.totalSuccessCount = 0;
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        disConnect();
        this.machine.onIdleState();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public StateType provideType() {
        return StateType.SECONDARY_ACTIVE;
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
        this.meta.setCurrentPingInterval(minPingInterval);
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
