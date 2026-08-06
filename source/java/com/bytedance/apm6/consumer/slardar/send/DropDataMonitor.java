package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class DropDataMonitor {
    private static final String KEY_DROP_BYTES = "drop_data_bytes";
    private static final String KEY_DROP_COUNT = "drop_data_count";
    private static final String KEY_DROP_DATA_REASON = "drop_reason";
    private static final String KEY_DROP_ITEMS = "drop_data_items";
    private static final String KEY_DROP_LOG_ID = "x-tt-logid";
    private static final String KEY_DROP_SERVER_TIME = "drop_timestamp";
    private static final String KEY_DROP_TIME = "timestamp";
    private static final String KEY_LOG_TYPE = "log_type";
    private static final String KEY_SP_NAME = "drop_message";
    private static final String LOG_TYPE = "server_drop_data";
    private static final int MAX_LENGTH = 10;
    private volatile boolean init;
    private JSONArray items = new JSONArray();
    private long serverDropTime;
    private String serverLogId;
    private SharedPreferences sharedPreferences;

    DropDataMonitor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DropDataMonitor getInstance() {
        return InnerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setServerLogId(String str) {
        this.serverLogId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setServerTimeStamp(long j) {
        this.serverDropTime = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void monitorDropLog(long j, long j2, long j3, Reason reason) {
        ensureInit();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", LOG_TYPE);
            jSONObject.put("timestamp", j3);
            jSONObject.put(KEY_DROP_COUNT, j);
            jSONObject.put(KEY_DROP_BYTES, j2);
            if (reason == Reason.SERVER_DROP) {
                jSONObject.put("x-tt-logid", this.serverLogId);
                jSONObject.put(KEY_DROP_SERVER_TIME, this.serverDropTime);
            }
            if (reason != null) {
                jSONObject.put(KEY_DROP_DATA_REASON, reason);
            }
            this.items.put(jSONObject);
            if (ApmContext.isDebugMode()) {
                Logger.d(Constants.TAG, "monitorDropLog:" + this.items.toString());
            }
            this.sharedPreferences.edit().putString(KEY_DROP_ITEMS, this.items.toString()).commit();
        } catch (Exception e) {
            Logger.e(Constants.TAG, "monitorDropLog:", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONArray getItems() {
        ensureInit();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < this.items.length(); i++) {
            try {
                if (i < 10) {
                    jSONArray.put(this.items.get(i));
                } else {
                    jSONArray2.put(this.items.get(i));
                }
            } catch (Exception unused) {
            }
        }
        this.items = jSONArray2;
        this.sharedPreferences.edit().putString(KEY_DROP_ITEMS, this.items.toString()).commit();
        return jSONArray;
    }

    private synchronized void ensureInit() {
        if (this.init) {
            return;
        }
        this.init = true;
        SharedPreferences sharedPreferences = ApmContext.getContext().getSharedPreferences(ApmContext.getCurrentProcessName() + "_drop_message", 0);
        this.sharedPreferences = sharedPreferences;
        String string = sharedPreferences.getString(KEY_DROP_ITEMS, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.items = new JSONArray(string);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class InnerHolder {
        private static final DropDataMonitor instance = new DropDataMonitor();

        private InnerHolder() {
        }
    }

    /* loaded from: classes3.dex */
    enum Reason {
        SERVER_DROP("server drop message"),
        FULL_DISK("disk is full");

        private String reason;

        Reason(String str) {
            this.reason = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.reason;
        }
    }
}
