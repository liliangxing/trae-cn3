package com.bytedance.sync.p005v4.compensate;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.compensate.RotationV4;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.IWsStatusService;
import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.bytedance.sync.p005v4.net.SocketPollNetTrace;
import com.bytedance.sync.p005v4.net.WsStatusKeeper;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.MsgSenderWrapperV4;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SocketPoll implements OnDataUpdateListener, WsStatusKeeper.OnWsStatusChangedListener, Handler.Callback {
    private static final int MSG_WHAT_SETTINGS_UPDATE = 101;
    private static final int MSG_WHAT_WS_STATUS_CHANGED = 102;
    private static final String TAG = "[SocketPoll] ";
    private final Configuration mConfiguration;
    private boolean mConnected;
    private final Context mContext;
    private final MsgSenderWrapperV4 mMsgSenderWrapper;
    private volatile Poll mPoll;
    private final AtomicBoolean mReceivedSyncMsg = new AtomicBoolean(false);
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private final Singleton<Handler> mHandler = new Singleton<Handler>() { // from class: com.bytedance.sync.v4.compensate.SocketPoll.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sync.Singleton
        public Handler create(Object... objArr) {
            return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get(), SocketPoll.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Poll {
        void destroy();

        void resetPollingInterval(BsyncProtocol bsyncProtocol);

        void start(boolean z);

        void switchToPoll();
    }

    SocketPoll(Context context, Configuration configuration) {
        this.mContext = context;
        this.mConfiguration = configuration;
        this.mMsgSenderWrapper = new MsgSenderWrapperV4(context, new SocketMsgSender());
    }

    public void start() {
        ISettings settings = SyncSettings.inst(this.mContext).getSettings();
        SyncSettings.inst(this.mContext).addOnDataUpdateListener(this);
        ((IWsStatusService) UgBusFramework.getService(IWsStatusService.class)).addWsStatusChangedListener(this);
        this.mConnected = this.mConfiguration.wsService.isConnect();
        LogUtils.m188v("[SocketPoll] start socket poll.");
        startWithSettings(settings, this.mConnected);
        this.mStarted.set(true);
    }

    private synchronized void startWithSettings(ISettings iSettings, boolean z) {
        if (iSettings == null) {
            return;
        }
        LogUtils.m188v("[SocketPoll] start socket poll with settings.");
        if (this.mPoll != null) {
            this.mPoll.destroy();
            this.mPoll = null;
            LogUtils.m188v("[SocketPoll] destroy old one.");
        }
        Poll createImpl = createImpl(z, iSettings);
        LogUtils.m185d("[SocketPoll] start new one. isReadyToPoll = " + createImpl);
        createImpl.start(isReadyToPoll());
        this.mPoll = createImpl;
    }

    private Poll createImpl(boolean z, ISettings iSettings) {
        if (z) {
            return new PollImpl(this.mHandler, iSettings, this.mMsgSenderWrapper);
        }
        return new PollEmpty();
    }

    @Override // com.bytedance.sync.interfaze.OnDataUpdateListener
    public void onDataUpdate(ISyncClient.Data data) {
        this.mHandler.get(new Object[0]).sendMessage(this.mHandler.get(new Object[0]).obtainMessage(101));
    }

    public void destroy() {
        SyncSettings.inst(this.mContext).removeOnDataUpdateListener(this);
        this.mHandler.get(new Object[0]).removeMessages(101);
        this.mHandler.get(new Object[0]).removeMessages(102);
    }

    public void onReceiveSyncMsg() {
        Poll poll;
        this.mReceivedSyncMsg.set(true);
        if (!isReadyToPoll() || (poll = this.mPoll) == null) {
            return;
        }
        poll.switchToPoll();
    }

    public void resetPollingInterval(BsyncProtocol bsyncProtocol) {
        Poll poll = this.mPoll;
        if (!this.mStarted.get() || this.mPoll == null) {
            return;
        }
        poll.resetPollingInterval(bsyncProtocol);
    }

    @Override // com.bytedance.sync.v4.net.WsStatusKeeper.OnWsStatusChangedListener
    public void onWsStatusChanged(boolean z) {
        this.mHandler.get(new Object[0]).obtainMessage(102, Boolean.valueOf(z)).sendToTarget();
    }

    private boolean isReadyToPoll() {
        return this.mReceivedSyncMsg.get();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 101) {
            boolean isConnect = this.mConfiguration.wsService.isConnect();
            startWithSettings(SyncSettings.inst(this.mContext).getSettings(), isConnect);
            this.mConnected = isConnect;
        }
        if (message.what != 102) {
            return false;
        }
        boolean isConnect2 = this.mConfiguration.wsService.isConnect();
        startWithSettings(SyncSettings.inst(this.mContext).getSettings(), isConnect2);
        this.mConnected = isConnect2;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class PollImpl implements Poll {
        private final IAppStateService mAppStateService = new IAppStateService() { // from class: com.bytedance.sync.v4.compensate.SocketPoll.PollImpl.1
            @Override // com.bytedance.sync.p005v4.compensate.IAppStateService
            public boolean isForeground() {
                return true;
            }
        };
        private final Singleton<Handler> mHandler;
        private final MsgSenderWrapperV4 mMsgSender;
        private RotationV4 mRotation;
        private final ISettings mSettings;

        public PollImpl(Singleton<Handler> singleton, ISettings iSettings, MsgSenderWrapperV4 msgSenderWrapperV4) {
            this.mHandler = singleton;
            this.mSettings = iSettings;
            this.mMsgSender = msgSenderWrapperV4;
        }

        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void start(boolean z) {
            RotationV4 createNew = createNew(z, this.mSettings);
            createNew.start(true);
            this.mRotation = createNew;
        }

        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void destroy() {
            RotationV4 rotationV4 = this.mRotation;
            if (rotationV4 != null) {
                rotationV4.destroy();
            }
        }

        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void switchToPoll() {
            RotationV4 rotationV4 = this.mRotation;
            if (rotationV4 == null || rotationV4.getStatus() == 1) {
                if (rotationV4 != null) {
                    rotationV4.destroy();
                }
                RotationV4 createNew = createNew(true, this.mSettings);
                createNew.start(true);
                this.mRotation = createNew;
            }
        }

        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void resetPollingInterval(BsyncProtocol bsyncProtocol) {
            RotationV4 rotationV4 = this.mRotation;
            if (rotationV4 != null) {
                rotationV4.tryResetRotate(bsyncProtocol);
            }
        }

        private RotationV4 createNew(boolean z, ISettings iSettings) {
            RotationV4.RotateIntervals rotateIntervals = new RotationV4.RotateIntervals();
            if (z) {
                rotateIntervals.foregroundInterval = iSettings.poll();
                rotateIntervals.backgroundInterval = iSettings.backgroundPoll();
                return new PollRotationV4(SocketPoll.TAG, this.mAppStateService, this.mMsgSender, this.mHandler, rotateIntervals);
            }
            rotateIntervals.foregroundInterval = iSettings.sync();
            rotateIntervals.backgroundInterval = iSettings.backgroundSync();
            return new SyncRotationV4(SocketPoll.TAG, this.mAppStateService, this.mMsgSender, this.mHandler, rotateIntervals);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class PollEmpty implements Poll {
        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void destroy() {
        }

        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void resetPollingInterval(BsyncProtocol bsyncProtocol) {
        }

        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void start(boolean z) {
        }

        @Override // com.bytedance.sync.v4.compensate.SocketPoll.Poll
        public void switchToPoll() {
        }

        private PollEmpty() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class SocketMsgSender implements IMsgSender {
        @Override // com.bytedance.sync.p005v4.intf.IMsgSender
        public boolean isPendingPayloadToSend() {
            return false;
        }

        private SocketMsgSender() {
        }

        @Override // com.bytedance.sync.p005v4.intf.IMsgSender
        public void send(PayloadEntry payloadEntry) {
            payloadEntry.canFallback = false;
            payloadEntry.forceHttps = false;
            payloadEntry.trace = new SocketPollNetTrace();
            payloadEntry.sendReason = 2;
            ((IMsgSender) UgBusFramework.getService(IMsgSender.class)).send(payloadEntry);
        }
    }
}
