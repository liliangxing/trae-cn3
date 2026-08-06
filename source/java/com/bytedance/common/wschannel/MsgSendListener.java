package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: classes3.dex */
public interface MsgSendListener {
    void onSendResult(WsChannelMsg wsChannelMsg, boolean z);
}
