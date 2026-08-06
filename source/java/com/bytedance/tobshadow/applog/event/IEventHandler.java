package com.bytedance.tobshadow.applog.event;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IEventHandler {
    int acceptType();

    EventPolicy onReceive(int i, String str, JSONObject jSONObject, EventBasicData eventBasicData);
}
