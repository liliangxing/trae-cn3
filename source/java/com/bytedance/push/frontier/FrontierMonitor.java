package com.bytedance.push.frontier;

import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.utils.Logger;
import com.ss.android.ug.bus.UgBusFramework;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FrontierMonitor implements IFrontierMonitor {
    private ISDKMonitor mISDKMonitor;

    @Override // com.bytedance.push.frontier.interfaze.IFrontierMonitor
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (this.mISDKMonitor == null) {
            this.mISDKMonitor = (ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class);
        }
        if (this.mISDKMonitor == null) {
            return;
        }
        if (Logger.debug()) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("event_name", str);
                jSONObject4.put("category", jSONObject);
                jSONObject4.put("metric", jSONObject2);
                jSONObject4.put("extra", jSONObject3);
                Logger.m274i("FrontierMonitor", "onMonitorEvent：" + jSONObject4.toString());
            } catch (Throwable unused) {
            }
        }
        this.mISDKMonitor.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }

    @Override // com.bytedance.push.frontier.interfaze.IFrontierMonitor
    public void onRequestFrontierSettingFailed(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "status", i);
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, IFrontierMonitor.KEY_LOG, str);
        JSONObject jSONObject3 = new JSONObject();
        add(jSONObject3, IFrontierMonitor.KEY_TIME_CONSUMING, j);
        monitorEvent(IFrontierMonitor.EVENT_UPDATE_SETTING, jSONObject, jSONObject3, jSONObject2);
    }

    @Override // com.bytedance.push.frontier.interfaze.IFrontierMonitor
    public void onRequestFrontierSettingSuccess(long j) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "status", 0L);
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, IFrontierMonitor.KEY_TIME_CONSUMING, j);
        monitorEvent(IFrontierMonitor.EVENT_UPDATE_SETTING, jSONObject, jSONObject2, null);
    }

    public void add(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
