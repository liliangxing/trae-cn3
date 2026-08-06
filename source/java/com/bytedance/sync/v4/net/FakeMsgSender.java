package com.bytedance.sync.v4.net;

import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.v4.intf.IMsgSender;
import com.bytedance.sync.v4.model.PayloadEntry;

/* loaded from: classes5.dex */
public class FakeMsgSender implements IMsgSender {
    @Override // com.bytedance.sync.v4.intf.IMsgSender
    public boolean isPendingPayloadToSend() {
        return false;
    }

    @Override // com.bytedance.sync.v4.intf.IMsgSender
    public void send(PayloadEntry payloadEntry) {
        LogUtils.d("【mock】send success -> " + payloadEntry);
    }
}
