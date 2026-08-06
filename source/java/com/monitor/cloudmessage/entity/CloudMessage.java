package com.monitor.cloudmessage.entity;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class CloudMessage {
    private String mCommandId;
    private String mParams;
    private JSONObject mParamsJson;

    @Deprecated
    private long mSendTime;
    private String mType;
    private String messageString;

    public String getParams() {
        return this.mParams;
    }

    public String getMessageString() {
        return this.messageString;
    }

    public static CloudMessage fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            CloudMessage cloudMessage = new CloudMessage();
            JSONObject jSONObject = new JSONObject(str);
            cloudMessage.mCommandId = jSONObject.optString("command_id");
            cloudMessage.mType = jSONObject.optString("type");
            String optString = jSONObject.optString("params");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2 = new JSONObject(optString);
            }
            cloudMessage.mParams = optString;
            cloudMessage.mParamsJson = jSONObject2;
            cloudMessage.messageString = str;
            return cloudMessage;
        } catch (Exception e) {
            if (ApmContext.isDebugMode()) {
                Logger.printErrStackTrace("cloudmessage", e, "Parse CloudMessage Error.");
            }
            return null;
        }
    }

    public JSONObject getParamsJson() {
        return this.mParamsJson;
    }

    public boolean isWifiOnly() {
        return this.mParamsJson.optBoolean("wifiOnly");
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    @Deprecated
    public long getSendTime() {
        return this.mSendTime;
    }

    @Deprecated
    public void setSendTime(long j) {
        this.mSendTime = j;
    }

    public String getCommandId() {
        return this.mCommandId;
    }

    public String toString() {
        return "CloudMessage{mParams='" + this.mParams + "', mType=" + this.mType + ", send_time=" + this.mSendTime + ", command_id='" + this.mCommandId + "'}";
    }
}
