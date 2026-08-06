package com.bytedance.sync.p005v4.net;

import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.util.JSONUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SocketPollNetTrace extends NetTrace {
    @Override // com.bytedance.sync.p005v4.net.NetTrace
    public void send() {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "send_method", this.mSendMethod);
        JSONUtils.safePutParam(jSONObject, "send_result", this.mSendResult);
        JSONUtils.safePutParam(jSONObject, "send_msg_type", this.mSendMsgType);
        JSONUtils.safePutParam(jSONObject, "ws_connect", this.mIsConnect);
        SyncMonitor.monitor("sync_sdk_ws_poll", jSONObject, null, null);
    }
}
