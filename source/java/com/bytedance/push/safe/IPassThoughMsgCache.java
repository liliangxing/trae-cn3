package com.bytedance.push.safe;

import com.bytedance.push.PushBody;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: classes4.dex */
public interface IPassThoughMsgCache extends IUgBusService {
    void cacheMsg(PushBody pushBody, int i);

    int getMsgFrom(PushBody pushBody);

    PushBody getRevokedMsg(long j);

    boolean isFromPassThough(String str);
}
