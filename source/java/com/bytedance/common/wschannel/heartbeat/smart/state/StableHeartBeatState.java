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
public class StableHeartBeatState implements ISmartHeartBeatState {
    private final Handler mHandler;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private long plumbPingInterval;
    private HeartBeatReactListener reactListener;
    private int totalFailCount = 0;
    private AtomicBoolean mWaitingForPong = new AtomicBoolean(false);
    private Runnable mTimeoutCheckRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.StableHeartBeatState.1
        @Override // java.lang.Runnable
        public void run() {
            if (StableHeartBeatState.this.mWaitingForPong.getAndSet(false)) {
                StableHeartBeatState.this.disConnect();
                StableHeartBeatState.access$208(StableHeartBeatState.this);
                Logger.m190d(OkChannelImpl.TAG, "failed times：" + StableHeartBeatState.this.totalFailCount);
                if (StableHeartBeatState.this.totalFailCount >= StableHeartBeatState.this.meta.getMaxPingFailCount()) {
                    Logger.m190d(OkChannelImpl.TAG, "Exceeded the maximum number of failures, ready to fall back to the detection state");
                }
                if (StableHeartBeatState.this.reactListener != null) {
                    Logger.m190d(OkChannelImpl.TAG, "Heartbeat timeout, ready to disconnect and reconnect");
                    StableHeartBeatState.this.reactListener.onHeartBeatTimeout();
                }
            }
        }
    };
    private Runnable mSendHeartBeatRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.StableHeartBeatState.2
        @Override // java.lang.Runnable
        public void run() {
            if (StableHeartBeatState.this.reactListener != null) {
                StableHeartBeatState.this.schedule();
                StableHeartBeatState.this.reactListener.onSendPing();
            }
        }
    };

    static /* synthetic */ int access$208(StableHeartBeatState stableHeartBeatState) {
        int i = stableHeartBeatState.totalFailCount;
        stableHeartBeatState.totalFailCount = i + 1;
        return i;
    }

    public StableHeartBeatState(HeartBeatReactListener heartBeatReactListener, SmartHeartBeatStateMachine smartHeartBeatStateMachine, SmartHeartBeatMeta smartHeartBeatMeta, Handler handler) {
        this.reactListener = heartBeatReactListener;
        this.machine = smartHeartBeatStateMachine;
        this.meta = smartHeartBeatMeta;
        this.mHandler = handler;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public void onEnterThisState() {
        if (this.totalFailCount >= this.meta.getMaxPingFailCount()) {
            this.totalFailCount = 0;
            this.machine.onPlumbState();
        } else {
            this.plumbPingInterval = this.meta.getPlumbPingInterval() - this.meta.getSuccessStep();
            schedule();
        }
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.totalFailCount = 0;
        Logger.m190d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState appState) {
        if (appState == AppState.STATE_FOREGROUND) {
            this.machine.onActiveState();
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
        return StateType.STABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        long j = this.plumbPingInterval;
        this.meta.setCurrentPingInterval(j);
        Logger.m190d(OkChannelImpl.TAG, "interval :" + j + " ms,the next time to send heartbeat is " + Utils.getTimeFormat(System.currentTimeMillis() + j));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, j);
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, this.meta.getPingTimeOut());
    }
}
