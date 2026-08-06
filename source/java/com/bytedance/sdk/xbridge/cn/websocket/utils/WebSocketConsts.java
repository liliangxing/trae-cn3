package com.bytedance.sdk.xbridge.cn.websocket.utils;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;

/* compiled from: WebSocketConsts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/WebSocketConsts;", "", "()V", "CONNECTED", "", NetworkStackConstant.ERR_DISCONNECTED, "SOCKET_TYPE_TT_NET", "", "StateType_CLOSED", "StateType_CONNECTED", "StateType_FAILED", "StateType_ONMESSAGED", "TAG_TASK_BASE", "TAG_TASK_TTNET", "TRANSPORT_PROTOCOL_UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class WebSocketConsts {
    public static final int CONNECTED = 1;
    public static final int DISCONNECTED = -1;
    public static final WebSocketConsts INSTANCE = new WebSocketConsts();
    public static final String SOCKET_TYPE_TT_NET = "ttnet";
    public static final String StateType_CLOSED = "closed";
    public static final String StateType_CONNECTED = "connected";
    public static final String StateType_FAILED = "failed";
    public static final String StateType_ONMESSAGED = "onMessaged";
    public static final String TAG_TASK_BASE = "Task.base";
    public static final String TAG_TASK_TTNET = "Task.ttnet";
    public static final String TRANSPORT_PROTOCOL_UNKNOWN = "unknown";

    private WebSocketConsts() {
    }
}
