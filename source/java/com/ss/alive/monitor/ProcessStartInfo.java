package com.ss.alive.monitor;

import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ProcessStartInfo {
    public static final int ACTIVITY_FLAG = 4;
    public static final int BIND_SERVICE_FLAG = 2;
    public static final int OTHER_FLAG = 5;
    public static final int RECEIVER_FLAG = 3;
    public static final int SCREEN_STATE_SCREEN_ACTIVE = 3;
    public static final int SCREEN_STATE_SCREEN_LOCKED = 2;
    public static final int SCREEN_STATE_SCREEN_OFF = 1;
    public static final int SCREEN_STATE_UNKNOWN = 0;
    public static final int START_SERVICE_FLAG = 1;
    private static final String TAG = "ProcessStartInfo";
    public Intent mIntent;
    public String referrer;
    public int screenState;
    public ServiceInfo serviceInfo;
    public long startTime = 0;
    public long endTime = 0;
    public String process = "";
    public List<String> messageStrList = new ArrayList();
    public int startFlag = 0;

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start_time", this.startTime);
            jSONObject.put("process", this.process);
            jSONObject.put("start_flag", this.startFlag);
            jSONObject.put("screen_state", this.screenState);
            ServiceInfo serviceInfo = this.serviceInfo;
            if (serviceInfo != null) {
                jSONObject.put("start_component", serviceInfo.name);
            }
            Intent intent = this.mIntent;
            if (intent != null) {
                jSONObject.put("intent", intent.toString());
                jSONObject.put("intent_action", this.mIntent.getAction());
                if (this.mIntent.getComponent() != null) {
                    jSONObject.put("start_component", this.mIntent.getComponent().getClassName());
                }
                Bundle extras = this.mIntent.getExtras();
                JSONObject jSONObject2 = new JSONObject();
                if (extras != null && !extras.isEmpty()) {
                    for (String str : extras.keySet()) {
                        jSONObject2.put(str, extras.get(str));
                    }
                }
                Uri data = this.mIntent.getData();
                if (data != null) {
                    jSONObject2.put("intent_data_string", data.toString());
                }
                jSONObject.put("intent_data", jSONObject2);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.messageStrList.size(); i++) {
                jSONArray.put(this.messageStrList.get(i));
            }
            jSONObject.put("message_list", jSONArray);
            if (!TextUtils.isEmpty(this.referrer)) {
                jSONObject.put("referrer", this.referrer);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJson().toString();
    }
}
