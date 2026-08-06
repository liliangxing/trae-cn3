package com.bytedance.sync.p005v4.compensate;

import android.content.Context;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.p005v4.intf.ICompensatorServiceV4;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IProtocolProcessor;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.ss.android.ug.bus.UgBusFramework;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CompensatorServiceV4 implements ICompensatorServiceV4 {
    private CompensatorImplV4 mCompensatorImpl;
    private final Configuration mConfiguration = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
    private final Context mContext;
    private final IProtocolProcessor mMsgProcessor;

    public CompensatorServiceV4(Context context, IProtocolProcessor iProtocolProcessor) {
        this.mContext = context;
        this.mMsgProcessor = iProtocolProcessor;
    }

    @Override // com.bytedance.sync.p005v4.intf.ICompensatorServiceV4
    public void reset() {
        CompensatorImplV4 compensatorImplV4 = this.mCompensatorImpl;
        if (compensatorImplV4 != null) {
            compensatorImplV4.destroy();
            this.mCompensatorImpl = null;
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.ICompensatorServiceV4
    public void onReceiveSyncMsg() {
        CompensatorImplV4 compensatorImplV4 = this.mCompensatorImpl;
        if (compensatorImplV4 != null) {
            compensatorImplV4.onReceiveSyncMsg();
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.ICompensatorServiceV4
    public void startOnce() {
        CompensatorImplV4 compensatorImplV4 = new CompensatorImplV4(this.mContext, this.mConfiguration, this.mMsgProcessor);
        compensatorImplV4.start();
        this.mCompensatorImpl = compensatorImplV4;
    }

    @Override // com.bytedance.sync.p005v4.intf.ICompensatorServiceV4
    public void resetPollingInterval(BsyncProtocol bsyncProtocol) {
        CompensatorImplV4 compensatorImplV4 = this.mCompensatorImpl;
        if (compensatorImplV4 != null) {
            compensatorImplV4.resetPollingInterval(bsyncProtocol);
        }
    }
}
