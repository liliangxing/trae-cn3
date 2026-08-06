package com.bytedance.android.service.manager.push.client.intelligence;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IClientFeatureService {
    public static final String INVOKE_SCENE_EVENT_BDPUSH_AUTH_SHOW = "event_bdpush_auth_show";
    public static final String INVOKE_SCENE_EVENT_NOTIFICATION_SHOW_UG = "event_notification_show_ug";
    public static final String INVOKE_SCENE_EVENT_PULL_REQUEST = "event_pull_request";
    public static final String INVOKE_SCENE_EVENT_PUSH_CLEAR_UG = "event_push_clear_ug";
    public static final String INVOKE_SCENE_EVENT_PUSH_CLICK = "event_push_click";
    public static final String INVOKE_SCENE_EVENT_PUSH_SHOW_UG = "event_push_show_ug";
    public static final String INVOKE_SCENE_PITAYA = "pitaya";

    void getClientFeatureAsync(IFeatureCallBack iFeatureCallBack, String str);

    JSONObject getClientFeatureSync(String str);
}
