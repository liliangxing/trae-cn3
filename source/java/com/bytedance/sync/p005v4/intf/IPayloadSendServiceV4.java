package com.bytedance.sync.p005v4.intf;

import com.bytedance.sync.interfaze.IPayloadSendService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IPayloadSendServiceV4 extends IPayloadSendService {
    void startSendToServer();

    void trySendUploadMsg();
}
