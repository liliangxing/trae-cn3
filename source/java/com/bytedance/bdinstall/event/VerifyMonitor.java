package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import com.bytedance.bdinstall.util.Constants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VerifyMonitor extends Monitor {
    private int decryptCode = 0;
    private int mRetryCount = 0;
    private int success = 0;
    private Map<String, Long> timestampMap;

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public void setFailCount(int i) {
        this.mRetryCount = i;
    }

    public int getSuccess() {
        return this.success;
    }

    public void setSuccess(int i) {
        this.success = i;
    }

    public void setDecryptCode(int i) {
        this.decryptCode = i;
    }

    public void setTimestampMap(Map<String, Long> map) {
        this.timestampMap = map;
    }

    public int getDecryptCode() {
        return this.decryptCode;
    }

    public Map<String, Long> getTimestampMap() {
        return this.timestampMap;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    protected JSONObject getEventParam() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l = this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_INIT);
            Long l2 = this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_GET_TICKET);
            Long l3 = this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_HANDLE_RESPONSE);
            Long l4 = this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_DECRYPT);
            Long l5 = this.timestampMap.get(Constants.TicketEvents.KEY_TICKET_CONSUMER_TICKET);
            jSONObject.put("params_for_special", "uc_login");
            jSONObject.put("result", getSuccess());
            jSONObject.put("retry_count", getRetryCount());
            jSONObject.put("decrypt_code", getDecryptCode());
            jSONObject.put(Constants.TicketEvents.KEY_TICKET_INIT, l);
            jSONObject.put(Constants.TicketEvents.KEY_TICKET_GET_TICKET, l2);
            jSONObject.put(Constants.TicketEvents.KEY_TICKET_HANDLE_RESPONSE, l3);
            jSONObject.put(Constants.TicketEvents.KEY_TICKET_DECRYPT, l4);
            jSONObject.put(Constants.TicketEvents.KEY_TICKET_CONSUMER_TICKET, l5);
            jSONObject.put(Constants.TicketEvents.KEY_TICKET_TOTAL_TIME, l.longValue() + l2.longValue() + l3.longValue() + l4.longValue() + l5.longValue());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    protected void reset() {
        this.decryptCode = 0;
        this.mRetryCount = 0;
        this.success = 0;
        this.timestampMap = null;
    }
}
