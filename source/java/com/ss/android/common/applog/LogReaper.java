package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.sampling.EventSamplingLoader;
import com.bytedance.applog.util.JsonUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.service.middleware.applog.IHeaderCustomTimelyCallback;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.task.TaskSession;
import com.ss.android.common.util.AppLogDevToolsUtils;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.core.RegisterServiceController;
import com.ss.android.deviceregister.core.cache.internal.EncryptUtils;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.appdownloader.p004ah.DevicePlans;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LogReaper extends Thread {
    static final String CONTENT_TYPE = "application/octet-stream;tt-data=b";
    static final int NOT_ALLOW_SEND = -1;
    static final int SEND_ERROR = 0;
    static final int SEND_SUCCESS = 200;
    private static final String TAG = "AppLog";
    private AtomicLong mBatchEventInterval;
    private final ConcurrentHashMap<String, String> mBlockV1;
    private final ConcurrentHashMap<String, String> mBlockV3;
    private final Context mContext;
    private final SimpleDateFormat mDateFormat;
    private final DisasterRecovery mDisasterRecovery;
    private volatile long mExternalBatchEventInterval;
    private final JSONObject mHeader;
    private long mLastBatchEventTime;
    private volatile long mLatestForgroundSessionTime;
    private long mMinLog;
    private final LinkedList<LogQueueItem> mQueue;
    private volatile long mScanInterval;
    private long mScanTime;
    private int mSendLaunchTimely;
    private LogSession mSession;
    private final List<AppLog.ILogSessionHook> mSessionHookList;
    private final AtomicBoolean mStopFlag;
    private volatile JSONObject mTimeSync;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogReaper(Context context, JSONObject jSONObject, LinkedList<LogQueueItem> linkedList, AtomicBoolean atomicBoolean, List<AppLog.ILogSessionHook> list, LogSession logSession, ConcurrentHashMap concurrentHashMap, ConcurrentHashMap concurrentHashMap2) {
        super("LogReaper");
        this.mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        this.mMinLog = 0L;
        this.mScanTime = 0L;
        this.mLastBatchEventTime = 0L;
        this.mBatchEventInterval = new AtomicLong();
        this.mExternalBatchEventInterval = 60000L;
        this.mSendLaunchTimely = 1;
        this.mTimeSync = null;
        this.mScanInterval = 120000L;
        this.mContext = context;
        this.mHeader = jSONObject;
        this.mQueue = linkedList;
        this.mStopFlag = atomicBoolean;
        this.mSessionHookList = list;
        updateSession(logSession);
        this.mBlockV1 = concurrentHashMap;
        this.mBlockV3 = concurrentHashMap2;
        this.mDisasterRecovery = new DisasterRecovery(context);
        for (String str : AppLog.APPLOG_URL()) {
            this.mDisasterRecovery.registerUrl(str);
        }
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("set_header", new EventBus.DataFetcher() { // from class: com.ss.android.common.applog.LogReaper.1
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.mergeJsonObject(LogReaper.this.mHeader, jSONObject2);
                try {
                    jSONObject2.put("appId", String.valueOf(DeviceRegisterManager.getAppId()));
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBatchEventInterval(long j) {
        this.mExternalBatchEventInterval = j;
        this.mBatchEventInterval.set(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSendLaunchTimely(int i) {
        this.mSendLaunchTimely = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTimeSync(final JSONObject jSONObject) {
        this.mTimeSync = jSONObject;
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("server_time_sync", new EventBus.DataFetcher() { // from class: com.ss.android.common.applog.LogReaper.2
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.mergeJsonObject(jSONObject, jSONObject2);
                try {
                    jSONObject2.put("appId", String.valueOf(DeviceRegisterManager.getAppId()));
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateHeader(JSONObject jSONObject) {
        try {
            for (String str : ApplogHeaderUtils.HEADER_KEYS) {
                this.mHeader.put(str, jSONObject.opt(str));
            }
            if (!LogUtils.isDisabled()) {
                LogUtils.sendJsonFetcher("set_header", new EventBus.DataFetcher() { // from class: com.ss.android.common.applog.LogReaper.3
                    public Object fetch() {
                        JSONObject jSONObject2 = new JSONObject();
                        JsonUtils.mergeJsonObject(LogReaper.this.mHeader, jSONObject2);
                        try {
                            jSONObject2.put("appId", String.valueOf(DeviceRegisterManager.getAppId()));
                        } catch (Throwable unused) {
                        }
                        return jSONObject2;
                    }
                });
            }
        } catch (Exception e) {
            TLog.m76e("AppLog updateHeader exception: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void filterHeader() {
        RegistrationHeaderHelper.filterHeader(this.mHeader);
    }

    private synchronized void processItem(LogQueueItem logQueueItem) {
        TaskSession taskSession;
        if (logQueueItem == null) {
            return;
        }
        if (!AppLog.isTouristMode() || AppLog.isEnableEventInTouristMode()) {
            if (logQueueItem instanceof LogQueueSwitchSession) {
                LogQueueSwitchSession logQueueSwitchSession = (LogQueueSwitchSession) logQueueItem;
                if (logQueueSwitchSession.isFlush) {
                    switchSession(logQueueSwitchSession.old, null, true, logQueueSwitchSession.min_event, false, true);
                } else {
                    switchSession(logQueueSwitchSession.old, logQueueSwitchSession.launch_session, logQueueSwitchSession.event_only, logQueueSwitchSession.min_event);
                    updateSession(logQueueSwitchSession.launch_session);
                    this.mLastBatchEventTime = System.currentTimeMillis();
                }
            } else if (logQueueItem instanceof LogQueueCleanSession) {
                batchSession(((LogQueueCleanSession) logQueueItem).max_session);
            } else if ((logQueueItem instanceof LogQueueSaveAndSendTaskSession) && (taskSession = ((LogQueueSaveAndSendTaskSession) logQueueItem).taskSession) != null) {
                JSONObject jSONObject = new JSONObject();
                RegistrationHeaderHelper.copy(this.mHeader, jSONObject);
                Pair<Long, String> saveTaskSession = TaskSessionDao.inst(this.mContext).saveTaskSession(taskSession, jSONObject);
                if (saveTaskSession != null) {
                    long longValue = ((Long) saveTaskSession.first).longValue();
                    String str = (String) saveTaskSession.second;
                    if (longValue > 0) {
                        trySendLog(str, longValue);
                    }
                }
            }
        }
    }

    private void trySendLog(String str, long j) {
        JSONObject jSONObject;
        int sendBatchLog;
        DBHelper dBHelper = DBHelper.getInstance(this.mContext);
        if (NetworkUtils.isNetworkAvailable(this.mContext)) {
            boolean z = false;
            try {
                TLog.m73d("AppLog begin to send  logs");
                sendBatchLog = sendBatchLog(AppLog.APPLOG_URL(), str, true);
            } catch (Throwable th) {
                TLog.m76e("AppLog send session exception: ", th);
            }
            if (sendBatchLog == -1) {
                return;
            }
            if (sendBatchLog == 200) {
                z = true;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable unused) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                jSONObject = null;
            }
            monitorPackJsonReported(jSONObject, z);
            AppLogDevToolsUtils.sendReportedEvent(jSONObject, z);
            boolean onLogSent = dBHelper.onLogSent(j, z);
            if (z || !onLogSent) {
                return;
            }
            DBHelper.monitorPackJsonCleanUp(jSONObject);
            return;
        }
        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
    }

    private void batchSession(long j) {
        if (j <= 0) {
            return;
        }
        TLog.m73d("AppLog try to batch session  id < " + j);
        LogSession session = DBHelper.getInstance(this.mContext).getSession(j);
        if (session != null) {
            switchSession(session, null, false, 0L);
            LogQueueCleanSession logQueueCleanSession = new LogQueueCleanSession();
            logQueueCleanSession.max_session = session.f39id;
            synchronized (this.mQueue) {
                this.mQueue.add(logQueueCleanSession);
            }
        }
    }

    private void switchSession(LogSession logSession, LogSession logSession2, boolean z, long j) {
        switchSession(logSession, logSession2, z, j, true, false);
    }

    private void switchSession(LogSession logSession, LogSession logSession2, boolean z, long j, boolean z2, boolean z3) {
        boolean z4;
        JSONObject jSONObject;
        int sendBatchLog;
        if (!AppLog.isTouristMode() || AppLog.isEnableEventInTouristMode()) {
            long waitDid = AppLog.getWaitDid();
            if (waitDid != -1) {
                RegisterServiceController.tryWaitDeviceInit(this.mContext, waitDid);
                if (!existDid()) {
                    String deviceId = DeviceRegisterManager.getDeviceId();
                    if (!NetUtil.isBadId(deviceId)) {
                        synchronized (this) {
                            try {
                                this.mHeader.put("device_id", deviceId);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            DBHelper dBHelper = DBHelper.getInstance(this.mContext);
            if (logSession == null && logSession2 == null) {
                return;
            }
            if (logSession != null) {
                long[] jArr = new long[1];
                if (z) {
                    jArr[0] = j;
                } else {
                    jArr[0] = 0;
                }
                List<AppLog.ILogSessionHook> list = this.mSessionHookList;
                String[] strArr = new String[1];
                JSONObject jSONObject2 = new JSONObject();
                synchronized (this) {
                    RegistrationHeaderHelper.copy(this.mHeader, jSONObject2);
                }
                IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback = AppLog.getIHeaderCustomTimelyCallback();
                if (iHeaderCustomTimelyCallback != null) {
                    iHeaderCustomTimelyCallback.updateHeader(jSONObject2);
                }
                long batchSession = dBHelper.batchSession(logSession, logSession2, jSONObject2, z, jArr, strArr, list, z2, this.mTimeSync, z3);
                if (batchSession <= 0 || !dBHelper.existsLogByQuery(batchSession)) {
                    return;
                }
                String str = strArr[0];
                if (jArr[0] > j && (z2 || z3)) {
                    LogQueueSwitchSession logQueueSwitchSession = new LogQueueSwitchSession();
                    logQueueSwitchSession.old = logSession;
                    logQueueSwitchSession.launch_session = logSession2;
                    logQueueSwitchSession.event_only = true;
                    logQueueSwitchSession.min_event = jArr[0];
                    logQueueSwitchSession.isFlush = z3;
                    synchronized (this.mQueue) {
                        this.mQueue.add(logQueueSwitchSession);
                    }
                }
                if (AppLog.getAdjustTerminate()) {
                    LogItem logItem = new LogItem();
                    logItem.f37id = batchSession;
                    logItem.value = str;
                    logItem.type = 0;
                    boolean checkHistoryTerminate = checkHistoryTerminate(logItem);
                    String str2 = logItem.value;
                    if (!checkHistoryTerminate) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ADJUST_TERMINATE_BLOCK_REQUEST_COUNT);
                        return;
                    }
                    str = str2;
                }
                if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                    try {
                        TLog.m73d("begin to send batch logs: " + batchSession);
                        sendBatchLog = sendBatchLog(AppLog.APPLOG_URL(), str, true);
                    } catch (Throwable th) {
                        th = th;
                        z4 = false;
                    }
                    if (sendBatchLog == -1) {
                        return;
                    }
                    z4 = sendBatchLog == 200;
                    if (z4) {
                        try {
                            if (existDid()) {
                                if (logSession2 != null) {
                                    logSession2.launch_sent = true;
                                    dBHelper.setSessionLaunchSent(logSession2.f39id);
                                }
                                if (dBHelper.mSendTimelyLaunchSet.contains(Long.valueOf(logSession.f39id)) && !dBHelper.mSendTimelySuccessLaunchSet.contains(Long.valueOf(logSession.f39id))) {
                                    dBHelper.mSendTimelySuccessLaunchSet.add(Long.valueOf(logSession.f39id));
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            TLog.m76e("send session exception: ", th);
                            jSONObject = new JSONObject(str);
                            monitorPackJsonReported(jSONObject, z4);
                            AppLogDevToolsUtils.sendReportedEvent(jSONObject, z4);
                            boolean onLogSent = dBHelper.onLogSent(batchSession, z4);
                            if (!z4) {
                                LogTrace.notifyLogTrace(3, 0, new Object[]{getTeaEventIndexFromData(jSONObject)});
                                LogTrace.notifyLogTrace(4, 0, new Object[]{getTerminateSessionIdFromData(jSONObject)});
                                DBHelper.monitorPackJsonCleanUp(jSONObject);
                            }
                            if (z4) {
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (Throwable unused2) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                        jSONObject = null;
                    }
                    monitorPackJsonReported(jSONObject, z4);
                    AppLogDevToolsUtils.sendReportedEvent(jSONObject, z4);
                    boolean onLogSent2 = dBHelper.onLogSent(batchSession, z4);
                    if (!z4 && onLogSent2) {
                        LogTrace.notifyLogTrace(3, 0, new Object[]{getTeaEventIndexFromData(jSONObject)});
                        LogTrace.notifyLogTrace(4, 0, new Object[]{getTerminateSessionIdFromData(jSONObject)});
                        DBHelper.monitorPackJsonCleanUp(jSONObject);
                    }
                    if (z4 || this.mMinLog >= 0) {
                        return;
                    }
                    this.mMinLog = batchSession;
                    return;
                }
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                return;
            }
            if (logSession2 != null && NetworkUtils.isNetworkAvailable(this.mContext) && this.mSendLaunchTimely > 0 && !logSession2.non_page) {
                try {
                    if (existDid()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("magic_tag", "ss_app_log");
                        JSONObject jSONObject4 = new JSONObject();
                        synchronized (this) {
                            RegistrationHeaderHelper.copy(this.mHeader, jSONObject4);
                        }
                        ApplogHeaderUtils.updateAppLogHeader(this.mContext, jSONObject4);
                        IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback2 = AppLog.getIHeaderCustomTimelyCallback();
                        if (iHeaderCustomTimelyCallback2 != null) {
                            iHeaderCustomTimelyCallback2.updateHeader(jSONObject4);
                        }
                        jSONObject3.put("header", jSONObject4);
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(AppLog.KEY_DATETIME, AppLog.formatDate(logSession2.timestamp));
                        jSONObject5.put(AppLog.KEY_SESSION_ID, logSession2.value);
                        jSONObject5.put(AppLog.KEY_LOCAL_TIME_MS, logSession2.timestamp);
                        jSONObject5.put(AppLog.KEY_EVENT_INDEX, logSession2.eventIndex);
                        jSONObject5.put(AppLog.KEY_EVENT_ID, AppLog.sGlobalEventId.incrementAndGet());
                        if (logSession2.non_page) {
                            jSONObject5.put("is_background", true);
                        } else {
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.COLLECT_FRONT_LAUNCH_COUNT);
                        }
                        String abSDKVersion = AppLog.getAbSDKVersion();
                        TLog.m77i("send first launch, uid: " + AppLog.getUserId() + ", abSdkVersion: " + abSDKVersion);
                        if (!TextUtils.isEmpty(abSDKVersion)) {
                            jSONObject5.put(AppLog.KEY_AB_SDK_VERSION, abSDKVersion);
                        }
                        jSONArray.put(jSONObject5);
                        AppLogDevToolsUtils.sendReceiveLaunch(jSONObject5);
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.COLLECT_LAUNCH_COUNT);
                        jSONObject3.put("launch", jSONArray);
                        AppLog.fillKeyIvForEncryptResp(jSONObject3, true);
                        if (200 == sendBatchLog(AppLog.APPLOG_URL(), jSONObject3.toString(), true)) {
                            logSession2.launch_sent = true;
                            dBHelper.setSessionLaunchSent(logSession2.f39id);
                            dBHelper.mSendTimelySuccessLaunchSet.add(Long.valueOf(logSession2.f39id));
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_SUCCESS_LAUNCH_COUNT);
                            AppLogDevToolsUtils.sendReportedEvent(jSONObject3, true);
                        } else {
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_FAILED_LAUNCH_COUNT);
                            AppLogDevToolsUtils.sendReportedEvent(jSONObject3, false);
                        }
                        dBHelper.mSendTimelyLaunchSet.add(Long.valueOf(logSession2.f39id));
                        if (EventVerify.inst().isEnable()) {
                            EventVerify.inst().putEvent("launch", jSONArray);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                    TLog.m76e("AppLog send launch exception: ", th3);
                    return;
                }
            }
            if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                return;
            }
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
        }
    }

    private boolean existDid() {
        try {
            return !StringUtils.isEmpty(this.mHeader.optString("device_id", ""));
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0524 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0434 A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03d6 A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x014a A[Catch: all -> 0x0125, TryCatch #4 {all -> 0x0125, blocks: (B:233:0x0079, B:235:0x007f, B:236:0x008b, B:238:0x0091, B:246:0x00af, B:248:0x00b9, B:250:0x00c5, B:252:0x00cb, B:253:0x00d0, B:254:0x00d6, B:257:0x0115, B:258:0x00e2, B:260:0x00ec, B:261:0x00ef, B:262:0x010e, B:265:0x011e, B:169:0x0132, B:171:0x0138, B:173:0x013e, B:174:0x0144, B:176:0x014a, B:184:0x0164, B:186:0x016e, B:188:0x017a, B:190:0x0180, B:191:0x0185, B:192:0x018b, B:194:0x01d2, B:195:0x0199, B:197:0x01a3, B:198:0x01a6, B:200:0x01c9, B:203:0x01dc, B:206:0x01e5, B:208:0x01eb, B:209:0x01f3, B:211:0x01f9), top: B:232:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01e5 A[Catch: all -> 0x0125, TryCatch #4 {all -> 0x0125, blocks: (B:233:0x0079, B:235:0x007f, B:236:0x008b, B:238:0x0091, B:246:0x00af, B:248:0x00b9, B:250:0x00c5, B:252:0x00cb, B:253:0x00d0, B:254:0x00d6, B:257:0x0115, B:258:0x00e2, B:260:0x00ec, B:261:0x00ef, B:262:0x010e, B:265:0x011e, B:169:0x0132, B:171:0x0138, B:173:0x013e, B:174:0x0144, B:176:0x014a, B:184:0x0164, B:186:0x016e, B:188:0x017a, B:190:0x0180, B:191:0x0185, B:192:0x018b, B:194:0x01d2, B:195:0x0199, B:197:0x01a3, B:198:0x01a6, B:200:0x01c9, B:203:0x01dc, B:206:0x01e5, B:208:0x01eb, B:209:0x01f3, B:211:0x01f9), top: B:232:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0249 A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x027f A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0357 A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0365 A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x039f A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03fb A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x042e A[Catch: all -> 0x0545, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x044b A[Catch: all -> 0x0545, TRY_LEAVE, TryCatch #3 {all -> 0x0545, blocks: (B:220:0x0209, B:223:0x021a, B:224:0x0225, B:20:0x0243, B:22:0x0249, B:24:0x026a, B:26:0x0274, B:27:0x0278, B:29:0x027f, B:30:0x0295, B:33:0x02bd, B:35:0x02c1, B:45:0x02fc, B:49:0x0357, B:52:0x035f, B:54:0x0365, B:55:0x037b, B:57:0x038a, B:62:0x039f, B:64:0x03a5, B:67:0x03ac, B:69:0x03b6, B:71:0x03f5, B:73:0x03fb, B:74:0x041f, B:76:0x042e, B:77:0x0447, B:79:0x044b, B:124:0x050f, B:126:0x0515, B:135:0x050a, B:136:0x0434, B:138:0x0440, B:139:0x03cc, B:140:0x03d6, B:152:0x0316, B:157:0x02ec, B:161:0x033d, B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:219:0x0209, inners: #0, #2, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0454 A[Catch: all -> 0x0509, TryCatch #7 {all -> 0x0509, blocks: (B:81:0x044e, B:83:0x0454, B:85:0x045c, B:88:0x0485, B:90:0x048b, B:92:0x0492, B:94:0x049c, B:96:0x04a1, B:99:0x04a4, B:101:0x04b1, B:103:0x04b7, B:105:0x04be, B:107:0x04c8, B:109:0x04cd, B:112:0x04d0, B:114:0x04dd, B:115:0x04e2, B:117:0x04ea, B:118:0x04ef, B:120:0x04f5, B:122:0x04fe), top: B:80:0x044e, outer: #3 }] */
    /* JADX WARN: Type inference failed for: r0v93, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v37, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.ss.android.common.applog.DisasterRecovery] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int sendLog(int i, String[] strArr, String str, boolean z) throws Throwable {
        ?? r5;
        LogReaper logReaper;
        int i2;
        ?? r3;
        String str2;
        String str3;
        String str4;
        long j;
        String str5;
        String str6;
        JSONArray jSONArray;
        JSONArray optJSONArray;
        String str7;
        int i3;
        String str8;
        JSONArray jSONArray2;
        String str9;
        SendLogCallback sendLogCallback;
        ?? r1;
        boolean z2;
        byte[] bytes;
        Map<String, String> logHttpHeader;
        String doPost;
        JSONObject jSONObject;
        long optLong;
        DisasterRecovery disasterRecovery;
        DisasterRecovery disasterRecovery2;
        JSONObject optJSONObject;
        String[] strArr2;
        DisasterRecovery disasterRecovery3;
        String str10 = "time_sync";
        String str11 = "header";
        String str12 = strArr[i];
        try {
            if (AppLog.getLogRecoverySwitch() && (disasterRecovery3 = this.mDisasterRecovery) != null && !disasterRecovery3.isCanSend(str12)) {
                if (AppLog.sCustomInfo != null) {
                    AppLog.sCustomInfo.monitorEvent("service_monitor", "applog_send_tuibi", 0, null, null);
                }
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CONGESTION_BLOCK_REQUEST_COUNT);
                return -1;
            }
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_COUNT);
            HashMap hashMap = new HashMap();
            try {
                if (AppLog.sUserIdIsolateEnabled) {
                    try {
                        if (AppLog.sUserIdIsolateCallback != null) {
                            JSONObject jSONObject2 = new JSONObject(str);
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("header");
                            JSONObject optJSONObject3 = jSONObject2.optJSONObject("time_sync");
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("event");
                            str2 = "blocklist";
                            if (optJSONArray2 != null) {
                                try {
                                    if (optJSONArray2.length() > 0) {
                                        str3 = "server_time";
                                        JSONArray jSONArray3 = new JSONArray();
                                        str4 = str12;
                                        int i4 = 0;
                                        j = 0;
                                        while (i4 < optJSONArray2.length()) {
                                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i4);
                                            JSONArray jSONArray4 = optJSONArray2;
                                            JSONArray jSONArray5 = jSONArray3;
                                            long optLong2 = jSONObject3.optLong("user_id", 0L);
                                            if (optLong2 > 0 && j <= 0) {
                                                j = optLong2;
                                            }
                                            if (optLong2 > 0 && optLong2 != j) {
                                                if (hashMap.containsKey(Long.valueOf(optLong2))) {
                                                    JSONObject jSONObject4 = (JSONObject) hashMap.get(Long.valueOf(optLong2));
                                                    if (jSONObject4 != null) {
                                                        JSONArray optJSONArray3 = jSONObject4.optJSONArray("event");
                                                        if (optJSONArray3 == null) {
                                                            optJSONArray3 = new JSONArray();
                                                        }
                                                        optJSONArray3.put(jSONObject3);
                                                        jSONObject4.put("event", optJSONArray3);
                                                    }
                                                    hashMap.put(Long.valueOf(optLong2), jSONObject4);
                                                    str6 = str11;
                                                } else {
                                                    JSONObject jSONObject5 = new JSONObject();
                                                    jSONObject5.put("magic_tag", "ss_app_log");
                                                    if (optJSONObject3 != null) {
                                                        jSONObject5.put("time_sync", optJSONObject3);
                                                    }
                                                    jSONObject5.put(str11, optJSONObject2);
                                                    str6 = str11;
                                                    jSONObject5.put("_gen_time", System.currentTimeMillis());
                                                    JSONArray jSONArray6 = new JSONArray();
                                                    jSONArray6.put(jSONObject3);
                                                    jSONObject5.put("event", jSONArray6);
                                                    hashMap.put(Long.valueOf(optLong2), jSONObject5);
                                                }
                                                jSONArray = jSONArray5;
                                            } else {
                                                str6 = str11;
                                                jSONArray = jSONArray5;
                                                jSONArray.put(jSONObject3);
                                            }
                                            i4++;
                                            jSONArray3 = jSONArray;
                                            optJSONArray2 = jSONArray4;
                                            str11 = str6;
                                        }
                                        str5 = str11;
                                        jSONObject2.put("event", jSONArray3);
                                        optJSONArray = jSONObject2.optJSONArray("event_v3");
                                        if (optJSONArray != null && optJSONArray.length() > 0) {
                                            JSONArray jSONArray7 = new JSONArray();
                                            i3 = 0;
                                            while (i3 < optJSONArray.length()) {
                                                JSONObject jSONObject6 = optJSONArray.getJSONObject(i3);
                                                long optLong3 = jSONObject6.optLong("user_id", 0L);
                                                if (optLong3 > 0 && j <= 0) {
                                                    j = optLong3;
                                                }
                                                if (optLong3 > 0 && optLong3 != j) {
                                                    if (hashMap.containsKey(Long.valueOf(optLong3))) {
                                                        JSONObject jSONObject7 = (JSONObject) hashMap.get(Long.valueOf(optLong3));
                                                        if (jSONObject7 != null) {
                                                            JSONArray optJSONArray4 = jSONObject7.optJSONArray("event_v3");
                                                            if (optJSONArray4 == null) {
                                                                optJSONArray4 = new JSONArray();
                                                            }
                                                            optJSONArray4.put(jSONObject6);
                                                            jSONObject7.put("event_v3", optJSONArray4);
                                                        }
                                                        hashMap.put(Long.valueOf(optLong3), jSONObject7);
                                                        str8 = str10;
                                                        jSONArray2 = optJSONArray;
                                                        str9 = str5;
                                                    } else {
                                                        JSONObject jSONObject8 = new JSONObject();
                                                        jSONObject8.put("magic_tag", "ss_app_log");
                                                        if (optJSONObject3 != null) {
                                                            jSONObject8.put(str10, optJSONObject3);
                                                        }
                                                        str9 = str5;
                                                        jSONObject8.put(str9, optJSONObject2);
                                                        str8 = str10;
                                                        jSONArray2 = optJSONArray;
                                                        jSONObject8.put("_gen_time", System.currentTimeMillis());
                                                        JSONArray jSONArray8 = new JSONArray();
                                                        jSONArray8.put(jSONObject6);
                                                        jSONObject8.put("event_v3", jSONArray8);
                                                        hashMap.put(Long.valueOf(optLong3), jSONObject8);
                                                    }
                                                } else {
                                                    str8 = str10;
                                                    jSONArray2 = optJSONArray;
                                                    str9 = str5;
                                                    jSONArray7.put(jSONObject6);
                                                }
                                                i3++;
                                                str5 = str9;
                                                str10 = str8;
                                                optJSONArray = jSONArray2;
                                            }
                                            jSONObject2.put("event_v3", jSONArray7);
                                        }
                                        if (j <= 0) {
                                            if (hashMap.isEmpty()) {
                                                logReaper = this;
                                                str7 = str;
                                            } else {
                                                Iterator it = hashMap.keySet().iterator();
                                                while (it.hasNext()) {
                                                    JSONObject jSONObject9 = (JSONObject) hashMap.get((Long) it.next());
                                                    if (jSONObject9 != null) {
                                                        logReaper = this;
                                                        try {
                                                            DBHelper.getInstance(logReaper.mContext).insertLog(jSONObject9.toString());
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            i2 = i;
                                                            r5 = strArr;
                                                            TLog.m76e("Send log failed", th);
                                                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                                                            if (AppLog.getLogRecoverySwitch()) {
                                                                r3.handleException(i2, r5, th);
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                }
                                                logReaper = this;
                                                str7 = jSONObject2.toString();
                                            }
                                            if (!AppLog.sUserIdIsolateCallback.allowIsolateDataReport(String.valueOf(j))) {
                                                return -1;
                                            }
                                            sendLogCallback = AppLog.sSendLogCallback;
                                            if (sendLogCallback != null) {
                                                JSONObject jSONObject10 = new JSONObject(str7);
                                                boolean onBeforeSendLog = sendLogCallback.onBeforeSendLog(jSONObject10);
                                                TLog.m73d("AppLog sendLogCallback.onBeforeSendLog allowToSend: " + onBeforeSendLog);
                                                if (!onBeforeSendLog) {
                                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CONGESTION_BLOCK_REQUEST_COUNT);
                                                    return 200;
                                                }
                                                str7 = jSONObject10.toString();
                                            }
                                            r1 = str7;
                                            if (Logger.debug()) {
                                                TLog.m73d("AppLog app_log: " + r1);
                                            }
                                            z2 = true;
                                            r5 = NetUtilWrapper.filterQuery(NetUtil.addCommonParams(str4, true), NetUtilWrapper.KEYS_REPORT_QUERY);
                                            bytes = r1.getBytes(HTTP.UTF_8);
                                            byte[] bArr = (byte[]) bytes.clone();
                                            logHttpHeader = AppLog.getLogHttpHeader();
                                            if (StringUtils.isEmpty((String) r5) && z && logReaper.mContext != null && AppLog.getLogEncryptSwitch()) {
                                                try {
                                                    JSONObject jSONObject11 = new JSONObject((String) r1);
                                                    strArr2 = new String[]{jSONObject11.optString(AppLog.KEY_ENCRYPT_RESP_KEY), jSONObject11.optString(AppLog.KEY_ENCRYPT_RESP_IV)};
                                                    try {
                                                        if (!EncryptUtils.isValidKeyIv(strArr2)) {
                                                            strArr2 = null;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        TLog.m76e("key iv failed", th);
                                                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                                                        doPost = NetUtil.sendEncryptLog(AppLog.getLogCompressor(), r5, bArr, logReaper.mContext, false, strArr2, logHttpHeader, r1, false, true);
                                                        i2 = r1;
                                                        if (doPost != null) {
                                                        }
                                                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                                                        TLog.m75e("app_log response empty");
                                                        return 0;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    strArr2 = null;
                                                }
                                                try {
                                                    doPost = NetUtil.sendEncryptLog(AppLog.getLogCompressor(), r5, bArr, logReaper.mContext, false, strArr2, logHttpHeader, r1, false, true);
                                                    i2 = r1;
                                                } catch (RuntimeException e) {
                                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                                    TLog.m76e("Send encrypt log failed", e);
                                                    doPost = NetUtil.doPost(AppLog.getLogCompressor(), r5, bytes, true, CONTENT_TYPE, false, logHttpHeader, false, true);
                                                    i2 = "Send encrypt log failed";
                                                }
                                            } else {
                                                doPost = NetUtil.doPost(AppLog.getLogCompressor(), r5, bytes, true, CONTENT_TYPE, false, logHttpHeader, false, true);
                                                i2 = r1;
                                            }
                                            if (doPost != null && doPost.length() != 0) {
                                                if (Logger.debug()) {
                                                    TLog.m73d("app_log response: " + doPost);
                                                }
                                                jSONObject = new JSONObject(doPost);
                                                if ("ss_app_log".equals(jSONObject.optString("magic_tag")) || !"success".equals(jSONObject.optString("message"))) {
                                                    z2 = false;
                                                }
                                                if (!z2) {
                                                    if (Logger.debug()) {
                                                        TLog.m73d("app_log upload success");
                                                    }
                                                    String str13 = str3;
                                                    try {
                                                        long optLong4 = jSONObject.optLong(str13);
                                                        if (optLong4 > 0) {
                                                            JSONObject jSONObject12 = new JSONObject();
                                                            jSONObject12.put(str13, optLong4);
                                                            jSONObject12.put("local_time", System.currentTimeMillis() / 1000);
                                                            logReaper.setTimeSync(jSONObject12);
                                                        }
                                                    } catch (Exception unused) {
                                                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                                                    }
                                                } else {
                                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                                                    TLog.m75e("app_log response is failed: " + doPost);
                                                }
                                                if (AppLog.getEnableEventUserId()) {
                                                    AppLog.sUidFromResp = jSONObject.optLong(AppLog.KEY_UID);
                                                    AppLog.sUserTypeFromResp = jSONObject.optInt(AppLog.KEY_USER_TYPE);
                                                    AppLog.sUserIsLoginFromResp = jSONObject.optInt(AppLog.KEY_USER_IS_LOGIN);
                                                    AppLog.sUserIsAuthFromResp = jSONObject.optInt(AppLog.KEY_USER_IS_AUTH);
                                                }
                                                optLong = jSONObject.optLong("batch_event_interval", 0L) * 1000;
                                                if (!AppLog.checkValidInterval(optLong)) {
                                                    logReaper.mBatchEventInterval.set(optLong);
                                                } else if (logReaper.mExternalBatchEventInterval != logReaper.mBatchEventInterval.get()) {
                                                    logReaper.mBatchEventInterval.set(logReaper.mExternalBatchEventInterval);
                                                }
                                                disasterRecovery = logReaper.mDisasterRecovery;
                                                if (disasterRecovery != null) {
                                                    disasterRecovery.updateRatioDowngradeParams(jSONObject);
                                                }
                                                try {
                                                    if (AppLog.getLogRecoverySwitch()) {
                                                        String str14 = str2;
                                                        if (jSONObject.optJSONObject(str14) != null) {
                                                            TLog.m73d("AppLog block list keys: " + jSONObject.optJSONObject(str14));
                                                            JSONArray optJSONArray5 = jSONObject.optJSONObject(str14).optJSONArray(DevicePlans.DEVICE_PLAN_VIVO1);
                                                            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                                                                int length = optJSONArray5.length();
                                                                for (int i5 = 0; i5 < length; i5++) {
                                                                    String string = optJSONArray5.getString(i5);
                                                                    if (!StringUtils.isEmpty(string)) {
                                                                        logReaper.mBlockV1.put(string, "block");
                                                                    }
                                                                }
                                                            }
                                                            JSONArray optJSONArray6 = jSONObject.optJSONObject(str14).optJSONArray(DevicePlans.DEVICE_PLAN_VIVO3);
                                                            if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                                                                int length2 = optJSONArray6.length();
                                                                for (int i6 = 0; i6 < length2; i6++) {
                                                                    String string2 = optJSONArray6.getString(i6);
                                                                    if (!StringUtils.isEmpty(string2)) {
                                                                        logReaper.mBlockV3.put(string2, "block");
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            TLog.m73d("AppLog block list is empty");
                                                            if (!logReaper.mBlockV1.isEmpty()) {
                                                                logReaper.mBlockV1.clear();
                                                            }
                                                            if (!logReaper.mBlockV3.isEmpty()) {
                                                                logReaper.mBlockV3.clear();
                                                            }
                                                        }
                                                    }
                                                    if (AppLog.getEventSamplingValue() > 0 && (optJSONObject = jSONObject.optJSONObject("sampling_list")) != null) {
                                                        AppLog.sEventSampling = EventSamplingLoader.parseEventSamplingFromJson(logReaper.mContext, (String) null, optJSONObject, AppLog.sEventSampling);
                                                    }
                                                } catch (Throwable th4) {
                                                    TLog.m76e("Parse log res failed", th4);
                                                }
                                                if (AppLog.getLogRecoverySwitch() && (disasterRecovery2 = logReaper.mDisasterRecovery) != null) {
                                                    disasterRecovery2.handleSuccess(i, strArr);
                                                }
                                                return !z2 ? 200 : 0;
                                            }
                                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                                            TLog.m75e("app_log response empty");
                                            return 0;
                                        }
                                        logReaper = this;
                                        str7 = str;
                                        sendLogCallback = AppLog.sSendLogCallback;
                                        if (sendLogCallback != null) {
                                        }
                                        r1 = str7;
                                        if (Logger.debug()) {
                                        }
                                        z2 = true;
                                        r5 = NetUtilWrapper.filterQuery(NetUtil.addCommonParams(str4, true), NetUtilWrapper.KEYS_REPORT_QUERY);
                                        bytes = r1.getBytes(HTTP.UTF_8);
                                        byte[] bArr2 = (byte[]) bytes.clone();
                                        logHttpHeader = AppLog.getLogHttpHeader();
                                        if (StringUtils.isEmpty((String) r5)) {
                                        }
                                        doPost = NetUtil.doPost(AppLog.getLogCompressor(), r5, bytes, true, CONTENT_TYPE, false, logHttpHeader, false, true);
                                        i2 = r1;
                                        if (doPost != null) {
                                            if (Logger.debug()) {
                                            }
                                            jSONObject = new JSONObject(doPost);
                                            if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                                            }
                                            z2 = false;
                                            if (!z2) {
                                            }
                                            if (AppLog.getEnableEventUserId()) {
                                            }
                                            optLong = jSONObject.optLong("batch_event_interval", 0L) * 1000;
                                            if (!AppLog.checkValidInterval(optLong)) {
                                            }
                                            disasterRecovery = logReaper.mDisasterRecovery;
                                            if (disasterRecovery != null) {
                                            }
                                            if (AppLog.getLogRecoverySwitch()) {
                                            }
                                            if (AppLog.getEventSamplingValue() > 0) {
                                                AppLog.sEventSampling = EventSamplingLoader.parseEventSamplingFromJson(logReaper.mContext, (String) null, optJSONObject, AppLog.sEventSampling);
                                            }
                                            if (AppLog.getLogRecoverySwitch()) {
                                                disasterRecovery2.handleSuccess(i, strArr);
                                            }
                                            if (!z2) {
                                            }
                                        }
                                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                                        TLog.m75e("app_log response empty");
                                        return 0;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    logReaper = this;
                                    i2 = i;
                                    r5 = strArr;
                                    TLog.m76e("Send log failed", th);
                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                                    if (AppLog.getLogRecoverySwitch()) {
                                    }
                                    throw th;
                                }
                            }
                            str3 = "server_time";
                            str5 = "header";
                            str4 = str12;
                            j = 0;
                            optJSONArray = jSONObject2.optJSONArray("event_v3");
                            if (optJSONArray != null) {
                                JSONArray jSONArray72 = new JSONArray();
                                i3 = 0;
                                while (i3 < optJSONArray.length()) {
                                }
                                jSONObject2.put("event_v3", jSONArray72);
                            }
                            if (j <= 0) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        logReaper = this;
                    }
                }
                if (doPost != null) {
                }
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                TLog.m75e("app_log response empty");
                return 0;
            } catch (Throwable th7) {
                th = th7;
                TLog.m76e("Send log failed", th);
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                if (AppLog.getLogRecoverySwitch() && (r3 = logReaper.mDisasterRecovery) != 0) {
                    r3.handleException(i2, r5, th);
                }
                throw th;
            }
            logReaper = this;
            str3 = "server_time";
            str2 = "blocklist";
            str4 = str12;
            str7 = str;
            sendLogCallback = AppLog.sSendLogCallback;
            if (sendLogCallback != null) {
            }
            r1 = str7;
            if (Logger.debug()) {
            }
            z2 = true;
            r5 = NetUtilWrapper.filterQuery(NetUtil.addCommonParams(str4, true), NetUtilWrapper.KEYS_REPORT_QUERY);
            bytes = r1.getBytes(HTTP.UTF_8);
            byte[] bArr22 = (byte[]) bytes.clone();
            logHttpHeader = AppLog.getLogHttpHeader();
            if (StringUtils.isEmpty((String) r5)) {
            }
            doPost = NetUtil.doPost(AppLog.getLogCompressor(), r5, bytes, true, CONTENT_TYPE, false, logHttpHeader, false, true);
            i2 = r1;
        } catch (Throwable th8) {
            th = th8;
            r5 = strArr;
            logReaper = this;
            i2 = i;
        }
    }

    static List<Long> getTeaEventIndexFromData(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("event_v3");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(Long.valueOf(optJSONArray.getJSONObject(i).optLong(AppLog.KEY_EVENT_INDEX, 0L)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("event");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        arrayList.add(Long.valueOf(optJSONArray2.getJSONObject(i2).optLong(AppLog.KEY_EVENT_INDEX, 0L)));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> getTerminateSessionIdFromData(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("terminate");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.getJSONObject(i).optString(AppLog.KEY_SESSION_ID, "");
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    private void cleanLog() {
        DBHelper.getInstance(this.mContext).cleanExpireLog();
    }

    private boolean scanLog() {
        int i;
        boolean z;
        JSONObject jSONObject;
        if ((AppLog.isTouristMode() && !AppLog.isEnableEventInTouristMode()) || !NetworkUtils.isNetworkAvailable(this.mContext)) {
            return false;
        }
        if (this.mMinLog < 0 && System.currentTimeMillis() - this.mScanTime > this.mScanInterval) {
            this.mMinLog = 0L;
            cleanLog();
            this.mScanTime = System.currentTimeMillis();
        }
        if (this.mMinLog < 0) {
            return false;
        }
        DBHelper dBHelper = DBHelper.getInstance(this.mContext);
        LogItem log = dBHelper.getLog(this.mMinLog);
        if (log == null) {
            this.mMinLog = -1L;
            return false;
        }
        if (this.mMinLog < log.f37id) {
            this.mMinLog = log.f37id;
        } else {
            this.mMinLog++;
        }
        if (log.value != null && log.value.length() != 0) {
            if (AppLog.getAdjustTerminate() && !checkHistoryTerminate(log)) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ADJUST_TERMINATE_BLOCK_REQUEST_COUNT);
                return true;
            }
            if (AppLog.getWaitDid() != -1) {
                try {
                    JSONObject jSONObject2 = new JSONObject(log.value);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("header");
                    String optString = this.mHeader.optString("device_id");
                    if (optJSONObject == null) {
                        if (NetUtil.isBadId(optString)) {
                            return false;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        synchronized (this) {
                            RegistrationHeaderHelper.copy(this.mHeader, jSONObject3);
                        }
                        jSONObject2.put("header", jSONObject3);
                        log.value = jSONObject2.toString();
                    } else if (NetUtil.isBadId(optJSONObject.optString("device_id"))) {
                        if (NetUtil.isBadId(optString)) {
                            return false;
                        }
                        optJSONObject.put("device_id", optString);
                        jSONObject2.put("header", optJSONObject);
                        log.value = jSONObject2.toString();
                    }
                } catch (Throwable unused) {
                }
            }
            try {
                i = log.type == 0 ? sendBatchLog(AppLog.APPLOG_URL(), log.value, true) : 200;
                z = i == 200;
            } catch (Throwable th) {
                TLog.m76e("AppLog send session exception: ", th);
                i = 0;
                z = false;
            }
            if (i == -1) {
                return true;
            }
            try {
                jSONObject = new JSONObject(log.value);
            } catch (Throwable unused2) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                jSONObject = null;
            }
            monitorPackJsonReported(jSONObject, z);
            AppLogDevToolsUtils.sendReportedEvent(jSONObject, z);
            boolean onLogSent = dBHelper.onLogSent(log.f37id, z);
            if (!z && onLogSent && log.type == 0) {
                LogTrace.notifyLogTrace(3, 0, new Object[]{getTeaEventIndexFromData(jSONObject)});
                LogTrace.notifyLogTrace(4, 0, new Object[]{getTerminateSessionIdFromData(jSONObject)});
                DBHelper.monitorPackJsonCleanUp(jSONObject);
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00d7 A[EDGE_INSN: B:94:0x00d7->B:55:0x00d7 BREAK  A[LOOP:1: B:3:0x001a->B:93:0x001a], SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        LogQueueItem logQueueItem;
        long j;
        LogQueueItem poll;
        long j2;
        TLog.m73d("AppLog LogReaper start");
        cleanLog();
        this.mScanTime = System.currentTimeMillis();
        this.mLastBatchEventTime = System.currentTimeMillis();
        LogQueueItem logQueueItem2 = null;
        loop0: while (true) {
            int i = 0;
            while (true) {
                if (logQueueItem2 == null) {
                    synchronized (this.mQueue) {
                        if (this.mStopFlag.get()) {
                            break loop0;
                        } else if (!this.mQueue.isEmpty()) {
                            logQueueItem2 = this.mQueue.poll();
                        }
                    }
                }
                logQueueItem = logQueueItem2;
                if (logQueueItem != null) {
                    processItem(logQueueItem);
                    logQueueItem2 = null;
                } else {
                    long j3 = this.mBatchEventInterval.get();
                    long j4 = j3 < 10000 ? j3 <= 0 ? 0L : 10000L : j3;
                    LogSession logSession = this.mSession;
                    long j5 = (logSession == null || logSession.non_page) ? 0L : logSession.f39id;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (j4 > 0 && j5 > 0) {
                        if (currentTimeMillis - this.mLastBatchEventTime <= j4) {
                            j2 = j4;
                        } else if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                            this.mLastBatchEventTime = currentTimeMillis;
                            TLog.m73d("AppLog batch event " + j4);
                            j2 = j4;
                            switchSession(logSession, null, true, 0L, false, false);
                        } else {
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                        }
                        j = j2;
                        if (!scanLog()) {
                            break;
                        }
                        if (AppLog.getLogRecoverySwitch() && (i = i + 1) > 4) {
                            this.mMinLog = -1L;
                            break;
                        }
                        logQueueItem2 = logQueueItem;
                    }
                    j = 0;
                    if (!scanLog()) {
                    }
                }
            }
            synchronized (this.mQueue) {
                if (this.mQueue.isEmpty()) {
                    if (j > 0) {
                        try {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j6 = this.mLastBatchEventTime;
                            long j7 = currentTimeMillis2 - j6;
                            if (j6 != 0) {
                                if (j7 >= j) {
                                    j = 0;
                                } else if (j7 >= 0) {
                                    j -= j7;
                                }
                            }
                            TLog.m73d("AppLog wait for batch event " + j);
                            if (j != 0) {
                                this.mQueue.wait(j);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        this.mQueue.wait();
                    }
                    if (this.mStopFlag.get()) {
                        break;
                    } else {
                        poll = logQueueItem;
                    }
                } else {
                    poll = this.mQueue.poll();
                }
            }
            logQueueItem2 = poll;
        }
        TLog.m73d("AppLog LogReaper quit");
    }

    private int sendBatchLog(String[] strArr, String str, boolean z) throws Throwable {
        int checkRatioDowngrade;
        if (AppLog.sInterceptAppLog) {
            checkRatioDowngrade = -1;
        } else {
            DisasterRecovery disasterRecovery = this.mDisasterRecovery;
            checkRatioDowngrade = disasterRecovery != null ? disasterRecovery.checkRatioDowngrade(this.mBatchEventInterval.get()) : 0;
        }
        if (-1 == checkRatioDowngrade) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.BACKOFF_BLOCK_REQUEST_COUNT);
            return -1;
        }
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length && (checkRatioDowngrade = sendLog(i, strArr, str, z)) != 200; i++) {
            }
        }
        return checkRatioDowngrade;
    }

    private void updateSession(LogSession logSession) {
        if (AppLog.isFixSessionLost() && logSession == null) {
            return;
        }
        this.mSession = logSession;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0);
        this.mLatestForgroundSessionTime = sharedPreferences.getLong("latest_forground_session_time", 0L);
        if (logSession == null || logSession.non_page) {
            return;
        }
        this.mLatestForgroundSessionTime = logSession.timestamp;
        sharedPreferences.edit().putLong("latest_forground_session_time", this.mLatestForgroundSessionTime).apply();
    }

    private boolean checkHistoryTerminate(LogItem logItem) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        String format = AppLog.getDateFormat().format(new Date(System.currentTimeMillis()));
        if (format.equals(AppLog.getDateFormat().format(Long.valueOf(this.mLatestForgroundSessionTime)))) {
            return true;
        }
        try {
            jSONObject = new JSONObject(logItem.value);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.isNull("terminate") || (optJSONArray = jSONObject.optJSONArray("terminate")) == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return true;
        }
        String optString = optJSONObject.optString(AppLog.KEY_DATETIME);
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        int optInt = optJSONObject.optInt("duration");
        try {
            Date parse = AppLog.sDateTimeFormat.parse(optString);
            if (parse == null || format.equals(AppLog.getDateFormat().format(parse))) {
                return true;
            }
            if (format.equals(AppLog.getDateFormat().format(new Date(parse.getTime() + (optInt * 1000))))) {
                return true;
            }
            if (jSONObject.isNull("event") && jSONObject.isNull("event_v3") && jSONObject.isNull("log_data") && jSONObject.isNull(EventVerify.TYPE_ITEM_IMPRESSION) && jSONObject.isNull("launch")) {
                return false;
            }
            try {
                DBHelper dBHelper = DBHelper.getInstance(this.mContext);
                jSONObject.remove("terminate");
                String jSONObject2 = jSONObject.toString();
                logItem.value = jSONObject2;
                dBHelper.updateLogData(logItem.f37id, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("terminate", optJSONArray);
                jSONObject3.put("magic_tag", "ss_app_log");
                if (!jSONObject.isNull("time_sync")) {
                    jSONObject3.put("time_sync", jSONObject.optJSONObject("time_sync"));
                }
                jSONObject3.put("header", jSONObject.optJSONObject("header"));
                jSONObject3.put("_gen_time", jSONObject.optLong("_gen_time"));
                dBHelper.insertLog(jSONObject3.toString(), 0);
            } catch (Throwable th) {
                TLog.m76e("AppLog checkHistoryTerminate", th);
            }
            return true;
        } catch (Throwable th2) {
            TLog.m76e("AppLog checkHistoryTerminate error", th2);
            return true;
        }
    }

    public static void monitorPackJsonReported(JSONObject jSONObject, boolean z) {
        if (jSONObject == null || !AppLogNewMonitor.getNewMonitor().isEnabled()) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("event_v3");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("event");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("log_data");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("launch");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("terminate");
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(z ? StatsCountKeys.REPORT_SUCCESS_LAUNCH_COUNT : StatsCountKeys.REPORT_FAILED_LAUNCH_COUNT, optJSONArray4.length());
        }
        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(z ? StatsCountKeys.REPORT_SUCCESS_TERMINATE_COUNT : StatsCountKeys.REPORT_FAILED_TERMINATE_COUNT, optJSONArray5.length());
        }
        int length = optJSONArray != null ? 0 + optJSONArray.length() : 0;
        if (optJSONArray2 != null) {
            length += optJSONArray2.length();
        }
        if (optJSONArray3 != null) {
            length += optJSONArray3.length();
        }
        if (length > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(z ? StatsCountKeys.REPORT_SUCCESS_EVENT_COUNT : StatsCountKeys.REPORT_FAILED_EVENT_COUNT, length);
        }
    }
}
