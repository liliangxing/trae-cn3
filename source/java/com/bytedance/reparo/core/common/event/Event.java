package com.bytedance.reparo.core.common.event;

import android.os.SystemClock;
import com.bytedance.reparo.core.common.utils.StringUtils;
import com.bytedance.reparo.core.common.utils.ThrowableUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class Event {
    private static volatile Boolean isMainProcess;
    private static volatile String processName;
    private HashMap<String, Object> categoryMap;
    private long endTime;
    private HashMap<String, Object> extraMap;
    private HashMap<String, Object> metricsMap;
    private String tag = "";
    private int eventType = 0;
    private String step = "";
    private String stepDesc = "";
    private long startTime = -1;
    private boolean collectDuration = false;
    private boolean isSuccess = true;
    private int errorCode = 0;
    private PatchException exception = null;
    private String msg = "";
    private String errorMsg = "";
    private EventSender sender = null;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface EventType {
        public static final int TYPE_ERROR_EXCEPTION = 2;
        public static final int TYPE_ERROR_MSG = 1;
        public static final int TYPE_MSG = 0;
    }

    private String getEventTypeDesc(int i) {
        return i == 0 ? "msg" : i == 1 ? "error_msg" : i == 2 ? "error_exception" : "";
    }

    public Event() {
        this.endTime = -1L;
        this.endTime = SystemClock.elapsedRealtime();
    }

    public Event eventType(int i) {
        this.eventType = i;
        return this;
    }

    public Event tag(String str) {
        this.tag = str;
        return this;
    }

    public Event step(String str) {
        this.step = str;
        return this;
    }

    public String getStep() {
        return this.step;
    }

    public Event stepDesc(String str) {
        this.stepDesc = str;
        return this;
    }

    public Event startTime(long j) {
        this.startTime = j;
        return this;
    }

    public Event endTime(long j) {
        this.endTime = j;
        return this;
    }

    public Event collectDuration() {
        this.collectDuration = true;
        return this;
    }

    public Event isSuccess(boolean z) {
        this.isSuccess = z;
        return this;
    }

    public Event msg(String str) {
        this.msg = str;
        return this;
    }

    public Event errorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public Event exception(PatchException patchException) {
        this.exception = patchException;
        this.errorCode = patchException.getErrorCode();
        return this;
    }

    public PatchException getException() {
        return this.exception;
    }

    public Event putMetrics(String str, Object obj) {
        getMetricsMap().put(str, obj);
        return this;
    }

    public Event putCategory(String str, Object obj) {
        getCategoryMap().put(str, obj);
        return this;
    }

    public Event putExtra(String str, Object obj) {
        getExtraMap().put(str, obj);
        return this;
    }

    public Event sender(EventSender eventSender) {
        this.sender = eventSender;
        return this;
    }

    public void send() {
        if (this.sender == null) {
            return;
        }
        if (this.collectDuration && this.startTime != -1 && this.endTime == -1) {
            this.endTime = SystemClock.elapsedRealtime();
        }
        this.sender.send(this);
    }

    public String getTag() {
        return this.tag;
    }

    public JSONObject createMetricJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.collectDuration) {
            long j = this.startTime;
            if (j != -1) {
                jSONObject.putOpt("duration", Long.valueOf(this.endTime - j));
            }
        }
        HashMap<String, Object> hashMap = this.metricsMap;
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<String, Object> entry : this.metricsMap.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public JSONObject createCategoryJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("is_success", Boolean.valueOf(this.isSuccess));
        jSONObject.putOpt("is_main_process", StringUtils.notNull(isMainProcess));
        HashMap<String, Object> hashMap = this.categoryMap;
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<String, Object> entry : this.categoryMap.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public JSONObject createExtraJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("process_name", StringUtils.notNull(processName));
        jSONObject.putOpt("tag", StringUtils.notNull(this.tag));
        jSONObject.putOpt("step", StringUtils.notNull(this.step));
        jSONObject.putOpt("step_desc", StringUtils.notNull(this.stepDesc));
        long j = this.startTime;
        jSONObject.putOpt("start_time", j == -1 ? "" : Long.valueOf(j));
        long j2 = this.endTime;
        jSONObject.putOpt("end_time", j2 != -1 ? Long.valueOf(j2) : "");
        int i = this.eventType;
        if (i == 2) {
            jSONObject.putOpt("error_msg", ThrowableUtils.getThrowableStack(this.exception));
        } else if (i == 1) {
            jSONObject.putOpt("error_msg", StringUtils.notNull(this.errorMsg));
        } else if (i == 0) {
            jSONObject.putOpt("msg", StringUtils.notNull(this.msg));
        }
        HashMap<String, Object> hashMap = this.extraMap;
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<String, Object> entry : this.extraMap.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public long getDuration() {
        if (!this.collectDuration || this.startTime == -1) {
            return -1L;
        }
        if (this.endTime == -1) {
            this.endTime = SystemClock.elapsedRealtime();
        }
        return this.endTime - this.startTime;
    }

    public String getErrorMsg() {
        int i = this.eventType;
        if (i == 2) {
            return ThrowableUtils.getThrowableStack(this.exception);
        }
        return i == 1 ? StringUtils.notNull(this.errorMsg) : "";
    }

    public HashMap<String, Object> getMetricsMap() {
        if (this.metricsMap == null) {
            this.metricsMap = new HashMap<>();
        }
        return this.metricsMap;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public int getStatus() {
        if (this.isSuccess) {
            return 1;
        }
        return this.errorCode;
    }

    public HashMap<String, Object> getCategoryMap() {
        if (this.categoryMap == null) {
            this.categoryMap = new HashMap<>();
        }
        return this.categoryMap;
    }

    public HashMap<String, Object> getExtraMap() {
        if (this.extraMap == null) {
            this.extraMap = new HashMap<>();
        }
        return this.extraMap;
    }

    public static void init(String str, boolean z) {
        processName = str;
        isMainProcess = Boolean.valueOf(z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{    \n");
        appendJSONItemStr(sb, "tag", this.tag, false);
        appendJSONItemStr(sb, "event_type", getEventTypeDesc(this.eventType), false);
        appendJSONItemStr(sb, "step", this.step, false);
        appendJSONItemStr(sb, "step_desc", this.stepDesc, false);
        appendJSONItemStr(sb, "start_time", Long.valueOf(this.startTime), false);
        appendJSONItemStr(sb, "end_time", Long.valueOf(this.endTime), false);
        appendJSONItemStr(sb, "collectDuration", Boolean.valueOf(this.collectDuration), false);
        appendJSONItemStr(sb, "is_success", Boolean.valueOf(this.isSuccess), false);
        appendJSONItemStr(sb, "msg", this.msg, false);
        appendJSONItemStr(sb, "error_msg", this.errorMsg, false);
        appendJSONItemStr(sb, "metrics_map", this.metricsMap, false);
        appendJSONItemStr(sb, "category_map", this.categoryMap, false);
        appendJSONItemStr(sb, "extra_map", this.extraMap, false);
        appendJSONItemStr(sb, "exception", this.exception, true);
        sb.append("}");
        return sb.toString();
    }

    private void appendJSONItemStr(StringBuilder sb, String str, Object obj, boolean z) {
        sb.append("\"").append(str).append("\"").append(Constants.COLON_SEPARATOR).append("\"").append(obj).append("\"");
        if (z) {
            sb.append(UpdateDialogNewBase.TYPE);
        } else {
            sb.append(",\n");
        }
    }
}
