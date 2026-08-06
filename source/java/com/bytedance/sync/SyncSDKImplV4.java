package com.bytedance.sync;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.SyncBusiness;
import com.bytedance.sync.interfaze.Callback;
import com.bytedance.sync.interfaze.ICommonService;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.interfaze.ISyncApi;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.ISyncNetService;
import com.bytedance.sync.interfaze.SyncClientCreator;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.Topic;
import com.bytedance.sync.net.SyncNetServiceImpl;
import com.bytedance.sync.p005v4.compensate.CompensatorServiceV4;
import com.bytedance.sync.p005v4.history.HistoryMgrV4;
import com.bytedance.sync.p005v4.history.IHistoryMgr;
import com.bytedance.sync.p005v4.history.ISyncHistory;
import com.bytedance.sync.p005v4.intf.ICompensatorServiceV4;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IDataErrorServiceV4;
import com.bytedance.sync.p005v4.intf.IDataPatchService;
import com.bytedance.sync.p005v4.intf.IMsgConverter;
import com.bytedance.sync.p005v4.intf.IMsgReceiver;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.IPayloadSendServiceV4;
import com.bytedance.sync.p005v4.intf.IProtocolProcessor;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.intf.ISyncStatus;
import com.bytedance.sync.p005v4.intf.IWsStatusService;
import com.bytedance.sync.p005v4.lifecycle.SyncLifeCycle;
import com.bytedance.sync.p005v4.monitor.WsMonitor;
import com.bytedance.sync.p005v4.net.MsgSenderV4;
import com.bytedance.sync.p005v4.net.WsStatusKeeper;
import com.bytedance.sync.p005v4.notify.MsgNotifierV4;
import com.bytedance.sync.p005v4.presistence.DBServiceImplV4;
import com.bytedance.sync.p005v4.process.DataErrorServiceV4;
import com.bytedance.sync.p005v4.process.DataPatchServiceV4;
import com.bytedance.sync.p005v4.process.HttpMsgProcessorV4;
import com.bytedance.sync.p005v4.process.ProtocolProcessorV4;
import com.bytedance.sync.p005v4.process.WsChannelMsgProcessorV4;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.MsgConverterV2;
import com.bytedance.sync.p005v4.protocal.MsgSenderWrapperV4;
import com.bytedance.sync.p005v4.protocal.Reason;
import com.bytedance.sync.p005v4.recv.MsgReceiverService;
import com.bytedance.sync.p005v4.status.SyncStatus;
import com.bytedance.sync.p005v4.tigger.SyncTiggerV4;
import com.bytedance.sync.p005v4.topic.CustomTopicMgr;
import com.bytedance.sync.p005v4.topic.SubscribeTopicCallbackWrapper;
import com.bytedance.sync.p005v4.upstream.PayloadSendServiceV4;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SyncSDKImplV4 implements ISyncApi, SyncBusiness.DataListenerAddCallback {
    private final MsgConverterV2 converter;
    private final BusinessManager mBusinessManager;
    private final Configuration mConfiguration;
    private final Context mContext;
    private final CustomTopicMgr mCustomTopicMgr;
    private final Singleton<Handler> mHandler;
    private final HttpMsgProcessorV4 mHttpMsgProcessor;
    private final ProtocolProcessorV4 mMsgProcessor;
    private final MsgNotifierV4 mNotifier;
    private SyncTiggerV4 mSyncTigger;
    private final WsChannelMsgProcessorV4 mWsMsgProcessor;
    private final String TAG = "[SyncSDKImplV4] ";
    private final AtomicBoolean mStarted = new AtomicBoolean(false);

    public SyncSDKImplV4(Context context, Configuration configuration) {
        Singleton<Handler> singleton = new Singleton<Handler>() { // from class: com.bytedance.sync.SyncSDKImplV4.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.sync.Singleton
            public Handler create(Object... objArr) {
                return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get());
            }
        };
        this.mHandler = singleton;
        this.mContext = context;
        this.mConfiguration = configuration;
        BusinessManager businessManager = new BusinessManager(this, new SyncClientCreator() { // from class: com.bytedance.sync.SyncSDKImplV4.2
            @Override // com.bytedance.sync.interfaze.SyncClientCreator
            public SyncClientV4 create(Long l) {
                return new SyncClientV4(l, SyncSDKImplV4.this.mBusinessManager);
            }
        });
        this.mBusinessManager = businessManager;
        MsgNotifierV4 msgNotifierV4 = new MsgNotifierV4(configuration, businessManager);
        this.mNotifier = msgNotifierV4;
        MsgConverterV2 msgConverterV2 = new MsgConverterV2(configuration.channelId, configuration.upStreamServiceId);
        this.converter = msgConverterV2;
        ProtocolProcessorV4 protocolProcessorV4 = new ProtocolProcessorV4(context);
        this.mMsgProcessor = protocolProcessorV4;
        this.mWsMsgProcessor = new WsChannelMsgProcessorV4(context);
        HttpMsgProcessorV4 httpMsgProcessorV4 = new HttpMsgProcessorV4(context);
        this.mHttpMsgProcessor = httpMsgProcessorV4;
        AccountEventSynchronizer accountEventSynchronizer = new AccountEventSynchronizer(context, configuration.accountService);
        UgBusFramework.registerService(IConfiguration.class, new ConfigurationService(configuration));
        UgBusFramework.registerService(IDeviceInfoGetter.class, accountEventSynchronizer);
        UgBusFramework.registerService(ILooper.class, new ILooper() { // from class: com.bytedance.sync.SyncSDKImplV4.3
            final Singleton<Looper> looper = new Singleton<Looper>() { // from class: com.bytedance.sync.SyncSDKImplV4.3.1
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.bytedance.sync.Singleton
                public Looper create(Object... objArr) {
                    HandlerThread handlerThread = new HandlerThread("sync-sdk-v4");
                    handlerThread.start();
                    return handlerThread.getLooper();
                }
            };

            @Override // com.bytedance.sync.interfaze.ILooper
            public Looper get() {
                return this.looper.get(new Object[0]);
            }
        });
        UgBusFramework.registerService(IMsgConverter.class, msgConverterV2);
        UgBusFramework.registerService(IDBServiceV4.class, new DBServiceImplV4(context));
        UgBusFramework.registerService(IWsStatusService.class, new WsStatusKeeper());
        UgBusFramework.registerService(ICompensatorServiceV4.class, new CompensatorServiceV4(context, new IProtocolProcessor() { // from class: com.bytedance.sync.SyncSDKImplV4.4
            @Override // com.bytedance.sync.p005v4.intf.IProtocolProcessor
            public void process(int i, BsyncProtocol bsyncProtocol) {
                SyncSDKImplV4.this.mMsgProcessor.process(i, bsyncProtocol);
            }
        }));
        UgBusFramework.registerService(IMsgReceiver.class, new MsgReceiverService());
        UgBusFramework.registerService(IMsgSender.class, new MsgSenderV4(context, protocolProcessorV4));
        UgBusFramework.registerService(ISyncMsgSenderV4.class, new MsgSenderWrapperV4(context));
        UgBusFramework.registerService(ICommonParamProvider.class, configuration.commonParamProvider);
        UgBusFramework.registerService(IFileDataCacheService.class, new DataFileCacheService(context));
        UgBusFramework.registerService(IDataPatchService.class, new DataPatchServiceV4(context, msgNotifierV4));
        UgBusFramework.registerService(IPayloadSendServiceV4.class, new PayloadSendServiceV4(context, configuration, accountEventSynchronizer, businessManager));
        UgBusFramework.registerService(IDataErrorServiceV4.class, new DataErrorServiceV4());
        UgBusFramework.registerService(ISyncNetService.class, new SyncNetServiceImpl(context, httpMsgProcessorV4));
        UgBusFramework.registerService(ISyncStatus.class, new SyncStatus());
        UgBusFramework.registerService(ICommonService.class, new CommonService(context));
        UgBusFramework.registerService(IHistoryMgr.class, new HistoryMgrV4(context));
        this.mCustomTopicMgr = new CustomTopicMgr();
        singleton.get(new Object[0]).post(new Runnable() { // from class: com.bytedance.sync.SyncSDKImplV4.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().syncLifeCycle.onLifeCycle(SyncLifeCycle.Init);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public synchronized void start(String str) {
        IDeviceInfoGetter iDeviceInfoGetter = (IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class);
        iDeviceInfoGetter.updateDid(str);
        if (this.mStarted.compareAndSet(false, true)) {
            iDeviceInfoGetter.startListenAccountChangeEvent();
            new WsMonitor().monitorStart();
        }
        SyncTiggerV4 syncTiggerV4 = this.mSyncTigger;
        if (syncTiggerV4 != null) {
            syncTiggerV4.destroy();
        }
        SyncTiggerV4 syncTiggerV42 = new SyncTiggerV4(this.mContext);
        this.mSyncTigger = syncTiggerV42;
        syncTiggerV42.start();
        ((IPayloadSendServiceV4) UgBusFramework.getService(IPayloadSendServiceV4.class)).trySendUploadMsg();
        this.mHandler.get(new Object[0]).postDelayed(new Runnable() { // from class: com.bytedance.sync.SyncSDKImplV4.6
            @Override // java.lang.Runnable
            public void run() {
                SyncMonitor.monitorStorageSize(SyncSDKImplV4.this.mContext);
            }
        }, TimeUnit.MINUTES.toMillis(2L));
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public void onReceiveWsChannelEvent(final WsChannelMsg wsChannelMsg) {
        this.mHandler.get(new Object[0]).post(new Runnable() { // from class: com.bytedance.sync.SyncSDKImplV4.7
            @Override // java.lang.Runnable
            public void run() {
                WsChannelMsg process = SyncSDKImplV4.this.mWsMsgProcessor.process(wsChannelMsg);
                if (process != null) {
                    BsyncProtocol convertToProtocol = SyncSDKImplV4.this.converter.convertToProtocol(process);
                    if (convertToProtocol != null) {
                        SyncSDKImplV4.this.mMsgProcessor.process(0, convertToProtocol);
                        ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).resetPollingInterval(convertToProtocol);
                        ((IMsgReceiver) UgBusFramework.getService(IMsgReceiver.class)).onReceiveWsEvent(process);
                        return;
                    }
                    LogUtils.m187i("[SyncSDKImplV4] convert protocol is null");
                    return;
                }
                LogUtils.m187i("[SyncSDKImplV4] receive ws channel msg is null");
            }
        });
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public ISyncClient registerBusiness(SyncBiz syncBiz) {
        LogUtils.m187i("[SyncSDKImplV4] register business " + syncBiz.bizId);
        if (!this.mConfiguration.enableMultiProcess || ToolUtils.isMainProcess(this.mContext) || this.mConfiguration.enableMultiProcessBusiness.contains(Integer.valueOf(Integer.parseInt("" + syncBiz.bizId)))) {
            return this.mBusinessManager.registerBusiness(syncBiz);
        }
        return null;
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public Collection<SyncBusiness> getRegisteredBusinesses() {
        return this.mBusinessManager.getBusinesses();
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public void subscribeTopic(Topic topic, Callback<Void> callback) {
        this.mCustomTopicMgr.subscribeTopic(topic, new SubscribeTopicCallbackWrapper(topic, "subscribe", callback));
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public void unsubscribeTopic(Topic topic, Callback<Void> callback) {
        this.mCustomTopicMgr.unsubscribeTopic(topic, new SubscribeTopicCallbackWrapper(topic, "unsubscribe", callback));
    }

    @Override // com.bytedance.sync.SyncBusiness.DataListenerAddCallback
    public void onAdd(long j) {
        this.mNotifier.doNotifyBusiness(j);
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public List<ISyncClient.Data> getHistoryData(ISyncHistory.HistoryData historyData) {
        return ((IHistoryMgr) UgBusFramework.getService(IHistoryMgr.class)).historyMsgProcessor().queryHistoryData(historyData);
    }

    @Override // com.bytedance.sync.interfaze.ISyncApi
    public void trySyncDataFromService() {
        if (this.mStarted.get()) {
            this.mHandler.get(new Object[0]).post(new Runnable() { // from class: com.bytedance.sync.SyncSDKImplV4.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SyncSDKImplV4.this.mSyncTigger.sendPollMsg(true, Reason.HttpPollBiz.getValue());
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
