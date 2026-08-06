package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ActivateMonitor extends Monitor {
    private long sActivateRequestStart = 0;
    private long sActivateRequestFinish = 0;
    private long sActivateFailCount = 0;
    private boolean isFirstActivate = false;
    private int isNewUserMode = 0;
    private int scene = 0;
    private boolean result = false;

    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean z) {
        this.result = z;
    }

    public void setScene(int i) {
        this.scene = i;
    }

    public int getScene() {
        return this.scene;
    }

    public void setNewUserMode(int i) {
        this.isNewUserMode = i;
    }

    public int isNewUserMode() {
        return this.isNewUserMode;
    }

    public boolean isFirstActivate() {
        return this.isFirstActivate;
    }

    public void setFirstActivate(boolean z) {
        this.isFirstActivate = z;
    }

    public void onActivateRequestStart() {
        if (this.sActivateRequestStart > 0) {
            return;
        }
        this.sActivateRequestStart = System.currentTimeMillis();
    }

    public void onActivateRequestFinish() {
        if (this.sActivateRequestFinish > 0) {
            return;
        }
        this.sActivateRequestFinish = System.currentTimeMillis();
    }

    public long getActivateRequestTime() {
        return this.sActivateRequestFinish - this.sActivateRequestStart;
    }

    public long getActivateFailCount() {
        return this.sActivateFailCount;
    }

    public void setActivateFailCount(long j) {
        this.sActivateFailCount = j;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    protected void reset() {
        this.sActivateRequestStart = 0L;
        this.sActivateRequestFinish = 0L;
        this.sActivateFailCount = 0L;
        this.isFirstActivate = false;
        this.result = false;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public JSONObject getEventParam() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("params_for_special", "uc_login");
            jSONObject.put("duration", getActivateRequestTime());
            jSONObject.put("retry_count", getActivateFailCount());
            jSONObject.put("is_first", isFirstActivate());
            jSONObject.put("is_new_user_mode", isNewUserMode());
            jSONObject.put("scene", getScene());
            jSONObject.put("result", isResult());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
