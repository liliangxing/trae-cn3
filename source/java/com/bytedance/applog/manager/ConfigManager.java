package com.bytedance.applog.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.forward.EventForward;
import com.bytedance.applog.forward.EventForwardLoader;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogMessageConstants;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.exception.AppLogExceptionManager;
import com.bytedance.applog.monitor.exception.ExceptionType;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.priority.EventPriority;
import com.bytedance.applog.priority.EventPriorityItem;
import com.bytedance.applog.priority.EventPriorityLoader;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.throttle.BackoffController;
import com.bytedance.applog.util.JsonUtils;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.crash.entity.Header;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ConfigManager {
    private static final String CONTENT_ENCODE_METHOD = "content_encode_method";
    private static final String CUSTOM_AB_CONFIG = "ab_configure";
    private static final boolean DEFAULT_IGNORE_EVENT_PRIORITY = false;
    private static final long DEFAULT_MAX_PACK_SIZE = 0;
    private static final long EVENT_INTERVAL_DEFAULT = 60000;
    private static final String EXTERNAL_AB_VERSION = "external_ab_version";
    private static final long INTERVAL_UPDATE_CONFIG_DEFAULT = 21600;
    private static final String KEY_ABTEST_INTERVAL = "abtest_fetch_interval";
    private static final String KEY_BAV_AB_ENABLE = "bav_ab_config";
    private static final String KEY_BAV_ENABLE = "bav_log_collect";
    private static final String KEY_CONFIG_TS = "app_log_last_config_time";
    private static final String KEY_CUSTOM_HEADRE_ALLOW = "header_custom_allow";
    private static final String KEY_HTTP_MONITOR_PORT = "http_monitor_port";
    private static final String KEY_IGNORE_EVENT_PRIORITY = "ignore_event_priority";
    private static final String KEY_LATEST_FORGROUND_SESSION_TIME = "latest_forground_session_time";
    private static final String KEY_MAX_PACK_SIZE = "max_pack_size";
    private static final String KEY_MONITOR_CONFIG = "monitor_config";
    private static final String KEY_PARAMS_BLOCK = "params_block";
    private static final String KEY_REAL_TIME_EVENTS = "real_time_events";
    private static final String KEY_SESS_LAST_DAY = "session_last_day";
    private static final String KEY_SESS_ORDER = "session_order";
    private static final long MAX_EVENT_INTERVAL = 300000;
    private static final long MIN_EVENT_INTERVAL = 10000;
    public static final int PROCESS_MAIN = 1;
    public static final int PROCESS_OTHER = 2;
    public static final int PROCESS_UNKNOW = 0;
    private static final long SEVEN_DAY_IN_SECONDS = 604800;
    private static final String SP_CUSTOM_HEADER = "header_custom";
    public static final String SP_FILE = "applog_stats";
    private static final String SP_KEY_CONFIG_INTERVAL = "fetch_interval";
    private static final String SP_KEY_EVENT_INTERVAL = "batch_event_interval";
    private static final String SP_KEY_EXPECTED_BATCH_CALLER = "expected_batch_interval_caller";
    private static final String SP_KEY_EXPECTED_BATCH_INTERVAL = "expected_batch_interval_interval";
    private static final String SP_KEY_EXPECTED_BATCH_UNIQUE_KEY = "expected_batch_interval_unique_key";
    private static final String SP_KEY_LAUNCH_TIMELY = "send_launch_timely";
    private static final String SP_KEY_SESSION_INTERVAL = "session_interval";
    private static final String SP_SESSION = "last_sp_session";
    private static final List<String> logTags = Collections.singletonList("ConfigManager");
    private final AppLogInstance appLogInstance;
    private Engine engine;
    private volatile EventForward eventForward;
    private volatile String mAbSdkVersion;
    private final Context mApp;
    private volatile JSONObject mConfig;
    private final SharedPreferences mCustomSp;
    private final BackoffController mDefaultBackoffController;
    private volatile EventPriority mEventPriority;
    private volatile String mExternalAbVersion;
    private final InitConfig mInitConfig;
    private volatile HashSet<String> mRealTimeEvents;
    private final SharedPreferences mSessionSp;
    private final SharedPreferences mSp;
    private volatile String mUserUniqueId;
    private long mEventIntervalFromLogResp = 0;
    private volatile boolean mFlushEnabled = true;
    private final Map<String, List<String>> blockedEventParamKeysMap = new ConcurrentHashMap();
    private List<String> allowedCustomHeaderKeys = null;
    private final HashSet<String> mBlockSetV1 = new HashSet<>();
    private final HashSet<String> mBlockSetV3 = new HashSet<>();

    private boolean isValidEventInterval(long j) {
        return j >= 10000 && j <= 300000;
    }

    public ConfigManager(AppLogInstance appLogInstance, Context context, InitConfig initConfig) {
        this.appLogInstance = appLogInstance;
        this.mApp = context;
        this.mInitConfig = initConfig;
        this.mSp = context.getSharedPreferences(initConfig.getSpName(), 0);
        this.mCustomSp = context.getSharedPreferences(AppLogHelper.getInstanceSpName(appLogInstance, SP_CUSTOM_HEADER), 0);
        this.mSessionSp = context.getSharedPreferences(AppLogHelper.getInstanceSpName(appLogInstance, SP_SESSION), 0);
        this.mDefaultBackoffController = new BackoffController(appLogInstance, this, getEventInterval());
        if (appLogInstance.isEnableEventPriority()) {
            setEventPriority(EventPriorityLoader.parseEventPriorityFromLocal(appLogInstance, this));
        }
        if (appLogInstance.isEventForwardEnabled()) {
            setEventForward(EventForwardLoader.parseFromLocal(appLogInstance));
        }
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void loadLocalCacheConfig() {
        if (this.appLogInstance.isCustomHeaderControlEnabled()) {
            String string = this.mSp.getString(KEY_CUSTOM_HEADRE_ALLOW, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    updateCustomHeaderControl(null, new JSONArray(string));
                } catch (Throwable th) {
                    this.appLogInstance.getMonitorHelper().sendError("parse custom header control config failed", th);
                }
            }
        }
        if (this.appLogInstance.isEventParamControlEnabled()) {
            String string2 = this.mSp.getString(KEY_PARAMS_BLOCK, null);
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            try {
                updateEventParamsControl(null, new JSONObject(string2));
            } catch (Throwable th2) {
                this.appLogInstance.getMonitorHelper().sendError("parse event params control config failed", th2);
            }
        }
    }

    public boolean autoStart() {
        return this.mInitConfig.autoStart();
    }

    public InitConfig getInitConfig() {
        return this.mInitConfig;
    }

    public String getLastDay() {
        return this.mSessionSp.getString(KEY_SESS_LAST_DAY, "");
    }

    public void setLastDay(String str, int i) {
        this.mSessionSp.edit().putString(KEY_SESS_LAST_DAY, str).putInt(KEY_SESS_ORDER, i).apply();
    }

    public int getSessionOrder() {
        return this.mSessionSp.getInt(KEY_SESS_ORDER, 0);
    }

    public SharedPreferences getStatSp() {
        return this.mSp;
    }

    public boolean isPlayEnable() {
        return this.mInitConfig.isPlayEnable();
    }

    public JSONObject getConfig() {
        return this.mConfig;
    }

    public Context getContext() {
        return this.mApp;
    }

    public void setFlushEnabled(boolean z) {
        this.mFlushEnabled = z;
    }

    public boolean isFlushEnabled() {
        return this.mFlushEnabled;
    }

    public void setConfig(JSONObject jSONObject) {
        this.appLogInstance.getLogger().debug(logTags, "setConfig: {}", jSONObject);
        this.mConfig = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.mSp.edit();
        long optInt = jSONObject.optInt(SP_KEY_SESSION_INTERVAL, 0);
        if (optInt > 0 && optInt <= 604800) {
            edit.putLong(SP_KEY_SESSION_INTERVAL, optInt * 1000);
        } else {
            edit.remove(SP_KEY_SESSION_INTERVAL);
        }
        long optInt2 = jSONObject.optInt(SP_KEY_EVENT_INTERVAL, 60) * 1000;
        if (isValidEventInterval(optInt2)) {
            edit.putLong(SP_KEY_EVENT_INTERVAL, optInt2);
        } else {
            edit.remove(SP_KEY_EVENT_INTERVAL);
        }
        int optInt3 = jSONObject.optInt(SP_KEY_LAUNCH_TIMELY, 0);
        if (optInt3 > 0 && optInt3 <= 604800) {
            edit.putInt(SP_KEY_LAUNCH_TIMELY, optInt3);
        } else {
            edit.remove(SP_KEY_LAUNCH_TIMELY);
        }
        long optInt4 = jSONObject.optInt(KEY_ABTEST_INTERVAL, 0);
        if (optInt4 > 20 && optInt4 <= 604800) {
            edit.putLong(KEY_ABTEST_INTERVAL, optInt4 * 1000);
        } else {
            edit.remove(KEY_ABTEST_INTERVAL);
        }
        if (jSONObject.optBoolean(KEY_BAV_AB_ENABLE, false)) {
            edit.putBoolean(KEY_BAV_AB_ENABLE, true);
        } else {
            edit.remove(KEY_BAV_AB_ENABLE);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_REAL_TIME_EVENTS);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.mRealTimeEvents = parseRealTimeEvents(optJSONArray);
            edit.putString(KEY_REAL_TIME_EVENTS, optJSONArray.toString());
        } else {
            this.mRealTimeEvents = new HashSet<>();
            edit.remove(KEY_REAL_TIME_EVENTS);
        }
        int optInt5 = jSONObject.optInt(KEY_HTTP_MONITOR_PORT, 0);
        if (optInt5 > 0) {
            edit.putInt(KEY_HTTP_MONITOR_PORT, optInt5);
        }
        edit.putLong(KEY_CONFIG_TS, currentTimeMillis);
        int optInt6 = jSONObject.optInt(Api.FORBID_REPORT_PHONE_DETAIL_INFO, -1);
        if (optInt6 >= 0) {
            edit.putBoolean(Api.FORBID_REPORT_PHONE_DETAIL_INFO, optInt6 > 0);
        }
        long optLong = jSONObject.optLong(SP_KEY_CONFIG_INTERVAL, INTERVAL_UPDATE_CONFIG_DEFAULT) * 1000;
        if (optLong < ReportConsts.LAST_STOP_INTERVAL || optLong > 172800000) {
            optLong = 21600000;
        }
        edit.putLong(SP_KEY_CONFIG_INTERVAL, optLong);
        edit.putInt(CONTENT_ENCODE_METHOD, jSONObject.optInt(CONTENT_ENCODE_METHOD, 0));
        edit.putLong(KEY_MAX_PACK_SIZE, jSONObject.optLong(KEY_MAX_PACK_SIZE, 0L));
        JSONObject optJSONObject = jSONObject.optJSONObject(Api.KEY_LOG_BACK);
        if (optJSONObject != null) {
            updateLogback(edit, optJSONObject);
        }
        edit.putBoolean(KEY_IGNORE_EVENT_PRIORITY, jSONObject.optInt(KEY_IGNORE_EVENT_PRIORITY, 0) == 1);
        if (this.appLogInstance.isEventParamControlEnabled()) {
            updateEventParamsControl(edit, jSONObject.optJSONObject(KEY_PARAMS_BLOCK));
        }
        if (this.appLogInstance.isCustomHeaderControlEnabled()) {
            updateCustomHeaderControl(edit, jSONObject.optJSONArray(KEY_CUSTOM_HEADRE_ALLOW));
        }
        edit.apply();
        if (jSONObject.has("monitor_config")) {
            this.appLogInstance.getMonitorHelper().getConfigManager().setConfig(jSONObject.optJSONObject("monitor_config"));
        }
        sendOriginCachedConfig2DevTools();
    }

    public long getConfigTs() {
        return this.mSp.getLong(KEY_CONFIG_TS, 0L);
    }

    public int getEncodeType() {
        return this.mSp.getInt(CONTENT_ENCODE_METHOD, 0);
    }

    private void updateEventParamsControl(SharedPreferences.Editor editor, JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (!this.blockedEventParamKeysMap.isEmpty()) {
            this.blockedEventParamKeysMap.clear();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONArray = jSONObject.optJSONArray(next)) != null && optJSONArray.length() != 0) {
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            hashSet.add(optString);
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        this.blockedEventParamKeysMap.put(next, new ArrayList(hashSet));
                    }
                }
            }
        }
        if (editor != null) {
            if (this.blockedEventParamKeysMap.isEmpty()) {
                editor.remove(KEY_PARAMS_BLOCK);
            } else {
                editor.putString(KEY_PARAMS_BLOCK, jSONObject.toString());
            }
        }
    }

    private void updateCustomHeaderControl(SharedPreferences.Editor editor, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            this.allowedCustomHeaderKeys = null;
            if (editor != null) {
                editor.remove(KEY_CUSTOM_HEADRE_ALLOW);
                return;
            }
            return;
        }
        this.allowedCustomHeaderKeys = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                this.allowedCustomHeaderKeys.add(optString);
            }
        }
        Engine engine = this.engine;
        if (engine != null) {
            engine.getDm().filterHeaderInMemory();
        }
        if (editor != null) {
            editor.putString(KEY_CUSTOM_HEADRE_ALLOW, jSONArray.toString());
        }
    }

    private HashSet<String> parseRealTimeEvents(JSONArray jSONArray) {
        HashSet<String> hashSet = new HashSet<>();
        if (jSONArray == null) {
            try {
                jSONArray = new JSONArray(this.mSp.getString(KEY_REAL_TIME_EVENTS, "[]"));
            } catch (Throwable unused) {
            }
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        return hashSet;
    }

    private HashSet<String> getRealTimeEvents() {
        if (this.mRealTimeEvents == null) {
            this.mRealTimeEvents = parseRealTimeEvents(null);
        }
        return this.mRealTimeEvents;
    }

    public String getAid() {
        return this.mInitConfig.getAid();
    }

    public String getChannel() {
        String channel = this.mInitConfig.getChannel();
        if (TextUtils.isEmpty(channel)) {
            channel = getTweakedChannel();
        }
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        try {
            return !TextUtils.isEmpty(SensitiveUtils.CHANNEL_KEY) ? this.mApp.getPackageManager().getApplicationInfo(this.mApp.getPackageName(), 128).metaData.getString(SensitiveUtils.CHANNEL_KEY) : channel;
        } catch (Throwable th) {
            this.appLogInstance.getLogger().error(logTags, "getChannel failed", th, new Object[0]);
            return channel;
        }
    }

    public String getLastChannel() {
        return this.mSp.getString("channel", "");
    }

    public boolean isCustomHeaderKeyAllowed(String str) {
        List<String> list;
        return !this.appLogInstance.isCustomHeaderControlEnabled() || (list = this.allowedCustomHeaderKeys) == null || list.isEmpty() || this.allowedCustomHeaderKeys.contains(str);
    }

    public boolean isEventParamKeyAllowed(String str, String str2) {
        List<String> list;
        if (this.appLogInstance.isEventParamControlEnabled() && this.blockedEventParamKeysMap.containsKey(str) && (list = this.blockedEventParamKeysMap.get(str)) != null && !list.isEmpty()) {
            return !list.contains(str2);
        }
        return true;
    }

    public boolean isEventParamsControlledByEventName(String str) {
        if (this.appLogInstance.isEventParamControlEnabled()) {
            return this.blockedEventParamKeysMap.containsKey(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAbSdkVersion(String str) {
        this.mAbSdkVersion = str;
        this.mCustomSp.edit().putString(Api.KEY_AB_SDK_VERSION, str).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAbSdkVersion() {
        if (this.mAbSdkVersion == null) {
            this.mAbSdkVersion = this.mCustomSp.getString(Api.KEY_AB_SDK_VERSION, "");
        }
        return this.mAbSdkVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserUniqueId(String str) {
        this.mUserUniqueId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserUniqueId() {
        if (this.mUserUniqueId == null) {
            this.mUserUniqueId = this.mCustomSp.getString("user_unique_id", "");
        }
        return this.mUserUniqueId;
    }

    public boolean isMainProcess() {
        if (this.mInitConfig.getProcess() == 0) {
            this.mInitConfig.setProcess(!Utils.getProcessName(this.mApp).contains(":"));
        }
        return this.mInitConfig.getProcess() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExternalAbVersion(String str) {
        this.appLogInstance.getLogger().debug(logTags, "setExternalAbVersion: {}", str);
        this.mCustomSp.edit().putString(EXTERNAL_AB_VERSION, str).apply();
        this.mExternalAbVersion = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getExternalAbVersion() {
        String str = this.mExternalAbVersion;
        if (TextUtils.isEmpty(str)) {
            synchronized (this) {
                str = this.mCustomSp.getString(EXTERNAL_AB_VERSION, "");
                this.mExternalAbVersion = str;
            }
        }
        return str;
    }

    public int getHttpMonitorPort() {
        return this.mSp.getInt(KEY_HTTP_MONITOR_PORT, 0);
    }

    public long getSessionLife() {
        return this.mSp.getLong(SP_KEY_SESSION_INTERVAL, 30000L);
    }

    public long getEventInterval() {
        if (isValidEventInterval(this.mEventIntervalFromLogResp)) {
            return this.mEventIntervalFromLogResp;
        }
        return this.mSp.getLong(SP_KEY_EVENT_INTERVAL, 60000L);
    }

    public ArrayList<BaseData> filterReal(List<BaseData> list) {
        Iterator<BaseData> it = list.iterator();
        ArrayList<BaseData> arrayList = null;
        while (it.hasNext()) {
            BaseData next = it.next();
            if (next instanceof EventV3) {
                EventV3 eventV3 = (EventV3) next;
                if (eventV3.getPriority() == 0 || getRealTimeEvents().contains(eventV3.getEvent())) {
                    it.remove();
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public boolean filterBlock(ArrayList<BaseData> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || (this.mBlockSetV1.size() == 0 && this.mBlockSetV3.size() == 0)) {
            return true;
        }
        Iterator<BaseData> it = arrayList.iterator();
        while (it.hasNext()) {
            BaseData next = it.next();
            if (next instanceof Event) {
                Event event = (Event) next;
                if (this.mBlockSetV1.contains(event.tag + (!TextUtils.isEmpty(event.label) ? event.label : ""))) {
                    it.remove();
                    MonitorUtils.stageEvent(this.appLogInstance.getMonitorHelper(), EventStage.FILTER_SERVER_BLOCKED, next);
                    this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.APPLOG_BLOCK_EVENT_COUNT);
                    this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
                    AppLogExceptionManager.getInstance().dispatchDiscardEvent(ExceptionType.InterruptionBlockList, next.getDetail());
                }
            } else if ((next instanceof EventV3) && this.mBlockSetV3.contains(((EventV3) next).getEvent())) {
                MonitorUtils.stageEvent(this.appLogInstance.getMonitorHelper(), EventStage.FILTER_SERVER_BLOCKED, next);
                it.remove();
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.APPLOG_BLOCK_EVENT_COUNT);
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
                AppLogExceptionManager.getInstance().dispatchDiscardEvent(ExceptionType.InterruptionBlockList, next.getDetail());
            }
        }
        return true;
    }

    public void updateBlock(HashSet<String> hashSet, HashSet<String> hashSet2) {
        if (hashSet != null) {
            this.mBlockSetV1.addAll(hashSet);
        }
        if (hashSet2 != null) {
            this.mBlockSetV3.addAll(hashSet2);
        }
    }

    public void parseCommonConfigFromResp(JSONObject jSONObject) {
        this.mEventIntervalFromLogResp = jSONObject.optLong(SP_KEY_EVENT_INTERVAL, 0L) * 1000;
        this.appLogInstance.getLogger().debug(logTags, "parseCommonConfigFromResp mEventIntervalFromLogResp: {}", Long.valueOf(this.mEventIntervalFromLogResp));
    }

    public void parseBackoffControllerFromResp(JSONObject jSONObject) {
        this.mDefaultBackoffController.parseBackoffControllerFromResp(jSONObject, getEventInterval(), null);
        EventPriorityLoader.parsePriorityRequestConfigFromResp(jSONObject, this.mEventPriority);
    }

    public void updateCongestionMaxRequestFrequency(EventPriorityItem eventPriorityItem, int i) {
        Engine engine = this.engine;
        if (engine != null) {
            engine.tryUpdateCongestionMaxRequestFrequency(eventPriorityItem, i);
        }
    }

    public String getVersion() {
        return this.mInitConfig.getVersion();
    }

    String getTweakedChannel() {
        return this.mInitConfig.getTweakedChannel();
    }

    public long getConfigInterval() {
        return this.mSp.getLong(SP_KEY_CONFIG_INTERVAL, 21600000L);
    }

    public long getLatestFgSessionTime() {
        return this.mSessionSp.getLong(KEY_LATEST_FORGROUND_SESSION_TIME, 0L);
    }

    public void setLatestForgroundSessionTime(long j) {
        this.mSessionSp.edit().putLong(KEY_LATEST_FORGROUND_SESSION_TIME, j).apply();
    }

    public EventPriority getEventPriority() {
        return this.mEventPriority;
    }

    public void setEventPriority(final EventPriority eventPriority) {
        Engine engine;
        if (isIgnoreEventPriority()) {
            return;
        }
        boolean z = eventPriority == null || eventPriority.isIntervalChanged(this.mEventPriority);
        this.mEventPriority = eventPriority;
        if (z && (engine = this.engine) != null) {
            engine.tryUpdateSenders();
        }
        if (LogUtils.isDisabled() || eventPriority == null) {
            return;
        }
        LogUtils.sendJsonFetcher("priority_config", new EventBus.DataFetcher() { // from class: com.bytedance.applog.manager.ConfigManager.1
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appId", ConfigManager.this.appLogInstance.getAppId());
                    jSONObject.put("config", eventPriority.getPriorityJson());
                    jSONObject.put("version", eventPriority.getVersion());
                    jSONObject.put("baseInterval", eventPriority.getBaseInterval());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public EventPriorityItem getEventPriorityItem(int i) {
        EventPriority eventPriority = this.mEventPriority;
        if (eventPriority != null) {
            return eventPriority.getEventPriorityItem(i);
        }
        return null;
    }

    public BackoffController getDefaultBackoffController() {
        return this.mDefaultBackoffController;
    }

    public long getMaxPackSize() {
        return this.mSp.getLong(KEY_MAX_PACK_SIZE, 0L);
    }

    public boolean isPackSizeLimitEnabled() {
        return getMaxPackSize() > 0;
    }

    public JSONObject getExpectedBatchInterval() {
        JSONObject jSONObject = new JSONObject();
        int i = this.mSp.getInt(SP_KEY_EXPECTED_BATCH_INTERVAL, -1);
        if (i < 0) {
            return null;
        }
        try {
            jSONObject.put("interval", i);
            jSONObject.put("caller", this.mSp.getString(SP_KEY_EXPECTED_BATCH_CALLER, ""));
            jSONObject.put(Header.KEY_UNIQUE_KEY, this.mSp.getString(SP_KEY_EXPECTED_BATCH_UNIQUE_KEY, ""));
        } catch (Throwable th) {
            this.appLogInstance.getLogger().error("json build ExpectedBatchInterval failed", th, new Object[0]);
        }
        return jSONObject;
    }

    public void updateLogback(SharedPreferences.Editor editor, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject logback = getLogback();
        if (logback != null) {
            JsonUtils.mergeJsonObject(jSONObject, logback);
            jSONObject = logback;
        }
        if (editor != null) {
            editor.putString(Api.KEY_LOG_BACK, jSONObject.toString());
        } else {
            this.mSp.edit().putString(Api.KEY_LOG_BACK, jSONObject.toString()).apply();
        }
    }

    public JSONObject getLogback() {
        String string = this.mSp.getString(Api.KEY_LOG_BACK, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (Throwable th) {
            this.appLogInstance.getLogger().error("json parse to logback failed", th, new Object[0]);
            return null;
        }
    }

    public boolean isIgnoreEventPriority() {
        return this.mSp.getBoolean(KEY_IGNORE_EVENT_PRIORITY, false);
    }

    public void setEventForward(EventForward eventForward) {
        Engine engine;
        if (eventForward == null || !eventForward.equals(this.eventForward)) {
            this.eventForward = eventForward;
            if (this.eventForward != null && (engine = this.engine) != null) {
                engine.tryUpdateSenders();
            }
            if (this.eventForward == null || LogUtils.isDisabled()) {
                return;
            }
            LogUtils.sendJsonFetcher("forward_config", new EventBus.DataFetcher() { // from class: com.bytedance.applog.manager.ConfigManager.2
                @Override // com.bytedance.applog.log.EventBus.DataFetcher
                public Object fetch() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("appId", ConfigManager.this.appLogInstance.getAppId());
                        jSONObject.put("config", ConfigManager.this.eventForward.getConfigJson());
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        }
    }

    public EventForward getEventForward() {
        return this.eventForward;
    }

    public void sendOriginCachedConfig2DevTools() {
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("remote_settings", new EventBus.DataFetcher() { // from class: com.bytedance.applog.manager.ConfigManager.3
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                if (ConfigManager.this.getConfigTs() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("appId", ConfigManager.this.appLogInstance.getAppId());
                    long j = ConfigManager.this.mSp.getLong(ConfigManager.SP_KEY_SESSION_INTERVAL, 0L);
                    jSONObject2.put(LogMessageConstants.SETTINGS_BG_SESSION_INTERVAL, j > 0 ? j + "ms" : "--");
                    long j2 = ConfigManager.this.mSp.getLong(ConfigManager.SP_KEY_EVENT_INTERVAL, 0L);
                    jSONObject2.put(LogMessageConstants.SETTINGS_BATCH_EVENT_INTERVAL, j2 > 0 ? j2 + "ms" : "--");
                    long j3 = ConfigManager.this.mSp.getLong(ConfigManager.KEY_ABTEST_INTERVAL, 0L);
                    jSONObject2.put(LogMessageConstants.SETTINGS_AB_FETCH_INTERVAL, j3 > 0 ? j3 + "ms" : "--");
                    jSONObject2.put(LogMessageConstants.SETTINGS_BAV_SWITCH, ConfigManager.this.mSp.getBoolean(ConfigManager.KEY_BAV_ENABLE, false));
                    jSONObject2.put(LogMessageConstants.SETTINGS_AB_SWITCH, ConfigManager.this.mSp.getBoolean(ConfigManager.KEY_BAV_AB_ENABLE, false));
                    jSONObject2.put(LogMessageConstants.SETTINGS_REAL_EVENTS, ConfigManager.this.mSp.getString(ConfigManager.KEY_REAL_TIME_EVENTS, "[]"));
                    jSONObject2.put(LogMessageConstants.SETTINGS_FORBID_DETAIL_SWITCH, ConfigManager.this.mSp.getBoolean(Api.FORBID_REPORT_PHONE_DETAIL_INFO, false));
                    long j4 = ConfigManager.this.mSp.getLong(ConfigManager.SP_KEY_CONFIG_INTERVAL, 0L);
                    jSONObject2.put(LogMessageConstants.SETTINGS_REMOTE_FETCH_INTERVAL, j4 > 0 ? j4 + "ms" : "--");
                    jSONObject2.put(LogMessageConstants.SETTINGS_LOG_COMPRESS_TYPE, Utils.getEncodeTypeString(ConfigManager.this.getEncodeType()));
                    jSONObject2.put(LogMessageConstants.SETTINGS_LOG_BACK, ConfigManager.this.mSp.getString(Api.KEY_LOG_BACK, ""));
                    jSONObject2.put(LogMessageConstants.SETTINGS_PACK_SIZE_LIMIT, ConfigManager.this.isPackSizeLimitEnabled());
                    jSONObject2.put(LogMessageConstants.SETTINGS_MAX_PACK_SIZE, ConfigManager.this.getMaxPackSize());
                    jSONObject2.put(LogMessageConstants.SETTINGS_IGNORE_EVENT_PRIORITY, ConfigManager.this.isIgnoreEventPriority());
                    jSONObject.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }
}
