package com.bytedance.bdinstall.event;

import com.bytedance.bdinstall.callback.event.Monitor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ParamsMonitor extends Monitor {
    private int type = 0;
    private int state = 0;
    private int flag = 0;
    private long duration = 0;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    protected void reset() {
        this.type = 0;
        this.state = 0;
        this.flag = 0;
        this.duration = 0L;
    }

    @Override // com.bytedance.bdinstall.callback.event.Monitor
    public JSONObject getEventParam() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("params_for_special", "uc_login");
            jSONObject.put("duration", getDuration());
            jSONObject.put("type", getType());
            jSONObject.put("state", getState());
            jSONObject.put("flag", getFlag());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
