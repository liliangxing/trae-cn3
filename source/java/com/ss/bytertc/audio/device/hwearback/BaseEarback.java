package com.ss.bytertc.audio.device.hwearback;

import android.content.Context;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class BaseEarback implements IHardWareEarback {
    public static final int RESULT_INVALID_STATE = -2;
    public static final int RESULT_OP_FAILED = -1;
    public static final int RESULT_SUCCESS = 0;
    private static final String TAG = "BaseEarback";
    protected final Context context;
    private volatile EarbackState state = EarbackState.IDLE;
    protected final WebRtcAudioEarBack webRtcAudioEarBack;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum EarbackState {
        IDLE,
        INITIALIZING,
        INITIALIZED,
        RUNNING
    }

    protected abstract boolean onClose();

    protected abstract void onInit();

    protected abstract boolean onIsSupportCall();

    protected abstract boolean onOpen();

    protected abstract void onRelease();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseEarback(Context context, WebRtcAudioEarBack webRtcAudioEarBack) {
        this.context = context;
        this.webRtcAudioEarBack = webRtcAudioEarBack;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int init() {
        RXLogging.i(TAG, "init() with state: " + this.state);
        if (this.state.ordinal() >= EarbackState.INITIALIZED.ordinal()) {
            this.webRtcAudioEarBack.onHardwareEarbackSupported(isSupport());
        } else if (this.state == EarbackState.INITIALIZING) {
            return 0;
        }
        changeState(EarbackState.INITIALIZING);
        onInit();
        return 0;
    }

    public EarbackState getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void onInitResult(boolean success) {
        if (this.state == EarbackState.INITIALIZING) {
            this.state = success ? EarbackState.INITIALIZED : EarbackState.IDLE;
            this.webRtcAudioEarBack.onHardwareEarbackSupported(success && isSupport());
        }
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int release() {
        RXLogging.i(TAG, "release() with state: " + this.state);
        if (this.state == EarbackState.IDLE) {
            return 0;
        }
        onRelease();
        changeState(EarbackState.IDLE);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        if (this.state.ordinal() < EarbackState.INITIALIZED.ordinal()) {
            return false;
        }
        return onIsSupportCall();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int open() {
        RXLogging.i(TAG, "open() with state: " + this.state);
        if (this.state == EarbackState.RUNNING) {
            return 0;
        }
        if (this.state == EarbackState.INITIALIZED && isSupport()) {
            if (!onOpen()) {
                return -1;
            }
            changeState(EarbackState.RUNNING);
            return 0;
        }
        return -2;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public synchronized int close() {
        RXLogging.i(TAG, "close() with state: " + this.state);
        if (this.state != EarbackState.RUNNING) {
            return -2;
        }
        if (!onClose()) {
            return -1;
        }
        changeState(EarbackState.INITIALIZED);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void onStateChanged(EarbackState oldState, EarbackState newState) {
    }

    private void changeState(EarbackState newState) {
        RXLogging.i(TAG, "changeState: " + this.state + " -> " + newState);
        EarbackState earbackState = this.state;
        this.state = newState;
        if (earbackState != newState) {
            onStateChanged(earbackState, newState);
        }
    }
}
