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
public class PlumbHeartBeatState implements ISmartHeartBeatState {
    private long currentPingInterval;
    private Handler mHandler;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private HeartBeatReactListener reactListener;
    private int currentIntervalFailCount = 0;
    private AtomicBoolean mWaitingForPong = new AtomicBoolean(false);
    private Runnable mTimeoutCheckRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.PlumbHeartBeatState.1
        @Override // java.lang.Runnable
        public void run() {
            if (PlumbHeartBeatState.this.mWaitingForPong.getAndSet(false)) {
                PlumbHeartBeatState.this.disConnect();
                PlumbHeartBeatState.access$208(PlumbHeartBeatState.this);
                if (PlumbHeartBeatState.this.currentIntervalFailCount >= PlumbHeartBeatState.this.meta.getMaxPingFailCount()) {
                    PlumbHeartBeatState.this.meta.setPlumbPingInterval(PlumbHeartBeatState.this.currentPingInterval);
                    PlumbHeartBeatState plumbHeartBeatState = PlumbHeartBeatState.this;
                    plumbHeartBeatState.currentPingInterval = plumbHeartBeatState.meta.getMinPingInterval() + PlumbHeartBeatState.this.meta.getPingStep();
                    PlumbHeartBeatState.this.machine.onStableState();
                }
                Logger.m190d(OkChannelImpl.TAG, "number of timeouts ：" + PlumbHeartBeatState.this.currentIntervalFailCount + ". Maximum heartbeat interval currently detected: " + PlumbHeartBeatState.this.currentPingInterval);
                if (PlumbHeartBeatState.this.reactListener != null) {
                    Logger.m190d(OkChannelImpl.TAG, "heartbeat timeout，ready to disconnect");
                    PlumbHeartBeatState.this.reactListener.onHeartBeatTimeout();
                }
            }
        }
    };
    private Runnable mSendHeartBeatRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.smart.state.PlumbHeartBeatState.2
        @Override // java.lang.Runnable
        public void run() {
            if (PlumbHeartBeatState.this.reactListener != null) {
                PlumbHeartBeatState.this.reactListener.onSendPing();
            }
        }
    };

    static /* synthetic */ int access$208(PlumbHeartBeatState plumbHeartBeatState) {
        int i = plumbHeartBeatState.currentIntervalFailCount;
        plumbHeartBeatState.currentIntervalFailCount = i + 1;
        return i;
    }

    public PlumbHeartBeatState(HeartBeatReactListener heartBeatReactListener, SmartHeartBeatStateMachine smartHeartBeatStateMachine, SmartHeartBeatMeta smartHeartBeatMeta, Handler handler) {
        this.reactListener = heartBeatReactListener;
        this.machine = smartHeartBeatStateMachine;
        this.meta = smartHeartBeatMeta;
        this.mHandler = handler;
        this.currentPingInterval = smartHeartBeatMeta.getMinPingInterval() + smartHeartBeatMeta.getPingStep();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public void onEnterThisState() {
        this.currentPingInterval = this.meta.getMinPingInterval() + this.meta.getPingStep();
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.currentIntervalFailCount = 0;
        if (this.currentPingInterval <= this.meta.getMaxPingInterval() - this.meta.getPingStep()) {
            this.currentPingInterval += this.meta.getPingStep();
            schedule();
            Logger.m190d(OkChannelImpl.TAG, "receive pong，increate detect step " + this.meta.getPingStep());
        } else {
            this.currentPingInterval = this.meta.getMaxPingInterval();
            SmartHeartBeatMeta smartHeartBeatMeta = this.meta;
            smartHeartBeatMeta.setPlumbPingInterval(smartHeartBeatMeta.getMaxPingInterval());
            disConnect();
            this.machine.onStableState();
            Logger.m190d(OkChannelImpl.TAG, "The maximum heartbeat interval test can ping: " + this.currentPingInterval);
        }
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.m190d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState appState) {
        if (appState == AppState.STATE_FOREGROUND) {
            disConnect();
            this.currentPingInterval = this.meta.getMinPingInterval() + this.meta.getPingStep();
            this.machine.onActiveState();
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
        return StateType.PLUMB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    private void schedule() {
        long j = this.currentPingInterval;
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
