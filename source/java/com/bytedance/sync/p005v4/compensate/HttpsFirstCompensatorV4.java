package com.bytedance.sync.p005v4.compensate;

import android.os.Handler;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.compensate.RotationV4;
import com.bytedance.sync.p005v4.intf.ICompensatorServiceV4;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class HttpsFirstCompensatorV4 implements ICompensatorV4 {
    protected final IAppStateService mAppStateService;
    private final boolean mCancelFirstTime;
    protected final Singleton<Handler> mHandler;
    private final ISyncMsgSenderV4 mMsgBuilder;
    private final boolean mNeedResetRotateWhenReceiveData;
    private RotationV4 mRotation;
    private ISettings mSettings;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsFirstCompensatorV4(IAppStateService iAppStateService, Singleton<Handler> singleton, ISyncMsgSenderV4 iSyncMsgSenderV4, boolean z, boolean z2) {
        this.mAppStateService = iAppStateService;
        this.mHandler = singleton;
        this.mMsgBuilder = iSyncMsgSenderV4;
        this.mCancelFirstTime = z;
        this.mNeedResetRotateWhenReceiveData = z2;
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void start(ISettings iSettings, boolean z) {
        RotationV4 syncRotationV4;
        LogUtils.m185d("[CompensatorV4] HttpsCompensator start readyToPoll = " + z);
        this.mSettings = iSettings;
        RotationV4.RotateIntervals rotateIntervals = new RotationV4.RotateIntervals();
        rotateIntervals.foregroundInterval = z ? iSettings.poll() : iSettings.sync();
        rotateIntervals.backgroundInterval = z ? iSettings.backgroundPoll() : iSettings.backgroundSync();
        if (z) {
            syncRotationV4 = new PollRotationV4(ICompensatorServiceV4.TAG, this.mAppStateService, this.mMsgBuilder, this.mHandler, rotateIntervals);
        } else {
            syncRotationV4 = new SyncRotationV4(ICompensatorServiceV4.TAG, this.mAppStateService, this.mMsgBuilder, this.mHandler, rotateIntervals);
        }
        this.mRotation = syncRotationV4;
        syncRotationV4.start(this.mCancelFirstTime);
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void onSettingsUpdate(ISettings iSettings, boolean z) {
        this.mSettings = iSettings;
        RotationV4.RotateIntervals rotateIntervals = new RotationV4.RotateIntervals();
        rotateIntervals.foregroundInterval = z ? iSettings.poll() : iSettings.sync();
        rotateIntervals.backgroundInterval = z ? iSettings.backgroundPoll() : iSettings.backgroundSync();
        this.mRotation.updateIntervals(rotateIntervals);
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void destroy() {
        LogUtils.m185d("[CompensatorV4] HttpsCompensator destroy");
        RotationV4 rotationV4 = this.mRotation;
        if (rotationV4 != null) {
            rotationV4.destroy();
        }
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void resetPollingInterval(BsyncProtocol bsyncProtocol) {
        RotationV4 rotationV4 = this.mRotation;
        if (rotationV4 == null || !this.mNeedResetRotateWhenReceiveData) {
            return;
        }
        rotationV4.tryResetRotate(bsyncProtocol);
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void switchToPoll() {
        RotationV4 rotationV4 = this.mRotation;
        if (rotationV4 == null || rotationV4.getStatus() == 1) {
            RotationV4 rotationV42 = this.mRotation;
            if (rotationV42 != null) {
                rotationV42.destroy();
            }
            RotationV4.RotateIntervals rotateIntervals = new RotationV4.RotateIntervals();
            rotateIntervals.foregroundInterval = this.mSettings.poll();
            rotateIntervals.backgroundInterval = this.mSettings.backgroundPoll();
            PollRotationV4 pollRotationV4 = new PollRotationV4(ICompensatorServiceV4.TAG, this.mAppStateService, this.mMsgBuilder, this.mHandler, rotateIntervals);
            this.mRotation = pollRotationV4;
            pollRotationV4.start(true);
        }
    }

    @Override // com.bytedance.sync.v4.net.NetTrace.TraceDepend
    public int getCurrentStrategy() {
        return this.mAppStateService.isForeground() ? 3 : 4;
    }
}
