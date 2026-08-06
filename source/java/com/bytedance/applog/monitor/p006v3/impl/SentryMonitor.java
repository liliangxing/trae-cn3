package com.bytedance.applog.monitor.p006v3.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.IV3Monitor;
import com.bytedance.applog.monitor.p006v3.MonitorConfigManager;
import com.bytedance.applog.monitor.p006v3.MonitorV3Utils;
import com.bytedance.applog.monitor.p006v3.RandomUtils;
import com.bytedance.applog.monitor.p006v3.StageEventBasic;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.priority.original.SqliteDatabaseKt;
import com.bytedance.applog.server.Api;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.wschannel.WsConstants;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SentryMonitor implements Handler.Callback, IV3Monitor<StageEvent> {
    private static final int MSG_FLUSH = 4;
    private static final int MSG_LOAD_SP = 12;
    private static final int MSG_STAGE = 8;
    private static final long flushIntervalMs = 500;
    private static final List<String> logTags = Collections.singletonList("SentryMonitor");
    private SharedPreferences cacheSp;
    private final MonitorConfigManager configManager;
    private Handler handler;
    public final Map<String, StageEvent> cacheMap = Collections.synchronizedMap(new LinkedHashMap());
    private boolean enabled = true;
    private boolean acceptAllEvents = true;
    private final AtomicBoolean hasInit = new AtomicBoolean(false);

    public SentryMonitor(MonitorConfigManager monitorConfigManager) {
        this.configManager = monitorConfigManager;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 4) {
            flushToSp();
            return false;
        }
        if (i == 8) {
            addStage((StageEvent) message.obj);
            return false;
        }
        if (i != 12) {
            return false;
        }
        loadSpData();
        return false;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class StageEvent {
        private StageEventBasic event;
        private boolean persistent = false;
        private EventStage stage;

        public StageEvent(EventStage eventStage, StageEventBasic stageEventBasic) {
            this.stage = eventStage;
            this.event = stageEventBasic;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SqliteDatabaseKt.colMonitorId, this.event.monitorId);
                if (this.event.eventType != null) {
                    jSONObject.put("event_type", this.event.eventType.getLabel());
                }
                if (!TextUtils.isEmpty(this.event.eventName)) {
                    jSONObject.put("event", this.event.eventName);
                }
                if (this.event.f59ts > 0) {
                    jSONObject.put(Api.KEY_LOCAL_TIME_MS, this.event.f59ts);
                }
                if (!TextUtils.isEmpty(this.event.priorityName)) {
                    jSONObject.put("event_priority", this.event.priorityName);
                }
                if (this.event.groupId >= 0) {
                    jSONObject.put("global_priority", this.event.groupId);
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        }

        public long size() {
            return (this.event != null ? r0.eventName.length() : 0) + 133;
        }

        public String serialize() {
            return "v3|" + (TextUtils.isEmpty(this.event.priorityName) ? "" : this.event.priorityName) + "|" + this.event.groupId + "|" + this.stage.name() + "|" + this.event.eventName + "|" + this.event.f59ts + "|" + this.event.eventType.name();
        }

        public static StageEvent deserialize(String str, String str2) {
            int i;
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            List<String> fastSplitString = MonitorV3Utils.fastSplitString(str2, '|');
            if (fastSplitString.isEmpty()) {
                return null;
            }
            if (fastSplitString.get(0).equals("v3")) {
                try {
                    i = Integer.parseInt(fastSplitString.get(2));
                } catch (Throwable unused) {
                    i = -1;
                }
                return new StageEvent(EventStage.valueOf(fastSplitString.get(3)), new StageEventBasic(TextUtils.isEmpty(fastSplitString.get(1)) ? null : fastSplitString.get(1), i, fastSplitString.get(4), str, Long.parseLong(fastSplitString.get(5)), StageEventType.parse(fastSplitString.get(6))));
            }
            if (fastSplitString.size() == 4) {
                return new StageEvent(EventStage.valueOf(fastSplitString.get(0)), new StageEventBasic(fastSplitString.get(1), str, Long.parseLong(fastSplitString.get(2)), StageEventType.V3_EVENT));
            }
            if (fastSplitString.size() == 5) {
                return new StageEvent(EventStage.valueOf(fastSplitString.get(0)), new StageEventBasic(fastSplitString.get(1), str, Long.parseLong(fastSplitString.get(2)), StageEventType.parse(fastSplitString.get(3))));
            }
            return null;
        }
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void initWithDisabled() {
        LoggerImpl.global().debug(8, logTags, "init with disabled", new Object[0]);
        this.enabled = false;
        this.cacheMap.clear();
        this.hasInit.set(true);
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public Pair<Map<String, StageEvent>, Long> getMapBySize(long j) {
        if (this.cacheMap.isEmpty()) {
            return new Pair<>(null, Long.valueOf(j));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.cacheMap) {
            for (Map.Entry<String, StageEvent> entry : this.cacheMap.entrySet()) {
                StageEvent value = entry.getValue();
                linkedHashMap.put(entry.getKey(), value);
                j -= value.size();
                if (j < 0) {
                    break;
                }
            }
        }
        return new Pair<>(linkedHashMap, Long.valueOf(j));
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void removeByMap(Map<String, StageEvent> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences sharedPreferences = this.cacheSp;
        SharedPreferences.Editor edit = sharedPreferences != null ? sharedPreferences.edit() : null;
        synchronized (this.cacheMap) {
            for (String str : map.keySet()) {
                this.cacheMap.remove(str);
                if (edit != null) {
                    edit.remove(str);
                }
            }
        }
        if (edit != null) {
            edit.apply();
        }
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void appendMapToJSONArray(Map<String, StageEvent> map, JSONArray jSONArray) {
        if (map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (StageEvent stageEvent : map.values()) {
            JSONArray jSONArray2 = (JSONArray) hashMap.get(stageEvent.stage);
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
                hashMap.put(stageEvent.stage, jSONArray2);
            }
            jSONArray2.put(stageEvent.toJson());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", "sdk_stage");
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                jSONObject2.put(((EventStage) entry.getKey()).toString(), entry.getValue());
            }
            jSONObject.put("params", jSONObject2);
            jSONObject.put(Api.KEY_LOCAL_TIME_MS, System.currentTimeMillis());
            jSONObject.put("event_id", MonitorV3Utils.getMonitorEventId());
            jSONObject.put(Api.KEY_DATETIME, MonitorV3Utils.getCurrentDateTime());
        } catch (Throwable unused) {
        }
        jSONArray.put(jSONObject);
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void init(Context context, HandlerThread handlerThread, String str) {
        IAppLogLogger global = LoggerImpl.global();
        List<String> list = logTags;
        global.debug(8, list, "init with prefix sp: {}.", str);
        if (!this.hasInit.compareAndSet(false, true)) {
            LoggerImpl.global().error(8, list, "init failed for already initialized with sp prefix:{}.", str);
            return;
        }
        if (!this.configManager.isSentryEnabled()) {
            LoggerImpl.global().debug(8, list, "init but disabled!!!", new Object[0]);
            this.acceptAllEvents = false;
            this.cacheMap.clear();
            this.enabled = false;
            return;
        }
        this.acceptAllEvents = RandomUtils.randomSamplingHit(this.configManager.getSentryColdStartSamplingRate(), 10000);
        LoggerImpl.global().debug(8, list, "sentry acceptAllEvents = {}", Boolean.valueOf(this.acceptAllEvents));
        this.cacheSp = context.getSharedPreferences(str + "@applog_monitor_sentry", 0);
        if (!isAcceptAllEvents()) {
            resetCacheMap();
        }
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.handler = handler;
        handler.removeMessages(4);
        this.handler.sendEmptyMessageDelayed(4, 500L);
        this.handler.sendEmptyMessageDelayed(12, Math.max(GWorker.INTERVAL, this.configManager.getColdStartReportDelay() - GWorker.INTERVAL) + new SecureRandom().nextInt(WsConstants.APP_STATE_CHANGE_SERVICE));
    }

    public boolean isAcceptAllEvents() {
        return this.acceptAllEvents || this.configManager.isDebugMode();
    }

    public void stage(String str, int i, EventStage eventStage, String str2, String str3, long j, StageEventType stageEventType) {
        if (!this.enabled || !this.configManager.isSentryEnabled()) {
            LoggerImpl.global().debug(8, logTags, "stage nothing for disabled!!!", new Object[0]);
            return;
        }
        StageEvent stageEvent = new StageEvent(eventStage, new StageEventBasic(str, i, str2, str3, j, stageEventType));
        if (this.handler != null && Looper.myLooper() == Looper.getMainLooper()) {
            Handler handler = this.handler;
            handler.sendMessage(handler.obtainMessage(8, stageEvent));
        } else {
            addStage(stageEvent);
        }
    }

    private void addStage(StageEvent stageEvent) {
        LoggerImpl.global().debug(8, logTags, "start handle stage ({})", stageEvent);
        synchronized (this.cacheMap) {
            if (isEventMaybeAccepted(stageEvent.event.eventName)) {
                StageEvent stageEvent2 = this.cacheMap.get(stageEvent.event.monitorId);
                if (stageEvent2 == null) {
                    this.cacheMap.put(stageEvent.event.monitorId, stageEvent);
                } else {
                    stageEvent2.persistent = false;
                    stageEvent2.event.merge(stageEvent.event);
                    if (stageEvent.stage.ordinal() > stageEvent2.stage.ordinal()) {
                        stageEvent2.stage = stageEvent.stage;
                    }
                }
                Handler handler = this.handler;
                if (handler != null) {
                    handler.removeMessages(4);
                    this.handler.sendEmptyMessageDelayed(4, 500L);
                }
            }
        }
    }

    private void flushToSp() {
        LoggerImpl.global().debug(8, logTags, "start flush cache map (size={}) to sp...", Integer.valueOf(this.cacheMap.size()));
        SharedPreferences.Editor edit = this.cacheSp.edit();
        synchronized (this.cacheMap) {
            Iterator<Map.Entry<String, StageEvent>> it = this.cacheMap.entrySet().iterator();
            while (it.hasNext()) {
                StageEvent value = it.next().getValue();
                if (!value.persistent && isEventMaybeAccepted(value.event.eventName)) {
                    edit.putString(value.event.monitorId, value.serialize());
                    value.persistent = true;
                }
            }
        }
        edit.putLong(MonitorConfigManager.SP_KEY_DATA_UPTIME, System.currentTimeMillis());
        edit.apply();
    }

    private void loadSpData() {
        StageEvent stageEvent;
        StageEvent deserialize;
        if (this.cacheSp == null) {
            return;
        }
        LoggerImpl.global().debug(8, logTags, "start load cache map from sp...", new Object[0]);
        long j = this.cacheSp.getLong(MonitorConfigManager.SP_KEY_DATA_UPTIME, 0L);
        if (j > 0 && System.currentTimeMillis() - j > TimeUnit.DAYS.toMillis(this.configManager.getDataAliveDays())) {
            this.cacheSp.edit().clear().apply();
            return;
        }
        Map<String, ?> all = this.cacheSp.getAll();
        if (all.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(all.size() * 2);
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && !MonitorConfigManager.SP_KEY_DATA_UPTIME.equals(key) && (deserialize = StageEvent.deserialize(key, (String) entry.getValue())) != null) {
                deserialize.persistent = true;
                hashMap.put(key, deserialize);
            }
        }
        synchronized (this.cacheMap) {
            for (Map.Entry entry2 : hashMap.entrySet()) {
                String str = (String) entry2.getKey();
                StageEvent stageEvent2 = (StageEvent) entry2.getValue();
                if (this.cacheMap.containsKey(entry2.getKey()) && (stageEvent = this.cacheMap.get(entry2.getKey())) != null) {
                    stageEvent2.persistent = false;
                    stageEvent2.event.merge(stageEvent.event);
                }
                this.cacheMap.put(str, stageEvent2);
            }
        }
    }

    public boolean isEventHitSampling(String str) {
        Integer num;
        if (isAcceptAllEvents() || !this.hasInit.get()) {
            return true;
        }
        if (isEventMaybeAccepted(str) && (num = this.configManager.getSentryEventMap().get(str)) != null && num.intValue() > 0) {
            return RandomUtils.randomSamplingHit(num.intValue(), 10000);
        }
        return false;
    }

    public boolean isEventMaybeAccepted(String str) {
        if (isAcceptAllEvents()) {
            return true;
        }
        if (this.configManager.getSentryEventMap() == null) {
            return false;
        }
        return this.configManager.getSentryEventMap().containsKey(str);
    }

    private void resetCacheMap() {
        if (this.cacheMap.isEmpty()) {
            return;
        }
        LoggerImpl.global().debug(8, logTags, "start reset cache map...", new Object[0]);
        if (!isAcceptAllEvents() && (this.configManager.getSentryEventMap() == null || this.configManager.getSentryEventMap().isEmpty())) {
            this.cacheMap.clear();
            return;
        }
        synchronized (this.cacheMap) {
            for (Map.Entry<String, StageEvent> entry : this.cacheMap.entrySet()) {
                if (!isEventMaybeAccepted(entry.getValue().event.eventName)) {
                    this.cacheMap.remove(entry.getKey());
                }
            }
        }
    }
}
