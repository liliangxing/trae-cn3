package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class CompensateHeartBeatManager {
    private static final long TIMEOUT = 5000;
    private AppState currentAppState;
    private Handler mHandler;
    private AtomicBoolean mIsWaitingPong = new AtomicBoolean(false);
    private Runnable mTimeoutCheckRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.CompensateHeartBeatManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (CompensateHeartBeatManager.this.mIsWaitingPong.getAndSet(false)) {
                Logger.d(OkChannelImpl.TAG, "Compensate for ping timeout, prepare to reconnect");
                if (CompensateHeartBeatManager.this.timeoutListener != null) {
                    CompensateHeartBeatManager.this.timeoutListener.onTimeout();
                }
            }
        }
    };
    private CustomHeartBeatWebSocket mWebSocket;
    private OnHeartBeatTimeoutListener timeoutListener;

    /* loaded from: classes3.dex */
    public interface OnHeartBeatTimeoutListener {
        void onTimeout();
    }

    public CompensateHeartBeatManager(OnHeartBeatTimeoutListener onHeartBeatTimeoutListener, Handler handler) {
        this.timeoutListener = onHeartBeatTimeoutListener;
        this.mHandler = handler;
    }

    public void setWebSocket(CustomHeartBeatWebSocket customHeartBeatWebSocket) {
        this.mWebSocket = customHeartBeatWebSocket;
    }

    public void updateCurrentAppState(AppState appState) {
        boolean z;
        if (!this.mIsWaitingPong.get()) {
            if (isBackToFore(appState)) {
                Logger.d(OkChannelImpl.TAG, "Switch the foreground in the background, send compensation ping");
                z = true;
            } else {
                z = false;
            }
            if (z) {
                try {
                    CustomHeartBeatWebSocket customHeartBeatWebSocket = this.mWebSocket;
                    if (customHeartBeatWebSocket != null) {
                        customHeartBeatWebSocket.sendPing();
                        waitingForPong();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.currentAppState = appState;
    }

    public boolean isWaitingPong() {
        return this.mIsWaitingPong.get();
    }

    public void onReceivePong() {
        Logger.d(OkChannelImpl.TAG, "After compensating for ping, received pong");
        this.mIsWaitingPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    private boolean isBackToFore(AppState appState) {
        return this.currentAppState == AppState.STATE_BACKGROUND && appState == AppState.STATE_FOREGROUND;
    }

    private void waitingForPong() {
        this.mIsWaitingPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, 5000L);
    }
}
