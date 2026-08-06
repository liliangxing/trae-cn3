package com.bytedance.sync.p005v4.net;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.interfaze.ICommonService;
import com.bytedance.sync.interfaze.IWsService;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IMsgConverter;
import com.bytedance.sync.p005v4.intf.IMsgReceiver;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.IReceiveWsMsg;
import com.bytedance.sync.p005v4.intf.IWsStatusService;
import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.bytedance.sync.p005v4.net.WsStatusKeeper;
import com.bytedance.sync.p005v4.utils.ProtocolUtils;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WsMsgSenderV4 extends BaseMsgSender implements WsStatusKeeper.OnWsStatusChangedListener, IReceiveWsMsg {
    private final IMsgSender callback;
    private final boolean enableMultiProcess;
    private final boolean isMainProcess;
    private final Object mLock;
    private final LinkedBlockingQueue<WsChannelMsg> mRetryMessageDequeue;
    private boolean mWaitingTimeout;
    private final IWsService wsService;

    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    public boolean isPendingPayloadToSend() {
        return false;
    }

    @Override // com.bytedance.sync.p005v4.net.BaseMsgSender
    public int method() {
        return 1;
    }

    public WsMsgSenderV4(Context context, IMsgSender iMsgSender) {
        super(context);
        this.mLock = new Object();
        this.mRetryMessageDequeue = new LinkedBlockingQueue<>();
        this.wsService = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().wsService;
        this.callback = iMsgSender;
        this.enableMultiProcess = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().enableMultiProcess;
        this.isMainProcess = ToolUtils.isMainProcess(context);
        ((IWsStatusService) UgBusFramework.getService(IWsStatusService.class)).addWsStatusChangedListener(this);
        ((IMsgReceiver) UgBusFramework.getService(IMsgReceiver.class)).registerWsChannelEventListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0084 A[Catch: all -> 0x00aa, TryCatch #1 {, blocks: (B:42:0x0076, B:44:0x007a, B:49:0x0084, B:53:0x00a0, B:54:0x00a8, B:65:0x00a3), top: B:41:0x0076, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a3 A[Catch: all -> 0x00aa, TryCatch #1 {, blocks: (B:42:0x0076, B:44:0x007a, B:49:0x0084, B:53:0x00a0, B:54:0x00a8, B:65:0x00a3), top: B:41:0x0076, outer: #0 }] */
    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void send(PayloadEntry payloadEntry) {
        boolean z;
        if (payloadEntry.forceHttps) {
            this.callback.send(payloadEntry);
            return;
        }
        if (payloadEntry.msg == null) {
            LogUtils.m186e("[SendMsgV4] msg is null ,not send");
            return;
        }
        int intValue = ProtocolUtils.INSTANCE.protocolMsgType(payloadEntry.msg).intValue();
        WsChannelMsg convertToWsMsg = ((IMsgConverter) UgBusFramework.getService(IMsgConverter.class)).convertToWsMsg(this.context, payloadEntry.msg);
        if (convertToWsMsg == null) {
            LogUtils.m186e("[SendMsgV4] convert msg error, not send");
            return;
        }
        if (this.enableMultiProcess && !this.isMainProcess) {
            if (payloadEntry.canFallback) {
                fallbackToHttp(payloadEntry);
                return;
            }
            return;
        }
        boolean isConnect = this.wsService.isConnect();
        if (isConnect) {
            this.mWaitingTimeout = false;
            this.wsService.send(convertToWsMsg);
            LogUtils.m187i("[SendMsgV4] send msg to ws " + MsgSenderV4.toLog(payloadEntry.msg));
        } else {
            try {
                synchronized (this.mLock) {
                    if (this.mWaitingTimeout && payloadEntry.canFallback) {
                        z = false;
                        if (!z) {
                            LogUtils.m187i("[SendMsgV4] ws not connect, sleep...");
                            long currentTimeMillis = System.currentTimeMillis();
                            this.mLock.wait(5000L);
                            if (!(System.currentTimeMillis() - currentTimeMillis < 5000)) {
                                this.mWaitingTimeout = true;
                            }
                        } else {
                            LogUtils.m187i("[SendMsgV4] ws not connect, but waiting timeout, so not sleep");
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isConnect = this.wsService.isConnect();
            r4 = ((ICommonService) UgBusFramework.getService(ICommonService.class)).isNetWorkAvailable(this.context);
            if (isConnect) {
                this.wsService.send(convertToWsMsg);
                LogUtils.m187i("[SendMsgV4] send msg to ws again " + MsgSenderV4.toLog(payloadEntry.msg));
            } else if (payloadEntry.canFallback && r4) {
                fallbackToHttp(payloadEntry);
                LogUtils.m187i("[SendMsgV4] ws not connect, fallback to http...");
            } else {
                LogUtils.m186e("[SendMsgV4] send payload failed with ws " + MsgSenderV4.toLog(payloadEntry.msg) + ", throw it");
            }
        }
        if (!isConnect && payloadEntry.canFallback && ((ICommonService) UgBusFramework.getService(ICommonService.class)).isNetWorkAvailable(this.context)) {
            return;
        }
        onTraceSendMsg(payloadEntry, isConnect ? 1 : r4 ? 2 : 3, intValue, this.wsService.isConnect());
        onEventSendMsg(payloadEntry);
    }

    private void fallbackToHttp(PayloadEntry payloadEntry) {
        PayloadEntry payloadEntry2 = new PayloadEntry();
        payloadEntry2.msg = payloadEntry.msg;
        payloadEntry2.canFallback = false;
        payloadEntry2.trace = payloadEntry.trace;
        payloadEntry2.sendReason = payloadEntry.sendReason;
        this.callback.send(payloadEntry2);
    }

    @Override // com.bytedance.sync.v4.net.WsStatusKeeper.OnWsStatusChangedListener
    public void onWsStatusChanged(boolean z) {
        if (z) {
            synchronized (this.mLock) {
                LogUtils.m187i("[SendMsgV4] notify ws connected");
                this.mLock.notifyAll();
            }
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IReceiveWsMsg
    public void onReceiveWsMsg(WsChannelMsg wsChannelMsg) {
        try {
            this.mRetryMessageDequeue.clear();
        } catch (Throwable unused) {
        }
    }
}
