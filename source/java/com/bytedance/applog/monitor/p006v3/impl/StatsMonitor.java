package com.bytedance.applog.monitor.p006v3.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.monitor.p006v3.IV3Monitor;
import com.bytedance.applog.monitor.p006v3.MonitorConfigManager;
import com.bytedance.applog.monitor.p006v3.MonitorV3Utils;
import com.bytedance.applog.server.Api;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.wschannel.WsConstants;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class StatsMonitor implements Handler.Callback, IV3Monitor<Integer> {
    private static final int MSG_FLUSH = 8;
    private static final int MSG_INCREASE = 16;
    private static final int MSG_LOAD_SP = 24;
    private static final long flushIntervalMs = 500;
    private static final List<String> logTags = Collections.singletonList("StatsMonitor");
    private final MonitorConfigManager configManager;
    private Handler handler;

    /* renamed from: sp */
    private SharedPreferences f60sp;
    private boolean enabled = true;
    private final Map<String, Integer> countMap = new ConcurrentHashMap();

    public StatsMonitor(MonitorConfigManager monitorConfigManager) {
        this.configManager = monitorConfigManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class IncreaseInfo {
        private final int count;
        private final String key;

        public IncreaseInfo(String str, int i) {
            this.key = str;
            this.count = i;
        }
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void init(Context context, HandlerThread handlerThread, String str) {
        this.f60sp = context.getSharedPreferences(str + "@applog_monitor_stats", 0);
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.handler = handler;
        handler.removeMessages(8);
        this.handler.sendEmptyMessageDelayed(8, 500L);
        this.handler.sendEmptyMessageDelayed(24, Math.max(GWorker.INTERVAL, this.configManager.getColdStartReportDelay() - GWorker.INTERVAL) + new SecureRandom().nextInt(WsConstants.APP_STATE_CHANGE_SERVICE));
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void initWithDisabled() {
        this.enabled = false;
        this.countMap.clear();
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public Pair<Map<String, Integer>, Long> getMapBySize(long j) {
        if (this.countMap.isEmpty()) {
            return new Pair<>(null, Long.valueOf(j));
        }
        return new Pair<>(new HashMap(this.countMap), Long.valueOf(j - (this.countMap.size() * 30)));
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void removeByMap(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        synchronized (this.countMap) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int intValue = entry.getValue() != null ? entry.getValue().intValue() : 0;
                Integer num = this.countMap.get(key);
                if (num != null) {
                    int max = Math.max(0, num.intValue() - intValue);
                    if (max == 0) {
                        this.countMap.remove(key);
                    } else {
                        this.countMap.put(key, Integer.valueOf(max));
                    }
                }
            }
        }
        this.handler.removeMessages(8);
        this.handler.sendEmptyMessageDelayed(8, 500L);
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void appendMapToJSONArray(Map<String, Integer> map, JSONArray jSONArray) {
        if (map.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", "sdk_stats");
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value != null && value.intValue() > 0) {
                    jSONObject2.put(entry.getKey(), value);
                }
            }
            jSONObject.put("params", jSONObject2);
            jSONObject.put(Api.KEY_LOCAL_TIME_MS, System.currentTimeMillis());
            jSONObject.put("event_id", MonitorV3Utils.getMonitorEventId());
            jSONObject.put(Api.KEY_DATETIME, MonitorV3Utils.getCurrentDateTime());
        } catch (Throwable th) {
            LoggerImpl.global().error(8, logTags, "appendMapToJSONArray failed", th, new Object[0]);
        }
        jSONArray.put(jSONObject);
    }

    public void increase(String str, int i) {
        if (this.enabled) {
            IncreaseInfo increaseInfo = new IncreaseInfo(str, i);
            Handler handler = this.handler;
            if (handler != null) {
                handler.sendMessageDelayed(handler.obtainMessage(16, increaseInfo), 16L);
            } else {
                increaseMapCount(increaseInfo);
            }
        }
    }

    public Map<String, Integer> getMap() {
        return new HashMap(this.countMap);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 8) {
            flush2Sp();
            return false;
        }
        if (i == 16) {
            increaseMapCount((IncreaseInfo) message.obj);
            return false;
        }
        if (i != 24) {
            return false;
        }
        mergeSpData();
        return false;
    }

    private void increaseMapCount(IncreaseInfo increaseInfo) {
        synchronized (this.countMap) {
            Integer num = this.countMap.get(increaseInfo.key);
            this.countMap.put(increaseInfo.key, Integer.valueOf((num != null ? num.intValue() : 0) + increaseInfo.count));
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(8);
            this.handler.sendEmptyMessageDelayed(8, 500L);
        }
    }

    private void mergeSpData() {
        SharedPreferences sharedPreferences = this.f60sp;
        if (sharedPreferences == null) {
            return;
        }
        long j = sharedPreferences.getLong(MonitorConfigManager.SP_KEY_DATA_UPTIME, 0L);
        if (j > 0 && System.currentTimeMillis() - j > TimeUnit.DAYS.toMillis(this.configManager.getDataAliveDays())) {
            this.f60sp.edit().clear().apply();
            return;
        }
        Map<String, ?> all = this.f60sp.getAll();
        if (all.isEmpty()) {
            return;
        }
        synchronized (this.countMap) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && !MonitorConfigManager.SP_KEY_DATA_UPTIME.equals(entry.getKey())) {
                    int intValue = entry.getValue() != null ? ((Integer) entry.getValue()).intValue() : 0;
                    Integer num = this.countMap.get(key);
                    if (num == null) {
                        this.countMap.put(key, Integer.valueOf(intValue));
                    } else {
                        this.countMap.put(key, Integer.valueOf(intValue + num.intValue()));
                    }
                }
            }
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(8);
            this.handler.sendEmptyMessageDelayed(8, 500L);
        }
    }

    private void flush2Sp() {
        SharedPreferences.Editor edit = this.f60sp.edit();
        edit.clear();
        synchronized (this.countMap) {
            for (Map.Entry<String, Integer> entry : this.countMap.entrySet()) {
                edit.putInt(entry.getKey(), entry.getValue() != null ? entry.getValue().intValue() : 0);
            }
        }
        edit.putLong(MonitorConfigManager.SP_KEY_DATA_UPTIME, System.currentTimeMillis());
        edit.apply();
    }
}
