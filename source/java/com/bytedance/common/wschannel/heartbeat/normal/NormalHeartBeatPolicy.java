package com.bytedance.common.wschannel.heartbeat.normal;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.p007ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NormalHeartBeatPolicy extends BaseHeartBeatPolicy<NormalHeartBeatMeta> {
    private Handler mHandler;
    private HeartBeatReactListener mReactListener;
    private Runnable mSendHeartBeatRunnable;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState appState) {
    }

    public NormalHeartBeatPolicy(NormalHeartBeatMeta normalHeartBeatMeta) {
        super(normalHeartBeatMeta);
        this.mWaitingForPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatPolicy.1
            @Override // java.lang.Runnable
            public void run() {
                if (NormalHeartBeatPolicy.this.mWaitingForPong.getAndSet(false)) {
                    NormalHeartBeatPolicy.this.disConnect();
                    if (NormalHeartBeatPolicy.this.mReactListener != null) {
                        Logger.m190d(OkChannelImpl.TAG, "heartbeat timeout，ready to close connection");
                        NormalHeartBeatPolicy.this.mReactListener.onHeartBeatTimeout();
                        HeartBeatMonitor.getInstance().onPingTimeout();
                    }
                }
            }
        };
        this.mSendHeartBeatRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatPolicy.2
            @Override // java.lang.Runnable
            public void run() {
                if (NormalHeartBeatPolicy.this.mReactListener != null) {
                    NormalHeartBeatPolicy.this.schedule();
                    NormalHeartBeatPolicy.this.mReactListener.onSendPing();
                }
            }
        };
    }

    @Override // com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy
    public void init(HeartBeatReactListener heartBeatReactListener, Handler handler) {
        this.mReactListener = heartBeatReactListener;
        this.mHandler = handler;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        Logger.m190d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        HeartBeatMonitor.getInstance().onPingSuccess();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.m190d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response response) {
        Logger.m190d(OkChannelImpl.TAG, "connect success，ready to send ping");
        updatePingInterval(response);
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        Logger.m190d(OkChannelImpl.TAG, "disconnected，stop to send ping");
        disConnect();
    }

    private void updatePingInterval(Response response) {
        long j;
        if (((NormalHeartBeatMeta) this.mMeta).getPingInterval() != -1) {
            return;
        }
        if (response == null) {
            ((NormalHeartBeatMeta) this.mMeta).setPingInterval(NormalHeartBeatMeta.DEFAULT_PING_INTERVAL);
            return;
        }
        String header = response.header("Handshake-Options");
        if (header != null) {
            String[] split = header.split(";");
            int length = split.length;
            j = -1;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = split[i];
                if (!TextUtils.isEmpty(str)) {
                    String[] split2 = str.split("=");
                    if ("ping-interval".equals(split2[0])) {
                        try {
                            j = Long.parseLong(split2[1]) * 1000;
                            break;
                        } catch (NumberFormatException unused) {
                            j = 270000;
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            }
        } else {
            j = -1;
        }
        if (j == -1) {
            ((NormalHeartBeatMeta) this.mMeta).setPingInterval(NormalHeartBeatMeta.DEFAULT_PING_INTERVAL);
        } else {
            ((NormalHeartBeatMeta) this.mMeta).setPingInterval(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        long pingInterval = ((NormalHeartBeatMeta) this.mMeta).getPingInterval();
        Logger.m190d(OkChannelImpl.TAG, "interval :" + pingInterval + " ms,the next time to send heartbeat is " + Utils.getTimeFormat(System.currentTimeMillis() + pingInterval));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, pingInterval);
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, ((NormalHeartBeatMeta) this.mMeta).getTimeout());
    }
}
