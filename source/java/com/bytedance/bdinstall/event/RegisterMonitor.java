package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RegisterMonitor extends Monitor {
    private long sRegisterRequestStart = 0;
    private long sRegisterRequestFinish = 0;
    private int mRegisterFailCount = 0;
    private boolean isDidChanged = false;
    private boolean isNewUser = false;
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

    public boolean isNewUser() {
        return this.isNewUser;
    }

    public void setNewUser(boolean z) {
        this.isNewUser = z;
    }

    public boolean isDidChanged() {
        return this.isDidChanged;
    }

    public void setDidChanged(boolean z) {
        this.isDidChanged = z;
    }

    public long getRegisterFailCount() {
        return this.mRegisterFailCount;
    }

    public long getRegisterRequestTime() {
        return this.sRegisterRequestFinish - this.sRegisterRequestStart;
    }

    public void setRegisterFailCount(int i) {
        this.mRegisterFailCount = i;
    }

    public void onRegisterRequestStart() {
        if (this.sRegisterRequestStart > 0) {
            return;
        }
        this.sRegisterRequestStart = System.currentTimeMillis();
    }

    public void onRegisterRequestFinish() {
        if (this.sRegisterRequestFinish > 0) {
            return;
        }
        this.sRegisterRequestFinish = System.currentTimeMillis();
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    protected void reset() {
        this.sRegisterRequestStart = 0L;
        this.sRegisterRequestFinish = 0L;
        this.mRegisterFailCount = 0;
        this.isDidChanged = false;
        this.isNewUser = false;
        this.result = false;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public JSONObject getEventParam() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("params_for_special", "uc_login");
            jSONObject.put("duration", getRegisterRequestTime());
            jSONObject.put("retry_count", getRegisterFailCount());
            jSONObject.put("is_first", isNewUser());
            jSONObject.put("did_change", isDidChanged());
            jSONObject.put("is_new_user_mode", isNewUserMode());
            jSONObject.put("scene", getScene());
            jSONObject.put("result", isResult());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
