package com.bytedance.sync.p005v4.compensate;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.ss.android.ug.bus.UgBusFramework;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WsFirstCompensatorV4 implements ICompensatorV4, Handler.Callback {
    private static final int MSG_WHAT_WS_STATUS_CHANGED = 3;
    private final Configuration configuration;
    private ICompensatorV4 impl;
    private boolean isWsConnected;
    private final IAppStateService mAppStateService;
    private final Singleton<Handler> mHandler = new Singleton<Handler>() { // from class: com.bytedance.sync.v4.compensate.WsFirstCompensatorV4.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sync.Singleton
        public Handler create(Object... objArr) {
            return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get(), WsFirstCompensatorV4.this);
        }
    };
    private final ISyncMsgSenderV4 mMsgBuilder;
    private boolean mReadyToPoll;
    private ISettings mSettings;

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public WsFirstCompensatorV4(IAppStateService iAppStateService, ISyncMsgSenderV4 iSyncMsgSenderV4, Configuration configuration) {
        this.mAppStateService = iAppStateService;
        this.mMsgBuilder = iSyncMsgSenderV4;
        this.configuration = configuration;
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void start(ISettings iSettings, boolean z) {
        LogUtils.m187i("[CompensatorV4] WsFirst start readyToPoll = " + z);
        this.mSettings = iSettings;
        this.mReadyToPoll = z;
        boolean isConnect = this.configuration.wsService.isConnect();
        this.isWsConnected = isConnect;
        ICompensatorV4 createImpl = createImpl(isConnect, true);
        this.impl = createImpl;
        createImpl.start(iSettings, z);
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void onSettingsUpdate(ISettings iSettings, boolean z) {
        this.mSettings = iSettings;
        ICompensatorV4 iCompensatorV4 = this.impl;
        if (iCompensatorV4 != null) {
            iCompensatorV4.onSettingsUpdate(iSettings, z);
        }
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void destroy() {
        LogUtils.m187i("[CompensatorV4] WsFirstCompensator destroy");
        this.mHandler.get(new Object[0]).removeCallbacksAndMessages(null);
        ICompensatorV4 iCompensatorV4 = this.impl;
        if (iCompensatorV4 != null) {
            iCompensatorV4.destroy();
        }
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void resetPollingInterval(BsyncProtocol bsyncProtocol) {
        ICompensatorV4 iCompensatorV4 = this.impl;
        if (iCompensatorV4 != null) {
            iCompensatorV4.resetPollingInterval(bsyncProtocol);
        }
    }

    @Override // com.bytedance.sync.p005v4.compensate.ICompensatorV4
    public void switchToPoll() {
        ICompensatorV4 iCompensatorV4 = this.impl;
        if (iCompensatorV4 != null) {
            iCompensatorV4.switchToPoll();
        }
        this.mReadyToPoll = true;
    }

    private ICompensatorV4 createImpl(boolean z, boolean z2) {
        if (z) {
            this.impl = new WsConnectedCompensatorV4(this.mAppStateService, this.mHandler, this.mMsgBuilder, true);
        } else {
            this.impl = new HttpsFirstCompensatorV4(this.mAppStateService, this.mHandler, this.mMsgBuilder, z2, false);
        }
        return this.impl;
    }

    @Override // com.bytedance.sync.v4.net.NetTrace.TraceDepend
    public int getCurrentStrategy() {
        ICompensatorV4 iCompensatorV4 = this.impl;
        if (iCompensatorV4 == null) {
            return 0;
        }
        return iCompensatorV4 instanceof WsConnectedCompensatorV4 ? 1 : 2;
    }
}
