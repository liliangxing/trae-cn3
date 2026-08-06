package com.bytedance.sync.p005v4.compensate;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.net.NetThreadPool;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.IProtocolProcessor;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.bytedance.sync.p005v4.net.CompensatorTrace;
import com.bytedance.sync.p005v4.net.HttpMsgSender;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.MsgSenderWrapperV4;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class CompensatorImplV4 implements OnDataUpdateListener, LifecycleObserver, IAppStateService {
    private final Configuration mConfiguration;
    private final Context mContext;
    private volatile ICompensatorV4 mCurrentCompensator;
    private boolean mForeground;
    private volatile ISettings mSettings;
    private final ISyncMsgSenderV4 msgSenderWrapper;
    private final AtomicBoolean mReceivedSyncMsg = new AtomicBoolean(false);
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private final Runnable mStartRunnable = new Runnable() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.4
        @Override // java.lang.Runnable
        public void run() {
            ISettings settings = SyncSettings.inst(CompensatorImplV4.this.mContext).getSettings();
            SyncSettings.inst(CompensatorImplV4.this.mContext).addOnDataUpdateListener(CompensatorImplV4.this);
            CompensatorImplV4.this.startCompensatorWithSettings(settings);
        }
    };
    private final Singleton<Handler> mHandler = new Singleton<Handler>() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sync.Singleton
        public Handler create(Object... objArr) {
            return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get());
        }
    };

    public CompensatorImplV4(Context context, Configuration configuration, IProtocolProcessor iProtocolProcessor) {
        this.mContext = context;
        this.mConfiguration = configuration;
        final HttpMsgSender httpMsgSender = new HttpMsgSender(context, iProtocolProcessor, null);
        this.msgSenderWrapper = new MsgSenderWrapperV4(context, new IMsgSender() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.2
            @Override // com.bytedance.sync.p005v4.intf.IMsgSender
            public boolean isPendingPayloadToSend() {
                return false;
            }

            @Override // com.bytedance.sync.p005v4.intf.IMsgSender
            public void send(final PayloadEntry payloadEntry) {
                payloadEntry.trace = new CompensatorTrace(CompensatorImplV4.this.mForeground, CompensatorImplV4.this.mCurrentCompensator);
                payloadEntry.sendReason = 2;
                NetThreadPool.submit(new Runnable() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        httpMsgSender.send(payloadEntry);
                    }
                });
            }
        });
    }

    @Override // com.bytedance.sync.interfaze.OnDataUpdateListener
    public void onDataUpdate(ISyncClient.Data data) {
        final ISettings settings = SyncSettings.inst(this.mContext).getSettings();
        this.mHandler.get(new Object[0]).post(new Runnable() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.3
            @Override // java.lang.Runnable
            public void run() {
                CompensatorImplV4.this.startCompensatorWithSettings(settings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCompensatorWithSettings(ISettings iSettings) {
        if (iSettings == null) {
            return;
        }
        ISettings iSettings2 = this.mSettings;
        ICompensatorV4 iCompensatorV4 = this.mCurrentCompensator;
        if (iSettings2 == null || iCompensatorV4 == null) {
            ICompensatorV4 createCompensatorImpl = createCompensatorImpl(iSettings.wsFirst());
            createCompensatorImpl.start(iSettings, isReadyToPoll());
            this.mCurrentCompensator = createCompensatorImpl;
        } else if ((this.mSettings.wsFirst() && !iSettings.wsFirst()) || (!this.mSettings.wsFirst() && iSettings.wsFirst())) {
            iCompensatorV4.destroy();
            ICompensatorV4 createCompensatorImpl2 = createCompensatorImpl(iSettings.wsFirst());
            createCompensatorImpl2.start(iSettings, isReadyToPoll());
            this.mCurrentCompensator = createCompensatorImpl2;
        } else {
            iCompensatorV4.onSettingsUpdate(iSettings, isReadyToPoll());
        }
        this.mSettings = iSettings;
        this.mStarted.set(true);
    }

    private ICompensatorV4 createCompensatorImpl(boolean z) {
        if (z) {
            return new WsFirstCompensatorV4(this, this.msgSenderWrapper, this.mConfiguration);
        }
        return new HttpsFirstCompensatorV4(this, this.mHandler, this.msgSenderWrapper, false, true);
    }

    private boolean isReadyToPoll() {
        return this.mReceivedSyncMsg.get();
    }

    private void registerLifeCycleListener() {
        Runnable runnable = new Runnable() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ProcessLifecycleOwner.get().getLifecycle().addObserver(CompensatorImplV4.this);
                } catch (Exception unused) {
                    LogUtils.m186e("there is something wrong when add life cycle Observer,maybe someone add addObserver in work thread");
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private void unregisterLifeCycleListener() {
        Runnable runnable = new Runnable() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ProcessLifecycleOwner.get().getLifecycle().removeObserver(CompensatorImplV4.this);
                } catch (Exception unused) {
                    LogUtils.m186e("there is something wrong when add life cycle Observer,maybe someone add addObserver in work thread");
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppBackground() {
        LogUtils.m187i("[CompensatorV4] startCompensate ON_STOP");
        this.mHandler.get(new Object[0]).post(new Runnable() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.7
            @Override // java.lang.Runnable
            public void run() {
                CompensatorImplV4.this.mForeground = false;
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppForeground() {
        LogUtils.m187i("[CompensatorV4] startCompensate ON_START");
        this.mHandler.get(new Object[0]).post(new Runnable() { // from class: com.bytedance.sync.v4.compensate.CompensatorImplV4.8
            @Override // java.lang.Runnable
            public void run() {
                CompensatorImplV4.this.mForeground = true;
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.compensate.IAppStateService
    public boolean isForeground() {
        return this.mForeground;
    }

    public void onReceiveSyncMsg() {
        this.mReceivedSyncMsg.set(true);
        if (isReadyToPoll()) {
            if (this.mCurrentCompensator != null) {
                this.mCurrentCompensator.switchToPoll();
            } else if (this.mHandler.get(new Object[0]).hasCallbacks(this.mStartRunnable)) {
                LogUtils.m187i("[CompensatorV4] reset start delay task and run right now");
                this.mHandler.get(new Object[0]).removeCallbacks(this.mStartRunnable);
                this.mHandler.get(new Object[0]).post(this.mStartRunnable);
            }
        }
    }

    public void start() {
        registerLifeCycleListener();
        ISettings settings = SyncSettings.inst(this.mContext).getSettings();
        LogUtils.m187i("[CompensatorV4] start compensator. compensator will run after " + ((settings.eventChangeInterval() * 1000) + 1000) + "ms");
        this.mHandler.get(new Object[0]).postDelayed(this.mStartRunnable, settings.wsFirst() ? 1000 + (settings.eventChangeInterval() * 1000) : 1000L);
    }

    public void destroy() {
        this.mHandler.get(new Object[0]).removeCallbacksAndMessages(null);
        SyncSettings.inst(this.mContext).removeOnDataUpdateListener(this);
        unregisterLifeCycleListener();
        if (this.mCurrentCompensator != null) {
            this.mCurrentCompensator.destroy();
            this.mCurrentCompensator = null;
        }
    }

    public void resetPollingInterval(BsyncProtocol bsyncProtocol) {
        if (!this.mStarted.get() || this.mCurrentCompensator == null) {
            return;
        }
        this.mCurrentCompensator.resetPollingInterval(bsyncProtocol);
    }
}
