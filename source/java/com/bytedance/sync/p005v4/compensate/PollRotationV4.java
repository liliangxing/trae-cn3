package com.bytedance.sync.p005v4.compensate;

import android.os.Handler;
import android.util.Log;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.compensate.RotationV4;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.Reason;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class PollRotationV4 extends RotationV4 {
    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    protected String getRotationName() {
        return "pollV4";
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    public int getStatus() {
        return 2;
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    protected boolean needReset(BsyncProtocol bsyncProtocol) {
        return (bsyncProtocol == null || bsyncProtocol.topics == null || bsyncProtocol.topics.isEmpty()) ? false : true;
    }

    public PollRotationV4(String str, IAppStateService iAppStateService, ISyncMsgSenderV4 iSyncMsgSenderV4, Singleton<Handler> singleton, RotationV4.RotateIntervals rotateIntervals) {
        super(str, iAppStateService, iSyncMsgSenderV4, singleton, rotateIntervals);
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    protected void executeOnce() {
        try {
            LogUtils.m185d(this.mTag + "start send poll");
            this.mMsgBuilder.sendPollMsg(false, (this.mLastExecuteIntervalsIsForeground ? Reason.Ping : Reason.BackgroundPing).getValue());
        } catch (Throwable th) {
            LogUtils.m186e("pollRotation executeOnce error: " + Log.getStackTraceString(th));
        }
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    public void destroy() {
        super.destroy();
        LogUtils.m185d(this.mTag + "cancelPoll");
    }
}
