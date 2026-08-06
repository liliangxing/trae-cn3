package com.bytedance.dataplatform.applog;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IAppLogService {
    void onEventV3(String event, JSONObject params);
}
