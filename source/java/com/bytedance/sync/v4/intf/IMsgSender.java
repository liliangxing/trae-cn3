package com.bytedance.sync.v4.intf;

import com.bytedance.sync.v4.model.PayloadEntry;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: classes5.dex */
public interface IMsgSender extends IUgBusService {
    boolean isPendingPayloadToSend();

    void send(PayloadEntry payloadEntry);
}
