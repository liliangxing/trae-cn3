package com.bytedance.sync.p005v4.compensate;

import android.os.Handler;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
abstract class RotationV4 {
    protected final IAppStateService mAppStateService;
    private final Singleton<Handler> mHandler;
    private RotateIntervals mIntervals;
    protected final ISyncMsgSenderV4 mMsgBuilder;
    protected final String mTag;
    protected boolean mLastExecuteIntervalsIsForeground = true;
    private final Runnable mScheduler = new Runnable() { // from class: com.bytedance.sync.v4.compensate.RotationV4.1
        @Override // java.lang.Runnable
        public void run() {
            RotationV4.this.executeOnce();
            RotationV4.this.schedule();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class RotateIntervals {
        long backgroundInterval;
        long foregroundInterval;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public @interface Type {
        public static final int TYPE_POLL = 2;
        public static final int TYPE_SYNC = 1;
    }

    protected abstract void executeOnce();

    protected abstract String getRotationName();

    public abstract int getStatus();

    protected abstract boolean needReset(BsyncProtocol bsyncProtocol);

    public void tryResetRotate(BsyncProtocol bsyncProtocol) {
        if (needReset(bsyncProtocol)) {
            doReset();
        }
    }

    private void doReset() {
        LogUtils.m187i(this.mTag + "receive data, do reset rotate");
        this.mHandler.get(new Object[0]).removeCallbacks(this.mScheduler);
        schedule();
    }

    public RotationV4(String str, IAppStateService iAppStateService, ISyncMsgSenderV4 iSyncMsgSenderV4, Singleton<Handler> singleton, RotateIntervals rotateIntervals) {
        this.mTag = str;
        this.mAppStateService = iAppStateService;
        this.mMsgBuilder = iSyncMsgSenderV4;
        this.mHandler = singleton;
        this.mIntervals = rotateIntervals;
    }

    public void start(boolean z) {
        if (!z) {
            executeOnce();
        }
        schedule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        long rotateInterval = getRotateInterval();
        LogUtils.m187i(this.mTag + "next time to request: " + (rotateInterval / 1000) + "s");
        if (rotateInterval < 0) {
            return;
        }
        this.mHandler.get(new Object[0]).postDelayed(this.mScheduler, rotateInterval);
    }

    protected long getRotateInterval() {
        long j;
        boolean isForeground = this.mAppStateService.isForeground();
        if (isForeground) {
            j = this.mIntervals.foregroundInterval;
        } else {
            j = this.mIntervals.backgroundInterval;
        }
        long j2 = j * 1000;
        this.mLastExecuteIntervalsIsForeground = isForeground;
        return j2;
    }

    public void destroy() {
        this.mHandler.get(new Object[0]).removeCallbacks(this.mScheduler);
    }

    public void updateIntervals(RotateIntervals rotateIntervals) {
        this.mIntervals = rotateIntervals;
    }
}
