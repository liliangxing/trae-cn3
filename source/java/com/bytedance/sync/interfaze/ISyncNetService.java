package com.bytedance.sync.interfaze;

import com.bytedance.sync.model.SubscribeResponse;
import com.bytedance.sync.model.Topic;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ISyncNetService extends IUgBusService {
    BsyncProtocol sendPipeline(BsyncProtocol bsyncProtocol);

    SubscribeResponse subscribeTopic(Topic topic);

    SubscribeResponse unsubscribeTopic(Topic topic);
}
