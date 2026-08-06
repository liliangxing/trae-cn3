package com.bytedance.sync.v4.intf;

import com.bytedance.sync.interfaze.IPayloadSendService;

/* loaded from: classes5.dex */
public interface IPayloadSendServiceV4 extends IPayloadSendService {
    void startSendToServer();

    void trySendUploadMsg();
}
