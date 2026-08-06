package com.bytedance.applog.monitor.p006v3.impl;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.monitor.p006v3.IV3Monitor;
import com.bytedance.applog.monitor.p006v3.MonitorConfigManager;
import com.bytedance.applog.monitor.p006v3.MonitorV3Utils;
import com.bytedance.applog.monitor.p006v3.RandomUtils;
import com.bytedance.applog.server.Api;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ErrorMonitor implements IV3Monitor<JSONObject> {
    private MonitorConfigManager configManager;
    private final List<ErrorInfo> errors = new CopyOnWriteArrayList();
    private int samplingRate = 10000;
    private final int maxErrorCountInMem = 100;

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void init(Context context, HandlerThread handlerThread, String str) {
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void removeByMap(Map<String, JSONObject> map) {
    }

    public ErrorMonitor(MonitorConfigManager monitorConfigManager) {
        this.configManager = monitorConfigManager;
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void initWithDisabled() {
        this.samplingRate = 0;
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public Pair<Map<String, JSONObject>, Long> getMapBySize(long j) {
        if (this.samplingRate <= 0) {
            return new Pair<>(null, Long.valueOf(j));
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        for (ErrorInfo errorInfo : this.errors) {
            int i2 = i + 1;
            hashMap.put(String.valueOf(i), errorInfo.toJson());
            this.errors.remove(errorInfo);
            j -= errorInfo.size();
            if (j <= 0) {
                break;
            }
            i = i2;
        }
        return new Pair<>(hashMap, Long.valueOf(j));
    }

    @Override // com.bytedance.applog.monitor.p006v3.IV3Monitor
    public void appendMapToJSONArray(Map<String, JSONObject> map, JSONArray jSONArray) {
        Iterator<JSONObject> it = map.values().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class ErrorInfo {
        private String clazz;
        private String message;
        private String stack;

        public ErrorInfo(String str, String str2, String str3) {
            this.message = str;
            this.clazz = str2;
            this.stack = str3;
        }

        public ErrorInfo(String str) {
            this.message = str;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "sdk_fatal");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", this.message);
                if (!TextUtils.isEmpty(this.clazz)) {
                    jSONObject2.put("class", this.clazz);
                    jSONObject2.put("stack", this.stack);
                }
                jSONObject.put("params", jSONObject2);
                jSONObject.put(Api.KEY_LOCAL_TIME_MS, System.currentTimeMillis());
                jSONObject.put("event_id", MonitorV3Utils.getMonitorEventId());
                jSONObject.put(Api.KEY_DATETIME, MonitorV3Utils.getCurrentDateTime());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }

        public long size() {
            int length;
            if (TextUtils.isEmpty(this.clazz)) {
                length = this.message.length() + 43;
            } else {
                length = this.message.length() + 65 + this.clazz.length() + this.stack.length();
            }
            return length;
        }
    }

    public void onError(String str, Throwable th) {
        if (RandomUtils.randomSamplingHit(this.samplingRate, 10000)) {
            if (th != null) {
                this.errors.add(new ErrorInfo(str, th.getClass().getCanonicalName(), getExceptionStackString(th)));
            } else {
                this.errors.add(new ErrorInfo(str));
            }
            if (this.errors.size() > 100) {
                this.errors.remove(0);
            }
        }
    }

    private String getExceptionStackString(Throwable th) {
        StringBuilder sb = new StringBuilder();
        while (th != null) {
            appendStackString(sb, th);
            th = th.getCause();
        }
        String replaceAll = sb.toString().replaceAll("[\\s|\\n]", "");
        return replaceAll.length() <= 200 ? replaceAll : replaceAll.substring(0, 200);
    }

    private void appendStackString(StringBuilder sb, Throwable th) {
        sb.append(th.toString());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\n\tat ").append(stackTraceElement);
        }
    }
}
