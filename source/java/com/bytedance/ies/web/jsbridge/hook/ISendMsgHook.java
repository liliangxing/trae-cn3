package com.bytedance.ies.web.jsbridge.hook;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface ISendMsgHook {
    public static final int TYPE_CALL = 1;
    public static final int TYPE_EVENT = 2;

    Js2MsgData beforeSendJsMsg(String str, JSONObject jSONObject, int i);
}
