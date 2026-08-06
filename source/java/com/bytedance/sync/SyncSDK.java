package com.bytedance.sync;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.SyncBiz;
import com.bytedance.sync.interfaze.Callback;
import com.bytedance.sync.interfaze.ISyncApi;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.Topic;
import com.bytedance.sync.p005v4.history.ISyncHistory;
import com.bytedance.sync.settings.SyncSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncSDK {
    private static Context application;
    private static Configuration configuration;
    private static volatile ISyncApi service;
    private static final AtomicBoolean sInited = new AtomicBoolean(false);
    private static final BusinessCache sCaches = new BusinessCache();
    private static final DelayTaskExecutor executor = new DelayTaskExecutor();
    private static final SDKInitObservable sInitObservable = new SDKInitObservable();

    static {
        SyncMonitor.injectNpthVersion();
    }

    public static void init(Context context, Configuration configuration2) {
        synchronized (SyncSDK.class) {
            application = context;
            if (hasInit()) {
                return;
            }
            LogUtils.m187i("init " + configuration2 + ", sdk version = ");
            LogUtils.setLogger(configuration2.logger);
            configuration = configuration2;
            service = new SyncSDKImplV4(context, configuration2);
            sInited.set(true);
            SDKInitObservable sDKInitObservable = sInitObservable;
            sDKInitObservable.notifyInit();
            sDKInitObservable.deleteObservers();
            sCaches.doAfterInit();
        }
    }

    public static boolean hasInit() {
        return sInited.get() && service != null;
    }

    public static void onReceiveWsEvent(final WsChannelMsg wsChannelMsg) {
        LogUtils.m187i("onReceiveWsEvent");
        if (wsChannelMsg == null || wsChannelMsg.getService() != 20032) {
            LogUtils.m188v("onReceiveWsEvent not process. serviceId isn't 20032");
        } else {
            executor.runAfterReady(new Runnable() { // from class: com.bytedance.sync.SyncSDK.1
                @Override // java.lang.Runnable
                public void run() {
                    SyncSDK.service.onReceiveWsChannelEvent(wsChannelMsg);
                }
            });
        }
    }

    @Deprecated
    public static ISyncClient registerBusiness(int i, OnDataUpdateListener onDataUpdateListener) {
        return registerBusiness(new SyncBiz.Builder(i).addOnUpdateListener(onDataUpdateListener).build());
    }

    public static ISyncClient registerBusiness(SyncBiz syncBiz) {
        if (syncBiz.bizId == 1) {
            LogUtils.m186e("inner business,not allow to register");
            return null;
        }
        if (!hasInit()) {
            return sCaches.addToCache(syncBiz);
        }
        return service.registerBusiness(syncBiz);
    }

    public static void start(String str, String str2) {
        LogUtils.m188v("#start, did = " + str + ", iid = " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogUtils.m187i("#start#ignore, did or iid is null");
            return;
        }
        if (!hasInit()) {
            throw new IllegalStateException("please init first");
        }
        SyncEventCompat.init(application, configuration);
        SyncMonitor.init(application, configuration, str);
        service.start(str);
        executor.onReady();
        registerSyncBusiness();
    }

    public static void runAfterStart(Runnable runnable) {
        executor.runAfterReady(runnable);
    }

    public static Collection<SyncBusiness> getRegisteredBusinesses() {
        if (!hasInit()) {
            return null;
        }
        Collection<SyncBusiness> registeredBusinesses = service.getRegisteredBusinesses();
        if (registeredBusinesses != null) {
            Iterator<SyncBusiness> it = registeredBusinesses.iterator();
            while (it.hasNext()) {
                SyncBusiness next = it.next();
                if (next != null && next.getBusiness() == 1) {
                    it.remove();
                }
            }
        }
        return registeredBusinesses;
    }

    public static void addInitObserver(Observer observer) {
        synchronized (SyncSDK.class) {
            if (hasInit()) {
                observer.update(sInitObservable, null);
            } else {
                sInitObservable.addObserver(observer);
            }
        }
    }

    public static void removeInitObserver(Observer observer) {
        try {
            sInitObservable.deleteObserver(observer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void subscribeTopic(Topic topic, Callback<Void> callback) {
        service.subscribeTopic(topic, callback);
    }

    public static void unsubscribeTopic(Topic topic, Callback<Void> callback) {
        service.unsubscribeTopic(topic, callback);
    }

    public static List<ISyncClient.Data> getHistoryData(ISyncHistory.HistoryData historyData) {
        if (!hasInit()) {
            return null;
        }
        if (historyData.dataType == ISyncHistory.HistoryDataType.CUSTOM && (historyData.topic == null || TextUtils.isEmpty(historyData.topic.getTopic()))) {
            return null;
        }
        return service.getHistoryData(historyData);
    }

    public static void trySyncDataFromServer() {
        if (hasInit()) {
            service.trySyncDataFromService();
        }
    }

    private static void registerSyncBusiness() {
        service.registerBusiness(new SyncBiz.Builder(1L).addOnUpdateListener(SyncSettings.inst(application)).build());
        Iterator<Long> it = SyncConstants.SYNC_MOCK_BUSINESS_ID_LIST.iterator();
        while (it.hasNext()) {
            service.registerBusiness(new SyncBiz.Builder(it.next().longValue()).addOnUpdateListener(new OnDataUpdateListener() { // from class: com.bytedance.sync.SyncSDK.2
                @Override // com.bytedance.sync.interfaze.OnDataUpdateListener
                public void onDataUpdate(ISyncClient.Data data) {
                    if (data == null || data.data == null) {
                        return;
                    }
                    LogUtils.m188v("recv mock data:".concat(new String(data.data)));
                }
            }).build());
        }
    }
}
