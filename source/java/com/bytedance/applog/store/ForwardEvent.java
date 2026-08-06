package com.bytedance.applog.store;

import com.bytedance.applog.priority.EventPriority;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ForwardEvent extends EventV3 {
    static final String TABLE = "forward_eventv3";

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.EventV3, com.bytedance.applog.store.BaseData
    public String getTableName() {
        return TABLE;
    }

    @Override // com.bytedance.applog.store.EventV3
    public void updateEventPriority(EventPriority eventPriority) {
    }

    public ForwardEvent(String str, String str2, boolean z, String str3) {
        super(str, str2, z, str3);
    }

    public ForwardEvent(String str, String str2) {
        super(str, str2);
    }

    public ForwardEvent() {
        super(null, null);
    }

    public static BaseData fromEventV3(EventV3 eventV3) {
        ForwardEvent forwardEvent = new ForwardEvent(eventV3.appId, eventV3.event);
        forwardEvent.disablePersonalization = eventV3.disablePersonalization;
        forwardEvent.param = eventV3.param;
        forwardEvent.setTs(eventV3.f80ts);
        forwardEvent.abSdkVersion = eventV3.abSdkVersion;
        forwardEvent.eid = eventV3.eid;
        forwardEvent.mDT = eventV3.mDT;
        forwardEvent.f79nt = eventV3.f79nt;
        forwardEvent.sid = eventV3.sid;
        forwardEvent.uid = eventV3.uid;
        forwardEvent.user_id = eventV3.user_id;
        forwardEvent.uuid = eventV3.uuid;
        forwardEvent.userIsAuth = eventV3.userIsAuth;
        forwardEvent.userIsLogin = eventV3.userIsLogin;
        forwardEvent.userType = eventV3.userType;
        forwardEvent.bav = eventV3.bav;
        forwardEvent.forward = 1;
        forwardEvent.monitorId = eventV3.monitorId;
        forwardEvent.sentryStained = eventV3.sentryStained;
        return forwardEvent;
    }
}
