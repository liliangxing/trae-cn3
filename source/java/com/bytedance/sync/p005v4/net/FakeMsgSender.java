package com.bytedance.sync.p005v4.net;

import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.model.PayloadEntry;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class FakeMsgSender implements IMsgSender {
    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    public boolean isPendingPayloadToSend() {
        return false;
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    public void send(PayloadEntry payloadEntry) {
        LogUtils.m185d("【mock】send success -> " + payloadEntry);
    }
}
