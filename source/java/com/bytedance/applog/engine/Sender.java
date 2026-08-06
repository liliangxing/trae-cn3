package com.bytedance.applog.engine;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.batch.PackOptConfig;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.isolate.IDataIsolateCallback;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.manager.DeviceManager;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.exception.AppLogExceptionManager;
import com.bytedance.applog.monitor.exception.ExceptionScene;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.StageEventBasic;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.priority.EventPriority;
import com.bytedance.applog.priority.EventPriorityItem;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.Pack;
import com.bytedance.applog.throttle.BackoffController;
import com.bytedance.applog.throttle.CongestionController;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Sender extends BaseWorker {
    private static final long INTERVAL_PACK = 10000;
    private static final long INTERVAL_PLAY = 50000;
    private static final String TAG = "Sender";
    private static final List<String> logTags = Collections.singletonList(TAG);
    private long doWorkTimeout;
    private final ConcurrentHashMap<String, CongestionController> mCongestionControllerMap;
    private final EventPriorityItem mEventPriorityItem;
    private final String mName;
    private final long[] mRetryIntervals;
    private int sendSuccessCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sender(Engine engine) {
        super(engine);
        this.mRetryIntervals = new long[]{10000};
        this.mCongestionControllerMap = new ConcurrentHashMap<>();
        this.doWorkTimeout = 0L;
        this.sendSuccessCount = 0;
        this.mEventPriorityItem = null;
        this.mName = TAG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sender(Engine engine, EventPriorityItem eventPriorityItem) {
        super(engine);
        long[] jArr = {10000};
        this.mRetryIntervals = jArr;
        this.mCongestionControllerMap = new ConcurrentHashMap<>();
        this.doWorkTimeout = 0L;
        this.sendSuccessCount = 0;
        this.mEventPriorityItem = eventPriorityItem;
        this.mName = "Sender_p_" + eventPriorityItem.getPriority();
        long eventInterval = eventPriorityItem.getEventInterval();
        if (eventInterval < 10000) {
            jArr[0] = eventInterval;
        }
    }

    public void setWorkTimeout(long j) {
        this.doWorkTimeout = j;
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected boolean needNet() {
        return !this.mImmediately;
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected long nextInterval() {
        if (this.mEventPriorityItem != null) {
            EventPriority eventPriority = this.mEngine.getConfig().getEventPriority();
            if (eventPriority != null && eventPriority.isPreferBatchEventInterval()) {
                long eventInterval = this.mEngine.getConfig().getEventInterval();
                if (eventInterval <= this.mEventPriorityItem.getEventInterval()) {
                    return eventInterval;
                }
            }
            return this.mEventPriorityItem.getEventInterval();
        }
        return this.mEngine.getConfig().getEventInterval();
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected long[] getRetryIntervals() {
        return this.mRetryIntervals;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0105 A[Catch: all -> 0x0146, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0029, B:6:0x0030, B:8:0x0047, B:10:0x0051, B:17:0x0076, B:19:0x007c, B:20:0x008b, B:22:0x009d, B:24:0x00e1, B:26:0x00e5, B:29:0x00ec, B:30:0x00ff, B:32:0x0105, B:34:0x0109, B:42:0x0110, B:43:0x0114, B:44:0x00f2, B:49:0x00b4, B:50:0x012c, B:46:0x00af), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114 A[Catch: all -> 0x0146, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0029, B:6:0x0030, B:8:0x0047, B:10:0x0051, B:17:0x0076, B:19:0x007c, B:20:0x008b, B:22:0x009d, B:24:0x00e1, B:26:0x00e5, B:29:0x00ec, B:30:0x00ff, B:32:0x0105, B:34:0x0109, B:42:0x0110, B:43:0x0114, B:44:0x00f2, B:49:0x00b4, B:50:0x012c, B:46:0x00af), top: B:2:0x0001, inners: #0 }] */
    @Override // com.bytedance.applog.engine.BaseWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean doWork(int i) {
        Bundle playBundle;
        long currentTimeMillis = System.currentTimeMillis();
        Session session = this.mEngine.getSession();
        IAppLogLogger logger = getAppLog().getLogger();
        List<String> list = logTags;
        Object[] objArr = new Object[4];
        boolean z = false;
        objArr[0] = this.mName;
        objArr[1] = Long.valueOf(currentTimeMillis);
        objArr[2] = session != null ? session.getId() : ArgusConstants.NULL_PLACE_HOLDER;
        objArr[3] = Integer.valueOf(i);
        logger.debug(list, "{} start doWork curTs={}, curSid={}, requestFrom={}", objArr);
        if (getAppLog().isTouristMode() && !getAppLog().isEnableEventInTouristMode()) {
            AppLogExceptionManager.getInstance().dispatchTouristMode(ExceptionScene.DataUpload);
            getAppLog().getLogger().warn(list, "{} not send events in tourist mode", this.mName);
            return true;
        }
        if (session != null && (playBundle = session.getPlayBundle(currentTimeMillis, INTERVAL_PLAY)) != null) {
            getAppLog().onEventV3("play_session", playBundle);
            this.mEngine.process(null, false);
        }
        DbStore dbStore = this.mEngine.getDbStore();
        DeviceManager dm = this.mEngine.getDm();
        if (dm.isValidDidAndIid()) {
            JSONObject transferHeader = SensitiveUtils.transferHeader(dm.getCopiedHeader());
            IHeaderCustomTimelyCallback headerCustomCallback = getAppLog().getHeaderCustomCallback();
            if (headerCustomCallback != null) {
                try {
                    headerCustomCallback.updateHeader(transferHeader);
                } catch (Throwable th) {
                    getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                    getAppLog().getLogger().error(logTags, "header custom callback updateHeader error", th, new Object[0]);
                    this.mEngine.getAppLog().getMonitorHelper().sendError("Sender IHeaderCustomTimelyCallback updateHeader failed", th);
                }
            }
            EventPriorityItem eventPriorityItem = this.mEventPriorityItem;
            if (eventPriorityItem != null && !eventPriorityItem.isDefault()) {
                dbStore.packByPriority(transferHeader, this.mEventPriorityItem, i);
                if (isWorkingTimeout(currentTimeMillis)) {
                    if (!PackOptConfig.packMultiQueryEnabled) {
                        trySendPack(i, currentTimeMillis);
                    }
                    do {
                    } while (trySendPack(i, currentTimeMillis));
                } else {
                    getAppLog().getLogger().debug(logTags, "{} work is timeout, will not do send.", this.mName);
                }
                z = true;
            }
            dbStore.pack(transferHeader, this.mEventPriorityItem, i, getAppLog().isLaunchPackDesc());
            if (isWorkingTimeout(currentTimeMillis)) {
            }
            z = true;
        } else {
            this.mEngine.getAppLog().getMonitorHelper().sendError("Sender failed due to invalid did", null);
            AppLogExceptionManager.getInstance().dispatchInvalidDid(ExceptionScene.DataUpload);
        }
        return z;
    }

    private boolean trySendPack(int i, long j) {
        Engine.PackSendResult send;
        Map<String, String> generateIsolateHttpHeader;
        DbStore dbStore = this.mEngine.getDbStore();
        int maxPackOnceReport = getAppLog().getMaxPackOnceReport();
        if (i == 4) {
            maxPackOnceReport = 8;
        } else if (i == 12) {
            maxPackOnceReport = 16;
        }
        List<Pack> sortPackList = sortPackList(dbStore, maxPackOnceReport);
        boolean z = sortPackList.size() >= maxPackOnceReport;
        if (sortPackList.isEmpty()) {
            return z;
        }
        ConfigManager config = this.mEngine.getConfig();
        String[] sendLogUris = getAppLog().getApiParamsUtil().getSendLogUris(this.mEngine, false, this.mEventPriorityItem);
        if (getAppLog().isDataIsolateEnabled()) {
            IDataIsolateCallback dataIsolateCallback = getAppLog().getDataIsolateCallback();
            HashMap hashMap = new HashMap();
            if (dataIsolateCallback != null && (generateIsolateHttpHeader = dataIsolateCallback.generateIsolateHttpHeader()) != null) {
                hashMap.putAll(generateIsolateHttpHeader);
            }
            send = send(config, sendLogUris, sortPackList, i, hashMap, j);
        } else {
            send = send(config, sendLogUris, sortPackList, i, null, j);
        }
        return z && !send.abort;
    }

    private Engine.PackSendResult send(ConfigManager configManager, String[] strArr, List<Pack> list, int i, Map<String, String> map, long j) {
        Iterator<Pack> it;
        char c;
        boolean checkUriCanSend;
        int i2;
        int i3;
        String[] strArr2 = strArr;
        Map<String, String> map2 = map;
        Engine.PackSendResult packSendResult = new Engine.PackSendResult();
        Iterator<Pack> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Pack next = it2.next();
            IAppLogLogger logger = getAppLog().getLogger();
            List<String> list2 = logTags;
            boolean z = false;
            logger.debug(list2, "{} work start send pack...", this.mName);
            if (isWorkingTimeout(j)) {
                getAppLog().getLogger().debug(list2, "{} work is timeout, break send pack", this.mName);
                break;
            }
            HashMap hashMap = new HashMap();
            if (map2 != null && !map.isEmpty()) {
                hashMap.putAll(map2);
            }
            Map<String, String> commonHttpHeaders = this.mEngine.getUriConfig().getCommonHttpHeaders();
            if (commonHttpHeaders != null && !commonHttpHeaders.isEmpty()) {
                hashMap.putAll(commonHttpHeaders);
            }
            if (next.data == null || next.data.length == 0) {
                it = it2;
                packSendResult.mSended.add(next);
                getAppLog().getLogger().warn(list2, "{} send empty pack: {}", this.mName, next);
            } else {
                BackoffController backoffController = getBackoffController(configManager);
                if (backoffController != null && backoffController.backoffLogRequestAsRatio(i)) {
                    getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.BACKOFF_BLOCK_REQUEST_COUNT);
                    getAppLog().getLogger().warn(list2, "{} backoff request as ratio not allowed to send: {}", this.mName, next);
                } else if (getAppLog().getAdjustTerminate() && next.interceptExpiredTerminate(this.mEngine.getSession())) {
                    getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.ADJUST_TERMINATE_BLOCK_REQUEST_COUNT);
                    getAppLog().getLogger().warn(list2, "{} adjust terminate not allowed to send: {}", this.mName, next);
                } else {
                    getAppLog().getLogger().debug(list2, "{} send pack start: {}", this.mName, next);
                    if (getAppLog().getMonitorHelper().isStageEnabled()) {
                        Iterator<StageEventBasic> it3 = next.getEventStainedEvents().iterator();
                        while (it3.hasNext()) {
                            MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.POST_START, it3.next());
                        }
                    }
                    int length = strArr2.length;
                    int i4 = 0;
                    boolean z2 = false;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            it = it2;
                            c = 2;
                            break;
                        }
                        String str = strArr2[i5];
                        if (PackOptConfig.packByLengthEnabled) {
                            checkUriCanSend = checkUriCanSend(str, next);
                        } else {
                            checkUriCanSend = checkUriCanSend(str);
                        }
                        boolean z3 = checkUriCanSend;
                        if (!z3) {
                            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.CONGESTION_BLOCK_REQUEST_COUNT);
                            getAppLog().getLogger().warn(logTags, "{} CongestionController not allowed uri:{} to send pack: {}", this.mName, str, next);
                            it = it2;
                            i2 = length;
                            i3 = i5;
                        } else {
                            boolean z4 = z;
                            IAppLogLogger logger2 = getAppLog().getLogger();
                            List<String> list3 = logTags;
                            Object[] objArr = new Object[3];
                            objArr[z4 ? 1 : 0] = this.mName;
                            objArr[1] = next;
                            objArr[2] = str;
                            logger2.debug(list3, "{} send pack:{} to uri: {}", objArr);
                            String[] strArr3 = new String[1];
                            strArr3[z4 ? 1 : 0] = str;
                            it = it2;
                            i2 = length;
                            i3 = i5;
                            c = 2;
                            i4 = getAppLog().getApi().send(strArr3, next.data, this.mEngine, next.getPackKeyAndIv(), next.encodeType, next.encodeHeaders, hashMap, true);
                            if (Api.checkIfJamMsg(i4)) {
                                getOrCreateCongestionController(str).handleException();
                            } else if (i4 == 200) {
                                getOrCreateCongestionController(str).handleSuccess();
                                z2 = z3;
                                break;
                            }
                        }
                        i5 = i3 + 1;
                        strArr2 = strArr;
                        it2 = it;
                        z2 = z3;
                        length = i2;
                        z = false;
                    }
                    next.failHttpCode = i4;
                    IAppLogLogger logger3 = getAppLog().getLogger();
                    List<String> list4 = logTags;
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = this.mName;
                    objArr2[1] = next;
                    objArr2[c] = Integer.valueOf(i4);
                    logger3.debug(list4, "{} send pack end: {}, resp code: {}", objArr2);
                    if (Api.checkIfJamMsg(i4)) {
                        updateDbAfterSend(next, false);
                        monitorAfterPackSend(getAppLog(), next, false);
                        getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                        break;
                    }
                    if (i4 == 200) {
                        updateDbAfterSend(next, true);
                        monitorAfterPackSend(getAppLog(), next, true);
                        this.sendSuccessCount++;
                    } else {
                        updateDbAfterSend(next, false);
                        monitorAfterPackSend(getAppLog(), next, false);
                        EventPriorityItem eventPriorityItem = this.mEventPriorityItem;
                        if (eventPriorityItem != null) {
                            eventPriorityItem.checkPriorityUrisValid(i4);
                        }
                        getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                        if (!z2) {
                            packSendResult.abort = true;
                        }
                    }
                }
            }
            strArr2 = strArr;
            it2 = it;
            map2 = map;
        }
        return packSendResult;
    }

    private void updateDbAfterSend(Pack pack, boolean z) {
        DbStore dbStore = this.mEngine.getDbStore();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            arrayList.add(pack);
        } else {
            arrayList2.add(pack);
        }
        dbStore.setResult(arrayList, arrayList2);
    }

    protected static void monitorAfterPackSend(AppLogInstance appLogInstance, Pack pack, boolean z) {
        if (appLogInstance.getMonitorHelper().isStageEnabled()) {
            Iterator<StageEventBasic> it = pack.getEventStainedEvents().iterator();
            while (it.hasNext()) {
                MonitorUtils.stageEvent(appLogInstance.getMonitorHelper(), z ? EventStage.REPORT_END : EventStage.POST_FAILED, it.next());
            }
        }
        pack.recordPackReportedWithNewMonitor(appLogInstance.getMonitorHelper(), z);
        if (LogUtils.isDisabled()) {
            return;
        }
        sendPackUpload2Devtools(appLogInstance.getAppId(), pack.getEventLocalIds(), z);
    }

    private boolean checkUriCanSend(String str) {
        if (Utils.isEmpty(str)) {
            return false;
        }
        return getOrCreateCongestionController(str).isCanSend();
    }

    private boolean checkUriCanSend(String str, Pack pack) {
        if (Utils.isEmpty(str)) {
            return false;
        }
        return getOrCreateCongestionController(str).isCanSend(pack);
    }

    private String getHost(String str) {
        if (Utils.isEmpty(str)) {
            return str;
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable unused) {
            return str;
        }
    }

    private CongestionController getOrCreateCongestionController(String str) {
        String host = getHost(str);
        if (!this.mCongestionControllerMap.containsKey(host)) {
            this.mCongestionControllerMap.put(host, new CongestionController(this.mName + ":" + host, this.mEngine.getConfig(), this.mEventPriorityItem));
        }
        CongestionController congestionController = this.mCongestionControllerMap.get(host);
        getAppLog().getLogger().info(logTags, "{} congestion for host:{} is {}", this.mName, host, congestionController);
        return congestionController;
    }

    private List<Pack> sortPackList(DbStore dbStore, int i) {
        DataIsolateKey isolateKey;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<Pack> queryPack = dbStore.queryPack(i, this.mEventPriorityItem);
        IDataIsolateCallback dataIsolateCallback = getAppLog().getDataIsolateCallback();
        if (getAppLog().getDataIsolateKey() != null && dataIsolateCallback != null) {
            dataIsolateCallback.beforeIsolate();
        }
        Iterator<Pack> it = queryPack.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pack next = it.next();
            if (getAppLog().getDataIsolateKey() != null && dataIsolateCallback != null && (isolateKey = next.getIsolateKey()) != null && !dataIsolateCallback.allowIsolateDataReport(isolateKey, next.getIsolateKeyValue())) {
                getAppLog().getLogger().debug(logTags, "Pack:{} is not allowed send by isolate rule [{}, {}]", next, isolateKey, next.getIsolateKeyValue());
                getAppLog().getMonitorHelper().increaseStats("disable_report_by_isolate:" + isolateKey);
            } else if (next.hasLaunch()) {
                arrayList2.add(next);
            } else if (next.hasTerminate()) {
                arrayList3.add(next);
            } else {
                arrayList.add(next);
            }
        }
        if (getAppLog().getDataIsolateKey() != null && dataIsolateCallback != null) {
            dataIsolateCallback.afterIsolate();
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.addAll(arrayList3);
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll((this.sendSuccessCount > 0 || arrayList.isEmpty()) ? 0 : 1, arrayList2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.engine.BaseWorker
    public String getName() {
        return this.mName;
    }

    private boolean isWorkingTimeout(long j) {
        return this.doWorkTimeout > 0 && System.currentTimeMillis() - j >= this.doWorkTimeout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tryUpdateCongestionMaxRequestFrequency(EventPriorityItem eventPriorityItem, int i) {
        if (eventPriorityItem == null || eventPriorityItem != this.mEventPriorityItem) {
            return;
        }
        Iterator<CongestionController> it = this.mCongestionControllerMap.values().iterator();
        while (it.hasNext()) {
            it.next().updateMaxRequestFrequency(i);
        }
    }

    private BackoffController getBackoffController(ConfigManager configManager) {
        EventPriorityItem eventPriorityItem = this.mEventPriorityItem;
        if (eventPriorityItem != null) {
            return eventPriorityItem.getBackoffController();
        }
        return configManager.getDefaultBackoffController();
    }

    public static void sendPackUpload2Devtools(final String str, final Set<Long> set, final boolean z) {
        if (set == null || set.isEmpty() || LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new EventBus.DataFetcher() { // from class: com.bytedance.applog.engine.Sender.1
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("$$APP_ID", str);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((Long) it.next());
                    }
                    jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                    jSONObject.put("$$UPLOAD_STATUS", z ? "success" : "failed");
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
        });
    }
}
