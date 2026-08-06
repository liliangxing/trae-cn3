package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsInfoJsbErrorEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/SLJSBErrorEvent;", "Lcom/bytedance/salamander/anniex/SLEvent;", "()V", "event_info", "Lcom/bytedance/salamander/anniex/SLJSBErrorEventInfo;", "getEvent_info", "()Lcom/bytedance/salamander/anniex/SLJSBErrorEventInfo;", "setEvent_info", "(Lcom/bytedance/salamander/anniex/SLJSBErrorEventInfo;)V", "eventType", "Lcom/bytedance/salamander/anniex/SLEventType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLJSBErrorEvent extends SLEvent {
    private SLJSBErrorEventInfo event_info = new SLJSBErrorEventInfo();

    @Override // com.bytedance.salamander.anniex.SLEvent
    public SLEventType eventType() {
        return SLEventType.JSB_ERROR;
    }

    public SLJSBErrorEventInfo getEvent_info() {
        return this.event_info;
    }

    public void setEvent_info(SLJSBErrorEventInfo sLJSBErrorEventInfo) {
        Intrinsics.checkNotNullParameter(sLJSBErrorEventInfo, "<set-?>");
        this.event_info = sLJSBErrorEventInfo;
    }
}
