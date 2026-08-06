package com.bytedance.push.settings.msg.callback;

import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MsgCallbackSettingsModel extends BaseJson {
    private final String CALLBACK_MSG_ARRIVE = "callback_msg_arrive";
    private final String CALLBACK_MSG_CLICK = "callback_msg_click";
    public boolean callbackMsgArrive;
    public boolean callbackMsgClick;

    public MsgCallbackSettingsModel() {
        init();
    }

    private void init() {
        this.callbackMsgArrive = false;
        this.callbackMsgClick = false;
    }

    public MsgCallbackSettingsModel(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.callbackMsgArrive = jSONObject.optBoolean("callback_msg_arrive", false);
            this.callbackMsgClick = jSONObject.optBoolean("callback_msg_click", false);
        } catch (Throwable th) {
            th.printStackTrace();
            init();
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "callback_msg_arrive", this.callbackMsgArrive);
        add(jSONObject, "callback_msg_click", this.callbackMsgClick);
        return jSONObject.toString();
    }
}
