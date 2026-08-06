package com.bytedance.sync.p005v4.compensate;

import android.os.Handler;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.compensate.RotationV4;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.Reason;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SyncRotationV4 extends RotationV4 {
    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    protected String getRotationName() {
        return "poll_init";
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    public int getStatus() {
        return 1;
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    protected boolean needReset(BsyncProtocol bsyncProtocol) {
        return (bsyncProtocol == null || bsyncProtocol.topics == null || bsyncProtocol.topics.isEmpty()) ? false : true;
    }

    public SyncRotationV4(String str, IAppStateService iAppStateService, ISyncMsgSenderV4 iSyncMsgSenderV4, Singleton<Handler> singleton, RotationV4.RotateIntervals rotateIntervals) {
        super(str, iAppStateService, iSyncMsgSenderV4, singleton, rotateIntervals);
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    protected void executeOnce() {
        LogUtils.m185d(this.mTag + "start send poll init");
        this.mMsgBuilder.sendPollMsg(false, Reason.Init.getValue());
    }

    @Override // com.bytedance.sync.p005v4.compensate.RotationV4
    public void destroy() {
        super.destroy();
        LogUtils.m185d(this.mTag + "cancelSync");
    }
}
