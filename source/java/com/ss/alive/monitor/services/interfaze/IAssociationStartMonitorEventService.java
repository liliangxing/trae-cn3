package com.ss.alive.monitor.services.interfaze;

import com.ss.alive.monitor.model.StartRecord;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface IAssociationStartMonitorEventService {
    public static final String KEY_CLIENT_TIME = "client_time";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_HOOK_NAME = "hook_name";
    public static final String KEY_MSG = "msg";
    public static final String KEY_PROCESS = "process";
    public static final String KEY_RESULT = "result";
    public static final String SERVICE_NAME_ASSOCIATION_START_EVENT = "association_start_event";
    public static final String SERVICE_NAME_PUSH_HOOK_RESULT = "push_hook_result";

    void enableReport(boolean z);

    void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void onAssociationStartEvent(StartRecord startRecord);

    void onHookResult(String str, boolean z, String str2, long j);

    void onUserActive();
}
