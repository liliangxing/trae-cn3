package com.bytedance.apm6.commonevent;

import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.commonevent.model.CommonLog;

/* loaded from: classes3.dex */
public interface IUnSampleLogListener {
    void onCommonEvent(CommonEvent commonEvent);

    void onCommonLog(CommonLog commonLog);
}
