package com.bytedance.sync.p005v4.intf;

import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IMsgSender extends IUgBusService {
    boolean isPendingPayloadToSend();

    void send(PayloadEntry payloadEntry);
}
