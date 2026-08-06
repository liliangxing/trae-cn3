package com.bytedance.common.wschannel.channel.impl.p007ok;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.p007ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okio.ByteString;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class HeartBeatProcessor {
    private final Handler mHandler;
    private final HeartBeatListener mListener;
    private CustomHeartBeatWebSocket mWebSocket;
    private long DEFAULT_PING_INTERVAL_MIN = NormalHeartBeatMeta.DEFAULT_PING_INTERVAL;
    private long mCurBackgroundHeart = NormalHeartBeatMeta.DEFAULT_PING_INTERVAL;
    private long mSuccessHeart = NormalHeartBeatMeta.DEFAULT_PING_INTERVAL;
    private AtomicBoolean mWaitingForPong = new AtomicBoolean(false);
    private Runnable mTimeoutCheckRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.HeartBeatProcessor.1
        @Override // java.lang.Runnable
        public void run() {
            if (HeartBeatProcessor.this.mWaitingForPong.getAndSet(false)) {
                HeartBeatProcessor.this.disConnect();
                if (HeartBeatProcessor.this.mListener != null) {
                    HeartBeatProcessor.this.mListener.onHeartBeatTimeout();
                }
            }
        }
    };
    private Runnable mSendHeartBeatRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.HeartBeatProcessor.2
        @Override // java.lang.Runnable
        public void run() {
            HeartBeatProcessor.this.sendPing();
            HeartBeatProcessor.this.schedule();
        }
    };
    private long mPongTimeout = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    interface HeartBeatListener {
        void onHeartBeatTimeout();
    }

    void onAppStateChanged(boolean z) {
    }

    HeartBeatProcessor(Handler handler, HeartBeatListener heartBeatListener) {
        this.mHandler = handler;
        this.mListener = heartBeatListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        long j = this.DEFAULT_PING_INTERVAL_MIN;
        Logger.m190d(OkChannelImpl.TAG, "interval :" + j + " ms,the next heartbeat is: " + Utils.getTimeFormat(System.currentTimeMillis() + j));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPing() {
        try {
            if (this.mWebSocket != null) {
                Logger.m190d(OkChannelImpl.TAG, "send ping");
                this.mWebSocket.sendPing();
                waitingForPong();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, this.mPongTimeout);
    }

    void setPongTimeout(long j) {
        this.mPongTimeout = j;
    }

    void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    void onReceivePong(CustomHeartBeatWebSocket customHeartBeatWebSocket, ByteString byteString) {
        Logger.m190d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    long getSuccessHeatBeatInterval() {
        return this.mSuccessHeart;
    }

    void onOpenSuccess(CustomHeartBeatWebSocket customHeartBeatWebSocket, Response response) {
        this.mWebSocket = customHeartBeatWebSocket;
        updatePingInterval(response);
        schedule();
    }

    private void updatePingInterval(Response response) {
        String header;
        if (response == null || (header = response.header("Handshake-Options")) == null) {
            return;
        }
        for (String str : header.split(";")) {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("=");
                if ("ping-interval".equals(split[0])) {
                    try {
                        this.DEFAULT_PING_INTERVAL_MIN = Long.parseLong(split[1]) * 1000;
                        return;
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
