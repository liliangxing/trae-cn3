package com.bytedance.sync.p005v4.net;

import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.p005v4.net.NetTrace;
import com.bytedance.sync.util.JSONUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CompensatorTrace extends NetTrace {
    private final boolean mForeground;
    private final int mStrategy;

    public CompensatorTrace(boolean z, NetTrace.TraceDepend traceDepend) {
        this.mForeground = z;
        this.mStrategy = traceDepend != null ? traceDepend.getCurrentStrategy() : 0;
    }

    @Override // com.bytedance.sync.p005v4.net.NetTrace
    public void send() {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "send_method", this.mSendMethod);
        JSONUtils.safePutParam(jSONObject, "send_result", this.mSendResult);
        JSONUtils.safePutParam(jSONObject, "is_foreground", this.mForeground);
        JSONUtils.safePutParam(jSONObject, "strategy", this.mStrategy);
        JSONUtils.safePutParam(jSONObject, "send_msg_type", this.mSendMsgType);
        JSONUtils.safePutParam(jSONObject, "ws_connect", this.mIsConnect);
        SyncMonitor.monitor("sync_sdk_compensator_net_monitor", jSONObject, null, null);
    }
}
